# Limites de Crédito com IA

## Visão Geral

Sistema de análise inteligente de crédito baseado em microsserviços. O objetivo é ajudar pessoas a entenderem se uma nova compra é compatível com sua situação financeira atual, evitando o comprometimento excessivo do crédito e o aumento do endividamento.

O sistema coleta dados de crédito, gera um histórico fictício de compras, calcula um score de risco e utiliza Inteligência Artificial para explicar o cenário ao usuário em linguagem natural, enviando uma notificação por e-mail quando o score indicar risco.

---

## Arquitetura

O sistema é composto por 5 microsserviços independentes que se comunicam de forma assíncrona via Apache Kafka:

<img width="1007" height="783" alt="image" src="https://github.com/user-attachments/assets/8d29de1b-82d3-4218-8cc7-9dc357ae7690" />


---

## Serviços

### Credito Service
Responsável pelo cadastro das informações financeiras do usuário: salário, limite de crédito total, limite disponível, quantidade de atrasos e quantidade de consultas ao CPF. Disponibiliza consulta via GET com cache em memória. Ao cadastrar, publica um evento no Kafka com os dados necessários para os demais serviços.

### Historico Service
Consome o evento do Credito Service e cria o registro base de histórico associado ao idCredito. O histórico é enriquecido com transações de compra contendo informações como valor e estabelecimento. A partir dessas transações, calcula o total gasto e publica o histórico consolidado para o Score Service. Disponibiliza consulta via GET com cache em memória.

### Score Service
Consome eventos do Credito Service e do Historico Service. Calcula o score de risco com base em quatro critérios independentes: uso do limite de crédito, tempo de histórico, quantidade de atrasos e quantidade de consultas ao CPF. Cada critério possui seu próprio método de cálculo, orquestrados por um método principal. Publica o resultado para o LLM Service.

### LLM Service
Consome o score calculado e utiliza a API da Claude (Anthropic) para gerar uma explicação em linguagem natural sobre o cenário de crédito do usuário. Caso o score seja negativo, publica o cenário para o Notificacao Service.

### Notificacao Service
Consome o cenário gerado pelo LLM Service e envia uma notificação por e-mail ao usuário informando sobre o risco no limite de crédito.

---

## Fluxo de Dados

| Etapa | Serviço Origem | Tópico Kafka | Serviço Destino |
|-------|---------------|--------------|-----------------|
| 1 | Credito Service | `credito-criado` | Historico Service, Score Service |
| 2 | Historico Service | `historico-criado` | Score Service |
| 3 | Score Service | `score-atualizado` | LLM Service |
| 4 | LLM Service | `cenario-informado` | Notificacao Service |

---

## Decisões Técnicas

### Por que Apache Kafka e não RabbitMQ ou AWS SNS/SQS?

O **Kafka** foi escolhido por três razões principais:

**Kafka vs RabbitMQ:** O RabbitMQ é um message broker tradicional, ideal para filas simples de tarefas. O Kafka é uma plataforma de streaming distribuído que persiste as mensagens em disco por tempo configurável, permitindo reprocessamento de eventos. No contexto deste sistema, se o Score Service cair e voltar depois, ele consegue reprocessar todos os eventos perdidos. Com RabbitMQ, esses eventos seriam perdidos ou exigiriam configuração adicional complexa.

**Kafka vs SNS/SQS:** O SNS/SQS é um serviço gerenciado da AWS, o que cria dependência de cloud vendor. O Kafka roda localmente via Docker, tornando o ambiente de desenvolvimento idêntico ao de produção, sem custo de cloud e sem dependência externa. Além disso, o Kafka suporta múltiplos consumidores no mesmo tópico de forma nativa, o que é essencial aqui, onde o tópico `credito-criado` é consumido tanto pelo Historico Service quanto pelo Score Service simultaneamente.

**Resumo:** Kafka foi escolhido pela durabilidade das mensagens, suporte nativo a múltiplos consumidores independentes e ambiente 100% local via Docker.

---

### Por que PostgreSQL e não MySQL ou MongoDB?

O **PostgreSQL** foi escolhido por ser o banco relacional mais completo e robusto disponível como open source:

**PostgreSQL vs MySQL:** O PostgreSQL possui suporte nativo a tipos avançados, melhor conformidade com o padrão SQL e desempenho superior em operações de leitura/escrita complexas. Para este sistema, que envolve cálculos financeiros com `BigDecimal` e relacionamentos entre entidades, a confiabilidade transacional do PostgreSQL é superior.

**PostgreSQL vs MongoDB:** O MongoDB é um banco de documentos, adequado para dados sem esquema definido. Os dados deste sistema — crédito, histórico, score — possuem estrutura bem definida e relacionamentos entre si, o que favorece um banco relacional com integridade referencial garantida pelo JPA/Hibernate.

**Resumo:** PostgreSQL foi escolhido pela robustez transacional, conformidade com padrões SQL e melhor integração com Spring Data JPA.

---

### Por que Spring Boot e não Quarkus ou Micronaut?

O **Spring Boot** é o framework Java mais utilizado no mercado, com maior ecossistema, documentação e comunidade. O `spring-kafka`, `spring-data-jpa`, `spring-cache` e `spring-validation` se integram nativamente sem configuração adicional, reduzindo o tempo de setup de cada microsserviço.

---

### Por que API da Claude (Anthropic) e não OpenAI ou Gemini?

A **API da Claude** foi escolhida por sua capacidade superior em análises contextuais e geração de texto explicativo em português. Para o objetivo do LLM Service — explicar cenários financeiros de forma clara e empática ao usuário — o Claude apresenta respostas mais precisas e com melhor qualidade de linguagem natural em comparação às alternativas avaliadas.

---

### Por que Spring Cache (cache em memória) e não Redis?

O **Spring Cache com cache simples em memória** foi escolhido por simplicidade operacional. Como o sistema roda em containers Docker independentes e os dados de crédito e histórico não são atualizados com alta frequência, o cache em memória é suficiente para reduzir consultas repetidas ao banco. O Redis adicionaria mais um container, mais configuração e complexidade de invalidação distribuída sem benefício real neste contexto.

---

### Por que Java Mail Sender e não SendGrid ou AWS SES?

O **Java Mail Sender** permite envio de e-mail via SMTP sem dependência de serviços externos pagos. Para este sistema, o envio de notificação é simples — um único e-mail por evento — sem necessidade de templates avançados, rastreamento de abertura ou volume alto de envios, o que tornaria SendGrid ou SES um overhead desnecessário.

---

## Padrões Implementados

| Padrão | Descrição |
|--------|-----------|
| **Database per Service** | Cada microsserviço possui seu banco PostgreSQL isolado |
| **Event-Driven Architecture** | Comunicação assíncrona via Kafka entre todos os serviços |
| **Idempotência** | Consumidores verificam se o evento já foi processado antes de executar |
| **Retry com Backoff** | Tentativas automáticas em caso de falha no consumo do evento |
| **Dead Letter Queue (DLQ)** | Eventos que falham após todas as tentativas são enviados para fila de erro |
| **Cache** | Consultas GET com cache em memória para reduzir carga no banco |

---

## Pré-requisitos

- Docker e Docker Compose instalados
- Java 17
- Maven 3.9+

---

## Como executar

```bash
docker-compose up --build
```

Os bancos de dados sobem primeiro com healthcheck configurado. Os serviços de backend só iniciam após os bancos estarem prontos e aceitando conexões.

---

## Estrutura do Projeto

```
credito-ia/
├── credito-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── historico-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── score-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── llm-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── notificacao-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
└── docker-compose.yml
```



---
Autor
---
Herik Kato

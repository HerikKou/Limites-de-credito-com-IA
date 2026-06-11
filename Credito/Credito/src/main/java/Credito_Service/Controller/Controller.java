package Credito_Service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Credito_Service.DTO.CreditoRequestDTO;
import Credito_Service.DTO.CreditoResponseDTO;
import Credito_Service.Service.ConsultarCreditoService;
import Credito_Service.Service.CriarCreditoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/credito")
public class Controller {

private final ConsultarCreditoService consultarCreditoService;
private final CriarCreditoService criarCreditoService;
public Controller(ConsultarCreditoService consultarCreditoService, CriarCreditoService criarCreditoService) {
    this.consultarCreditoService = consultarCreditoService;
    this.criarCreditoService = criarCreditoService;
}



@PostMapping("/criar")
public ResponseEntity<CreditoResponseDTO> criarCredito(@RequestBody CreditoRequestDTO request) {
    CreditoResponseDTO response = criarCreditoService.criarCredito(request);
    return ResponseEntity.status(201).body(response);
}




@GetMapping("/{id}")
public ResponseEntity<CreditoResponseDTO> consultarCredito(@PathVariable Long id) {
    CreditoResponseDTO response = consultarCreditoService.consultarCredito(id);
    return ResponseEntity.status(200).body(response);
}
}
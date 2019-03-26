package br.com.fiap.paymentservice.controller;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import br.com.fiap.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/payment-service")
public class PaymentServiceController {

    @Autowired
    private PaymentRepository repository;

    @GetMapping("/{idTransacao}")
    public ResponseEntity<PaymentDTO> findById(
            @PathVariable(value="idTransacao", required = true) Long idTransacao) {
        PaymentDTO payment = repository.get(idTransacao);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> post(@RequestBody PaymentDTO payment) {
        repository.add(payment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idTransacao}")
                .buildAndExpand(payment.getIdTransacao()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{idTransacao}")
    public ResponseEntity<String> patch(
            @PathVariable(value="idTransacao", required=true) Long idTransacao,
            @RequestBody PaymentDTO payment
    ) {
        repository.update(idTransacao, payment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(idTransacao).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{idTransacao}")
    public ResponseEntity<?> delete(
            @PathVariable(value="idTransacao", required=true) Long idTransacao) {
        repository.delete(idTransacao);

        return new ResponseEntity<>("Transação excluída com sucesso!", HttpStatus.OK);
    }
}

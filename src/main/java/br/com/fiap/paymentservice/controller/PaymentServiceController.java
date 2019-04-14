package br.com.fiap.paymentservice.controller;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import br.com.fiap.paymentservice.repository.PaymentRepository;
import io.swagger.annotations.*;
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
@Api(value = "Payment", description = "Payment Service REST API")
public class PaymentServiceController {

    @Autowired
    private PaymentRepository repository;

    @ApiOperation(httpMethod = "GET", value = "Método get para buscar uma transação filtrando por id")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna um PaymentDTO com uma mensagem de sucesso",
                    response = PaymentDTO.class)
    })
    @GetMapping("/{idTransacao}")
    public ResponseEntity<PaymentDTO> findById(
            @ApiParam(value = "Payment Id", required = true)
            @PathVariable(value="idTransacao", required = true) Long idTransacao) {
        PaymentDTO payment = repository.get(idTransacao);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "POST", value = "Método post para inserir uma transação")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna a URL do PaymentDTO criado",
                    response = Object.class)
    })
    @PostMapping("/")
    public ResponseEntity<Object> post(
            @ApiParam(format = "Json", name = "PaymentDTO")
            @RequestBody PaymentDTO payment) {
        repository.add(payment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idTransacao}")
                .buildAndExpand(payment.getIdTransacao()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(httpMethod = "PATCH", value = "Método patch para atualizar uma transação")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna a URL do PaymentDTO alterado",
                    response = String.class)
    })
    @PatchMapping("/{idTransacao}")
    public ResponseEntity<String> patch(
            @ApiParam(value = "Payment Id", required = true)
            @PathVariable(value="idTransacao", required=true) Long idTransacao,
            @RequestBody PaymentDTO payment
    ) {
        repository.update(idTransacao, payment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(idTransacao).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(httpMethod = "DELETE", value = "Método delete para excluir uma transação")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna uma string confirmando a exclusão",
                    response = String.class)
    })
    @DeleteMapping("/{idTransacao}")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Payment Id", required = true)
            @PathVariable(value="idTransacao", required=true) Long idTransacao) {
        repository.delete(idTransacao);

        return new ResponseEntity<>("Transação excluída com sucesso!", HttpStatus.OK);
    }
}

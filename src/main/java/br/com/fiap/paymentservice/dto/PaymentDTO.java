package br.com.fiap.paymentservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private BigDecimal valorCompra;
    private String bandeira;
}

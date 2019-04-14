package br.com.fiap.paymentservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    @ApiModelProperty(notes = "The Transacao ID")
    private Long idTransacao;

    @ApiModelProperty(notes = "Número do Cartão")
    private String numeroCartao;

    @ApiModelProperty(notes = "Data de validade do Cartão")
    private String validadeCartao;

    @ApiModelProperty(notes = "Valor da Compra")
    private BigDecimal valorCompra;

    @ApiModelProperty(notes = "Bandeira do cartão")
    private String bandeira;
}

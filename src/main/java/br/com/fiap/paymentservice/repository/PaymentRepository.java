package br.com.fiap.paymentservice.repository;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepository {
    private static Map<Long, PaymentDTO> payments = new HashMap<>();

    public PaymentDTO get(Long idTransacao) {
        return payments.get(idTransacao);
    }

    public void add(PaymentDTO payment) {
        payments.put(payment.getIdTransacao(), payment);
    }

    public void update(Long idTransacao, PaymentDTO payment) {
        PaymentDTO paymentUpdated = payments.get(idTransacao);

        if (payment.getNumeroCartao() != null)
            paymentUpdated.setNumeroCartao(payment.getNumeroCartao());

        if (payment.getValidadeCartao() != null)
            paymentUpdated.setValidadeCartao(payment.getValidadeCartao());

        if (payment.getValorCompra() != null)
            paymentUpdated.setValorCompra(payment.getValorCompra());

        if (payment.getBandeira() != null)
            paymentUpdated.setBandeira(payment.getBandeira());
    }

    public PaymentDTO delete(Long idTransacao) {
        return payments.remove(idTransacao);
    }
}

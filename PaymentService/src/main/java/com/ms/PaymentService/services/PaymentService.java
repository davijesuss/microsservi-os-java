package com.ms.PaymentService.services;

import com.ms.PaymentService.dtos.PaymentRequestDto;
import com.ms.PaymentService.models.PaymentModel;
import com.ms.PaymentService.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentModel processPayment(PaymentRequestDto paymentRequestDto) {
        PaymentModel payment = new PaymentModel();
        payment.setPedidoId(paymentRequestDto.getPedidoId());
        payment.setQuantia(paymentRequestDto.getQuantia());
        payment.setMetodoPagamento(paymentRequestDto.getMetodoPagamento());
        payment.setStatus("PROCESSING");
        return paymentRepository.save(payment);
    }
}

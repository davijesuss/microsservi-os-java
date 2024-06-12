package com.ms.PaymentService.controllers;

import com.ms.PaymentService.dtos.PaymentRequestDto;
import com.ms.PaymentService.models.PaymentModel;
import com.ms.PaymentService.services.PaymentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentModel> processPayment(@RequestBody @Valid PaymentRequestDto paymentRequestDto) {
        PaymentModel payment = paymentService.processPayment(paymentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}

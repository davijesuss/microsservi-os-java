package com.ms.PaymentService.repositories;

import com.ms.PaymentService.models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}

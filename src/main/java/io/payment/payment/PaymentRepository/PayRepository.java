package io.payment.payment.PaymentRepository;

import io.payment.payment.PaymentModel.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayRepository extends JpaRepository<Pay, UUID> {
}

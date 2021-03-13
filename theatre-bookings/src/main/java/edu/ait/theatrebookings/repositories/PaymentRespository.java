package edu.ait.theatrebookings.repositories;

import edu.ait.theatrebookings.dto.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRespository extends JpaRepository<Payment, Integer> {
}

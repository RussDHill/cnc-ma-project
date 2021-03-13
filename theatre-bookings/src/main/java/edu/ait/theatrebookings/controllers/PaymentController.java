package edu.ait.theatrebookings.controllers;

import edu.ait.theatrebookings.exceptions.DataNotFoundException;
import edu.ait.theatrebookings.dto.Payment;
import edu.ait.theatrebookings.repositories.PaymentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentRespository paymentRespository;

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentRespository.findAll();
    }

    @GetMapping("/payments/{id}")
    Optional<Payment> getPaymentById(@PathVariable Integer id) {
        return paymentRespository.findById(id);
    }

    @PostMapping("payments/")
    public ResponseEntity createPayment(@Valid @RequestBody Payment newPayment) {

        newPayment.setId(null);
        paymentRespository.save(newPayment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newPayment.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/payments/{id}")
    public void deletePayment(@PathVariable Integer id) {
        try {
            paymentRespository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("Unable to delete payment with id: " + id);
        }
    }

}

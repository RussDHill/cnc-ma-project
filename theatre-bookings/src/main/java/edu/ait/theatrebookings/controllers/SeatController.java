package edu.ait.theatrebookings.controllers;

import edu.ait.theatrebookings.dto.Seat;
import edu.ait.theatrebookings.repositories.SeatRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
public class SeatController {

    @Autowired
    SeatRespository seatRespository;

    @GetMapping("/seats")
    public List<Seat> getAllSeats() {
        return seatRespository.findAll();
    }

    @GetMapping("/seats/{id}")
    Optional<Seat> getPaymentById(@PathVariable Integer id) {
        return seatRespository.findById(id);
    }

    // No need for other methods - Seat table is read only
}

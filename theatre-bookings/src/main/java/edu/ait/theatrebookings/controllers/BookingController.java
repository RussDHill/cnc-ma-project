package edu.ait.theatrebookings.controllers;

import edu.ait.theatrebookings.dto.Payment;
import edu.ait.theatrebookings.exceptions.DataNotFoundException;
import edu.ait.theatrebookings.feignclients.TheatrePerformanceClient;
import edu.ait.theatrebookings.repositories.BookingRespository;
import edu.ait.theatrebookings.dto.Booking;
import edu.ait.theatrebookings.repositories.PaymentRespository;
import edu.ait.theatreperformances.dto.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRespository bookingRespository;

    @Autowired
    TheatrePerformanceClient theatrePerformanceClient;

    @Autowired
    PaymentRespository paymentRespository;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingRespository.findAll();
    }

    @GetMapping("/bookings/{id}")
    Optional<Booking> getBookingById(@PathVariable Integer id) {
        return bookingRespository.findById(id);
    }

    @GetMapping("/bookings/performance/{id}")
    List<Booking> getBookingPerformanceById(@PathVariable Integer id) {
        return bookingRespository.findByPerformanceId(id);
    }

    @PostMapping("bookings/")
    public ResponseEntity createBooking(@Valid @RequestBody Booking newBooking) {

        Optional<Performance> performance =
                theatrePerformanceClient.getPerformanceById(newBooking.getPerformanceId());

        Optional<Payment> payment =
                paymentRespository.findById(newBooking.getPaymentId());

        if (performance.isPresent() && payment.isPresent()) {
            newBooking.setId(null);
            bookingRespository.save(newBooking);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(newBooking.getId()).toUri();

            return ResponseEntity.created(location).build();
        } else {
            throw new DataNotFoundException(
                    "Unable to create booking with performance id: " +
                    newBooking.getPerformanceId());
        }
    }

    @PutMapping("bookings/")
    public ResponseEntity updateBooking(@RequestBody Booking newBooking) {

        Optional<Booking> booking =
                bookingRespository.findById(newBooking.getId());

        if (booking.isPresent()) {

            bookingRespository.save(newBooking);

            return ResponseEntity.status(HttpStatus.OK).build();

        } else {
            throw new DataNotFoundException(
                    "Unable to update booking with id: " +
                            newBooking.getId());
        }
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        try {
            bookingRespository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("Unable to delete booking  with id: " + id);
        }
    }
}

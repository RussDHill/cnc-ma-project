package edu.ait.theatrebookingsystem.feignclients;

import edu.ait.theatrebookings.dto.*;
import edu.ait.theatreperformances.dto.Description;
import edu.ait.theatreperformances.dto.DescriptionSummary;
import edu.ait.theatreperformances.dto.Performance;
import edu.ait.theatreperformances.dto.PerformanceDescription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@FeignClient("netflix-zuul-api-gateway")
public interface TheatreBookingClient {

    @GetMapping("/theatre-bookings/bookings")
    List<Booking> getAllBookings();

    @GetMapping("/theatre-bookings/bookings/{id}")
    Optional<Booking> getBookingById(@PathVariable Integer id);

    @GetMapping("/theatre-bookings/bookings/performance/{id}")
    List<Booking> getBookingByPerformanceId(@PathVariable Integer id);

    @PostMapping("/theatre-bookings/bookings/")
    ResponseEntity createBooking(@Valid @RequestBody Booking newBooking);

    @PutMapping("/theatre-bookings/bookings/")
    ResponseEntity updateBooking(@RequestBody Booking newBooking);

    @DeleteMapping("/theatre-bookings/bookings/{id}")
    void deleteBooking(@PathVariable Integer id);


    @GetMapping("/theatre-bookings/payments")
    public List<Payment> getAllPayments();

    @GetMapping("/theatre-bookings/payments/{id}")
    Optional<Payment> getPaymentById(@PathVariable Integer id);

    @PostMapping("/theatre-bookings/payments/")
    public ResponseEntity createPayment(@Valid @RequestBody Payment newPayment);

    @PutMapping("/theatre-bookings/payments/")
    public ResponseEntity updatePayment(@RequestBody Payment newPayment) ;

    @DeleteMapping("/theatre-bookings/payments/{id}")
    public void deletePayment(@PathVariable Integer id);


    @GetMapping("/theatre-bookings/seats")
    public List<Seat> getAllSeats();

    @GetMapping("/theatre-bookings/seats/{id}")
    Optional<Seat> getSeatById(@PathVariable Integer id);


    @GetMapping("/theatre-bookings/theatre-booking/descriptions")
    List<Description> getAllDescriptions();

    @GetMapping("/theatre-bookings/theatre-booking/descriptions/summary")
    List<DescriptionSummary> getAllDescriptionsBySummaries();

    @GetMapping("/theatre-bookings/theatre-booking/descriptions/{id}")
    Optional<Description> getDescriptionById(@PathVariable Integer id);

    @DeleteMapping("/theatre-bookings/theatre-booking/descriptions/{id}")
    void deleteDescription(@PathVariable Integer id);

    @PostMapping("/theatre-bookings/theatre-booking/descriptions/")
    ResponseEntity createDescription(@RequestBody Description newDesc);

    @PutMapping("/theatre-bookings/theatre-booking/descriptions/")
    ResponseEntity updateWine(@RequestBody Description newDesc);

    @GetMapping("/theatre-bookings/theatre-booking/performances/descriptions")
    List<PerformanceDescription> getPerformancesDescriptionsByPage();

    @GetMapping("/theatre-bookings/theatre-booking/performances/{id}/descriptions")
    Optional<PerformanceDescription> getPerformancesDescriptionsById(@PathVariable Integer id);

    @GetMapping("/theatre-bookings/theatre-booking/performances")
    List<Performance> getAllPerformances();

    @GetMapping("/theatre-bookings/theatre-booking/performances/{id}")
    Optional<Performance> getPerformanceById(@PathVariable Integer id);

    @DeleteMapping("/theatre-bookings/theatre-booking/performances/{id}")
    void deletePerformance(@PathVariable Integer id);

    @PostMapping("/theatre-bookings/theatre-booking/performances/")
    ResponseEntity createPerformance(@RequestBody Performance newPerf);

    @PutMapping("/theatre-bookings/theatre-booking/performances/")
    ResponseEntity updatePerformance(@RequestBody Performance newPerf);

    @GetMapping("/theatre-bookings/theatre-booking/performance-config")
    String getPerformanceConfig();

    @GetMapping("/theatre-bookings/booking-config")
    String getBookingConfig();
}

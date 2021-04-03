package edu.ait.theatrebookingsystem.controllers;

import edu.ait.theatrebookings.dto.Booking;
import edu.ait.theatrebookings.dto.Payment;
import edu.ait.theatrebookingsystem.dto.*;
import edu.ait.theatrebookingsystem.feignclients.*;
import edu.ait.theatreperformances.dto.*;
import edu.ait.theatreperformances.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TheatreController {

    @Autowired
    TheatreBookingClient theatreBookingClient;

    @GetMapping("/descriptions/summary")
    public List<String> getAllPerformanceSummaries() {

        List<Description> descriptions = theatreBookingClient.getAllDescriptions();
        List<Performance> performances = theatreBookingClient.getAllPerformances();

        Map<Integer, Description> descriptionSummaryMap = descriptions.stream()
                .collect(Collectors.toMap(Description::getId, ds -> ds));

        List<String> allPerformanceSummaries  = new ArrayList<String>();

        for (Performance performance : performances) {
            String tmp = descriptionSummaryMap.get(performance.getDescription()).getName() + " - " +
                    performance.getDate().toString() + " - " +
                    performance.getTime().toString();

            allPerformanceSummaries.add(tmp);
        }

        return allPerformanceSummaries;
    }

    @GetMapping("/performance/description/{id}")
    public Optional<FlatPerformanceDescription> getAllPerformanceDetailById(@PathVariable Integer id) {

        Optional<PerformanceDescription> performanceDescription  =
                theatreBookingClient.getPerformancesDescriptionsById(id);

        if (performanceDescription.isPresent()) {
            FlatPerformanceDescription flatPerformanceDescription =
                    new FlatPerformanceDescription(performanceDescription.get());

            return Optional.of(flatPerformanceDescription);
        } else {
            return Optional.empty();
        }
    }

    @GetMapping("/booked/performance/{id}")
    List<Integer> getBookedSeatsByPerformanceId(@PathVariable Integer id) {

        List<Booking> bookings = theatreBookingClient.getBookingByPerformanceId(id);

        List<Integer> bookedSeats = new ArrayList<>();

        for (Booking booking : bookings) {
            bookedSeats.add(booking.getSeatId());
        }

        return bookedSeats;
    }

    @PostMapping("/paid-bookings/")
    public ResponseEntity createPaidBooking(@Valid @RequestBody PaidBooking paidBooking) {

        Optional<Performance> performance =
                theatreBookingClient.getPerformanceById(paidBooking.getPerformanceId());

        if (performance.isPresent()) {

            Payment payment = new Payment(null, paidBooking.getDate(),
                    paidBooking.getAmount(), paidBooking.getPayType());

            ResponseEntity responseEntity = theatreBookingClient.createPayment(payment);

            if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
                throw new DataNotFoundException(
                        "Unable to create payment for paid booking with performance id: " +
                                paidBooking.getPerformanceId());
            }

            String location = responseEntity.getHeaders().getLocation().toString();
            String strPayId = location.substring(location.lastIndexOf("/") + 1);
            Integer payId = Integer.parseInt(strPayId);

            List<Integer> seatIds = paidBooking.getSeatIds();
            for (Integer seatId:  seatIds) {
                Booking booking = new Booking(null, payId, seatId, paidBooking.getPerformanceId());
                responseEntity = theatreBookingClient.createBooking(booking);
                if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
                    throw new DataNotFoundException(
                            "Unable to create booking for paid booking with performance id: " +
                                    paidBooking.getPerformanceId());
                }
            }

            URI uriLocation = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(payId).toUri();

            return ResponseEntity.created(uriLocation).build();
        } else {
            throw new DataNotFoundException(
                    "Unable to create booking with performance id: " +
                            paidBooking.getPerformanceId());
        }
    }

    @GetMapping("/theatre-config")
    public String getTheatreConfig() {
        return theatreBookingClient.getBookingConfig() + " - " + theatreBookingClient.getPerformanceConfig();
    }
}

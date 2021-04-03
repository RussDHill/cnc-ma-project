package edu.ait.theatrebookings.controllers;

import edu.ait.theatrebookings.config.Configuration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RefreshScope
@RestController
class BookingConfigController {

    @Autowired
    Configuration config;

    @GetMapping("/booking-config")
    String getBookingConfig() {
        return config.getCreditCard() + " - " + config.getSeats();
    }
}

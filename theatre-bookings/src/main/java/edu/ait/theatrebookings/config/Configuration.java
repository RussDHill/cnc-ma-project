package edu.ait.theatrebookings.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("theatre-bookings")
@Component
public class Configuration {

    private String creditcard;
    private String seats;

    public String getCreditCard() {
        return creditcard;
    }

    public void setCreditCard(String creditcard) {
        this.creditcard = creditcard;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}

package edu.ait.theatreperformances.controllers;

import edu.ait.theatreperformances.config.Configuration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RefreshScope
@RestController
class TheatreController {

    @Autowired
    Configuration config;

    @RequestMapping("/theatre")
    String getTheatre() {
        return config.getName() + " - " + config.getSeats();
    }
}

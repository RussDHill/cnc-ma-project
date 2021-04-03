package edu.ait.theatreperformances.controllers;

import edu.ait.theatreperformances.config.Configuration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RefreshScope
@RestController
class PerformanceConfigController {

    @Autowired
    Configuration config;

    @GetMapping("/performance-config")
    String getPerformanceConfig() {
        return config.getName();
    }
}

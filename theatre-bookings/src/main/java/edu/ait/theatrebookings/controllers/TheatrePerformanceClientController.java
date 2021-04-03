package edu.ait.theatrebookings.controllers;

import edu.ait.theatreperformances.dto.*;
import edu.ait.theatrebookings.feignclients.TheatrePerformanceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatre-booking")
public class TheatrePerformanceClientController {

    @Autowired
    TheatrePerformanceClient theatrePerformanceClient;

    @GetMapping("/descriptions")
    List<Description> getAllDescriptions() {
        return theatrePerformanceClient.getDescriptions();
    }

    @GetMapping("/descriptions/summary")
    List<DescriptionSummary> getAllDescriptionsBySummaries() {
        return theatrePerformanceClient.getAllDescriptionsBySummaries();
    }

    @GetMapping("/descriptions/{id}")
    Optional<Description> getDescriptionById(@PathVariable Integer id) {
        return theatrePerformanceClient.getDescriptionById(id);
    }

    @DeleteMapping("/descriptions/{id}")
    void deleteDescription(@PathVariable Integer id) {
        theatrePerformanceClient.deleteDescription(id);
    }

    @PostMapping("descriptions/")
    ResponseEntity createDescription(@RequestBody Description newDesc) {
        return theatrePerformanceClient.createDescription(newDesc);
    }

    @PutMapping("descriptions/")
    ResponseEntity updateWine(@RequestBody Description newDesc) {
        return theatrePerformanceClient.updateWine(newDesc);
    }

    @GetMapping("/performances/descriptions")
    List<PerformanceDescription> getPerformancesDescriptionsByPage() {
        return theatrePerformanceClient.getPerformancesDescriptions();
    }

    @GetMapping("/performances/{id}/descriptions")
    Optional<PerformanceDescription> getPerformancesDescriptionsById(@PathVariable Integer id) {
        return theatrePerformanceClient.getPerformancesDescriptionsById(id);
    }

    @GetMapping("/performances")
    List<Performance> getAllPerformances() {
        return theatrePerformanceClient.getPerformances();
    }

    @GetMapping("/performances/{id}")
    Optional<Performance> getPerformanceById(@PathVariable Integer id) {
        return theatrePerformanceClient.getPerformanceById(id);
    }

    @DeleteMapping("/performances/{id}")
    void deletePerformance(@PathVariable Integer id) {
        theatrePerformanceClient.deletePerformance(id);
    }

    @PostMapping("performances/")
    ResponseEntity createPerformance(@RequestBody Performance newPerf) {
        return theatrePerformanceClient.createPerformance(newPerf);
    }

    @PutMapping("performances/")
    ResponseEntity updatePerformance(@RequestBody Performance newPerf) {
        return theatrePerformanceClient.updatePerformance(newPerf);
    }

    @GetMapping("/performance-config")
    String getPerformanceConfig() {
        return theatrePerformanceClient.getPerformanceConfig();
    }
}

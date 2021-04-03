package edu.ait.theatrebookings.feignclients;

import edu.ait.theatreperformances.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("netflix-zuul-api-gateway")
public interface TheatrePerformanceClient {

    @GetMapping("/theatre-performances/descriptions")
    List<Description> getDescriptions();

    @GetMapping("/theatre-performances/descriptions/summary")
    List<DescriptionSummary> getAllDescriptionsBySummaries();

    @GetMapping("/theatre-performances/descriptions/{id}")
    Optional<Description> getDescriptionById(@PathVariable Integer id);

    @DeleteMapping("/theatre-performances/descriptions/{id}")
    void deleteDescription(@PathVariable Integer id);

    @PostMapping("/theatre-performances/descriptions/")
    ResponseEntity createDescription(@RequestBody Description newDesc);

    @PutMapping("/theatre-performances/descriptions/")
    ResponseEntity updateWine(@RequestBody Description newDesc);

    @GetMapping("/theatre-performances/performances/descriptions")
    List<PerformanceDescription> getPerformancesDescriptions();

    @GetMapping("/theatre-performances/performances/{id}/descriptions")
    Optional<PerformanceDescription> getPerformancesDescriptionsById(@PathVariable Integer id);

    @GetMapping("/theatre-performances/performances")
    List<Performance> getPerformances();

    @GetMapping("/theatre-performances/performances/{id}")
    Optional<Performance> getPerformanceById(@PathVariable Integer id);

    @DeleteMapping("/theatre-performances/performances/{id}")
    void deletePerformance(@PathVariable Integer id);

    @PostMapping("/theatre-performances/performances/")
    ResponseEntity createPerformance(@RequestBody Performance newPerf);

    @PutMapping("/theatre-performances/performances/")
    ResponseEntity updatePerformance(@RequestBody Performance newPerf);

    @GetMapping("/theatre-performances/performance-config")
    String getPerformanceConfig();
}

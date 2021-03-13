package edu.ait.theatrebookings.feignclients;

import edu.ait.theatreperformances.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("theatre-performances")
public interface TheatrePerformanceClient {

    @GetMapping("/descriptions")
    List<Description> getDescriptions();

    @GetMapping("/descriptions/summary")
    List<DescriptionSummary> getAllDescriptionsBySummaries();

    @GetMapping("/descriptions/{id}")
    Optional<Description> getDescriptionById(@PathVariable Integer id);

    @DeleteMapping("/descriptions/{id}")
    void deleteDescription(@PathVariable Integer id);

    @PostMapping("descriptions/")
    ResponseEntity createDescription(@RequestBody Description newDesc);

    @PutMapping("descriptions/")
    ResponseEntity updateWine(@RequestBody Description newDesc);

    @GetMapping("/performances/descriptions")
    List<PerformanceDescription> getPerformancesDescriptions();

    @GetMapping("/performances/{id}/descriptions")
    Optional<PerformanceDescription> getPerformancesDescriptionsById(@PathVariable Integer id);

    @GetMapping("/performances")
    List<Performance> getPerformances();

    @GetMapping("/performances/{id}")
    Optional<Performance> getPerformanceById(@PathVariable Integer id);

    @DeleteMapping("/performances/{id}")
    void deletePerformance(@PathVariable Integer id);

    @PostMapping("performances/")
    ResponseEntity createPerformance(@RequestBody Performance newPerf);

    @PutMapping("performances/")
    ResponseEntity updatePerformance(@RequestBody Performance newPerf);
}

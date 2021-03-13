package edu.ait.theatreperformances.controllers;

import edu.ait.theatreperformances.exceptions.DataNotFoundException;
import edu.ait.theatreperformances.repositories.PerformanceRepository;
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
public class PerformanceController {

    @Autowired
    PerformanceRepository performanceRepository;

    @GetMapping("/performances")
    public List<Performance> getPerformances() {
        return performanceRepository.findAll();
    }

    @GetMapping("/performances/{id}")
    public Optional<Performance> getPerformanceById(@PathVariable Integer id) {
        return performanceRepository.findById(id);
    }

    @PostMapping("performances/")
    public ResponseEntity createPerformance(@Valid @RequestBody Performance newPerf) {

        newPerf.setId(null);
        performanceRepository.save(newPerf);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newPerf.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("performances/")
    public ResponseEntity updatePerformance(@RequestBody Performance newPerf) {

        Integer newWineId = newPerf.getId();
        Performance savedWine = performanceRepository.save(newPerf);

        if (savedWine.getId().equals(newWineId)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(savedWine.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
    }

    @DeleteMapping("/performances/{id}")
    public void deletePerformance(@PathVariable Integer id) {
        try {
            performanceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("Unable to delete performance with id: " + id);
        }
    }
}

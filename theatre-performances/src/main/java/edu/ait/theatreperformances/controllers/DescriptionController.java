package edu.ait.theatreperformances.controllers;

import edu.ait.theatreperformances.dto.Description;
import edu.ait.theatreperformances.dto.DescriptionSummary;
import edu.ait.theatreperformances.exceptions.DataNotFoundException;
import edu.ait.theatreperformances.repositories.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class DescriptionController {

    @Autowired
    DescriptionRepository descriptionRepository;

    @GetMapping("/descriptions")
    public List<Description> getDescriptions() {
        return descriptionRepository.findAll();
    }

    @GetMapping("/descriptions/summary")
    public List<DescriptionSummary> getAllDescriptionsBySummaries() {
        return descriptionRepository.findAllDescriptionSummariesBy();
    }

    @GetMapping("/descriptions/{id}")
    public Optional<Description> getDescriptionById(@PathVariable Integer id) {
        Optional<Description> foundDescription = descriptionRepository.findById(id);
        if (foundDescription.isPresent()) {
            return foundDescription;
        } else {
            throw new DataNotFoundException("Unable to find description with id: " + id);
        }
    }

    @DeleteMapping("/descriptions/{id}")
    public void deleteDescription(@PathVariable Integer id) {
        try {
            descriptionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException("Unable to find description with id: " + id);
        }
    }

    @PostMapping("descriptions/")
    public ResponseEntity createDescription(@Valid @RequestBody Description newDesc) {

        newDesc.setId(null);
        descriptionRepository.save(newDesc);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newDesc.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("descriptions/")
    public ResponseEntity updateDescription(@RequestBody Description newDesc) {

        Integer newDescId = newDesc.getId();
        Description savedPerf = descriptionRepository.save(newDesc);

        if (savedPerf.getId().equals(newDescId)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(savedPerf.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
    }
}

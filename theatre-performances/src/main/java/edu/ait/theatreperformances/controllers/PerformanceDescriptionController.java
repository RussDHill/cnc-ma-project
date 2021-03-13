package edu.ait.theatreperformances.controllers;

import edu.ait.theatreperformances.repositories.PerformanceDescriptionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import edu.ait.theatreperformances.dto.PerformanceDescription;

import java.util.Optional;
import java.util.List;

@RestController
public class PerformanceDescriptionController {

    @Autowired
    PerformanceDescriptionRepository performanceDescriptionRepository;

    @GetMapping("/performances/descriptions")
    public List<PerformanceDescription> getPerformancesDescriptions() {
        return performanceDescriptionRepository.findAll();
    }

    @GetMapping("/performances/{id}/descriptions")
    public Optional<PerformanceDescription> getPerformancesDescriptionsById(@PathVariable Integer id) {
        return performanceDescriptionRepository.findById(id);
    }
}

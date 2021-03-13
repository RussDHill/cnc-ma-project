package edu.ait.theatreperformances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ait.theatreperformances.dto.PerformanceDescription;

public interface PerformanceDescriptionRepository extends JpaRepository<PerformanceDescription, Integer> {

}

package edu.ait.theatreperformances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ait.theatreperformances.dto.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Integer>
{

}

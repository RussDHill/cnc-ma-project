package edu.ait.theatreperformances.repositories;


import edu.ait.theatreperformances.dto.DescriptionSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.ait.theatreperformances.dto.Description;

import java.util.List;

public interface DescriptionRepository extends JpaRepository<Description, Integer>
{
    List<DescriptionSummary> findAllDescriptionSummariesBy();
}

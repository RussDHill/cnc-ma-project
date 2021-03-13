package edu.ait.theatrebookings.repositories;

import edu.ait.theatrebookings.dto.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRespository extends JpaRepository<Booking, Integer> {
    List<Booking> findByPerformanceId(Integer performanceId);
}

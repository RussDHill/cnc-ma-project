package edu.ait.theatrebookings.repositories;

import edu.ait.theatrebookings.dto.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRespository extends JpaRepository<Seat, Integer> {

}

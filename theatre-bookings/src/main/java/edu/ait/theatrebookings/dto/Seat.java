package edu.ait.theatrebookings.dto;

import javax.persistence.*;

@Entity
public class Seat {

    public enum Band {
        A, B, C;
    }

    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Band band;

    public Seat() {
    }

    public Seat(Integer id, Band band) {
        this.id = id;
        this.band = band;
    }

    public Integer getSeatId() {
        return id;
    }

    public void setSeatId(Integer seatNo) {
        this.id = seatNo;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + id +
                ", band=" + band +
                '}';
    }
}

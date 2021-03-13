package edu.ait.theatrebookings.dto;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer paymentId;

    @Min(value = 1, message = "Seat Id should not be less than 1")
    @Max(value = 24, message = "Seat Id should not be greater than 24")
    private Integer seatId;
    private Integer performanceId;

    public Booking() {
    }

    public Booking(Integer id, Integer paymentId, Integer seatId, Integer performanceId) {
        this.id = id;
        this.paymentId = paymentId;
        this.seatId = seatId;
        this.performanceId = performanceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer payment) {
        this.paymentId = payment;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seat) {
        this.seatId = seat;
    }

    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", paymentId=" + paymentId +
                ", seatId=" + seatId +
                ", performanceId=" + performanceId +
                '}';
    }
}


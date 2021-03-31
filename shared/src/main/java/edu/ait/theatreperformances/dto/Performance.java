package edu.ait.theatreperformances.dto;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.DecimalMin;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="performance")
@ApiModel(description="The date, time and cost of a performance")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @DecimalMin("20.00")
    private Float priceBandA;
    @DecimalMin("15.00")
    private Float priceBandB;
    @DecimalMin("10.00")
    private Float priceBandC;
    private LocalTime time;
    private Integer description_id;

    public Performance() {
    }

    public Performance(Integer id, LocalDate date, LocalTime time, Float priceBandA,
                       Float priceBandB, Float priceBandC, Integer description_id) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.priceBandA = priceBandA;
        this.priceBandB = priceBandB;
        this.priceBandC = priceBandC;
        this.description_id = description_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Float getPriceBandA() {
        return priceBandA;
    }

    public void setPriceBandA(Float priceBandA) {
        this.priceBandA = priceBandA;
    }

    public Float getPriceBandB() {
        return priceBandB;
    }

    public void setPriceBandB(Float priceBandB) {
        this.priceBandB = priceBandB;
    }

    public Float getPriceBandC() {
        return priceBandC;
    }

    public void setPriceBandC(Float priceBandC) {
        this.priceBandC = priceBandC;
    }

    public Integer getDescription() {
        return description_id;
    }

    public void setDescription(Integer description_id) {
        this.description_id = description_id;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", priceBandA=" + priceBandA +
                ", priceBandB=" + priceBandB +
                ", priceBandC=" + priceBandC +
                ", description_id=" + description_id +
                '}';
    }
}

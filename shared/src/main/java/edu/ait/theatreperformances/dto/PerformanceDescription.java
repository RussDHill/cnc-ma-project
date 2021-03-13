package edu.ait.theatreperformances.dto;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="performance")
public class PerformanceDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Float priceBandA;
    private Float priceBandB;
    private Float priceBandC;
    private Time time;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Description description;

    public PerformanceDescription() {
    }

    public PerformanceDescription(Integer id, Date date, Float priceBandA, Float priceBandB,
                                  Float priceBandC, Time time, Description description) {
        this.id = id;
        this.date = date;
        this.priceBandA = priceBandA;
        this.priceBandB = priceBandB;
        this.priceBandC = priceBandC;
        this.time = time;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PerformanceDescription{" +
                "id=" + id +
                ", date=" + date +
                ", priceBandA=" + priceBandA +
                ", priceBandB=" + priceBandB +
                ", priceBandC=" + priceBandC +
                ", time=" + time +
                ", description=" + description +
                '}';
    }
}

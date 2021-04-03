package edu.ait.theatrebookingsystem.dto;

import edu.ait.theatreperformances.dto.PerformanceDescription;
import edu.ait.theatreperformances.dto.Description;

import java.sql.Date;
import java.sql.Time;

public class FlatPerformanceDescription {

    private Integer id;
    private Date date;
    private Time time;
    private Float priceBandA;
    private Float priceBandB;
    private Float priceBandC;
    private String name;
    private String description;

    public FlatPerformanceDescription() {
    }

    public FlatPerformanceDescription(PerformanceDescription pd) {
        id = pd.getId();
        date = pd.getDate();
        time = pd.getTime();
        priceBandA = pd.getPriceBandA();
        priceBandB = pd.getPriceBandB();
        priceBandC = pd.getPriceBandC();
        Description d = pd.getDescription();
        name = d.getName();
        description = d.getDescription();
    }

    public FlatPerformanceDescription(Integer id, Date date, Time time, Float priceBandA,
                                      Float priceBandB, Float priceBandC,
                                      String name, String description) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.priceBandA = priceBandA;
        this.priceBandB = priceBandB;
        this.priceBandC = priceBandC;
        this.name = name;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FlatPerformanceDescription{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", priceBandA=" + priceBandA +
                ", priceBandB=" + priceBandB +
                ", priceBandC=" + priceBandC +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

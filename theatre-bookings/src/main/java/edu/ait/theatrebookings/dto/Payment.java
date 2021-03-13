package edu.ait.theatrebookings.dto;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.time.LocalDate;

@Entity
public class Payment {

    public enum PayType {
        ACCOUNT, CREDIT_CARD, CHEQUE, CASH;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @DecimalMin("10.00")
    private Float amount;
    @Enumerated(EnumType.ORDINAL)
    private PayType payType;

    public Payment() {
    }

    public Payment(Integer id, LocalDate date, Float amount, PayType payType) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.payType = payType;
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", payType=" + payType +
                '}';
    }
}

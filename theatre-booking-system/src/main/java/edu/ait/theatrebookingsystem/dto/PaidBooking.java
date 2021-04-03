package edu.ait.theatrebookingsystem.dto;

import edu.ait.theatrebookings.dto.Payment;

import java.time.LocalDate;
import java.util.List;

public class PaidBooking {

    public enum PayType {
        ACCOUNT, CREDIT_CARD, CHEQUE, CASH;
    }

    private List<Integer> seatIds;
    private Integer performanceId;
    private LocalDate date;
    private Float amount;
    private Payment.PayType payType;

    public PaidBooking() {
    }

    public PaidBooking(List<Integer> seatIds, Integer performanceId, LocalDate date, Float amount, Payment.PayType payType) {
        this.seatIds = seatIds;
        this.performanceId = performanceId;
        this.date = date;
        this.amount = amount;
        this.payType = payType;
    }

    public List<Integer> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Integer> seatIds) {
        this.seatIds = seatIds;
    }

    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
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

    public Payment.PayType getPayType() {
        return payType;
    }

    public void setPayType(Payment.PayType payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "PaidBooking{" +
                "seatIds=" + seatIds +
                ", performanceId=" + performanceId +
                ", date=" + date +
                ", amount=" + amount +
                ", payType=" + payType +
                '}';
    }
}

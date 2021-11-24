package com.example.bettingapplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Betslip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placedBetslip;
    private Double payment;
    private Double odds;
    private BigDecimal possibleGain;

    public Betslip() {

    }

    public Betslip(String placedBetslip, Double payment, Double odds, BigDecimal possibleGain) {
        this.placedBetslip = placedBetslip;
        this.payment = payment;
        this.odds = odds;
        this.possibleGain = possibleGain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlacedBetslip() {
        return placedBetslip;
    }

    public void setPlacedBetslip(String placedBetslip) {
        this.placedBetslip = placedBetslip;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public BigDecimal getPossibleGain() {
        return possibleGain;
    }

    public void setPossibleGain(BigDecimal possibleGain) {
        this.possibleGain = possibleGain;
    }
}

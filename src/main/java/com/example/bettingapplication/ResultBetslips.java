package com.example.bettingapplication;

import java.math.BigDecimal;
import java.util.List;

public class ResultBetslips {
    private List<MatchOnBetslip> matchesOnBetslip;
    private Double payment;
    private Double odds;
    private BigDecimal possibleGain;

    public ResultBetslips(List<MatchOnBetslip> matchesOnBetslip, Double payment, Double odds, BigDecimal possibleGain) {
        this.matchesOnBetslip = matchesOnBetslip;
        this.payment = payment;
        this.odds = odds;
        this.possibleGain = possibleGain;
    }

    public List<MatchOnBetslip> getMatchesOnBetslip() {
        return matchesOnBetslip;
    }

    public void setMatchesOnBetslip(List<MatchOnBetslip> matchesOnBetslip) {
        this.matchesOnBetslip = matchesOnBetslip;
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

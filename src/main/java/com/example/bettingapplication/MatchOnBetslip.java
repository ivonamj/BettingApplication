package com.example.bettingapplication;

public class MatchOnBetslip {
    private String name;
    private char homeAwayDraw;
    private Double odd;

    public MatchOnBetslip(String name, char homeAwayDraw, Double odd) {
        this.name = name;
        this.homeAwayDraw = homeAwayDraw;
        this.odd = odd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getHomeAwayDraw() {
        return homeAwayDraw;
    }

    public void setHomeAwayDraw(char homeAwayDraw) {
        this.homeAwayDraw = homeAwayDraw;
    }

    public Double getOdd() {
        return odd;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
}

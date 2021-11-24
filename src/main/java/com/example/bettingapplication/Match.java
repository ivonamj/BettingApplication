package com.example.bettingapplication;

import javax.persistence.*;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double home_win;
    private Double away_win;
    private Double draw;

    public Match() {

    }

    public Match(String name, Double home_win, Double away_win, Double draw) {
        this.name = name;
        this.home_win = home_win;
        this.away_win = away_win;
        this.draw = draw;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHome_win() {
        return home_win;
    }

    public void setHome_win(Double home_win) {
        this.home_win = home_win;
    }

    public Double getAway_win() {
        return away_win;
    }

    public void setAway_win(Double away_win) {
        this.away_win = away_win;
    }

    public Double getDraw() {
        return draw;
    }

    public void setDraw(Double draw) {
        this.draw = draw;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", home_win=" + home_win +
                ", away_win=" + away_win +
                ", draw=" + draw +
                '}';
    }
}

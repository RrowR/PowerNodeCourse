package com.test.day99finalTask.task01;

import java.util.Date;
import java.util.Objects;

public class WorldCup {
    private Date year;
    private String country;
    private String winner;

    public WorldCup() {
    }

    public WorldCup(Date year, String country, String winner) {
        this.year = year;
        this.country = country;
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldCup worldCup = (WorldCup) o;
        return Objects.equals(year, worldCup.year) &&
                Objects.equals(country, worldCup.country) &&
                Objects.equals(winner, worldCup.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, country, winner);
    }

    @Override
    public String toString() {
        return "WorldCup{" +
                "year=" + year +
                ", country='" + country + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}

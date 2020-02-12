package com.twu.biblioteca.model;

public class Movie {

    private String name;
    private String director;
    private int year;
    private double rating;
    private boolean availability;

    public Movie(String name, String director, int year, double rating, boolean availability) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

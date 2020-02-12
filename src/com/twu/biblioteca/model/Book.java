package com.twu.biblioteca.model;

public class Book {

    private String name;
    private String author;
    private int  publishYear;
    private boolean isAvailable;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }
}

package com.twu.biblioteca.model;

public class Book {

    private String name;
    private String author;
    private int  publishYear;
    private boolean status;

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.status = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

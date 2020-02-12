package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.Arrays;
import java.util.List;

public class LibraryRepository {

    List<Book> books;

    public LibraryRepository(){
        books = Arrays.asList(new Book("The Hobbit", "J.R.R. Tolkien", 1937),
                new Book("A Clockwork Orange", "Anthony Burgess", 1962),
                new Book("Neuromancer", "William Gibson", 1984),
                new Book("The Adventures of Tom Sawyer", "Mark Twain", 1876));
    }

    public List<Book> allBooks(){
        return books;
    }

    public Book findBook(String bookName){
        for (Book bookFound: books) {
            if (bookFound.getName().equals(bookName) &&
                    bookFound.getAvailable()) {
                return bookFound;
            }
        }
        return null;
    }

    public Book findCheckedOutBook(String bookName){
        for (Book bookFound: books) {
            if (bookFound.getName().equals(bookName) &&
                    !bookFound.getAvailable()) {
                return bookFound;
            }
        }
        return null;
    }
}

package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryService {

    public List<Book> listOfBooks(){
        return Arrays.asList(new Book("The Hobbit", "J.R.R. Tolkien", 1937),
                new Book("A Clockwork Orange", "Anthony Burgess", 1962),
                new Book("Neuromancer", "William Gibson", 1984),
                new Book("The Adventures of Tom Sawyer", "Mark Twain", 1876));
    }

    public List<String> listOfBookAssembler(){
        List<String> newBookList = new ArrayList<>();

        for (Book book:listOfBooks()) {
            newBookList.add(book.getName() + " | " + book.getAuthor() + " | " + book.getPublishYear());
        }

        return newBookList;
    }

}

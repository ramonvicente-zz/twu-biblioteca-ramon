package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.view.LibraryView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryService {

    private LibraryView libraryView;

    List<Book> books = Arrays.asList(new Book("The Hobbit", "J.R.R. Tolkien", 1937),
            new Book("A Clockwork Orange", "Anthony Burgess", 1962),
            new Book("Neuromancer", "William Gibson", 1984),
            new Book("The Adventures of Tom Sawyer", "Mark Twain", 1876));


    public List<String> listOfBookAssembler(){
        List<String> newBookList = new ArrayList<>();

        for (Book book:books) {
            if(book.getStatus() == true){
                newBookList.add(book.getName() + " | " + book.getAuthor() + " | " + book.getPublishYear());
            }
        }

        return newBookList;
    }

    public boolean checkOutBook(String bookTyped){
        Book bookToCheckOut = searchBook(bookTyped);
        if(bookToCheckOut!=null){
            bookToCheckOut.setStatus(false);
            return true;
        }
        return false;
    }

    private Book searchBook(String bookName){
        for (Book bookFound: books) {
            if (bookFound.getName().equals(bookName) &&
                    bookFound.getStatus()==true) {
                return bookFound;
            }
        }
        return null;
    }

    private Book searchCheckedOutBook(String bookName){
        for (Book bookFound: books) {
            if (bookFound.getName().equals(bookName) &&
                    bookFound.getStatus()==false) {
                return bookFound;
            }
        }
        return null;
    }

    public boolean returnBook(String bookTyped){
        Book bookToCheckOut = searchCheckedOutBook(bookTyped);
        if(bookToCheckOut!=null){
            bookToCheckOut.setStatus(true);
            return true;
        }
        return false;
    }

}

package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.LibraryRepository;
import com.twu.biblioteca.view.LibraryView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryService {

    private LibraryView libraryView;
    private LibraryRepository libraryRepository;

    public LibraryService(){
        libraryRepository = new LibraryRepository();
    }

    public List<Book> listAllBooks(){
        return libraryRepository.allBooks();
    }

    public List<String> listOfBookAssembler(){
        List<String> newBookList = new ArrayList<>();

        for (Book book : listAllBooks()) {
            if(book.getAvailable()) {
                newBookList.add(book.getName() + " | " + book.getAuthor() + " | " + book.getPublishYear());
            }
        }

        return newBookList;
    }

    public boolean checkOutBook(String bookName) {
        Book bookToCheckOut = libraryRepository.findBook(bookName);
        if (bookToCheckOut != null) {
            bookToCheckOut.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        Book bookToCheckOut = libraryRepository.findCheckedOutBook(bookName);
        if (bookToCheckOut != null) {
            bookToCheckOut.setAvailable(true);
            return true;
        }
        return false;
    }
}

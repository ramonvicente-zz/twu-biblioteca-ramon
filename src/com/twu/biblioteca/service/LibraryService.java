package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.LibraryRepository;
import com.twu.biblioteca.view.LibraryView;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

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
            if(book.getAvailability()) {
                newBookList.add(book.getName() + " | " + book.getAuthor() + " | " + book.getPublishYear());
            }
        }
        return newBookList;
    }

    public boolean borrowBook(String bookName) {
        Book bookToBorrow = libraryRepository.findBook(bookName);
        if (bookToBorrow != null) {
            bookToBorrow.setAvailability(false);
            return true;
        }
        return false;
    }

    public boolean giveBookBack(String bookName) {
        Book bookToGiveBack = libraryRepository.findCheckedOutBook(bookName);
        if (bookToGiveBack != null) {
            bookToGiveBack.setAvailability(true);
            return true;
        }
        return false;
    }
}

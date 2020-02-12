package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(){
        bookRepository = new BookRepository();
    }

    public List<Book> listAllBooks(){
        return bookRepository.allBooks();
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
        Book bookToBorrow = bookRepository.findBook(bookName);
        if (bookToBorrow != null) {
            bookToBorrow.setAvailability(false);
            return true;
        }
        return false;
    }

    public boolean giveBookBack(String bookName) {
        Book bookToGiveBack = bookRepository.findCheckedOutBook(bookName);
        if (bookToGiveBack != null) {
            bookToGiveBack.setAvailability(true);
            return true;
        }
        return false;
    }
}

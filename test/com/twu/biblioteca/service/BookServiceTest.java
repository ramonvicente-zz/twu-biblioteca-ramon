package com.twu.biblioteca.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookServiceTest {

    BookService bookService;

    @Before
    public void setUp(){
        bookService = new BookService();
    }

    @Test
    public void shouldThereAreAListOfBook(){
        Assert.assertNotNull(bookService.listAllBooks());
    }

    @Test
    public void shouldHaveAnSpecificBookInTheListOfBooks(){
        String book = "Neuromancer | William Gibson | 1984";
        Assert.assertTrue(bookService.listOfBookAssembler().contains(book));
    }

    @Test
    public void shouldCustomerCheckoutASpecificBook(){
        String bookChosen = "A Clockwork Orange";
        Assert.assertTrue(bookService.borrowBook(bookChosen));
    }

   @Test
    public void shouldCustomerReturnAChekoutedBook(){
        String bookChosen = "A Clockwork Orange";
        bookService.borrowBook(bookChosen);

        Assert.assertTrue(bookService.giveBookBack(bookChosen));
    }

}

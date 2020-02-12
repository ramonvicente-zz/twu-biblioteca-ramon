package com.twu.biblioteca.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibraryServiceTest {

    LibraryService libraryService;

    @Before
    public void setUp(){
        libraryService = new LibraryService();
    }

    @Test
    public void shouldThereAreAListOfBook(){
        Assert.assertNotNull(libraryService.listAllBooks());
    }

    @Test
    public void shouldHaveAnSpecificBookInTheListOfBooks(){
        String book = "Neuromancer | William Gibson | 1984";
        Assert.assertTrue(libraryService.listOfBookAssembler().contains(book));
    }

    @Test
    public void shouldCustomerCheckoutASpecificBook(){
        String bookChosen = "A Clockwork Orange";
        Assert.assertTrue(libraryService.borrowBook(bookChosen));
    }

   @Test
    public void shouldCustomerReturnAChekoutedBook(){
        String bookChosen = "A Clockwork Orange";
        libraryService.borrowBook(bookChosen);

        Assert.assertTrue(libraryService.giveBookBack(bookChosen));
    }

}

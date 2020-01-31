package com.twu.biblioteca.model;

import com.twu.biblioteca.service.LibraryService;
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
    public void shouldShowWelcomeMessage(){
        Assert.assertEquals("Welcome to Biblioteca. Your one-stop-shop for great " +
                "book titles in Bangalore!", libraryService.showWelcomeMessage());
    }

    @Test
    public void shouldThereAreAListOfBook(){
        Assert.assertNotNull(libraryService.listOfBooks());
    }

    @Test
    public void shouldHaveAnSpecificBookInTheListOfBooks(){
        String book = "Neuromancer | William Gibson | 1984";

        Assert.assertTrue(libraryService.listOfBookAssembler().contains(book));
    }
}

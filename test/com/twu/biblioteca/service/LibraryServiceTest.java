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
        Assert.assertNotNull(libraryService.listOfBooks());
    }

    @Test
    public void shouldHaveAnSpecificBookInTheListOfBooks(){
        String book = "Neuromancer | William Gibson | 1984";

        Assert.assertTrue(libraryService.listOfBookAssembler().contains(book));
    }
}

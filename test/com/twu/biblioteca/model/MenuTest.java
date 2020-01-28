package com.twu.biblioteca.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MenuTest {

    private List<Book> books;

    @Before
    public void setUp(){
        //books = Arrays.asList(new Book("The Crow", ));
    }

    @Test
    public void shouldShowWelcomeMessage(){
        Menu menu = new Menu();
        Assert.assertEquals("Welcome to Biblioteca. Your one-stop-shop for great " +
                "book titles in Bangalore!", menu.showWelcomeMessage());
    }
}

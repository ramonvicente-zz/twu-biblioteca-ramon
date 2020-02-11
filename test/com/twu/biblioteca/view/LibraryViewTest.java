package com.twu.biblioteca.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibraryViewTest {

    LibraryView libraryView;

    @Before
    public void setup(){
        libraryView = new LibraryView();
    }

    @Test
    public void shouldShowWelcomeMessage(){
        String message = "Welcome to Biblioteca. Your one-stop-shop for great " +
                "book titles in Bangalore!";

        Assert.assertEquals(message, libraryView.welcomeMessage());
    }

    @Test
    public void shouldShowInvalidMenuOptionMessage(){
        String message = "Please select a valid option!";

        Assert.assertEquals(message, libraryView.invalidMenuOptionMessage());
    }

    @Test
    public void shouldReturnASuccessMessageWhenUserCheckOutAnExistingBook(){
        String message = "Thank you. Enjoy the book";
        Assert.assertEquals(message, libraryView.checkoutBookSuccessMessage());
    }

    @Test
    public void shouldReturnAUnErroMessageWhenUserCheckOutAnExistingBook(){
        String message = "Sorry, that book is not available";
        Assert.assertEquals(message, libraryView.checkoutBookErrorMessage());
    }
}

package com.twu.biblioteca.view;

import org.junit.Assert;
import org.junit.Test;

public class LibraryViewTest {

    @Test
    public void shouldShowWelcomeMessage(){
        String message = "Welcome to Biblioteca. Your one-stop-shop for great " +
                "book titles in Bangalore!";

        LibraryView libraryView = new LibraryView();

        Assert.assertEquals(message, libraryView.showWelcomeMessage());
    }
}

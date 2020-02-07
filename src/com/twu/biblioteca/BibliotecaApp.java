package com.twu.biblioteca;

import com.twu.biblioteca.view.LibraryView;

public class BibliotecaApp {

    public static void main(String[] args) {

        LibraryView libraryView = new LibraryView();
        System.out.println(libraryView.welcomeMessage());
        System.out.println();
        libraryView.showMenu();
    }
}

package com.twu.biblioteca;

import com.twu.biblioteca.service.LibraryService;

public class BibliotecaApp {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();
        System.out.println(libraryService.showWelcomeMessage());
        System.out.println();

        for (String book: libraryService.listOfBookAssembler()) {
            System.out.println(book);
        }

    }
}

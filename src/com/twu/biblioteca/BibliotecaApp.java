package com.twu.biblioteca;

import com.twu.biblioteca.model.Menu;

public class BibliotecaApp {

    public static void main(String[] args) {

        Menu menu = new Menu();
        System.out.println(menu.showWelcomeMessage());
    }
}

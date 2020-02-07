package com.twu.biblioteca.view;

import com.twu.biblioteca.service.LibraryService;

import java.util.Scanner;

public class LibraryView {

    private LibraryService libraryService;

    public LibraryView(){
        libraryService = new LibraryService();
    }

    public String welcomeMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1 - List of Books");
        int menuOption = scanner.nextInt();

        switch (menuOption){
            case 1:
                for (String book : libraryService.listOfBookAssembler()) {
                    System.out.println(book);
                }
                break;
            default:
                System.out.println(invalidMenuOptionMessage());
                showMenu();
        }
    }

    public String invalidMenuOptionMessage(){
        return "Please select a valid option!";
    }
}

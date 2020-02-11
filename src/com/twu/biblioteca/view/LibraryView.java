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
        System.out.println(" " +
                "0 - Exit application \n 1 - List of Books " +
                "\n 2 - Checkout Book");
        int menuOption = scanner.nextInt();

        switch (menuOption){
            case 0:
                break;
            case 1:
                for (String book : libraryService.listOfBookAssembler()) {
                    System.out.println(book);
                }
                showMenu();
                break;
            case 2:
                System.out.println("Type the book name:");

                Scanner newScanner = new Scanner(System.in);
                String bookName = newScanner.nextLine();

                if(libraryService.checkOutBook(bookName)){
                    System.out.println(checkoutBookSuccessMessage());
                } else{
                    System.out.println(checkoutBookErrorMessage());
                }
                showMenu();
                break;
            default:
                System.out.println(invalidMenuOptionMessage());
                showMenu();
        }
    }

    public String invalidMenuOptionMessage(){
        return "Please select a valid option!";
    }

    public String checkoutBookSuccessMessage(){
        return "Thank you. Enjoy the book";
    }

    public String checkoutBookErrorMessage(){
        return "Sorry, that book is not available";
    }
}

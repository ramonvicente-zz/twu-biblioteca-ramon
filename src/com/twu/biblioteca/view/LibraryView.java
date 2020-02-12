package com.twu.biblioteca.view;

import com.twu.biblioteca.service.BookService;

import java.util.Scanner;

public class LibraryView {

    private BookService libraryService;

    public LibraryView(){
        libraryService = new BookService();
    }

    public String welcomeMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println(" " +
                "0 - Exit application \n 1 - List of Books " +
                "\n 2 - Checkout Book \n 3 - Return Book");
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
                String bookNameToBorrow = newScanner.nextLine();

                bookActivityTemplate(libraryService.borrowBook(bookNameToBorrow),
                        borrowBookSuccessMessage(), borrowBookErrorMessage());
                break;
            case 3:
                System.out.println("Type the book name:");
                Scanner giveBackBookScanner = new Scanner(System.in);
                String bookNameToGiveBack = giveBackBookScanner.nextLine();

                bookActivityTemplate(libraryService.giveBookBack(bookNameToGiveBack),
                        giveBackBookSuccessMessage(), giveBackBookErrorMessage());
                break;
            default:
                System.out.println(invalidMenuOptionMessage());
                showMenu();
        }
    }

    public String invalidMenuOptionMessage(){
        return "Please select a valid option!";
    }

    public String borrowBookSuccessMessage(){
        return "Thank you. Enjoy the book";
    }

    public String borrowBookErrorMessage(){
        return "Sorry, that book is not available";
    }

    public String giveBackBookSuccessMessage(){
        return "Thank you for returning the book";
    }

    public String giveBackBookErrorMessage(){
        return "That is not a valid book to return";
    }

    public void bookActivityTemplate(boolean bookActivity, String successMessage, String errorMessage){
        if(bookActivity){
            System.out.println(successMessage);
        } else{
            System.out.println(errorMessage);
        }
        showMenu();
    }
}

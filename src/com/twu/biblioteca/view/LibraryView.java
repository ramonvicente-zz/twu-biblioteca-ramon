package com.twu.biblioteca.view;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;

import java.util.List;
import java.util.Scanner;

public class LibraryView {

    private BookService libraryService;
    private MovieService movieService;

    public LibraryView(){
        libraryService = new BookService();
        movieService = new MovieService();
    }

    public String welcomeMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println(" " +
                "0 - Exit application \n 1 - List of Books " +
                "\n 2 - Borrow Book \n 3 - Give Back Book \n 4 - Show Available Movies");
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

            case 4:
                System.out.println("MOVIE \t DIRECTOR \t YEAR \t RATING");
                showAvailableMovies();
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

    public void showAvailableMovies(){
        List<String> movies = movieService.listOfAvailableMoviesAssembler(movieService.listOfAllAvailableMovies());
        String allMovies = "";
        for(String movie : movies){
            allMovies += (movie + "\n");
        }
        System.out.println(allMovies);
    }
}

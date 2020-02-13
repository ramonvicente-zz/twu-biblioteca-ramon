package com.twu.biblioteca.view;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;

import java.util.List;
import java.util.Scanner;

public class LibraryView {

    private BookService libraryService;
    private MovieService movieService;
    private UserService userService;

    public LibraryView(){
        libraryService = new BookService();
        movieService = new MovieService();
        userService = new UserService();
    }

    public String welcomeMessage(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println(" " +
                "0 - Exit application \n 1 - List of Books " +
                "\n 2 - Borrow Book \n 3 - Give Back Book \n 4 - Show Available Movies \n 5 - Borrow Movie");
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
                if(userService.isLogged()) {
                    bookViewTemplate("borrow");
                } else {
                    doLoginTemplate();

                    if(!userService.isLogged()){
                        tryLoginAgain();
                    } else{
                        bookViewTemplate("borrow");
                    }
                }
                break;

            case 3:
                if(userService.isLogged()) {
                    bookViewTemplate("giveBack");
                } else {
                    doLoginTemplate();
                    if(!userService.isLogged()){
                        tryLoginAgain();
                    } else{
                        bookViewTemplate("giveBack");
                    }

                }
                break;

            case 4:
                System.out.println("MOVIE \t DIRECTOR \t YEAR \t RATING");
                showAvailableMovies();
                showMenu();
                break;

            case 5:
                System.out.println("Type the movie name:");
                String movieName = userTextInput();

                System.out.println(movieService.borrowMovie(movieName));
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
        return "That is not a valid book to give back";
    }

    public String userCanNotLoginMessage(){
        return "Your credentials not match";
    }

    private void showAvailableMovies(){
        List<String> movies = movieService.listOfAvailableMoviesAssembler(movieService.listOfAllAvailableMovies());
        String allMovies = "";
        for(String movie : movies){
            allMovies += (movie + "\n");
        }
        System.out.println(allMovies);
    }

    private void bookViewTemplate(String typeOfAction){
        System.out.println("Type the book name:");
        String userInput = userTextInput();
        if(typeOfAction.equals("borrow")){
            bookActivityTemplate(libraryService.borrowBook(userInput),
                    borrowBookSuccessMessage(), borrowBookErrorMessage());
        } else {
            bookActivityTemplate(libraryService.giveBookBack(userInput),
                    giveBackBookSuccessMessage(), giveBackBookErrorMessage());
        }
    }

    private void bookActivityTemplate(boolean bookActivity, String successMessage, String errorMessage){
        if(bookActivity){
            System.out.println(successMessage);
        } else{
            System.out.println(errorMessage);
        }
        showMenu();
    }

    private void doLoginTemplate(){
        System.out.println("You need log in to access this.");
        System.out.println("Type your library number:");
        String libraryNumber = userTextInput();

        System.out.println("Type your password:");
        String password = userTextInput();

        userService.login(libraryNumber, password);

        if(!userService.isLogged()){
            System.out.println(userCanNotLoginMessage());
            System.out.println("Try log in again");
            doLoginTemplate();
        } else {
            System.out.println("Now you are logged");
        }
    }

    private void tryLoginAgain(){
        System.out.println(userCanNotLoginMessage());
        System.out.println("Try log in again");
        doLoginTemplate();
    }

    private String userTextInput(){
        Scanner textScanner = new Scanner(System.in);
        return textScanner.nextLine();
    }
}

package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository {

    List<Movie> movies;

    public MovieRepository(){
        movies = Arrays.asList(
            new Movie("The Lion King", "Jon Favreau", 2019, 9, true),
            new Movie("The Goonies", "Richard Donner", 1985, 8.5, true),
            new Movie("The Nightmare Before Christmas", "Henry Selick", 1993, 10, false),
            new Movie("The Secret Life of Walter Mitty", "Ben Stiller", 2013, 7.6,true)
        );
    }

    public List<Movie> getAvailableMovies(){
        return movies.stream().filter(movie -> movie.isAvailability()).collect(Collectors.toList());
    }


    public Movie findAvailableMovie(String movieName){
        return getAvailableMovies().stream().filter(movie -> movie.getName().equals(movieName)).findFirst().orElse(null);
    }

    public void changeAvailableMovieToNotAvailable(Movie movie, boolean availability){
        getAvailableMovies().stream().filter(foundMovie -> foundMovie.getName().equals(movie.getName())).
                findFirst().get().setAvailability(availability);
    }
}

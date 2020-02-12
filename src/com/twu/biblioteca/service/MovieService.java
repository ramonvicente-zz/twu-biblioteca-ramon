package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(){
        movieRepository = new MovieRepository();
    }

    public List<Movie> listOfAllAvailableMovies(){
        return movieRepository.getAvailableMovies();
    }

    public List<String> listOfAvailableMoviesAssembler(List<Movie> movies){
        List<String> newMovieList = new ArrayList<String>();
        for(Movie movie : movies){
            newMovieList.add(movie.getName() + " | " + movie.getDirector() + " | " + movie.getYear() + " | " + movie.getRating());
        }
        return newMovieList;
    }

    public String borrowMovie(String movieName){
        Movie movie = movieRepository.findAvailableMovie(movieName);
        if(movie != null)
            movieRepository.changeAvailableMovieToNotAvailable(movie, false);

        if(movie != null && !movie.isAvailability()){
            return "Enjoy the Movie";
        } else{
            return "Sorry, that movie is not available";
        }
    }
}

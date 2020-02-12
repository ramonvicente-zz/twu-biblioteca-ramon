package com.twu.biblioteca.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovieServiceTest {
    MovieService movieService;

    @Before
    public void setUp(){
        movieService = new MovieService();
    }

    @Test
    public void shouldReturnAListOfAllAvailableMovies(){
        Assert.assertEquals(movieService.listOfAllAvailableMovies().size(), 3);
    }

}

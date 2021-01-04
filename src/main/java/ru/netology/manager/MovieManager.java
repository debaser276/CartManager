package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    Movie[] movies = new Movie[10];

    public MovieManager() {}

    public MovieManager(int moviesAmounts) {
        movies = new Movie[moviesAmounts];
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLastTen() {
        Movie[] tmp;
        int length;
        if (movies.length < 10) {
            length = movies.length - 1;
            tmp = new Movie[length];
        } else {
            length = 9;
            tmp = new Movie[length];
        }
        for (int i = 0; i < length; i++) {
            tmp[i] = movies[length];
        }
        return tmp;
    }
}

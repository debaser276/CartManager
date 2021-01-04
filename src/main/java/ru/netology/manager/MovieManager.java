package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    Movie[] movies = new Movie[0];
    private int moviesToShow;

    public MovieManager() {}

    public MovieManager(int moviesToShow) {
        this.moviesToShow = moviesToShow;
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLast() {
        Movie[] tmp;
        int length = Math.min(movies.length, 10);
        if (moviesToShow != 0) {
            length = moviesToShow;
        }
        tmp = new Movie[length];
        for (int i = 0; i < length; i++) {
            tmp[i] = movies[movies.length - i - 1];
        }
        return tmp;
    }
}

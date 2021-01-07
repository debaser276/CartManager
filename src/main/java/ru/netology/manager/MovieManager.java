package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    MovieRepository repository;
    private int moviesToShow;

    public MovieManager() {}

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieManager(MovieRepository repository, int moviesToShow) {
        this.repository = repository;
        this.moviesToShow = moviesToShow;
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getLast() {
        Movie[] movies = repository.findAll();
        Movie[] tmp;
        int length = Math.min(movies.length, 10);
        if (moviesToShow != 0 && moviesToShow < length) {
            length = moviesToShow;
        }
        tmp = new Movie[length];
        for (int i = 0; i < length; i++) {
            tmp[i] = movies[movies.length - i - 1];
        }
        return tmp;
    }

    public Movie findById(int id) {
        return repository.findByID(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}

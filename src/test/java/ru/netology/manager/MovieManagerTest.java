package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    MovieManager manager = new MovieManager();
    int movieCount = 15;
    Movie[] movies = new Movie[movieCount];

    @BeforeEach
    public void setup() {
        for (int i = 0; i < movieCount; i++) {
            movies[i] = new Movie(i + 1, "movie" + i + 1, "movie" + i + 1);
        }
    }

    @Test
    public void shouldReturnOne() {
        manager.addMovie(movies[0]);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmpty() {
        assertArrayEquals(new Movie[]{}, manager.getLast());
    }

    @Test
    public void shouldReturnMoreOne() {
        manager.addMovie(movies[0]);
        manager.addMovie(movies[1]);
        manager.addMovie(movies[2]);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[2], movies[1], movies[0]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastTen() {
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[14], movies[13], movies[12], movies[11], movies[10], movies[9], movies[8], movies[7], movies[6], movies[5]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastCustom() {
        int moviesToShow = 3;
        MovieManager manager = new MovieManager(moviesToShow);
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[14], movies[13], movies[12]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnOneCustom() {
        MovieManager manager = new MovieManager(1);
        manager.addMovie(movies[0]);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[0]};
        assertArrayEquals(expected, actual);
    }

}
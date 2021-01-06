package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {

    @Mock
    MovieRepository repository;

    @InjectMocks
    MovieManager manager;

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
        Movie[] returned = new Movie[]{movies[0]};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getLast();
        assertArrayEquals(returned, actual);
    }

    @Test
    public void shouldReturnEmpty() {
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(repository).findAll();
        assertArrayEquals(new Movie[]{}, manager.getLast());
    }

    @Test
    public void shouldReturnMoreOne() {
        manager.addMovie(movies[0]);
        manager.addMovie(movies[1]);
        manager.addMovie(movies[2]);
        Movie[] expected = new Movie[]{movies[2], movies[1], movies[0]};
        Movie[] returned = new Movie[]{movies[0], movies[1], movies[2]};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastTen() {
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }
        doReturn(movies).when(repository).findAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[14], movies[13], movies[12], movies[11], movies[10], movies[9], movies[8], movies[7], movies[6], movies[5]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastCustom() {
        int moviesToShow = 3;
        MovieManager manager = new MovieManager(repository, moviesToShow);
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }
        doReturn(movies).when(repository).findAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[14], movies[13], movies[12]};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnOneCustom() {
        MovieManager manager = new MovieManager(repository, 1);
        manager.addMovie(movies[0]);
        Movie[] returned = new Movie[]{movies[0]};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{movies[0]};
        assertArrayEquals(expected, actual);
    }
}
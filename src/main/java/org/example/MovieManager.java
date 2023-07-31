package org.example;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private final List<String> movies;
    private final int limit;

    public MovieManager() {
        this(5);
    }

    public MovieManager(int limit) {
        this.movies = new ArrayList<>();
        this.limit = limit;
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public String[] findAll() {
        return movies.toArray(new String[0]);
    }

    public String[] findLast() {
        return findLast(limit);
    }

    public String[] findLast(int limit) {
        int resultLength = Math.min(limit, movies.size());
        List<String> result = new ArrayList<>();
        for (int i = resultLength - 1; i >= 0; i--) {
            result.add(movies.get(i));
        }
        return result.toArray(new String[0]);
    }
}

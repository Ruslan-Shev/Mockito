package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("The Shawshank Redemption");
        assertArrayEquals(manager.findAll(), new String[]{"The Shawshank Redemption"});
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("The Shawshank Redemption");
        manager.addMovie("The Godfather");
        assertArrayEquals(manager.findAll(), new String[]{"The Shawshank Redemption", "The Godfather"});
    }

    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager();
        manager.addMovie("The Shawshank Redemption");
        manager.addMovie("The Godfather");
        manager.addMovie("The Dark Knight");
        assertArrayEquals(manager.findLast(), new String[]{"The Dark Knight", "The Godfather", "The Shawshank Redemption"});
    }
}

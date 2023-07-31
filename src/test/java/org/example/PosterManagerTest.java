package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    // тест на добавление фильма
    @Test
    void shouldAddMovie() {
        // создаем менеджер с лимитом 5
        PosterManager manager = new PosterManager();
        // добавляем фильм "Титаник"
        manager.addMovie("Титаник");
        // получаем массив всех фильмов
        String[] actual = manager.findAll();
        // создаем ожидаемый массив с одним фильмом "Титаник"
        String[] expected = new String[]{"Титаник"};
        // сравниваем массивы
        assertArrayEquals(expected, actual);
    }

    // тест на вывод всех фильмов в порядке добавления
    @Test
    void shouldFindAll() {
        // создаем менеджер с лимитом 5
        PosterManager manager = new PosterManager();
        // добавляем три фильма
        manager.addMovie("Титаник");
        manager.addMovie("Аватар");
        manager.addMovie("Интерстеллар");
        // получаем массив всех фильмов
        String[] actual = manager.findAll();
        // создаем ожидаемый массив с тремя фильмами в порядке добавления
        String[] expected = new String[]{"Титаник", "Аватар", "Интерстеллар"};
        // сравниваем массивы
        assertArrayEquals(expected, actual);
    }

    // тест на вывод максимально лимит штук последних добавленных фильмов в обратном от добавления порядке, когда количество фильмов меньше лимита
    @Test
    void shouldFindLastLessThanLimit() {
        // создаем менеджер с лимитом 5
        PosterManager manager = new PosterManager();
        // добавляем три фильма
        manager.addMovie("Титаник");
        manager.addMovie("Аватар");
        manager.addMovie("Интерстеллар");
        // получаем массив последних фильмов в обратном порядке
        String[] actual = manager.findLast();
        // создаем ожидаемый массив с тремя фильмами в обратном порядке добавления
        String[] expected = new String[]{"Интерстеллар", "Аватар", "Титаник"};
        // сравниваем массивы
        assertArrayEquals(expected, actual);
    }

    // тест на вывод максимально лимит штук последних добавленных фильмов в обратном от добавления порядке, когда количество фильмов больше лимита
    @Test
    void shouldFindLastMoreThanLimit() {
        // создаем менеджер с лимитом 3
        PosterManager manager = new PosterManager(3);
        // добавляем пять фильмов
        manager.addMovie("Титаник");
        manager.addMovie("Аватар");
        manager.addMovie("Интерстеллар");
        manager.addMovie("Начало");
        manager.addMovie("Дюнкерк");
        // получаем массив последних фильмов в обратном порядке
        String[] actual = manager.findLast();
        // создаем ожидаемый массив с тремя последними фильмами в обратном порядке добавления (лимит 3)
        String[] expected = new String[]{"Дюнкерк", "Начало", "Интерстеллар"};
        // сравниваем массивы
        assertArrayEquals(expected, actual);
    }
}

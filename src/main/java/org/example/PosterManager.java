package org.example;
public class PosterManager {
    // поле для хранения массива фильмов
    private String[] movies = new String[0];
    // поле для хранения лимита вывода фильмов
    private final int limit;

    // конструктор без параметров, выставляющий лимит в 5
    public PosterManager() {
        this.limit = 5;
    }

    // конструктор с параметром, берущий значение лимита из параметра
    public PosterManager(int limit) {
        this.limit = limit;
    }

    // метод для добавления нового фильма
    public void addMovie(String movie) {
        // создаем новый массив на единицу больше старого
        String[] newMovies = new String[movies.length + 1];
        // копируем все элементы из старого массива в новый
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        // добавляем новый фильм в конец нового массива
        newMovies[newMovies.length - 1] = movie;
        // присваиваем новый массив полю movies
        movies = newMovies;
    }

    // метод для вывода всех фильмов в порядке добавления
    public String[] findAll() {
        return movies;
    }

    // метод для вывода максимально лимит штук последних добавленных фильмов в обратном от добавления порядке
    public String[] findLast() {
        // вычисляем правильный размер результирующего массива-ответа
        int resultLength = Math.min(movies.length, limit);
        // создаем массив-ответ с нужным размером
        String[] result = new String[resultLength];
        // заполняем массив-ответ из массива movies в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }
}

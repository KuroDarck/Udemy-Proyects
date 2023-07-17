package Modelo;

// Aggregation, Sampling and Search Interface
public interface Movie_Catalog {

    /**
     * Inserts a movie into the catalog.
     *
     * @param movie The movie to insert.
     */
    void insertMovie(Movie movie);

    /**
     * Displays all movies in the catalog.
     */
    void showMovie();

    /**
     * Searches for a movie in the catalog based on its name.
     *
     * @param nameMovie The name of the movie to search for.
     */
    void searchMovie(String nameMovie);
}

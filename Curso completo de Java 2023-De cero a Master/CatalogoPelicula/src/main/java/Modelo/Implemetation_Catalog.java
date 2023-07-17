/**
 * Implementation of the Movie_Catalog interface.
 */
package Modelo;

import javax.swing.*;
import java.util.ArrayList;

public class Implemetation_Catalog implements Movie_Catalog {

    private final ArrayList<String> listMovie;

    /**
     * Constructor for Implemetation_Catalog class.
     * Initializes an empty list of movies.
     */
    public Implemetation_Catalog() {
        this.listMovie = new ArrayList<>();
    }

    /**
     * Inserts a movie into the catalog.
     *
     * @param nombreMovie The movie to be inserted.
     */
    @Override
    public void insertMovie(Movie nombreMovie) {
        this.listMovie.add(nombreMovie.toString());
    }

    /**
     * Displays the list of movies in a message dialog.
     * If the list is empty, an error message is shown.
     */
    @Override
    public void showMovie() {
        String message;
        if (this.listMovie.isEmpty()) {
            message = "List is empty";
        } else {
            message = this.listMovie.toString();
        }
        JOptionPane.showMessageDialog(null, message, "List of Movie", this.listMovie.isEmpty() ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Searches for a movie in the catalog based on its name.
     *
     * @param nameMovie The name of the movie to search for.
     */
    @Override
    public void searchMovie(String nameMovie) {
        String resul = null;
        for (var movie : this.listMovie) {
            if (movie.equals(nameMovie)) {
                resul = movie;
                break;
            }
        }

        if (resul != null) {
            JOptionPane.showMessageDialog(null, "Movie --> " + resul, "Search Movie", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Movie \""+nameMovie+ "\" not found", "Search Movie", JOptionPane.WARNING_MESSAGE);
        }

        if (this.listMovie.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty", "List of Movies", JOptionPane.ERROR_MESSAGE);
        }
    }

}

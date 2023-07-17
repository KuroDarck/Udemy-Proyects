package UI_view;

import Modelo.*;

import javax.swing.*;

public class UI_Movie {

    /**
     * Provides a user interface for managing movies.
     */
    public static void interfaceUser() {
        Movie_Catalog movies = new Implemetation_Catalog();
        Movie movie;
        String nameMoVie;
        CERRA:
        while (true) {
            String option = JOptionPane.showInputDialog(null,
                    """
                            1 ==> Insert Movie
                            2 ==> Show Movie
                            3 ==> Search Movie
                            4 ==> Exit
                            Input an Option""",
                    JOptionPane.QUESTION_MESSAGE
            );

            switch (option) {

                case "1":
                    nameMoVie = JOptionPane.showInputDialog(null,
                            "Input name of the movie",
                            "Input",
                            JOptionPane.QUESTION_MESSAGE
                    );
                    movie = new Movie(nameMoVie);
                    movies.insertMovie(movie);
                    break;

                case "2":
                    movies.showMovie();
                    break;

                case "3":
                    nameMoVie = JOptionPane.showInputDialog(null, "Input name of the movie",
                            "Input",
                            JOptionPane.QUESTION_MESSAGE);
                    movies.searchMovie(nameMoVie);
                    break;

                case "4":
                    break CERRA;

                default:
                    JOptionPane.showMessageDialog(null,
                            """
                                    Wrong Choice
                                    Try Again
                                    Well Choice
                                    The option is from 1 to 4""",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

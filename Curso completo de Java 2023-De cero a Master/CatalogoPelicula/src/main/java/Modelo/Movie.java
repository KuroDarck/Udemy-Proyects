package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a Movie object.
 */
public class Movie implements Serializable {
    private String name;

    /**
     * Default constructor for the Movie class.
     */
    public Movie() {
        // Default constructor
    }

    /**
     * Constructor for the Movie class with a name parameter.
     *
     * @param name The name of the movie.
     */
    public Movie(String name) {
        this.name = name;
    }

    /**
     * Sets the name of the movie.
     *
     * @param name The name of the movie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the movie.
     *
     * @return The name of the movie.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the movie.
     *
     * @return A string representation of the movie.
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Checks if the movie is equal to another object.
     *
     * @param o The object to compare.
     * @return True if the movie is equal to the object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(name, movie.name);
    }

    /**
     * Returns the hash code of the movie.
     *
     * @return The hash code of the movie.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

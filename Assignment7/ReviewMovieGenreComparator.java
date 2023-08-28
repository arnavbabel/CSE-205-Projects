// Assignment: #7
// Name: Arnav Babel
// StudentID: 1225345329 
// Lecture: MWF 12:20-1:10
// Description: overrides the compare method

//package(s)
import java.util.Comparator;

public class ReviewMovieGenreComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        //checks to see which movie genre is longer and returns the number difference between the two genres
        if (movie1.getMovieGenre().getGenre().compareTo(movie2.getMovieGenre().getGenre()) != 0) {
                return movie1.getMovieGenre().getGenre().compareTo(movie2.getMovieGenre().getGenre());
        }

        //checks to see which movie has more collections and returns the range of the total collections
        if (movie1.getTotalCollection() != movie2.getTotalCollection()) {
            return movie1.getTotalCollection() - movie2.getTotalCollection();
        }

        //checks to see which movie name is longer and returns the number difference between the two genres
        if (movie1.getMovieName().compareTo(movie2.getMovieName()) != 0) {
            return movie1.getMovieName().compareTo(movie2.getMovieName());
        }

        //checks to see which movie director name is longer and returns the number difference between the two director names
        if (movie1.getDirector().compareTo(movie2.getDirector()) != 0) {
            return movie1.getDirector().compareTo(movie2.getDirector());
        }

        //checks to see which movie review is longer and returns the number difference between the two reviews
        if (movie1.getReview().compareTo(movie2.getReview()) != 0) {
            return movie1.getReview().compareTo(movie2.getReview());
        }

        //if the reviews are the same, then return 0
        return 0;
    }    
}

// Assignment: #7
// Name: Arnav Babel
// StudentID: 1225345329 
// Lecture: MWF 12:20-1:10
// Description: compares which movies have higher ratings and sorts them accordingly 

//packages
import java.util.Comparator;

public class ReviewRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        //checks to see which movie has more stars and returns the range of stars
        if (movie1.getStars() != movie2.getStars()) {
            return movie1.getStars() - movie2.getStars();
        }

        //checks to see which movie name is longer and returns the number difference between the two names 
        if (movie1.getMovieName().compareTo(movie2.getMovieName()) != 0) {
            return movie1.getMovieName().compareTo(movie2.getMovieName());
        }

        //checks to see which director name is longer and returns the number difference between the two names
        if (movie1.getDirector().compareTo(movie2.getDirector()) != 0) {
            return movie1.getDirector().compareTo(movie2.getDirector());
        }

        //checks to see which movie has more reviews and returns the review
        if (movie1.getReview().compareTo(movie2.getReview()) != 0) {
            return movie1.getReview().compareTo(movie2.getReview());
        }
        return 0;        
    }
}

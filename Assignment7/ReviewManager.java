// Assignment: #7
// Name: Arnav Babel
// StudentID: 1225345329 
// Lecture: MWF 12:20-1:10
// Description: gets a list of movie objects and organizes it by the review management system

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Movie> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }
    
    //searches for a movie in reviewList
    public int movieExists(String movieName, String director){
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getMovieName().equals(movieName) && reviewList.get(i).getDirector().equals(director)) {
                return i;
            }
        }
        //returns -1 if the movie doesn't exist
        return -1;
    }

    //returns all the movies in that specific genre
    public ArrayList<Integer> movieGenreExists(String genre) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getMovieGenre().getGenre().equals(genre)) {
                integers.add(i);
            }
        }
        return integers;
    }

    //gets the index of the movie in reviewList
    public Movie getMovie(int index) {
        return reviewList.get(index);
    }

    /**
     * Add a Movie object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two Movies are
     * considered duplicated if they have exactly the same movie name and genre.
     * 
     * @param  movieName          the name of the movie
     * @param  stars              the number of stars the movie recieved
     * @param  review             the movie review
     * @param  totalCollection    the integer total collection earned by the movie
     * @param  genre              the movie's genre
     * @param  director           the movie's director
     * @param  prodictionCompany  production comapny of the movie
     * @return                    true if the operation is successful; false otherwise
     */
    
    //Adds a movie review to the reviewList
    public boolean addReview(String movieName, int stars, String review, String totalCollection, String genre, String director, String productionCompany) {
        if (movieExists(movieName, director) == -1) {
            int collection = totalCollection.length();
            MovieGenre newGenre = new MovieGenre(genre, productionCompany);
            Movie newMovie = new Movie(movieName, stars, review, collection, director, newGenre);
            reviewList.add(newMovie);
            return true;
        }
        return false;
    }

    //removes a movie from reviewList
    public boolean removeReview(String movieName, String director) {
        if (movieExists(movieName, director) > -1) {
            reviewList.remove(movieExists(movieName, director));
            return true;
        }
        return false;
    }

    //sorts reviewList by ratings
    public void sortByRating() {
        Sorts.sort(reviewList, new ReviewRatingComparator());
    }

    //sorts reviewList by the movie's genre
    public void sortByMovieGenre() {
        Sorts.sort(reviewList, new ReviewMovieGenreComparator());
    }

    //lists all movies in reviewList
    public String listReviews() {
        String movies = "";
        for (int i = 0; i < reviewList.size(); i++) {
            movies += reviewList.get(i).toString();
        }
        return movies;
    }

    public String printReviews(ArrayList<Integer> movies) {
        String temp = "";
        for (int i = 0; i < movies.size(); i++) {
            if (reviewList.size() > 0 && movies.size() > 0) {
                temp += reviewList.get(movies.get(i)).toString();
            }
        }
        return temp;
    }

    //clears reviewList and closes it
    public void closeReviewManager() {
        reviewList.clear();
    }
}

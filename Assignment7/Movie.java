// Assignment: #7
// Name: Arnav Babel
// StudentID: 1225345329 
// Lecture: MWF 12:20-1:10
// Description: gets the movie information from the user and returns its information

//package(s)
import java.io.Serializable;

public class Movie implements Serializable {
    
    //instance variable(s)
    private static final long serialVersionUID = 205L;
    private String movieName;
    private int stars;
    private String review;
    private int totalCollection;
    private String director;
    private MovieGenre movieGenre;

    //constructor(s)
    public Movie(String movieName, int stars, String review, int totalCollection, String director, MovieGenre movieGenre) {
        this.movieName = movieName;
        this.stars = stars;
        this.review = review;
        this.totalCollection = totalCollection;
        this.director = director;
        this.movieGenre = movieGenre;
    }

    //getter(s)
    public String getMovieName() {
        return this.movieName;
    }
    public int getStars() {
        return this.stars;
    }
    public int getTotalCollection() {
        return this.totalCollection;
    }
    public String getDirector() {
        return this.director;
    }
    public String getReview() {
        return this.review;
    }
    public MovieGenre getMovieGenre() {
        return this.movieGenre;
    }

    //setter(s)


    //toString()
    public String toString() {
        String star = "";
        String dollar = "";
        for (int i = 0; i < this.stars; i++) { //prints a star for every star review
            star += "*";
        }
        for (int i = 0; i < this.totalCollection; i++) { //prints a dollar sign for every review
            dollar += "$";
        }
        return movieName + " Movie\n" + star + "\n" + "Total Collection earned: " + dollar + "\n" +  
               movieGenre.toString() + "Director: " + director + "\n" + "Review:\t" + review + "\n\n";
    }

    //misc.
}

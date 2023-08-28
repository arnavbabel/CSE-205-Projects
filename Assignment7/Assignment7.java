// Assignment: #7
// Name: Arnav Babel
// StudentID: 1225345329 
// Lecture: MWF 12:20-1:10
// Description: driver class for Assignment7

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Assignment7
{
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Movie and Movie Genre information
        String movieName, movieGenre;
        String review = null, director, productionCompany, totalCollection;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Movie manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;   
        
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Movie Review
                        System.out.print("Please enter the movie information:\n");
                        System.out.print("Enter the movie name:\n");
                        movieName = stdin.readLine().trim(); 
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the total collection:\n");
                        totalCollection = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the movie genre:\n");
                        movieGenre = stdin.readLine().trim();
                        System.out.print("Enter the movie's Director:\n");
                        director = stdin.readLine().trim();
                        System.out.print("Enter the movie's production company\n");
                        productionCompany = stdin.readLine().trim();
                        
                        if (reviewManager.addReview(movieName, rating, review, totalCollection, movieGenre, director, productionCompany)) {
                            //if the review is added successfully, print this statement
                            System.out.print("Movie added to the database!\n");
                        } else {
                            //if the review is not added successfully, print this statement instead  
                            System.out.print("Movie NOT added!\n");
                        }
                        break;
                        
                    case 'D': // Search for a movie
                        System.out.print("Please enter the Movie name to search:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the movies's director':\n");
                        director = stdin.readLine().trim();
                        
                        if (reviewManager.movieExists(movieName, director) > -1) {
                            //if the movie review exists, print this statement and the review
                            System.out.print("Movie found. Here's the review:\n" + reviewManager.getMovie(reviewManager.movieExists(movieName, director)).getReview() + "\n");
                        } else {
                            //if the review does not exist, print this statement instead
                            System.out.print("Movie not found. Please try again\n");
                        }
                        break;
                        
                    case 'E': // Search for a Movie Genre
                        System.out.print("Please enter the movie genre to search:\n");
                        movieGenre = stdin.readLine().trim();
                          
                        if (reviewManager.movieGenreExists(movieGenre).size() != -1) {
                            //if there are movies in the array in the genre, then print how many movies are in that genre
                            System.out.printf("%s Movies matching %s type were found:\n", reviewManager.movieGenreExists(movieGenre).size(), movieGenre);
                            System.out.print(reviewManager.printReviews(reviewManager.movieGenreExists(movieGenre)) + "\n");
                        } else {
                            //if there are no movies in the array in the genre, print this statement instead
                            System.out.printf("Movie Genre: %s was NOT found\n", movieGenre);
                        }
                        break;
   
                    case 'L': // List movie's reviews
                        if (reviewManager.listReviews().length() > 0) {
                            //if there are reviews in the arrayList, print this statement and the review
                            System.out.print("\n" + reviewManager.listReviews() + "\n");
                        } else {
                            //if there are no reviews in the arrayList, print this statement
                            System.out.print("\nNo Reviews available");
                        }
                        break;
                        
                    case 'N': //sorts the movie reviews by rating
                        //Sorts.sort(reviewManager.reviewList, new ReviewRatingComparator());
                        reviewManager.sortByRating();
                        System.out.print("sorted by rating\n");
                        break;

                    case 'P': //sorts the movie reviews by movie genre
                        Sorts.sort(reviewManager.reviewList, new ReviewMovieGenreComparator());
                        System.out.print("sorted by genre\n");
                        break;
                        
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the name of the movie for which you want the review removed:\n");
                        movieName = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie's director:\n");
                        director = stdin.readLine().trim();
                        
                        if (reviewManager.removeReview(movieName, director) == true) {
                            //if the review was successfully removed, print this statement
                            System.out.print(movieName + ", " + director + " was removed\n");
                        } else {
                            //if the reveiw was not successfully removed, print this statement
                            System.out.print(movieName + ", " + director + " was NOT removed\n");
                        }
                        break;
        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("The movie management system was reset!\n");
                        break;

                    case 'U': // Write movies' names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the movie:\n");
                        movieName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = movieName + "\n" + review + "\n";
                         
                        try {
                            FileWriter fw = new FileWriter(outFilename);
                            BufferedWriter bw = new BufferedWriter(fw);

                            bw.write(outMsg);
                            bw.close();
                            //prints this statement if successfully written
                            System.out.print(outFilename + " is written\n");
                        } catch (IOException e) {
                            //prints this statement if there is an error
                            System.out.println("Write string inside the file error\n");
                        }                
                        break;
    
                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();

                        try {
                            FileReader fr = new FileReader(inFilename);
                            BufferedReader br = new BufferedReader(fr);

                            System.out.print(inFilename + " was read\n");

                            System.out.print("The contents of the file are:\n");
                            String read = br.readLine();

                            while (read != null) {
                                //puts the contents inside of read together
                                System.out.print(read + "\n");
                                read = br.readLine();
                            }
                            fr.close();
                        } catch (FileNotFoundException e) {
                            //prints that the file was not found
                            System.out.print(inFilename + " was not found\n");
                        } catch (IOException e) {
                            //prints that there was an error reading from the file
                            System.out.print("Read string from file error\n");
                        }
                        break;
                        
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        
                        try {
                            FileOutputStream fo = new FileOutputStream(outFilename);
                            (new ObjectOutputStream(fo)).writeObject(reviewManager);
                            // System.out.println(outFilename + " is written\n");
                            ObjectOutputStream oo = new ObjectOutputStream(fo);

                            //serializes reviewManager to a data file
                            oo.writeObject(reviewManager);
                            oo.close();
                        } catch (NotSerializableException e) {
                            //prints this statement if there was a serialization error
                            System.out.print("Not serializable exception\n");
                        } catch (IOException e) {
                            //prints this statement if there was an error writing to the file
                            System.out.print("Data file written exception\n");
                        }
                        break;                    
    
                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        try {
                            FileInputStream fi = new FileInputStream(inFilename);
                            ObjectInputStream oi = new ObjectInputStream(fi);

                            //deserializes ReviewManager from a file
                            reviewManager = (ReviewManager) oi.readObject();
                            System.out.print(inFilename + " was read\n");
                            oi.close();
                        } catch (ClassNotFoundException e) {
                            //prints this statement if a class is not found
                            System.out.print("Class not found exception\n");
                        } catch (NotSerializableException e) {
                            //prints this statement if there is a serialization error
                            System.out.print("Not serializable exception\n");
                        } catch (IOException e) {
                            //prints this statement if there is an error reading the file
                            System.out.print("Data file read exception\n");
                        }
                        break;
                     
                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to YoMovies! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) movies.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a movie\n" + "E\t\tSearch for a genre\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by genre\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
   
}

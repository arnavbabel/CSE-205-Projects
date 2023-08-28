// Assignment: #7
// Name: Arnav Babel
// StudentID: 1225345329 
// Lecture: MWF 12:20-1:10
// Description: sorts the contents inside the ArrayList

//package(s)
import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {

    public static void sort(ArrayList<Movie> reviewList, Comparator<Movie> xComparator) {
        int arrayIndex = 0;

        //for loop that iterates through reviewList (arrayList containing movies)
        for (int i = 0; i < reviewList.size(); i++) {
            arrayIndex = i;
            
            //gets the index of the movie in the list and sets it to array
            Movie array = reviewList.get(arrayIndex);

            //for loop that iterates through and compares the values in reviewList
            for (int j = i; j < reviewList.size(); j++) {
                if (xComparator.compare(reviewList.get(arrayIndex), reviewList.get(j)) > 0) {
                    arrayIndex = j;
                }
            }

            if (arrayIndex != i) {
                Movie temp = reviewList.get(i);
                reviewList.set(i, reviewList.get(arrayIndex));
                reviewList.set(arrayIndex, temp);
            }
        }
    }    
}

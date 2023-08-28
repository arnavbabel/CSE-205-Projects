// Assignment #: 2
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: 12:20-1:10
//  Description: The program gives the user 6 different options, 5 of which do a mathmatical computation with numbers 
//               given by the user. 

import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int option = 0;
        int val1, val2;
        int sum = 0;
        int product = 1;
        int sequence, numOddVals = 0, length = 0;
        int leftmostDigit = 0, val;
        int gcd = 0, least;

        do {
            displayOptions();
            option = scnr.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter a number:");
                    val1 = scnr.nextInt(); //gets the user's input for val1

                    for (int i = 1; i <= val1; i++) { //computes the sum of all values from 1 to val2
                        sum += i; //adds the value of i to sum
                    }

                    System.out.println("The sum of 1 to " + val1 + " is " + sum + "\n"); //prints the sum
                    break;
                case 2:
                    System.out.print("Enter a number:\n"); //prompts the user for the first value
                    val1 = scnr.nextInt(); //gets the user's input for val1
            
                    for (int i = 1; i <= val1; i++) { //computes the factorial of val2
                        product *= i; //multiplies the value of i to product
                    }
            
                    System.out.println("The factorial of " + val1 + " is " + product + "\n"); //prints the factorial
                    break;
                case 3:
                    System.out.print("Enter the length of sequence\n"); //prompts the user for the length of the sequence
                    length = scnr.nextInt(); //gets the user's length for the sequence

                    System.out.print("Enter the sequence\n"); //prompts the user for values for the sequence
                    
                    for (int i = 0; i < length; i++) { //gets the number and checks to see if it is odd or even
                        sequence = scnr.nextInt(); //gets the user's input for the value
            
                        if (sequence % 2 != 0) { //checks to see if the values in sequence are even or odd
                            numOddVals++; //increments the number of odd values by 1
                        }
                    }
            
                    System.out.println("The count of odd integers in the sequence is " + numOddVals + "\n"); //prints the number of odd values
                    break;
                case 4:
                    System.out.print("Enter a number:\n"); //prompts the user for a value
                    val = scnr.nextInt(); //gets the user's input for val
            
                    leftmostDigit = val; //sets val to the leftmostDigit
                    while (leftmostDigit >= 10) { //removes digits from the right until only the leftmost one is left
                        leftmostDigit /= 10; //divides leftmostDigit by 10 while the loop is true
                    }
            
                    System.out.println("The leftmost digit of " + val + " is " + leftmostDigit + "\n"); //prints the leftmost digit
                    break;
                case 5:
                    System.out.print("Enter a number: "); //prompts the user for the first value
                    val1 = scnr.nextInt(); //gets the user's input for val1
                    System.out.print("Enter a second number: "); //prompts the user for the second value
                    val2 = scnr.nextInt(); //gets the user's input for val2
            
                    least = val1; //initializes val1 to least
                    if (val1 > val2) { //sets val2 to least if val1 is larger than val2
                        least = val2;
                    }
                    for (int i = 1; i <= least; i++) { //iterates through every value from 1 to least
                        if (val1 % i == 0 && val2 % i == 0) { //searches for the greatest common divisor of val1 and val2
                            gcd = i; //sets the greatest common divisor to gcd
                        }
                    }
                    System.out.println("The greatest common divisor of " + val1 + " and " + val2 + " is " + gcd + "\n"); //prints the greatest common divisor
                    break;
                case 6:
                    System.out.println("Bye");
                    break;
            }
        } while (option != 6);
    }

    public static void displayOptions() { //method that displays the user's options
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1. Calculate the sum of integers from 1 to m");
        System.out.println("2. Calculate the factorial of a given number");
        System.out.println("3. Calculate the count of odd integers in a given sequence");
        System.out.println("4. Display the leftmost digit of a given number");
        System.out.println("5. Calculate the greatest common divisor of two given integers");
        System.out.println("6. Quit");
    }
}
//Assignment #: Arizona State University Spring 2023 CSE205 #8
//Name: Arnav Babel
//StudentID: 1225345329
//Lecture: MWF 12:20-1:10 
//Description: Testing recursion through different applications

//package(s)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment8 {

	public static void main(String[] args) {
		char inputOption = ' ';
		String userInput;

		// menu
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			do {
				printMenu();
				userInput = br.readLine().trim();
				inputOption = userInput.charAt(0);
				inputOption = Character.toUpperCase(inputOption);
				double[] doublesArray = {};

				if (userInput.isEmpty()) {
					continue;
				}

				switch (inputOption) {
					case 'A': //recursive method that calculates the sum of all elements in an array of doubles and returns the sum
						System.out.print("Enter numbers (0 to finish): "); //gets the user's inputs for the array values

						doublesArray = parseDoubles(br); //parses the user's values as double
						double sumOutput = sumDoubles(doublesArray, doublesArray.length - 1); //calculates the sum of the array values

						System.out.print("Sum of elements in array: " + sumOutput + "\n"); //prints the sum						
						break; //exits the case

					case 'B': //recursive method that calculates the sum of all integers between two numbers (including the two numbers) and returns the sum
						System.out.print("Enter the first number: "); //prompts the user for the first value
						int firstNum = readInteger(br);
						System.out.print("Enter the second number: "); //prompts the user for the second value
						int secondNum = readInteger(br);

						int sum = sumBetweenTwoVals(firstNum, secondNum); //calculates the sum of the values between two numbers

						System.out.print("The sum of all integers between " + firstNum + " and " + secondNum + " is: " + 
										 sum + "\n"); //prints the sum between two values
						break; //exits the case

					case 'C': //recursive method that calculates the prime factorization of an integer and returns a string as a result
						System.out.print("Enter an integer to factorize: ");
						int val = readInteger(br);

						String result = factorizationResult(val, 2); //calculates all the values factorable

						System.out.print("The prime factorization of " + val + " is: " + result + "\n");
						break; //exits the case

					case 'D': //recursive method that removes all occurrences of a specified substring in a string and returns the result string
						System.out.print("Please enter string: "); //prompts the user to enter a string
						String userString = br.readLine().trim();
						System.out.print("Please enter substring to remove: "); //prompts the user to enter the substring to remove
						String substringToRemove = br.readLine().trim();
						
						String newString = removeExtraChar(userString, substringToRemove); //removes the substring from the string

						System.out.print("String after substring removal: " + newString + "\n"); //prints the new string
						break; //exits the case

					case 'E': //quits the program
						break;

					default: //default case
						System.out.print("Invalid choice. Please choose a char between A and E.\n");
				}
			} while (inputOption != 'E');
		} catch (IOException ex) {
			System.out.print("Please choose a char between A and E.\n"); //prompts the user to enter a proper (expected) value
		}
	}
	// ----------------------------------------------------------------------------------------

	//method that calculates the sum of the elements in an array of doubles
	public static double sumDoubles(double[] myArray, int index) {
		double sumOfArray = myArray[index];
		if (index == 0) { //checks to see if the length of the array is 0
			return sumOfArray; //returns the sum of the array
		} else {
			return sumOfArray + sumDoubles(myArray, index - 1); //returns the sum of the array
		}
	}

	//method that calculates the sum of all values between two specific values
	public static int sumBetweenTwoVals(int val1, int val2) {
		int sum = val1;
		if (val1 >= val2) {
			if (val1 == val2) { //base case
				return sum;
			} else { //recursive part
				return sum + sumBetweenTwoVals(val1 - 1, val2); 
			}
		} else { //recursive part
			return sum + sumBetweenTwoVals(val1 + 1, val2);
		}
	}

	//method that calculates the prime factorizations of a number
	public static String factorizationResult(int val, int factor) {
		String str = "";
		if (factor < val) { //checks to see if the factor value is smaller than the value being factored
			if (val % factor == 0) { //checks to see if it is divisible and gets a remainder of 0
				str = factor + "";
				return str + "x" + factorizationResult(val / factor, factor); //returns the result
			} else {
				return factorizationResult(val, factor + 1); //returns the user's value and the next factorable value
			}
		} else {
			return str + factor + ""; //returns the the string and factor value
		}
	}

	//method that removes all occurrences of a substring from a string
	public static String removeExtraChar(String str1, String str2) {
		int index = str1.indexOf(str2);
		if (index == -1) { //base case
            return str1;
        } else { //recursive part
            if (index == 0) { //checks to see if the substring is at the beginning of the string
				str1 = str1.substring(str2.length() - 1, str1.length());
				return removeExtraChar(str1, str2);
			} else if (index == str1.length() - str2.length()) { //checks to see if the substring is at the end of the string 
				str1 = str1.substring(0, index);
				return removeExtraChar(str1, str2);
			} else { //checks to see if the substring is anywhere else in the string
				str1 = str1.substring(0, index) + str1.substring(index + str2.length(), str1.length());
				return removeExtraChar(str1, str2);
			}
        } 
	}

	// utility method for parsing doubles from standard input that returns an array of doubles
	public static double[] parseDoubles(BufferedReader reader) {
		String line = "";
		ArrayList<Double> container = new ArrayList<>();
		try {
			line = reader.readLine();
			double num = Double.parseDouble(line);

			while (num != 0) {
				container.add(num);
				line = reader.readLine();
				num = Double.parseDouble(line);
			}

		} catch (IOException ex) {
			System.out.println("IO Exception.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, return to main menu.");
		}

		double[] result = new double[container.size()];
		for (int i = 0; i < container.size(); i++) {
			result[i] = container.get(i);
		}
		return result;
	}

	// utility method for parsing integers from standard input (only positive integers allowed)
    public static int readInteger(BufferedReader reader) throws IOException {
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error reading input. Please try again.");
            number = readInteger(reader);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            number = readInteger(reader);
        }
        if (number <0) {
        	System.out.println("Invalid input. Only positive integers allowed. Please try again.");
        	number = readInteger(reader);
        }
        return number;
    }

	// utility method for printing the menu
	public static void printMenu() {
		System.out.print("\nWhat would you like to do?\n\n");
		System.out.print("A: Calculate the sum of all elements in an array of doubles\n");
		System.out.print("B: Calculate the sum of all integers between two numbers (including the two numbers)\n");
		System.out.print("C: Calculate the prime factorization of an integer\n");
		System.out.print("D: Remove all occurrences of a specified substring in a string\n");
		System.out.print("E: Quit\n\n");
	}
}

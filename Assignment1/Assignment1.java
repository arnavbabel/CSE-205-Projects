// Assignment #: 1
//         Name: Arnav Babel
//    StudentID: 1225345329
//      Lecture: 12:20-1:10
//  Description: This class reads a string, an integer and a floating point number from a keyboard and prints it out
//               along with other messages.
import java.util.Scanner;  // use the Scanner class located in the "java.util" directory
//The Scanner class is used to get the user input
public class Assignment1
{
    public static void main(String[] args)
    {
     String name; //creates a variable called name
     int id; //creates a variable called id
     double cgpa; //creates a variable called cgpa
     Scanner console = new Scanner(System.in);
     // display the user input with other messages
     System.out.print("Enter your name:\n");  
     // read a string (name) entered by a user
     name = console.nextLine();
     System.out.print("Enter last four digits of your ASU ID:\n");  
     // read a integer (last four digits of ASU ID) entered by a user  
     id = console.nextInt();
     System.out.print("Enter your CGPA:\n"); 
     // read a floating point number (cgpa) entered by a user 
     cgpa = console.nextDouble();
     //print the information entered by the user along with other messages
     System.out.print("Name: " + name + "\nLast four digits of ASU ID: " + id + "\nCGPA: " + cgpa);
    }
}

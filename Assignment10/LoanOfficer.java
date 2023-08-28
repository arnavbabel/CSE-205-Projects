// Assignment #: ASU CSE205 Spring 2023 #10
// Name: Arnav Babel
// StudentID: 1225345329
// Lecture: MWF 12:20-1:10
// Description: LoanOfficer class represents a bank loan officer
//              that accept/handle and release customers.
//              //---- is where you should add your own code

public class LoanOfficer
{
   private int officerID; //number of the loan officer
   private Customer currentCustomer; //customer assigned to an officer

   //**************************************************
   //Constructor to initialize member variables
   //Initially no patient is assigned
   public LoanOfficer(int id)
   {
      this.officerID = id;
      currentCustomer = null;
   }

   //******************************************
   //an accessor method for the officer's ID
   public int getID()
   {
      return officerID;
   }

   //****************************************************************
   //method to determine if a loanOfficer currently has a customer by
   //checking the currentCustomer variable
   public boolean hasCustomer()
   {
      if (currentCustomer == null) { //checks to see if a loanOfficer has a customer
         return false; //returns false if a loanOfficer does not have a customer
      } else {
         return true; //returns true if otherwise
      }
   }

   //************************************************************************
   //assign customer1 to currentCustomer if the officer does not have customer
   public boolean assignCustomer(Customer customer1)
   {
      if (currentCustomer == null) { //checks to see if an officer does not have a customer
         currentCustomer = customer1; //assigns customer1 to currentCostomer if true
         return true; //returns true if the officer does not have a customer
      } else {
         return false; //returns false if otherwise
      }
   }

   //*********************************************
   public Customer handleCustomer()
   {
      Customer customer;
      if (currentCustomer != null) { //checks to see if a customer is assigned to an officer
         customer = currentCustomer; //saves the current customer to a new variable
         currentCustomer = null; //sets currentCustomer to null if true
         return customer; //returns the current customer
      } 
      return null; //returns null if otherwise
   }

   //********************************************
   //toString method returns a string containing
   //the information of a loanOfficer
   public String toString()
   {
      String result = "\nOfficer ID: " + officerID;

      if (currentCustomer == null)
         result += " does not have any cutomers\n";
      else
         result += " is serving customer with id " + currentCustomer.getCustID() + "\n";

      return result;
   }
}
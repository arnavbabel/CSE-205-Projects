// Assignment #: ASU CSE205 Spring 2023 #10
// Name: Arnav Babel
// StudentID: 1225345329
// Lecture: MWF 12:20-1:10
// Description: This program manages customer queues, assigns customer to loan officer,
//              process and release them, etc.
//              //---- is where you should add your own code

import java.util.LinkedList;

public class CustomerManagement
{
   private LinkedList<Customer> LEQueue;
   private LinkedList<Customer> MEQueue;
   private LinkedList<Customer> SEQueue;

   private LinkedList<Customer> checkoutQueue;

   private LoanOfficer[] officerList;

   //**********************************************
   //Constructor
   public CustomerManagement(int numOfLoanOfficers)
   {
      LEQueue = new LinkedList<Customer>();
      MEQueue = new LinkedList<Customer>();
      SEQueue = new LinkedList<Customer>();
      checkoutQueue = new LinkedList<Customer>();

      //creating LoanOfficer objects
      officerList = new LoanOfficer[numOfLoanOfficers];
      for (int i=0; i< officerList.length; i++)
      {
         officerList[i] = new LoanOfficer(i);
      }
   }

   //*******************************************************************
   //add a customer to the corresponding queue based on its category
   //return true if added to a queue successfully; otherwise return false
   boolean addCustomer(int id, String category)
   {
      if (category.equals("LE")) { //checks to see if the category is LE
         Customer customer = new Customer(id, category); //instantiates a new customer with the id and category
         LEQueue.add(customer); //adds the customer to LEQueue
         return true; //returns true
      } else if (category.equals("ME")) { //checks to see if the category is ME
         Customer customer = new Customer(id, category); //instantiates a new customer with the id and category
         MEQueue.add(customer); //adds the customer to MEQueue
         return true; //returns true
      } else if (category.equals("SE")) { //checks to see if the category is SE
         Customer customer = new Customer(id, category); //instantiates a new customer with the id and category
         SEQueue.add(customer); //adds the customer to SEQueue
         return true; //returns true
      }
      return false; //returns false if none of the cases are true
   }

   //*******************************************************************
   //assign a customer to a loan officer with large enterprise (LE) queues
   //going first; return null if there are no customers in the queues or if
   //there are no loan officer are available
   Customer assignCustomerToLoanOfficer()
   {
      for (int i = 0; i < officerList.length; i++) { //iterates through the officerList list
         if (officerList[i].hasCustomer()) { //checks to see if the officers have customers assigned to them
            if (i == officerList.length - 1) { //checks to see if the end of the list is reached
               return null; //returns null if true
            }
            continue; //continues to the else
         } else {
            Customer nextCustomer = null;
            if (!LEQueue.isEmpty()) { //if LEQueue is the only queue open
               nextCustomer = LEQueue.removeFirst(); //removes the customer from the queue and assigns it to the loan officer
   
            } else if (!MEQueue.isEmpty()) { //if MEQueue is the only queue open
               nextCustomer = MEQueue.removeFirst(); //removes the customer from the queue and assigns it to the loan officer
   
            } else if (!SEQueue.isEmpty()) { //if SEQueue is the only queue open
               nextCustomer = SEQueue.removeFirst(); //removes the customer from the queue and assigns it to the loan officer
   
            } else if ((LEQueue.isEmpty()) && (MEQueue.isEmpty()) && (SEQueue.isEmpty())) { //if none of the queues are open
               return null; //returns null if none of the queues are open
            }
            for (LoanOfficer officer : officerList) { //checks to see if there are any available officers 
               if (!officer.hasCustomer() && nextCustomer != null) { //checks to see if the officer does not have a customer and if there is a customer waiting in the queue
                  officer.assignCustomer(nextCustomer); //assigns the customer to the officer
                  break; //exits the loop
               }
            }
            officerList[i].assignCustomer(nextCustomer); //assigns the officer the next customer
            return nextCustomer; //returns the customer
         }
      }
      return null; //returns null if otherwise
   }

   //***************************************************************
   //check if officer with the officerID has a customer, and release
   //that customer if they do. Then add that customer to checkout queue
   //and return the Customer object; otherwise return null
   Customer releaseCustomerFromOfficer(int officerID)
   {
      for (LoanOfficer officer : officerList) { //iterates through every officer in the officerList list
         if (officer.getID() == officerID) { //checks to see if the officer in the list has the same ID
            if(officer.hasCustomer()) { //checks to see if the officer has a customer
               Customer customer = officer.handleCustomer(); //sets the officer to the customer
               checkoutQueue.add(customer); //adds the customer to the checkout queue
               return customer; //returns the customer
            }
         }
      }
      return null; //returns null if otherwise
   }

   //**************************************************************
   //remove the first Customer from the checkoutQueue and return it;
   //otherwise the method return null.
   public Customer checkoutCustomer()
   {
      if (checkoutQueue.isEmpty()) { //checks to see if the checkout queue is empty
         return null; //returns null if true
      }
      return checkoutQueue.removeFirst(); //returns the first index if otherwise
   }

   //************************************************
   //The printQueue prints out the content
   //of the queues and the array of loan officers
   public void printQueues()
   {
      System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
      System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
      System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
      for (int i = 0; i < officerList.length; i++)
      {
         System.out.print(officerList[i].toString());
      }
      System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
   }
}
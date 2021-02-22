
// Cablebilling.java
/*  Purpose: To design the cable company billing calculator
    Developed by Smita Rothe
    Created on July 12, 2020
*/

//import java package
import java.util.Scanner;

public class Cablebilling {
	// create an instance of a scanner class for input from command window
	static Scanner console = new Scanner(System.in);
	//declare named constants with values to use in program
	static final double R_BILL_PROC_FEE = 4.50;
	static final double R_BASIC_SERC_COST = 20.50;
	static final double R_COST_PREM_CHANNEL= 7.50;
	static final double B_BILL_PROC_FEE= 15.00;
	static final double B_BASIC_SERV_COST = 75.00;
	static final double B_BASIC_CONN_COST = 5.00;
	static final double B_COST_PREM_CHANNEL = 50.00;

    ////main method begins execution of java application
    public static void main(String[] args) {

        // declare variables
        int accountNumber;
        char customerType;
        int noOfPremChannels;
        int noOfBasicServConn;
        double amountDue;

        // prompt the user for entering account number, customer type, number of basic service connections and number of premium channels values
        System.out.println("This program computes a cable bill.");
        System.out.print("Enter the account number: ");
        accountNumber = console.nextInt();
        System.out.print("Enter the customer type: R 0r r (Residential), B or b (Business): ");
        customerType = console.next().charAt(0);


        // processing phase
        switch (Character.toUpperCase(customerType)){
			   case 'R' :
			         System.out.print("Enter the number of premium channels: ");
                     noOfPremChannels = console.nextInt();
			        //calculate dueamount and then display output
			        amountDue = R_BILL_PROC_FEE + R_BASIC_SERC_COST + noOfPremChannels * R_COST_PREM_CHANNEL;
			        System.out.printf("Account number: %d%n", accountNumber);
			        System.out.printf("Amount due: $%.2f%n", amountDue);
			        break;

			   case 'B' :
			          System.out.print("Enter the number of basic service connections: ");
                      noOfBasicServConn = console.nextInt();
                      System.out.print("Enter the number of premium channels: ");
                      noOfPremChannels = console.nextInt();
			         // check if the number of connections exceed the basic service connections
			         if (noOfBasicServConn <= 10)
					 {
					     amountDue = B_BILL_PROC_FEE + B_BASIC_SERV_COST + noOfPremChannels * B_COST_PREM_CHANNEL;
					 }
					 else
					 {   //if it exceeds than basic service connections then add $5 for each extra connections
						 amountDue = B_BILL_PROC_FEE + B_BASIC_SERV_COST + noOfPremChannels * B_COST_PREM_CHANNEL + (noOfBasicServConn-10)*5;
		             }
		             System.out.printf("Account number: %d%n", accountNumber);
		             System.out.printf("Amount due: $%.2f%n", amountDue);
		             break;
		   }//end switch
	  }// end method main
}//end class Cablebilling



/*
   Main Algorithm
  1. Prompt the user to enter the account number
  2. Prompt the user to enter the customer type
  5. Save the user inputs in according variables.
  6. check the value for the customer Type entered by the user.
      6.1  If the value for customer Type is R (residential)
           6.1.1 Prompt the user to enter the number of premium channels values
           6.1.2 Now use this formula to calculate the billing amount -
           amountDue = R_BILL_PROC_FEE + R_BASIC_SERC_COST + noOfPremChannels * R_COST_PREM_CHANNEL
      6.2  If the value for customer Type is B (Business)
           6.2.1. Prompt the user to enter the number of basic service connections
           6.2.2. Prompt the user to enter the number of premium channels values
           6.2.3  Now first check if the number of connections exceeds the basic service connections
                 6.2.3.1  if number of connections are less than or equal to 10 then
                          amountDue = R_BILL_PROC_FEE + R_BASIC_SERC_COST + noOfPremChannels * R_COST_PREM_CHANNEL
                 6.2.3.2  if number of connections are more  than 10 then add 5 dollar for each extra connection
                          amountDue = R_BILL_PROC_FEE + R_BASIC_SERC_COST + noOfPremChannels * R_COST_PREM_CHANNEL + (noOfBasicServConn-10)*5
  7. Finally display out the customer account number with the billing amount (amount due).

*/






/*
 * Accounts.java
 * Developed by Smita Rothe
   Script Date: aug 19, 2020 
 */
package accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Accounts {
    //main method starts the execution of the program
    public static void main(String[] args) throws FileNotFoundException {
        
        double interestRate;//define the variable for interestRate input       
        //create a scanner object for the keyboard input        
        Scanner keyboard= new Scanner(System.in);
        
        System.out.print("Enter the annual interest rate: ");
        interestRate= keyboard.nextDouble();
        //create the instance of the SavingsAccount class
        SavingsAccount account= new SavingsAccount(500.0, interestRate);
        
        System.out.println("The initial balance is "+ account.getBalance());//display the initial balance in the account
        System.out.println(" ");
        //open the file Deposits using dfile object
        File dfile= new File("Deposits.txt");
        Scanner dinputFile= new Scanner(dfile);
        //read the Deposits file and deposit(add) all the amounts in the account balance
        while(dinputFile.hasNext()){
            double number= dinputFile.nextDouble();  
            account.deposit(number);
            System.out.printf("The account balance after deposit is : %.2f\n" , account.getBalance());          
        }//end while loop
             
        //open the file Withdrawals       
        File wfile= new File("Withdrawals.txt");
        Scanner winputFile= new Scanner(wfile);
        //read the Withdrawals file and withdraw(remove) all the amounts from the account balance
        while(winputFile.hasNext()){
              double number=winputFile.nextDouble();
              account.withdraw(number); 
              System.out.printf("The account balance after withdrawal is:%.2f\n ", account.getBalance());
         }
        //display the monthly interest earned with updated balance amount after completing all deposits and withdrawals 
         System.out.printf("The monthly interest earned on the total amount is: %.2f\nThe account balance after all deposits and withdrawals with monthly interest is: %.2f\n\n",
                           account.monthlyProcess(), account.getBalance());
         
        //Display the status of the account if it is active or not
        System.out.println( account);
        
        //close the files
        dinputFile.close();
        winputFile.close();

    }//end method main
    
}//end class Accounts

/*
 * BankAccount.java
 * Developed by Smita Rothe
   Script Date: aug 19, 2020 
 */
package accounts;

public abstract class BankAccount {
     private double balance, yinterest;
     private int numOfDeposits, numOfWithdrawls;
     private double annualInterestRate, serviceCharges,  monthlyInterest, monthlyInterestRate;
    
    /*public BankAccount(){
        this.balance=0.0;
        this.interestRate=0.0;
    } */
    
    public BankAccount(double bal, double interest){
        this.balance= bal;
        this.annualInterestRate= interest;
    }
    
    public void setBalance(double bal){
        this.balance= bal;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setYearlyInterest(double interest){
        yinterest=interest;
    }
    public double getYearlyInterest(){
        return this.yinterest;
    }
    public double getMonthlyInterest(){
        return this.monthlyInterest;
    }
    
    public int getnumOfDeposites(){
        return this.numOfDeposits;
    }
    public int getnumOfWithdrawals(){
        return this.numOfWithdrawls;
    }
    public void setServiceCharges(double charges){
        serviceCharges=charges;
    }
    public double getserviceCharges(){
        return serviceCharges;
    }
     public double deposit(double depAmount){
        this.balance= this.balance +depAmount;
        this.numOfDeposits= this.numOfDeposits+1;
        return balance;        
    } 
    public double withdraw(double withAmount){
        this.balance= this.balance-withAmount;
        this.numOfWithdrawls= this.numOfWithdrawls+1;
        return balance;
    }
   
    public double calcInterest (double bal){
       
        monthlyInterestRate= annualInterestRate/12;
        monthlyInterest = this.balance * (monthlyInterestRate/100);
        this.balance = this.balance+ monthlyInterest;
        return monthlyInterest;
    }
    
    public double monthlyProcess ( ){
        double Interest;
        this.balance = this.balance- this.serviceCharges;
        Interest= calcInterest(balance);
        numOfDeposits=0;
        numOfWithdrawls=0;
        serviceCharges=0.0;
        return Interest;
    }
            
}

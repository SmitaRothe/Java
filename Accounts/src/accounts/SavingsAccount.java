/*
 * SavingsAccount.java
 * Developed by Smita Rothe
   Script Date: aug 19, 2020 
 */
package accounts;

public class SavingsAccount extends BankAccount{
    private boolean ActiveStatus;
    private double interest;
       
    public SavingsAccount(double bal, double interest){
        super(bal,interest);
        if(bal<25){
            ActiveStatus=false;
        }else{ 
            ActiveStatus=true;
        }     
    }//end constructor SavingsAccount
    
    @Override
    public double withdraw(double amount){
        double balance=0.0;
        if (ActiveStatus= true){
             balance=super.withdraw(amount);
        }else{
            System.out.println("The account is inactive");
        }
        return balance;
    }//end class withdraw
    
    @Override
    public double deposit(double damount){
        double balance;
            balance= super.deposit(damount);
            if (balance >25){
                ActiveStatus=true;         
            }
        return balance;
    }
    
    @Override
    public double monthlyProcess(){
             int extrawithdraw ;      
            if (super.getnumOfWithdrawals() >4){  
                extrawithdraw=(getnumOfWithdrawals()-4)*1;
                super.setServiceCharges(extrawithdraw);
            }            
            interest =super.monthlyProcess();
            if (super.getBalance()<25){
                ActiveStatus=false;
            }else{ 
                ActiveStatus=true;
            }   
       return interest;
    }
       
    @Override
    public String toString(){
        String str, status;
        if (ActiveStatus= true){
            status="active";
        }else{
            status="inactive";
        }
        str= "The status of the account is "+ status;
        return str;
    }
}

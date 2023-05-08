
package Bank;

public class Account {
    //Declaring instance variables.
    final public int accountNum;
    public double balance=0;
    public boolean loan=false;
    
    //Account constructor method.
    public Account(int accountNum){
        this.accountNum = accountNum;
    }
    //Withdraw: check if the balance and amount is suitible and remove the amount from the balance.
    public void withdraw(double amount){
        if (amount<=0||balance<amount){
            System.out.println(ConsoleColors.RED+"Error: Invalid Amount!");
        }
        else{
            balance = balance - amount;
            System.out.println(ConsoleColors.GREEN+"Success!"); //Success message.
            System.out.println("Withdrawn: "+amount+".\nCurrent balance: "+checkBalance()+".");
        }
    }
    //Deposit: check if the amount is suitible and add the amount to the balance.
    public void deposit(double amount){
         if (amount<=0){
            System.out.println(ConsoleColors.RED+"Error: Invalid Amount!");
        }
        else{
            balance = balance + amount;
            System.out.println(ConsoleColors.GREEN+"Success!"); //Success message.
            System.out.println("Deposited: "+amount+".\nCurrent balance: "+checkBalance()+".");
        }
    }
    //A method that outputs the balance of the account.
    public double checkBalance(){
        
        return balance;
    }
    //A method enable and disable the loan on the account.
    public void loanEnable(boolean loan){
        this.loan = loan;
    }
    //toString method for use in the selection screen.
    @Override
  public String toString(){
      String x;
      if (loan = true){
        x = "Yes.";
      }
      else x = "No.";
      return ("Account Number: "+accountNum+".\nBalance: "+balance+".\nDoes it have a loan? "+x);
  }
}
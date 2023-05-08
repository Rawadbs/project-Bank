package Bank;

public class Loan {
    //Declaring instance variables.
    final private double amount;
    final private int numOfMonths;
    final public int account;
    final private double rate;
    private double remaining;
    private int remainingMonths;
    //Loan constructor method.
    public Loan(double amount, int numOfMonths, int account, double rate){
        this.amount = amount;
        this.numOfMonths = numOfMonths;
        this.account = account;
        this.rate = rate;
        this.remainingMonths = numOfMonths;
        Account loanaccount = BankConsole.acc.get(account);
        loanaccount.balance = loanaccount.balance + this.amount;
    }
    //Calculating intrest using the given rate.
    public double intrest(){
        double intrest = amount*rate/100;
        return intrest;
    }
    //Calculating total amount (given amount+intrest).
    public double totalAmount(){
        double total = this.intrest()+amount;
        return total; 
    }
    //Calculating the monthly deserved amount (total amount/number of months).
    public double monthlyAmount(){
        double monthly = totalAmount()/numOfMonths;
        return monthly;
    }
    //Paying the amount for 1 month and subtracting it from the remaining amount.
    public void payMonth(){
        double monthly = monthlyAmount();
        Account loanaccount = BankConsole.acc.get(account);
        double balance = loanaccount.balance;
        remaining = remainingMonths * monthly;
        if(BankConsole.acc.get(account).balance > monthlyAmount() && remaining > 0){ //Checking if balance is enough.
            remaining = remaining - monthlyAmount();
            remainingMonths--;
            BankConsole.acc.get(account).balance = balance - monthly;
            System.out.println(ConsoleColors.GREEN+"Success!");
            System.out.println(ConsoleColors.GREEN+"Amount paid: "+monthly+".\nBalance: "+BankConsole.acc.get(account).balance+".\nRemaining Months: "+remainingMonths);
        }
        else System.out.println(ConsoleColors.RED+"Error: There is not enough balance to pay the loan.");
        if(remainingMonths == 0){ //Checking if remaining is 0 to remove the loan.
            System.out.println(ConsoleColors.GREEN+"Loan payment complete!");
            BankConsole.acc.get(account).loan = false;
            BankConsole.loans.removeElementAt(account);
        }
    }
    //toString method for use in the selection screen.
    @Override
    public String toString() {
        remaining = remainingMonths * monthlyAmount();
        return "Original amount: "+amount+".\nIntrest rate: "+rate+
              "%.\nNumber of months: "+numOfMonths+".\nTotal amount: "
              +totalAmount()+".\nMonthly amount: "+monthlyAmount()+
              ".\nRemaining amount: "+remaining+"."+
              ".\nRemaining months amount: "+remainingMonths+".";
  }
}
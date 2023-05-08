
package Bank;

import java.util.*; //Importing Scanner and Vector classes.
public class BankConsole {
    public static Vector<Account> acc = new Vector<Account>(); //Creating the vector for accounts.
    public static Vector<Loan> loans = new Vector<Loan>(); //Creating the vector for loans.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Creating a Scanner object.
        boolean mainLoop = true;
        System.out.println("\t***************************************"); //Starting page.
        System.out.println("\t\tBank Console");
        System.out.println("\t\tMade by: \n\t\tHussien Aljifri, 442002930 \n\t\t& \n\t\tRawad Bin Siddeq, 442005646");
        System.out.println("\t***************************************");
        while(mainLoop){ //Start of the loop.
            System.out.println("---------------------------------------\nChoose a number between 1 and 8:\n---------------------------------------");
            System.out.println("1- Create new account."); //Selection screen
            System.out.println("2- Deposit an amount on to an existing account.");
            System.out.println("3- Withdraw an amount from an existing account.");
            System.out.println("4- Check the current balance of an existing account.");
            System.out.println("5- Get a new loan on an existing account.");
            System.out.println("6- Check an existing loan status.");
            System.out.println("7- Pay one monthly payment of an existing loan.");
            System.out.println("8- Exit.");
            int operation = input.nextInt(); //Taking the users choice.
            switch(operation){
            case 1: //Customer and Account creation.
                System.out.println("Please enter your name: ");
                String name = input.next();
                System.out.println("Please enter your National ID: ");
                int nationalID = input.nextInt();
                System.out.println("Please enter Phone Number: ");
                int number = input.nextInt();
                System.out.println("Please enter E-Mail: ");
                String mail = input.next();
                System.out.println("Please enter Address: ");
                String address = input.next();
                Customer c = new Customer(name, nationalID, address, mail, number); //Constructing Customer.
                Account a = new Account(acc.size()); //Constructing Account.
                acc.addElement(a); //Adding the element to the vector.
                int num = acc.size();
                System.out.println(ConsoleColors.GREEN+"Successfully created account!\nAccount Number: "+num); //Success message.
                break;
            case 2: //Depositing money to an existing account.
                System.out.println("Please enter the account you would like to deposit to: ");
                int depacc = input.nextInt(); //Getting the account number.
                if(depacc<=acc.size() && depacc > 0){
                Account dep = acc.get(depacc-1); //Getting the account requested from the vector.
                System.out.println("Please enter the amount you would like to deposit: ");
                double amount = input.nextDouble(); //Getting the amount.
                dep.deposit(amount);
                }
                else System.out.println(ConsoleColors.RED+"Error: There is no account with that number."); //Error message when the account number is incorrect.
                break;
            case 3: //Withdrawing money from an existing account.
                System.out.println("Please enter the account you would like to withdraw from: ");
                int wacc = input.nextInt(); //Getting the account number.
                if(wacc<=acc.size() && wacc > 0){
                Account withdraw = acc.get(wacc-1); //Getting the account requested from the vector.
                System.out.println("Please enter the amount you would like to withdraw: ");
                double amount = input.nextDouble(); //Getting the amount.
                withdraw.withdraw(amount);
                }
                else System.out.println(ConsoleColors.RED+"Error: There is no account with that number."); //Error message when the account number is incorrect.
                break;
            case 4: //Checking the balance of an existing account.
                System.out.println("Please enter the account you would like to check the balance of: ");
                int cbacc = input.nextInt(); //Getting the account number.
                if(cbacc<=acc.size() && cbacc > 0){
                Account checkbalance = acc.get(cbacc-1); //Getting the account requested from the vector.
                System.out.println("The remaining balance of the account is: "+checkbalance.checkBalance());
                }
                else System.out.println(ConsoleColors.RED+"Error: There is no account with that number."); //Error message when the account number is incorrect.
                break;
            case 5: //Creating a new loan.
                System.out.println("Please enter the account you would like to create a loan on: ");
                int loanacc = input.nextInt(); //Getting the account number.
                if(loanacc<=acc.size() && loanacc > 0){
                Account addloan = acc.get(loanacc-1); //Getting the account requested from the vector.
                if(addloan.loan == true){ //Checking if the account has a loan or not.
                    System.out.println(ConsoleColors.RED+"Error: This account already has a loan.");
                }
                else{
                    System.out.println("Please enter the amount of the loan: ");
                    double amount = input.nextDouble(); //Getting the amount of the loan.
                    System.out.println("Please enter the number of months the loan will last: ");
                    int months = input.nextInt(); //Getting the number of months for the loan.
                    System.out.println("Please enter the deserved rate of the loan in percentage: ");
                    double rate = input.nextDouble(); //Getting the rate of the loan.
                    Loan newloan = new Loan(amount, months, loanacc-1, rate); //Constructing Loan.
                    loans.setSize(acc.size()); //Setting the size of the loan vector to the same as account vector.
                    loans.insertElementAt(newloan, loanacc-1); //Inserting loan into loan vector.
                    addloan.loanEnable(true); //Enabling the boolean value in the account.
                    System.out.println(ConsoleColors.GREEN+"Successfully created loan!");
                }
                }
                else System.out.println(ConsoleColors.RED+"Error: There is no account with that number."); //Error message when the account number is incorrect.
                break;
            case 6: //Checking the status of an existing loan.
                System.out.println("Please enter the account number you would like to check the loan status of: ");
                int ls = input.nextInt(); //Getting the account number.
                if(acc.get(ls-1).loan == true && ls > 0){
                Loan loanstatus = loans.get(ls-1); //Getting the account requested from the vector.
                System.out.println(loanstatus.toString());
                }
                else System.out.println(ConsoleColors.RED+"Error: There is no loan associated with that account."); //Error message when the account number is incorrect.
                break;
            case 7: //Paying one month of an existing loan.
                System.out.println("Please enter the account number you would like to pay the loan on: ");
                int pl = input.nextInt(); //Getting the account number.
                if(acc.get(pl-1).loan == true && pl > 0){
                Loan loanpay = loans.get(pl-1); //Getting the account requested from the vector.
                loanpay.payMonth();
                }
                else System.out.println(ConsoleColors.RED+"Error: There is no loan associated with that account."); //Error message when the account number is incorrect.
                break;
            case 8: //Exiting program.
                System.out.println(ConsoleColors.GREEN+"Goodbye!");
                mainLoop = false;
                }
            while(operation > 8 || operation < 1){ //Checking that the input was between 1 and 8.
                System.out.println(ConsoleColors.RED+"Error: Please input an integer from 1 to 8.");
                break; //Note: i would use try and catch to handle InputMismatchException but it is not included in this project.
            }
        }//End of the loop. 
    }
}
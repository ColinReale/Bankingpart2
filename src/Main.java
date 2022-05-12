import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankAccount acct = new BankAccount("Charlie", 100, 500);
        acct.Deposit(100);
        BankAccount acct2 = new BankAccount("Desmond", 101, 5000);
        BankAccount acct3 = new BankAccount("Nico", 103, 300);
        acct2.trx(acct3, 100);
        acct.Total();
        acct2.Total();
        acct3.Total();



        accounts.add(new BankAccount("Sally", 10001, 3000));
        accounts.add(new BankAccount("Raj", 10002, 4000));
        accounts.add(new BankAccount("Ivan", 10003, 2000));
        accounts.add(acct);
        accounts.add(acct2);
        accounts.add(acct3);


        System.out.println("Hello! Welcome to the Bank. Are you an existing customer? (-1 to exit)");
        System.out.println("1 = Yes \n 2 = No");


//        it's okay that I didn't import the scanner here bc it's imported elsewhere?
        int response = Integer.valueOf(scan.nextLine());

//        may need something like this?
//        mainMenu(accounts[0]);

        while (true) {


            if (response == 1) {
                System.out.println("What is your account number?");
                int accountNum = Integer.valueOf(scan.nextLine());


                boolean isAccountHolder = false;
                int index = -1;
                for (int i=0; i<accounts.size(); i++) {
                    BankAccount acc = accounts.get(i);
                    if (accountNum == acc.getAccountNumber()) {
                        isAccountHolder = true;
                        index = i;
                    }

                }
                if (isAccountHolder) {
                    mainMenu(accounts.get(index));
                } else {
                    System.out.println("Sorry we couldn't find your account number, please try again");
                }

            } else if (response == 2) {
                BankAccount newAccount = new BankAccount();
                System.out.println("Let's create an account!");
                System.out.println("What is the name you'd like on the account?");
                String responseName = scan.nextLine();
                newAccount.setAccountHolderName(responseName);
                System.out.println("What is the starting amount for the account?");
                double responseAmount = Double.valueOf(scan.nextLine());
                newAccount.setBalance(responseAmount);
                accounts.add(newAccount);

                mainMenu(accounts.get(accounts.size() - 1));
            } else if (response == -1) {
                System.out.println("Okay, have a nice day!");

            }

        }

    }
    public static void mainMenu(BankAccount acc) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello " + acc.getAccountHolderName() + "!");
        System.out.println("Welcome to the main menu, what would you like to do today?");
        System.out.println("1. Check account balance \n 2. Make a withdrawal \n 3. Make a deposit \n 4. Make a transfer to another account \n 0. Exit ");

        int response = Integer.valueOf(scan.nextLine());
        while (response != 0) {


            if (response == 1) {
                acc.getBalance();
                System.out.println("Current balance is " + acc.getBalance());
                mainMenu(accounts.get(accounts.size() - 1));
            } else if (response == 2) {
                System.out.println("What amount would you like to withdraw?");
                double withdrawAmt = Double.valueOf(scan.nextLine());
                acc.Withdrawal(withdrawAmt);
                System.out.println("The amount " + withdrawAmt + " has been withdrawn.");
                mainMenu(accounts.get(accounts.size() - 1));
            } else if (response == 3) {
                System.out.println("What amount would you like to deposit?");
                double depAmt = Double.valueOf(scan.nextLine());
                acc.Deposit(depAmt);
                System.out.println("The amount " + depAmt + " has been deposited.");
                mainMenu(accounts.get(accounts.size() - 1));
            } else if (response == 4) {
                System.out.println("Please enter the account number you'd like to transfer money to");
                int accountToTransferTo = Integer.valueOf(scan.nextLine());
                BankAccount toTransferTo = new BankAccount();
                boolean isAccountHolder = false;
                int index = -1;

                for (int i=0; i<accounts.size(); i++) {
                    BankAccount accs = accounts.get(i);
                    if (accountToTransferTo == accs.getAccountNumber()) {
                        toTransferTo = accs;
                        isAccountHolder = true;
                        index = i;
                    }

                }

                if (isAccountHolder) {
                    System.out.println("How much would you like to transfer?");
                    double transferAmount = Double.valueOf(scan.nextLine());

                    acc.transfer(toTransferTo, transferAmount);
                    System.out.println(acc.getHolderName() + " moved " + transferAmount + " and now has " + acc.getBalance());
                    System.out.println(toTransferTo.getAccountHolderName() + " was given " + transferAmount + " and now has " + toTransferTo.getBalance());
                    break;
                } else {
                    System.out.println("Sorry, account not found. Try again");
                    mainMenu(acc);
                }
                break;
            } else if (response == 0) {
                System.out.println("Okay, have a nice day!");
                break;
            }
        }
    }
}
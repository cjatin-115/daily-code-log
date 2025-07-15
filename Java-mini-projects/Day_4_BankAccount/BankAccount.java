import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    int AccountNumber, Balance;
    String AccountHolderName;

    BankAccount(int x, int y, String z) {
        AccountNumber = x;
        Balance = y;
        AccountHolderName = z;
    }

    public void Deposit(int x) {
        Balance += x;
    }

    public void Withdraw(int y) {
        Balance -= y;
    }

    public void AccountDetails() {
        System.out.println("Account Holder : " + AccountHolderName);
        System.out.println("Account Number : " + AccountNumber);
        System.out.println("Account Balance : " + Balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the account number : ");
        int x = sc.nextInt();
        System.out.print("enter the account balance :");
        int y = sc.nextInt();
        sc.nextLine();
        System.out.print("enter the account holder name :");
        String z = sc.nextLine();

        BankAccount obj = new BankAccount(x, y, z);

        while (true) {

            System.out.print("what operation to perform (1.withdraw ,2.deposit ,3.account details ,4.exit):");
            int choice ;
            
            try {
                choice = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter an integer between 1 and 4.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount you want to withdraw :");
                    int a = sc.nextInt();
                    if ( a > obj.Balance ){
                        System.out.println("Insufficient balance! Cannot withdraw " + a);
                        break;
                    }
                    else{
                        obj.Withdraw(a);
                        break;
                    }
                    

                case 2:
                    System.out.print("Enter the amount you want to deposit :");
                    int b = sc.nextInt();
                    obj.Deposit(b);
                    break;

                case 3:
                    obj.AccountDetails();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.print("enter valid input !!");
            }
        }

    }

}
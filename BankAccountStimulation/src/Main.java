import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String name = sc.next();
        System.out.print("Enter Account Number: ");
        int accountNo = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Set Your PIN: ");
        int pin = sc.nextInt();

        Account user = new Account(accountNo, name, pin, balance);
        byte choice;

        do{
            System.out.println("========== Menu ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice : ");
            choice = sc.nextByte();
            int transactionPin;
            switch (choice){

                case 1 :
                    System.out.print("Enter your PIN : ");
                    transactionPin = sc.nextInt();
                    user.viewBalance(transactionPin);
                    break;

                case 2 :
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    System.out.print("Enter your PIN: ");
                    transactionPin = sc.nextInt();
                    user.depositMoney(transactionPin, depositAmount);
                    break;

                case 3 :
                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();
                    System.out.print("Enter your PIN: ");
                    transactionPin = sc.nextInt();
                    user.withdrawMoney(transactionPin, withdrawAmount);
                    break;

                case 4 :
                    System.out.print("Enter your PIN: ");
                    transactionPin = sc.nextInt();
                    user.viewTransactionHistory(transactionPin);
                    break;

                case 5 :
                    System.out.println("Exiting....");
            }
        }while(choice != 5);
    }
}
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Account {
    private int accountNo;
    private String name;
    private int pin;
    private double balance;

    private ArrayList<String> transcationHistory;

    public Account(int accountNo, String name, int pin, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.transcationHistory = new ArrayList<>();
        System.out.println("Account Opened! \n Initial Balance : " + balance);
    }

    private String dateAndTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return now.format(formatter);
    }

    public void depositMoney(int pin, double amount){
        if(this.pin != pin){
            System.out.println("Invalid PIN!");
            return;
        }
        if(amount > 0){
            balance += amount;
            String timeStamp = dateAndTime();
            transcationHistory.add("Deposit of  " + amount + " at " + timeStamp);
            System.out.println("Deposit of " + amount + " Successfull");
            System.out.println("Available Balance: " + balance);
        }
    }
    public void withdrawMoney(int pin, double amount){
        if(this.pin != pin){
            System.out.println("Invalid PIN!");
            return;
        }
        if(amount < balance) {
            balance -= amount;
            String timeStamp = dateAndTime();
            transcationHistory.add("Withdrawl of " + amount + " at " + timeStamp);
            System.out.println("Successfull!");
            System.out.println("Available Balance : " + balance);
        }else{
            System.out.println("Insufficient Balance!");
            return;
        }
    }
    public void viewTransactionHistory(int pin){
        if(this.pin != pin){
            System.out.println("Invalid PIN!");
            return;
        }
        for(String history : transcationHistory){
            System.out.println(history);
        }
    }

    public void viewBalance(int pin){
        if(this.pin == pin){
            System.out.println("Available Balance : " + balance);
            return;
        }
        System.out.println("Invalid PIN!");
    }
}

package main.java.com.across.netbanking.app;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("Welcome to Across!\nYour seamless internet banking."); // greets

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your bank account number: ");
        String userEnteredAccountNum = sc.next();
        System.out.print("Enter your PIN: ");
        short userEnteredPIN = sc.nextShort();
        
        // Validate User credentials!
        try {
            
        } catch (Exception e) {
            
        }
        
        
    }
}

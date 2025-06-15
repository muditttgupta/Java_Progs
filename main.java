
// File: Main.java
import Balance.Account;

public class main {
    public static void main(String[] args) {
        // Create an Account object with an initial balance
        Account myAccount = new Account(5000.75);
        
        // Call the method to display balance
        myAccount.Display_Balance();
    }
}

interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
}

class Account implements Bank {
    double balance;
    Account(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        }
        else {
            System.out.println("Invalid");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid");
        }
    }
}
public class BankDemo {
    public static void main(String[] args) {
        Account myAccount = new Account(1000);
        myAccount.deposit(500);
        myAccount.withdraw(200);
        myAccount.withdraw(1500);
    }
}

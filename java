import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;

    Account(String customerName, int accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    void deposit(double amount) {
        // Implement deposit logic for both account types
    }

    void withdraw(double amount) {
        // Implement withdrawal logic for both account types
    }

    void displayBalance() {
        // Implement balance display logic for both account types
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String customerName, int accountNumber, String accountType, double interestRate) {
        super(customerName, accountNumber, accountType);
        this.interestRate = interestRate;
    }

    void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Amount deposited to savings account: " + amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn from savings account: " + amount);
        } else {
            System.out.println("Insufficient balance in savings account.");
        }
    }

    void displayBalance() {
        System.out.println("Savings account balance: " + balance);
    }

    void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added to savings account: " + interest);
    }
}

class CurrentAccount extends Account {
    double minimumBalance;

    CurrentAccount(String customerName, int accountNumber, String accountType, double minimumBalance) {
        super(customerName, accountNumber, accountType);
        this.minimumBalance = minimumBalance;
    }

    void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Amount deposited to current account: " + amount);
    }

    void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Amount withdrawn from current account: " + amount);
        } else {
            System.out.println("Insufficient balance in current account. Service charge applied.");
            balance -= 50; // Example service charge
        }
    }

    void displayBalance() {
        System.out.println("Current account balance: " + balance);
    }
}

class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter account number:");
        int accountNumber = scanner.nextInt();

        System.out.println("Enter account type (savings/current):");
        String accountType = scanner.next();

        if (accountType.equalsIgnoreCase("savings")) {
            System.out.println("Enter interest rate:");
            double interestRate = scanner.nextDouble();
            SavingsAccount savingsAccount = new SavingsAccount(customerName, accountNumber, accountType, interestRate);

            // ... perform operations on savings account
        } else if (accountType.equalsIgnoreCase("current")) {
            System.out.println("Enter minimum balance:");
            double minimumBalance = scanner.nextDouble();
            CurrentAccount currentAccount = new CurrentAccount(customerName, accountNumber, accountType, minimumBalance);

            // ... perform operations on current account
        } else {
            System.out.println("Invalid account type.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class ATM {

    private BankAccount account; // Step 5: the ATM "has a" BankAccount it operates on

    // Constructor: connects this ATM to a specific bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Step 2: displays the menu and handles user choices
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the ATM.");

        while (running) {
            // Menu display
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                scanner.next(); // discard bad input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Step 3: checkBalance()
                    System.out.println("Your current balance is: " + account.checkBalance());
                    break;

                case 2:
                    // Step 3: deposit(amount)
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount); // BankAccount prints success/failure message
                    break;

                case 3:
                    // Step 3: withdraw(amount)
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount); // BankAccount prints success/failure message
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }

    // Entry point of the program
    public static void main(String[] args) {
        // Step 4: create a bank account with a starting balance
        BankAccount myAccount = new BankAccount(1000.0);

        // Step 5: connect the ATM to that account
        ATM atm = new ATM(myAccount);

        // Start the ATM interface
        atm.start();
    }
}

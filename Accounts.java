import java.text.DecimalFormat;
import java.util.Scanner;

public class Accounts {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    // Setters and Getters
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Withdraw Methods
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    // Deposit Methods
    public double calcCheckingDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    // User Input for Withdrawals
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = sc.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative.\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account: ");
        double amount = sc.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative.\n");
        }
    }

    // User Input for Deposits
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit to Checking Account: ");
        double amount = sc.nextDouble();

        if (amount >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Invalid deposit amount.\n");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit to Saving Account: ");
        double amount = sc.nextDouble();

        if (amount >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid deposit amount.\n");
        }
    }
}

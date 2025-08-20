import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Accounts {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00"); // Input in decimal format

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    int selection;

    // Validate login information (Customer Number and PIN)
    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                // Predefined login credentials
                data.put(1234567, 9876);
                data.put(7654321, 6789);

                System.out.println("Welcome to ATM");
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(sc.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(sc.nextInt());

            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers allowed.\n");
                sc.nextLine(); // Clear scanner buffer
                continue;
            }

            boolean validLogin = false;

            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    validLogin = true;
                    break;
                }
            }

            if (validLogin) {
                getAccountType();
                x = 2; // Exit login loop after successful login
            } else {
                System.out.println("\nWrong Customer Number or PIN.\n");
            }

        } while (x == 1);
    }

    // If credentials are correct, display this menu
    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 -> Checking Account");
        System.out.println("Type 2 -> Saving Account");
        System.out.println("Type 3 -> Exit");

        System.out.print("Choice: ");
        selection = sc.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM, Bye");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 -> View Balance");
        System.out.println("Type 2 -> Withdraw Funds");
        System.out.println("Type 3 -> Deposit Funds");
        System.out.println("Type 4 -> Exit");

        System.out.print("Choice: ");
        selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, Bye");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 -> View Balance");
        System.out.println("Type 2 -> Withdraw Funds");
        System.out.println("Type 3 -> Deposit Funds");
        System.out.println("Type 4 -> Exit");

        System.out.print("Choice: ");
        selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, Bye");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getSaving();
        }
    }
}

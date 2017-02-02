//Project assignment for 2-2.
//Banking project where the user will be adding/removing bank accounts from an ATM

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double userBalance; //this will be the value
    static double startBalance = 0;
    static int selection;
    static double withdrawAmount;
    static int lastSelection;

    //welcome and prompt user for name
    public static void main(String[] args) throws Exception {
        Map<String, Double> hashMap = new HashMap();

        String userName;

        while (true) {


            System.out.println("Hello, and welcome to the ATM!");
            System.out.println("Please type in your name to begin.");


            userName = scanner.nextLine();

            //check if they have an account
            if (hashMap.containsKey(userName)) {
                System.out.println("Welcome back to your account," + userName);
            }
            //once account is created, prompt user for deposit amount (userBalance)
            else {
                System.out.println("It looks like you don't have an account. A new one will be created for you.");
                System.out.println("Please enter a new username.");
                userName = scanner.nextLine();
                System.out.println("How much would you like to input into your new account?");
                userBalance = Double.parseDouble(scanner.nextLine());
                hashMap.put(userName, userBalance);
            }


            //show options
            System.out.println("What would you like to do?");
            System.out.println("Type 1 for balance check.");
            System.out.println("Type 2 for withdraw money.");
            System.out.println("Type 3 to cancel.");

            //make selection
            selection = Integer.parseInt(scanner.nextLine());
            String selectionName = " ";
            if (selection == 1) {
                selectionName = "Balance Check";
            } else if (selection == 2) {
                selectionName = "Withdraw Funds";
            } else if (selection == 3) {
                selectionName = "Cancel";
            }
            System.out.println("You have selected " + selectionName);

            while ((selection == 1) || (selection == 2)) {
                switch (selection) {
                    case 1:
                        System.out.println("Your balance is " + userBalance);
                        System.out.println("What would you like to do?");
                        System.out.println("Type 1 for balance check.");
                        System.out.println("Type 2 for withdraw money.");
                        System.out.println("Type 3 to cancel.");
                        selection = Integer.parseInt(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("How much money would you like to withdraw?");
                        withdrawAmount = Integer.parseInt(scanner.nextLine());

                        if (withdrawAmount > userBalance) {
                            throw new Exception("You cannot withdraw more than your available balance!");
                        } else if ((withdrawAmount <= userBalance) && (userBalance > 0)) {
                            System.out.println("You may take your money.");
                            double newBalance = userBalance - withdrawAmount;
                            System.out.println("Your new account balance is $" + newBalance);
                            //System.out.println("Have a nice day!");
                            System.out.println("What would you like to do?");
                            System.out.println("Type 1 for balance check.");
                            System.out.println("Type 2 for withdraw money.");
                            System.out.println("Type 3 to cancel.");
                            selection = Integer.parseInt(scanner.nextLine());
                        }
                        break;
                    case 3:
                        break;
                }
            }

            System.out.println("Would you like to: ");
            System.out.println("1. Exit");
            System.out.println("2. Remove bank account");

            lastSelection = Integer.parseInt(scanner.nextLine());

            switch (lastSelection) {
                case 1:
                    System.out.println("Goodbye!");
                    break;
                case 2:
                    System.out.println("You have selected to remove your account.");
                    hashMap.remove(userName);
                    System.out.println("Your account has been removed!");
                    break;
            }

            //loop back to the beginning to ask the next user for their userName, commented out below shows the contents of hashMap
            //System.out.println(hashMap);
        }
    }
}
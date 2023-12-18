package ATM;

import java.util.Scanner;

public class ATMMachine{

    public static void main(String[] args) {
        ATMImplement imp = new ATMImplement();
        Scanner scanner = new Scanner(System.in);
        int userId = 10001;
        String userPassword = "user@123";


        System.out.println("Welcome to ATM interface!!");
        System.out.println("==========================");

        System.out.println("Enter user Id: ");
        int inputId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter password:");
        String inputPassword = scanner.nextLine();

        if((inputId == userId) && inputPassword.equals(userPassword)){
            while (true){
                System.out.println("Choose your option!");
                System.out.println("1. Deposit Amount");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. View Available Balance");
                System.out.println("4. Exit");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        imp.depositAmount(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter Amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();

                        imp.withdrawAmount(withdrawAmount);
                        System.out.println("Do you want the receipt(Y/N)?");
                        String receipt = scanner.nextLine();
                        if (receipt.equals("Y")){
                            imp.viewMiniStatement();
                        } else if (receipt.equals("N")){
                            System.out.println("Thank you for co-ordinating!");
                        }
                        break;

                    case 3:
                        imp.viewBalance();
                        break;

                    case 4:
                        System.out.println("Thank you for using our service!!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter valid choice!");
                }

            }
        } else {
            System.out.println("Sorry! Verification failed!!");
            System.exit(0);
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan principal: ");
        int principal = scanner.nextInt();

        System.out.print("What do you want to calculate?\n" +
                "type \"m\" – for number of monthly payments,\n" +
                "type \"p\" – for the monthly payment: ");
        char choice = scanner.next().charAt(0);

        if (choice == 'm') {
            System.out.print("Enter the monthly payment: ");
            int payment = scanner.nextInt();
            int months = (int) Math.ceil((double) principal / payment);
            System.out.println("It will take " + months + " month" + (months > 1 ? "s" : "") + " to repay the loan");
        } else if (choice == 'p') {
            System.out.print("Enter the number of months: ");
            int months = scanner.nextInt();
            int payment = (int) Math.ceil((double) principal / months);
            int lastPayment = principal - (months - 1) * payment;
            if (lastPayment != payment) {
                System.out.println("Your monthly payment = " + payment + " and the last payment = " + lastPayment + ".");
            } else {
                System.out.println("Your monthly payment = " + payment);
            }
        }

        scanner.close();
    }
}

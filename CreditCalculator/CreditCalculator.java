import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What do you want to calculate?\n" +
                "type \"n\" for number of monthly payments,\n" +
                "type \"a\" for annuity monthly payment amount,\n" +
                "type \"p\" for loan principal: ");
        char choice = scanner.next().charAt(0);

        if (choice == 'n') {
            System.out.print("Enter the loan principal: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter the monthly payment: ");
            double payment = scanner.nextDouble();

            System.out.print("Enter the loan interest: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Формула для расчета количества месяцев
            double months = Math.log(payment / (payment - interest * principal)) / Math.log(1 + interest);
            int roundedMonths = (int) Math.ceil(months);

            // Перевод месяцев в годы и месяцы
            int years = roundedMonths / 12;
            int remainingMonths = roundedMonths % 12;

            // Вывод результата
            if (years > 0) {
                System.out.println("It will take " + years + " year" + (years > 1 ? "s" : "") +
                        (remainingMonths > 0 ? " and " + remainingMonths + " month" + (remainingMonths > 1 ? "s" : "") : "") +
                        " to repay this loan!");
            } else {
                System.out.println("It will take " + roundedMonths + " month" + (roundedMonths > 1 ? "s" : "") + " to repay this loan!");
            }

        } else if (choice == 'a') {
            System.out.print("Enter the loan principal: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter the number of periods: ");
            int months = scanner.nextInt();

            System.out.print("Enter the loan interest: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Формула для расчета аннуитетного платежа
            double payment = principal * interest * Math.pow(1 + interest, months) / (Math.pow(1 + interest, months) - 1);

            System.out.println("Your monthly payment = " + Math.ceil(payment) + "!");
        } else if (choice == 'p') {
            System.out.print("Enter the annuity payment: ");
            double payment = scanner.nextDouble();

            System.out.print("Enter the number of periods: ");
            int months = scanner.nextInt();

            System.out.print("Enter the loan interest: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Формула для расчета суммы кредита
            double loanPrincipal = payment / (interest * Math.pow(1 + interest, months) / (Math.pow(1 + interest, months) - 1));

            System.out.println("Your loan principal = " + Math.ceil(loanPrincipal) + "!");
        }

        scanner.close();
    }
}

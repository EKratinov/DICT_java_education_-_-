import java.util.Scanner;

public class CreditCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Что вы хотите рассчитать?\n" +
                "введите \"n\" для количества ежемесячных платежей,\n" +
                "введите \"a\" для суммы аннуитетного ежемесячного платежа,\n" +
                "введите \"p\" для основной суммы кредита,\n" +
                "введите \"d\" для дифференцированных платежей: ");
        char choice = scanner.next().charAt(0);

        if (choice == 'n') {
            System.out.print("Введите основную сумму кредита: ");
            double principal = scanner.nextDouble();

            System.out.print("Введите ежемесячный платеж: ");
            double payment = scanner.nextDouble();

            System.out.print("Введите процентную ставку: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Формула для расчета количества месяцев
            double months = Math.log(payment / (payment - interest * principal)) / Math.log(1 + interest);
            int roundedMonths = (int) Math.ceil(months);

            // Перевод месяцев в годы и месяцы
            int years = roundedMonths / 12;
            int remainingMonths = roundedMonths % 12;

            // Вывод результата
            if (years > 0) {
                System.out.println("Для погашения этого кредита потребуется " + years + " год" + (years > 1 ? "а" : "") +
                        (remainingMonths > 0 ? " и " + remainingMonths + " месяц" + (remainingMonths > 1 ? "ев" : "") : "") +
                        "!");
            } else {
                System.out.println("Для погашения этого кредита потребуется " + roundedMonths + " месяц" + (roundedMonths > 1 ? "ев" : "") + "!");
            }

        } else if (choice == 'a') {
            System.out.print("Введите основную сумму кредита: ");
            double principal = scanner.nextDouble();

            System.out.print("Введите количество периодов: ");
            int months = scanner.nextInt();

            System.out.print("Введите процентную ставку: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Формула для расчета аннуитетного платежа
            double payment = principal * interest * Math.pow(1 + interest, months) / (Math.pow(1 + interest, months) - 1);

            System.out.println("Ваш ежемесячный платеж = " + Math.ceil(payment) + "!");

        } else if (choice == 'p') {
            System.out.print("Введите сумму аннуитетного платежа: ");
            double payment = scanner.nextDouble();

            System.out.print("Введите количество периодов: ");
            int months = scanner.nextInt();

            System.out.print("Введите процентную ставку: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Формула для расчета основной суммы кредита
            double loanPrincipal = payment / (interest * Math.pow(1 + interest, months) / (Math.pow(1 + interest, months) - 1));

            System.out.println("Ваша основная сумма кредита = " + Math.ceil(loanPrincipal) + "!");

        } else if (choice == 'd') {
            // Расчет дифференцированных платежей
            System.out.print("Введите основную сумму кредита: ");
            double principal = scanner.nextDouble();

            System.out.print("Введите количество периодов: ");
            int periods = scanner.nextInt();

            System.out.print("Введите процентную ставку: ");
            double interest = scanner.nextDouble() / 100 / 12;

            // Фиксированная сумма основной части платежа каждый месяц
            double fixedPrincipalPayment = principal / periods;

            for (int month = 1; month <= periods; month++) {
                // Рассчитываем процентную часть для текущего месяца
                double interestPayment = interest * (principal - fixedPrincipalPayment * (month - 1));

                // Общий платеж для текущего месяца
                double totalPayment = fixedPrincipalPayment + interestPayment;

                // Выводим детали платежа для текущего месяца
                System.out.printf("Месяц %d: %.2f (основной платеж: %.2f, платеж по процентам: %.2f)%n",
                        month, totalPayment, fixedPrincipalPayment, interestPayment);
            }
        }

        scanner.close();
    }
}

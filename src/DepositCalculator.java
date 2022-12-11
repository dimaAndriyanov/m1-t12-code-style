import java.util.Scanner;

public class DepositCalculator {
    double getBalanceInTheEndOfPeriodWithMonthlyPayments(double deposit, double interestRate, int depositPeriod) {
        double balanceInTheEndOfPeriod = deposit * Math.pow((1 + interestRate / 12), 12 * depositPeriod);
        return setPrecisionToValue(balanceInTheEndOfPeriod, 2);
    }

    double getBalanceInTheEndOfPeriodWithYearlyPayments(double deposit, double interestRate, int depositPeriod) {
        return setPrecisionToValue(deposit + deposit * interestRate * depositPeriod, 2);
    }

    double setPrecisionToValue(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    void showBalanceInTheEndOfPeriod() {
        int deposit;
        int depositPeriod;
        int userInput;
        double balance = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        deposit = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        userInput = scanner.nextInt();
        if (userInput == 1) {
            balance = getBalanceInTheEndOfPeriodWithYearlyPayments(deposit, 0.06, depositPeriod);
        } else if (userInput == 2) {
            balance = getBalanceInTheEndOfPeriodWithMonthlyPayments(deposit, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + deposit + " за " + depositPeriod + " лет превратятся в " + balance);
    }

    public static void main(String[] args) {
        new DepositCalculator().showBalanceInTheEndOfPeriod();
    }
}

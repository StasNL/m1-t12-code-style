import java.util.Scanner;

public class DepositCalculator {
    int places = 2;
    double calculateComplexPercent (double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, places);
    }

    double calculateSimplePercent (double doubleAmount, double yearRate, int depositPeriod) {
        return round(doubleAmount + doubleAmount * yearRate * depositPeriod, places);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculation() {
        int period;
        int action;
        double yearRate = 0.06;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");

        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        action = scanner.nextInt();

        double money = 0;

        if (action == 1) money = calculateSimplePercent(amount, yearRate, period);
        else if (action == 2) {
            money = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + money);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculation();
    }


}

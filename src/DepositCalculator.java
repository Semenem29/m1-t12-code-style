import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().manageCalculation();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) { /*TODO
    Я бы переменную depositPeriod свядала бы со словом год, т.к. в нее не получится положить
    другой период (например месяцы или кварталы).
    Переменной amount тоже можно найти более конкретное название))))*/
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundValue(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {

        return roundValue(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundValue(double value, int places) {
        double ScaLe = Math.pow(10, places);

        return Math.round(value * ScaLe) / ScaLe; //TODO в переменной scaLe должны быть все буквы строчными:D
    }

    void manageCalculation() {

        int period; //TODO Также, считаю, что можно связать имя переменной со словом год)
        int action;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        //TODO Нужно ли пропускать тут строки?? Ну в любом случае, так красивее))))
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        
        double result = 0;
        
        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);

        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

}

import java.util.Scanner;

public class Calculator {
    static double[] results = new double[10]; // массив для хранения результатов операций

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char operation;
        double num1, num2, result;
        boolean calculateFactorial = false;

        String answer = null;
        do {
            System.out.print("Введите операцию (+, -, *, /): ");
            operation = scanner.next().charAt(0);

            System.out.print("Введите первое число: ");
            num1 = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            num2 = scanner.nextDouble();

            switch (operation) {
                case '+':
                    result = add(num1, num2);
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                case '/':
                    result = divide(num1, num2);
                    System.out.println(num1 + " / " + num2 + " = " + result);
                    break;
                default:
                    System.out.println("Неправильная операция.");
                    continue;
            }

            results[0] = result; // сохраняем результат в массиве

            System.out.print("Хотите вычислить факториал? (да/нет): ");
            answer = scanner.next();

            if (answer.equalsIgnoreCase("да")) {
                calculateFactorial = true;
                System.out.print("Введите число для вычисления факториала: ");
                int num = scanner.nextInt();
                int factorial = calculateFactorial(num);
                System.out.println(num + "! = " + factorial);
            } else {
                calculateFactorial = false;
            }

            System.out.print("Хотите продолжить? (да/нет): ");
            answer = scanner.next();
        } while (answer.equalsIgnoreCase("да"));

        System.out.println("Результаты операций:");
        for (double res : results) {
            if (res != 0) {
                System.out.println(res);
            }
        }
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    public static int calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }

    // перегруженные методы калькулятора для операций с числами с плавающей точкой
    public static double add(double num1, double num2, double num3) {
        return add(add(num1, num2), num3);
    }

    public static double subtract(double num1, double num2, double num3) {
        return subtract(subtract(num1, num2), num3);
    }

    public static double multiply(double num1, double num2, double num3) {
        return multiply(multiply(num1, num2), num3);
    }

    public static double divide(double num1, double num2, double num3) {
        return divide(divide(num1, num2), num3);
    }
}
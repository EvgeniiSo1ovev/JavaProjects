package Homeworks.HWL4.task3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.io.FileWriter;

/*
 * В калькулятор добавьте возможность отменить последнюю операцию.
 * Пример
 * 1
 * +
 * 2
 * ответ:
 * 3
 * +
 * 4
 * ответ:
 * 7
 * Отмена
 * 3
 * *
 * 3
 * ответ:
 * 9
 * Дополнительно каскадная отмена - отмена нескольких операций
 */
public class task3 {

    public static void main(String[] args) {
        calculator();
    }

    static double operations(String oper, double num_1, double num_2) {
        double res;
        switch (oper) {
            case "+":
                res = num_1 + num_2;
                break;
            case "-":
                res = num_1 - num_2;
                break;
            case "*":
                res = num_1 * num_2;
                break;
            case "/":
                res = num_1 / num_2;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    static void calculator() {
        Deque<Double> defaultNum_1 = new ArrayDeque<>();
        boolean defaulFirstRun = true;
        calculator(defaultNum_1, defaulFirstRun);
        return;
    }

    static void calculator(Deque<Double> num_1, boolean firstRun) {
        Scanner myScanner = new Scanner(System.in);
        if (firstRun == true) {
            System.out.print("Введите первое число: ");
            num_1.addFirst(myScanner.nextDouble());
        } else {
            System.out.printf("Число: %.2f\n", num_1.getLast());
        }
        System.out.print("Введите операцию (+, -, *, / или c - отмена, r - сброс или q - выход): ");
        String oper = String.format(myScanner.next());
        switch (oper) {
            case "c":
                String cMsg = "Отмена последней операции\n";
                System.out.print(cMsg);
                writeLog(cMsg);
                if (num_1.size() > 2) {
                    num_1.removeLast();
                    calculator(num_1, false);
                } else {
                    calculator();
                }
                myScanner.close();
                return;
            case "r":
                String rMsg = "Сброс всех операций\n";
                System.out.print(rMsg);
                writeLog(rMsg);
                calculator();
                myScanner.close();
                return;
            case "q":
                String qMsg = "Выход из программы\n";
                System.out.print(qMsg);
                writeLog(qMsg);
                myScanner.close();
                return;
        }
        System.out.print("Введите второе число: ");
        double num_2 = myScanner.nextDouble();
        if (oper == "/" && num_2 == 0) {
            String ErrorMsg = "Ошибка! На ноль делить нельзя!\n";
            System.out.print(ErrorMsg);
            writeLog(String.format("%.2f %s %.2f = %s", num_1.getLast(), oper, num_2, ErrorMsg));
            calculator(num_1, false);
            myScanner.close();
            return;
        }
        double result = operations(oper, num_1.getLast(), num_2);
        System.out.printf("Ответ: %.2f\n", result);
        writeLog(String.format("%.2f %s %.2f = %.2f\n", num_1.getLast(), oper, num_2, result));
        num_1.addLast(result);
        calculator(num_1, false);
        myScanner.close();
        return;
    }

    static void writeLog(String logMsg) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(logMsg);
            writer.flush();
        } catch (Exception e) {
            System.out.println("Получена ошибка доступа к лог-файлу");
        }
    }
}

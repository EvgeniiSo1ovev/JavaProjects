package Homeworks.HWL2.task4;

/*
 * К калькулятору из предыдущего дз добавить логирование.
 */
import java.util.Scanner;
import java.io.FileWriter;

public class task4 {
    public static void main(String[] args) {
        calculator();
    }

    static double operations(String oper, double num_1, double num_2){
        double res;
        switch (oper){
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
    
    static void calculator(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num_1 = myScanner.nextDouble();
        System.out.print("Введите операцию (+, -, *, /): ");
        String oper = myScanner.next();
        System.out.print("Введите второе число: ");
        double num_2 = myScanner.nextDouble();
        if (oper == "/" && num_2 == 0){
            System.out.println("Ошибка! На ноль делить нельзя!");
            myScanner.close();
            return;
        }
        double result = operations(oper, num_1, num_2);
        System.out.printf("Ваш результат: %.2f\n", result);
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(String.format("%.2f %s %.2f = %.2f\n", num_1, oper, num_2, result));
            writer.flush();
        } catch (Exception e) {
            System.out.println("Получена ошибка доступа к лог-файлу");
        }
        myScanner.close();
    }
}

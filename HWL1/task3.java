package Homeworks.HWL1;
/*
 * Реализовать простой калькулятор (+ - / *)
 * Ввод числа ->
 * Ввод знака ->
 * Ввод числа ->
 */

import java.util.Scanner;

public class task3 { 
    
    public static void main(String[] args) {
        calculator();
    }

    static double operations(String oper, double num_1, double num_2){
        double res = 0;
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
        System.out.printf("Ваш результат: %.2f\n", operations(oper, num_1, num_2));
        myScanner.close();
        return;
    }
}
package Homeworks.HWL1;

/*
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! 
 * (произведение чисел от 1 до n)
 * Ввод:5
 * Треугольное число 1 + 2 + 3 + 4 + 5 = 15
 * n! 1 * 2 * 3 * 4 * 5 = 120
 */
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = myScanner.nextInt();
        System.out.printf("Треугольное число %s = %d\n", getSumString(n), getSum(n));
        System.out.printf("n! %s = %d\n", getFactorialString(n), getFactorial(n));
        myScanner.close();
    }

    static int getSum(int num) {
        if (num == 1)
            return 1;
        return getSum(num - 1) + num;
    }

    static String getSumString(int num) {
        if (num == 1)
            return "1";
        return getSumString(num - 1) + " + " + String.valueOf(num);
    }

    static int getFactorial(int num) {
        if (num == 1)
            return 1;
        return getFactorial(num - 1) * num;
    }

    static String getFactorialString(int num) {
        if (num == 1)
            return "1";
        return getFactorialString(num - 1) + " * " + String.valueOf(num);
    }
}

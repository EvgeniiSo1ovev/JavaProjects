package Homeworks.HWL2;

/*
 * Напишите метод, который принимает на вход строку (String) 
 * и определяет является ли строка палиндромом (возвращает boolean значение).
 */
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String myString = myScanner.nextLine();
        if (isPalindrom(myString)) {
            System.out.printf("Строка %s является палиндромом", myString);
        } else {
            System.out.printf("Строка %s не является палиндромом", myString);
        }
        myScanner.close();
    }

    static boolean isPalindrom(String myStr) {
        for (int i = 0; i < myStr.length() / 2; i++) {
            if (myStr.charAt(i) != myStr.charAt(myStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
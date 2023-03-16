package Homeworks.HWL1;
/*
 * (ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
 * Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
 * Требуется восстановить выражение до верного равенства.
 * Предложить хотя бы одно решение или сообщить, что его нет.
 * Ввод: 2? + ?5 = 69
 * Вывод: 24 + 45 = 69
 */

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите уравнение вида q + w = e, q, w, e >= 0.");
        System.out.println("Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69:");
        String equation = myScanner.nextLine();
        System.out.println(getDecision(equation));
        myScanner.close();
    }

    static String getDecision(String equation) {
        String result = "Нет решения уравнения";
        String[] myArrayStrings = equation.split(" ");
        int num_1;
        int num_2;
        for (int i = 0; i <= 9; i++) {
            num_1 = Integer.parseInt(myArrayStrings[0].replace("?", String.format("%d", i)));
            for (int j = 0; j <= 9; j++) {
                num_2 = Integer.parseInt(myArrayStrings[2].replace("?", String.format("%d", j)));
                if ((num_1 + num_2) == Integer.parseInt(myArrayStrings[4])) {
                    result = String.format("%d + % d = %s", num_1, num_2, myArrayStrings[4]);
                    return result;
                }
            }
        }
        return result;
    }
}

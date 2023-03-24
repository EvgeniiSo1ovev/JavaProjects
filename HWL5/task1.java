package Homeworks.HWL5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
2) Вывод всего
Пример:
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 1242353
К: Введите 1) Добавление номера
2) Вывод всего
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 547568
К: Введите 1) Добавление номера
2) Вывод всего
Я: 2
Иванов: 1242353, 547568 
*/
public class task1 {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, List<String>> dbMap = new HashMap<>();
        phoneBook(dbMap);
        myScanner.close();
    }

    static void phoneBook(Map<String, List<String>> dbMap) {
        System.out.println("Введите:\n1 - Добавление номера\n2 - Вывод всех данных с выходом");
        String oper = myScanner.next();
        if (oper.equals("1")) {
            addPhoneNumber(dbMap);
            phoneBook(dbMap);
        } else if (oper.equals("2")) {
            printData(dbMap);
        } else {
            System.out.println("Введено что-то отличное от 1 или 2. Исправьтесь!");
            phoneBook(dbMap);
        }
    }

    static void addPhoneNumber(Map<String, List<String>> dbMap) {
        System.out.print("Введите фамилию: ");
        String lastName = String.format(myScanner.next());
        List<String> phoneNumbers = new ArrayList<>();
        if (dbMap.containsKey(lastName))
            for (String item : dbMap.get(lastName))
                phoneNumbers.add(item);
        System.out.print("Введите номер: ");
        phoneNumbers.add(myScanner.next());
        dbMap.put(lastName, phoneNumbers);
        System.out.println("Номер добавлен в телефонную книгу");
    }

    static void printData(Map<String, List<String>> dbMap) {
        if (!dbMap.isEmpty()) {
            System.out.println("Содержимое телефонной книги:");
            for (Map.Entry<String, List<String>> item : dbMap.entrySet()) {
                System.out.printf("%s: %s\n", item.getKey(), String.join(", ", item.getValue()));
            }
        }
        System.out.println("Выход программы");
    }
}
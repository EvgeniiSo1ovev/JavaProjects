package Homeworks.HWL5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени. 
*/

public class task2 {

    public static void main(String[] args) {
        ArrayList<String> workers = new ArrayList<>(Arrays.asList("Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"));
        Map<String, Integer> freqNames = namesFrequency(workers);
        print(sortByValue(freqNames));
    }

    static ArrayList<String> getNames(ArrayList<String> myArrayList) {
        ArrayList<String> result = new ArrayList<>();
        int end;
        for (int i = 0; i < myArrayList.size(); i++) {
            end = myArrayList.get(i).indexOf(' ');
            result.add(myArrayList.get(i).substring(0, end));
        }
        return result;
    }

    static Map<String, Integer> namesFrequency(ArrayList<String> myArrayList) {
        ArrayList<String> namesList = getNames(myArrayList);
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < namesList.size(); i++) {
            if (!result.containsKey(namesList.get(i))) {
                result.put(namesList.get(i), Collections.frequency(namesList, namesList.get(i)));
            }
        }
        return result;
    }

    static Map<String, Integer> sortByValue(Map<String, Integer> myMap) {
        List<Entry<String, Integer>> myList = new ArrayList<>(myMap.entrySet());
        myList.sort(Entry.<String, Integer>comparingByValue().reversed());
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Entry<String, Integer> item : myList) {
            result.put(item.getKey(), item.getValue());
        }
        return result;
    }

    static void print(Map<String, Integer> myMap) {
        if (!myMap.isEmpty()) {
            for (Entry<String, Integer> item : myMap.entrySet()) {
                System.out.printf("%s: %d\n", item.getKey(), item.getValue());
            }
        }
    }
}

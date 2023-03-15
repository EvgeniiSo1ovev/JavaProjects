package Homeworks.HWL3;

import java.util.ArrayList;
import java.util.Random;

/*
 * Задан целочисленный список ArrayList. 
 * Найти минимальное, максимальное и среднее ариф. из этого списка.
 */
public class task3 {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = getArrayList(10);
        System.out.println(myArrayList);
        System.out.printf("Значение минимального элемента списка: %d\n", minValue(myArrayList));
        System.out.printf("Значение максимального элемента списка: %d\n", maxValue(myArrayList));
        System.out.printf("Значение среднего арифметического элементов списка: %.2f\n", arithMean(myArrayList));
    }

    static ArrayList<Integer> getArrayList(int len) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Random rand = new Random();
            myArrayList.add(rand.nextInt(100));
        }
        return myArrayList;
    }

    static int minValue(ArrayList<Integer> myArrayList) {
        int minVal = myArrayList.get(0);
        for (int item : myArrayList) {
            if (item < minVal) {
                minVal = item;
            }
        }
        return minVal;
    }

    static int maxValue(ArrayList<Integer> myArrayList) {
        int maxVal = myArrayList.get(0);
        for (int item : myArrayList) {
            if (item > maxVal) {
                maxVal = item;
            }
        }
        return maxVal;
    }

    static double arithMean(ArrayList<Integer> myArrayList) {
        double sum = 0;
        for (int item : myArrayList) {
            sum += item;
        }
        return sum / myArrayList.size();
    }
}

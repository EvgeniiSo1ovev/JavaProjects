package Homeworks.HWL3;

import java.util.ArrayList;
import java.util.Random;

/*
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 */
public class task2 {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = getArrayList(20);
        System.out.println(myArrayList);
        removeEven(myArrayList);
        System.out.println(myArrayList);
    }

    static ArrayList<Integer> getArrayList(int len) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Random rand = new Random();
            myArrayList.add(rand.nextInt(100));
        }
        return myArrayList;
    }

    static boolean isEven(int num){
        if ((num % 2) == 0){
            return true;
        }
        return false;
    }

    static void removeEven(ArrayList<Integer> myArrayList){
        for (int i = myArrayList.size()-1; i >= 0; i--){
            if (isEven(myArrayList.get(i))){
                myArrayList.remove(i);
            }
        }
    }
}

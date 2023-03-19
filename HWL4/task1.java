package Homeworks.HWL4;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/*
 * Пусть дан LinkedList с несколькими элементами. 
 * Реализуйте метод(не void), который вернет “перевернутый” список.
 */

public class task1 {
    public static void main(String[] args) {
        LinkedList<Integer> myLL = getList(5);
        System.out.println(myLL);
        LinkedList<Integer> myReversedLL = reverseList(myLL);
        System.out.println(myReversedLL);
    }

    static LinkedList<Integer> getList(int len) {
        LinkedList<Integer> myLL = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Random rand = new Random();
            myLL.add(rand.nextInt(100));
        }
        return myLL;
    }

    static LinkedList<Integer> reverseList(LinkedList<Integer> myLL) {
        LinkedList<Integer> tempLL = new LinkedList<>();
        ListIterator<Integer> myIterator = myLL.listIterator();
        while (myIterator.hasNext()) {
            tempLL.addFirst(myIterator.next());
        }
        return tempLL;
    }
}

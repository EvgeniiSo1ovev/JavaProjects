package Homeworks.HWL3;

import java.util.ArrayList;
import java.util.Random;

/*
 * (Дополнительное) Реализовать алгоритм сортировки слиянием
 */

public class task1 {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = getArrayList(10);
        System.out.println(myArrayList);
        mergeSort(myArrayList);
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

    static void mergeSort(ArrayList<Integer> myArrayList) {
        if (!myArrayList.isEmpty()) {
            ArrayList<Integer> tempArray = new ArrayList<>(myArrayList);
            mergeSortImpl(myArrayList, tempArray, 0, myArrayList.size() - 1);
        }
    }

    static void mergeSortImpl(ArrayList<Integer> myArrayList, ArrayList<Integer> tempArray, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortImpl(myArrayList, tempArray, l, m);
            mergeSortImpl(myArrayList, tempArray, m + 1, r);
            int k = l;
            int i = l;
            int j = m + 1;
            while (i <= m || j <= r) {
                if (j > r || (i <= m && myArrayList.get(i) < myArrayList.get(j))) {
                    tempArray.set(k, myArrayList.get(i));
                    i++;
                } else {
                    tempArray.set(k, myArrayList.get(j));
                    j++;
                }
                k++;
            }
            for (int n = l; n <= r; n++) {
                myArrayList.set(n, tempArray.get(n));
            }
        }
    }
}

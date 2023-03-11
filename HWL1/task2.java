package Homeworks.HWL1;
/*
 * Вывести все простые числа от 1 до 1000
 */

public class task2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++){
            if (isPrimeNumber(i)){
                System.out.println(i);
            }
        }
    }

    static boolean isPrimeNumber(int num){
        int count = 1;
        boolean result = true;
        for (int i = 2; i <= num; i++){
            if ((num % i) == 0){
                count++;
            }
            if (count > 2){
                result = false;
                break;
            }
        }
        return result;
    }
}

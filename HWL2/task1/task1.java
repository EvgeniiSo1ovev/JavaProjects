package Homeworks.HWL2.task1;

/*
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами), 
 * результат после каждой итерации запишите в лог-файл.
 */
import java.io.FileWriter;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        int[] myArray = { 9, 1, 5, 6, 2, 3, 7 };
        bubbleSort(myArray);
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write(Arrays.toString(arr)+"\n");
                writer.flush();
            } catch (Exception e) {
                System.out.println("Получена ошибка доступа к лог-файлу");
                break;
            }
        }
    }
}

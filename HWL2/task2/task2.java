package Homeworks.HWL2.task2;

/*
 * Дана строка (получение через обычный текстовый файл!!!)
 * "фамилия":"Иванов","оценка":"5","предмет":"Математика"
 * "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
 * Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
 * Студент [фамилия] получил [оценка] по предмету [предмет].
 * 
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class task2 {
    public static void main(String[] args) {
        getDataFile("file1.txt");
    }

    static void getDataFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                StringBuilder sb = new StringBuilder();
                String[] lines = line.split("\"");
                sb.append("Студент " + lines[3] + " получил " + lines[7] + " по предмету " + lines[11]);
                System.out.println(sb);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Получена ошибка доступа к лог-файлу");
        }
    }
}

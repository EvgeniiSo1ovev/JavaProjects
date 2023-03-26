package Homeworks.HWL6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        NoteBook notebook1 = new NoteBook("Lenovo", "IdeaPad 3 15ITL6", "L48JYB53298");
        notebook1.price = 43999;
        notebook1.volumeRAM = 8;
        notebook1.volumeHardDisc = 1000;
        notebook1.os = "NoOS";
        notebook1.color = "Black";
        NoteBook notebook2 = new NoteBook("HUAWEI", "53013PLV BoD-WDI9 MateBook D15", "H998KMKDF");
        notebook2.price = 39999;
        notebook2.volumeRAM = 8;
        notebook2.volumeHardDisc = 256;
        notebook2.os = "Windows 11";
        notebook2.color = "Black";
        NoteBook notebook3 = new NoteBook("ASUS", "M1702QA-AU081", "ASUS3458NJORI");
        notebook3.price = 64999;
        notebook3.volumeRAM = 16;
        notebook3.volumeHardDisc = 512;
        notebook3.os = "NoOS";
        notebook3.color = "Black";
        NoteBook notebook4 = new NoteBook("ACER", "A315-23 UN.HVTSI.023", "ACER56KKLIJS");
        notebook4.price = 35999;
        notebook4.volumeRAM = 8;
        notebook4.volumeHardDisc = 256;
        notebook4.os = "Windows 11";
        notebook4.color = "White";
        NoteBook notebook5 = new NoteBook("Lenovo", "IdeaPad 3 15ITL6", "L564hb6756");
        notebook5.price = 43999;
        notebook5.volumeRAM = 8;
        notebook5.volumeHardDisc = 1000;
        notebook5.os = "NoOS";
        notebook5.color = "Black";
        ProductList noteBookSet = new ProductList();
        noteBookSet.add(notebook1);
        noteBookSet.add(notebook2);
        noteBookSet.add(notebook3);
        noteBookSet.add(notebook4);
        noteBookSet.add(notebook5);
        System.out.println(noteBookSet.toString());
        System.out.println("Приветствую на виртуальном складе магазина техники");
        ProductList FiltredList = new ProductList(noteBookSet, setFilterParam());
        System.out.println(FiltredList.toString());
    }

    static Map<String, String> setFilterParam() {
        Map<String, String> filterParam = new HashMap<>();
        System.out.println("Примените фильтр для поиска необходимого ноутбука.");
        return setFilterParam(filterParam);
    }

    static Map<String, String> setFilterParam(Map<String, String> filterParam) {
        System.out.print(
                "Введите цифру, соответствующую необходимому критерию:\n1 - ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n4 - Цвет\n");
        String criteria = myScanner.next();
        switch (criteria) {
            case "1":
                System.out.print("Введите минимальное значение для ОЗУ:\n");
                filterParam.put("VRAM", myScanner.next());
                break;
            case "2":
                System.out.print("Введите минимальное значение для объема ЖД:\n");
                filterParam.put("VHD", myScanner.next());
                break;
            case "3":
                System.out.print("Введите необходимую операционную систему:\n");
                myScanner.nextLine();
                filterParam.put("OS", myScanner.nextLine());
                break;
            case "4":
                System.out.print("Введите цвет:\n");
                filterParam.put("Color", myScanner.next());
                break;
            default:
                System.out.println("Введено что-то отличное от указанных номеров критерий!");
                return setFilterParam(filterParam);
        }
        System.out.print("Для выхода из меню настройки фильтра введите q или для продолжения введите любой символ: ");
        if (myScanner.next().equals("q"))
            return filterParam;
        return setFilterParam(filterParam);
    }
}
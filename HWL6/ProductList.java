package Homeworks.HWL6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ProductList {
    private Map<NoteBook, ArrayList<String>> productList;
    private Map<String, String> filterParam;

    public ProductList() {
        this.productList = new LinkedHashMap<>();
        this.filterParam = new HashMap<>();
        this.filterParam.put("VRAM", "0");
        this.filterParam.put("VHD", "0");
        this.filterParam.put("OS", "All");
        this.filterParam.put("Color", "All");
    }

    public ProductList(ProductList noteBookSet, Map<String, String> filterParam) {
        this.productList = new LinkedHashMap<>();
        this.filterParam = new HashMap<>();
        if (filterParam.containsKey("VRAM")) {
            this.filterParam.put("VRAM", filterParam.get("VRAM"));
        } else {
            this.filterParam.put("VRAM", "0");
        }
        if (filterParam.containsKey("VHD")) {
            this.filterParam.put("VHD", filterParam.get("VHD"));
        } else {
            this.filterParam.put("VHD", "0");
        }
        if (filterParam.containsKey("OS")) {
            this.filterParam.put("OS", filterParam.get("OS"));
        } else {
            this.filterParam.put("OS", "All");
        }
        if (filterParam.containsKey("Color")) {
            this.filterParam.put("Color", filterParam.get("Color"));
        } else {
            this.filterParam.put("Color", "All");
        }
        int minVRAM = Integer.valueOf(this.filterParam.get("VRAM"));
        int minVHD = Integer.valueOf(this.filterParam.get("VHD"));
        String oneOS = this.filterParam.get("OS");
        String oneColor = this.filterParam.get("Color");
        for (Entry<NoteBook, ArrayList<String>> item : noteBookSet.productList.entrySet()) {
            if (item.getKey().volumeRAM >= minVRAM && item.getKey().volumeHardDisc >= minVHD
                    && (oneOS == "All" || item.getKey().os.equals(oneOS))
                    && (oneColor == "All" || item.getKey().color.equals(oneColor))) {
                this.productList.put(item.getKey(), item.getValue());
            }
        }
    }

    public void add(NoteBook notebook) {
        ArrayList<String> serialNumbersList = new ArrayList<>();
        String errorMsg = "";
        if (this.productList.containsKey((NoteBook) notebook)) {
            serialNumbersList = (ArrayList<String>) this.productList.get(notebook).clone();
            errorMsg = "Ошибка добавления аналогичного ноутбука в список";
        } else {
            errorMsg = "Ошибка добавления ноутбука в список";
        }
        if (serialNumbersList.add(notebook.serialNumber)) {
            this.productList.put(notebook, serialNumbersList);
        } else {
            System.out.println(errorMsg);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(
                "Параметры фильтра: \nМин. ОЗУ: %s\nМин. объем ЖД: %s\nОперационная система: %s\nЦвет: %s\n",
                this.filterParam.get("VRAM"), this.filterParam.get("VHD"), this.filterParam.get("OS"),
                this.filterParam.get("Color")));
        result.append("---------------------------------------\n");
        if (!this.productList.isEmpty()) {
            for (Entry<NoteBook, ArrayList<String>> item : this.productList.entrySet()) {
                result.append(item.getKey().toString());
                result.append(String.format("Количество на складе: %d шт.\n", item.getValue().size()));
                result.append("---------------------------------------\n");
            }
        } else {
            result.append("Пусто, ничего нет!");
        }
        return result.toString();
    }
}

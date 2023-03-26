package Homeworks.HWL6;

public class NoteBook {
    private String brand;
    private String model;
    protected String serialNumber;
    int price;
    int volumeRAM;
    int volumeHardDisc;
    String os;
    String color;

    public NoteBook(String brand, String model, String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public boolean equals(Object o) {
        NoteBook t = (NoteBook) o;
        return this.brand == t.brand && this.model == t.model && this.volumeHardDisc == t.volumeHardDisc
                && this.volumeRAM == t.volumeRAM && this.os == t.os;
    }

    public int hashCode() {
        return this.brand.hashCode() + this.model.hashCode() + this.volumeHardDisc + this.volumeRAM
                + this.os.hashCode();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s %s\n", this.brand, this.model));
        result.append(String.format("Цена = %d\n", this.price));
        result.append(String.format("Характеристики:\nОЗУ : %d\nОбъем ЖД : %d\n", this.volumeRAM, this.volumeHardDisc));
        result.append(String.format("Операционная система : %s\nЦвет : %s\n", this.os, this.color));
        return result.toString();
    }
}
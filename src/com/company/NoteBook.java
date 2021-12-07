package com.company;

public class NoteBook {
    private int cost;
    private int ram;
    private String manufacturer;
    private int numberModel;


    public NoteBook() {
    }

    public NoteBook(int cost, int ram, String manufacturer, int numberModel) {
        this.cost = cost;
        this.ram = ram;
        this.manufacturer = manufacturer;
        this.numberModel = numberModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRam() {
        return ram;
    }

    public int getCost() {
        return cost;
    }

    public int getNumberModel() {
        return numberModel;
    }

    public void print(NoteBook note) {
        System.out.println(note.cost + " " + note.ram + " " + note.getManufacturer());
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        NoteBook noteBook1 = new NoteBook(500, 4, "Lenuvo", 1);
        NoteBook noteBook2 = new NoteBook(1000, 4, "Lenuvo", 1);
        NoteBook noteBook3 = new NoteBook(1500, 4, "Lenuvo", 1);
        NoteBook noteBook4 = new NoteBook(2000, 8, "Lenuvo", 1);
        NoteBook noteBook5 = new NoteBook(500, 8, "Lenuvo", 1);
        NoteBook noteBook6 = new NoteBook(500, 8, "Asos ", 2);
        NoteBook noteBook7 = new NoteBook(1500, 24, "Eser", 4);
        NoteBook noteBook8 = new NoteBook(2000, 4, "Xamiou", 5);
        NoteBook noteBook9 = new NoteBook(1500, 4, "MacNote", 3);

        NoteBook[] arrNoteBook = {noteBook1, noteBook2, noteBook3, noteBook4, noteBook5, noteBook6, noteBook7,
                noteBook8, noteBook9};

        for( NoteBook n : arrNoteBook){
            n.print(n);
        }
        for (int i = 0; i < arrNoteBook.length - 1; i++) {
            for (int j = i + 1; j < arrNoteBook.length; j++) {
                if (arrNoteBook[i].getCost() > arrNoteBook[j].getCost()) {
                    extracted(arrNoteBook, i, j);
                } else if (arrNoteBook[i].getCost() == arrNoteBook[j].getCost()) {
                    if (arrNoteBook[i].getRam() > arrNoteBook[j].getRam()) {
                        extracted(arrNoteBook, i, j);
                    } else if (arrNoteBook[i].getRam() == arrNoteBook[j].getRam()) {
                        if (arrNoteBook[i].getNumberModel() > arrNoteBook[j].getNumberModel()) {
                            extracted(arrNoteBook, i, j);
                        }
                    }
                }
            }
        }

        System.out.println("sorted");
        for( NoteBook n : arrNoteBook){
            n.print(n);
        }
    }

    private static void extracted(NoteBook[] arrNoteBook, int i, int j) {
        NoteBook t = arrNoteBook[i];
        arrNoteBook[i] = arrNoteBook[j];
        arrNoteBook[j] = t;
    }
}

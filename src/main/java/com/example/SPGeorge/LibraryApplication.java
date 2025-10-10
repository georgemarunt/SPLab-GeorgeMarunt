package com.example.SPGeorge;

import com.example.SPGeorge.entity.*;

public class LibraryApplication {
    public static void main(String[] args) {

        Book firstBook = new Book(8L, "Cer senin");

        Author cristianSomber= new Author(6L, "Cristian Somber");
        cristianSomber.addBook(firstBook);
        firstBook.addAuthor(cristianSomber);

        Chapter capitolUnu = new Chapter(12L, "Amurg");
        SubChapter subUnu = new SubChapter(13L, "Amurg.1");
        SubChapter subUnuUnu = new SubChapter(14L, "Amurg.1.1");
        SubChapter subUnuUnuUnu = new SubChapter(15L, "Amurg.1.1.1");

        capitolUnu.addSubChapter(subUnu);
        subUnu.addSubChapter(subUnuUnu);
        subUnuUnu.addSubChapter(subUnuUnuUnu);
        firstBook.addChapter(capitolUnu);

        System.out.println("Book: " + firstBook.getTitle());
        System.out.println("Authors:");
        for (Author a : firstBook.getAuthors()) {
            System.out.println(" - " + a.getName());
        }

        System.out.println("Chapters:");
        for (Chapter c : firstBook.getChapters()) {
            System.out.println("  * " + c.getName());
            for (SubChapter sc : c.getSubChapters()) {
                System.out.println("    - " + sc.getName());
            }
        }
    }
}
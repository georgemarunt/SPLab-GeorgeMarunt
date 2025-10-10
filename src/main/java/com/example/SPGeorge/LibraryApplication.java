package com.example.SPGeorge;

import com.example.SPGeorge.entity.*;

public class LibraryApplication {
    public static void main(String[] args) {
        Book book = new Book(8L, "Cer senin");

        Author author = new Author(6L, "Cristian", "Somber");
        author.addBook(book);
        book.addAuthor(author);

        Section cap1   = new Section("Capitolul 1");
        Section cap11  = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");

        book.addContent(new Paragraph("Mulțumesc celor care ..."));
        book.addContent(new TableOfContents("Cuprins auto-generat"));
        book.addContent(cap1);

        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);

        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);

        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(new Image("image://subchapter-1-1-1"));
        cap111.add(new TableEntity("Tabel exemplu 1.1.1"));

        book.print();
    }
}
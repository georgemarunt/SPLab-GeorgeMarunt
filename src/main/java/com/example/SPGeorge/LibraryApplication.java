package com.example.SPGeorge;

import com.example.SPGeorge.entity.*;
import com.example.SPGeorge.helper.strategy.RenderContext;
import com.example.SPGeorge.helper.strategy.AlignLeft;
import com.example.SPGeorge.helper.strategy.AlignCenter;
import com.example.SPGeorge.helper.strategy.AlignRight;

public class LibraryApplication {
    public static void main(String[] args) {
        RenderContext ctx = RenderContext.builder()
                .width(50)
                .indent("")
                .build();

        Book book = new Book(8L, "Cer senin");

        Author author = new Author(6L, "Cristian", "Somber");
        author.addBook(book);
        book.addAuthor(author);

        Section cap1   = new Section("Capitolul 1");
        Section cap11  = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");

        Paragraph pIntro = new Paragraph("Mulțumesc celor care ...");
        pIntro.setTextAlignment(new AlignLeft());

        Paragraph pMoto = new Paragraph("Moto capitol");
        pMoto.setTextAlignment(new AlignCenter());

        Paragraph p11 = new Paragraph("Text from subchapter 1.1");
        p11.setTextAlignment(new AlignLeft());

        Paragraph p111 = new Paragraph("Text from subchapter 1.1.1");
        p111.setTextAlignment(new AlignRight());

        book.addContent(pIntro);
        book.addContent(new TableOfContents("Cuprins auto-generat"));
        book.addContent(cap1);

        cap1.add(pMoto);
        cap1.add(cap11);

        cap11.add(p11);
        cap11.add(cap111);

        cap111.add(p111);
        cap111.add(new Image("image://subchapter-1-1-1"));
        cap111.add(new TableEntity("Tabel exemplu 1.1.1"));

        book.print(ctx);
    }
}
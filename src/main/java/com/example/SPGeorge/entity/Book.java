package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;

    private final TableOfContents tableOfContents= new TableOfContents("Cuprins auto-generat");
    private final List<Author> authors = new ArrayList<>();
    private final List<Element> elements = new ArrayList<>();

    public void addAuthor(Author author) { authors.add(author); }
    public void addContent(Element e) { elements.add(e); }
    public void removeContent(Element e) { elements.remove(e); }
    public Element getContent(int index) { return elements.get(index); }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            System.out.print("  - ");
            a.print();
        }
        System.out.println("Contents:");
        for (Element e : elements) {
            e.print("  ");
        }
    }
}
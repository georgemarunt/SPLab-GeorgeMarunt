package com.example.SPGeorge.entity;

import com.example.SPGeorge.helper.strategy.RenderContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;

    private final TableOfContents tableOfContents = new TableOfContents("Cuprins auto-generat");
    private final List<Author> authors = new ArrayList<>();
    private final List<Element> elements = new ArrayList<>();

    public void addAuthor(Author author) { authors.add(author); }
    public void addContent(Element e) { elements.add(e); }
    public void removeContent(Element e) { elements.remove(e); }
    public Element getContent(int index) { return elements.get(index); }

    public void print(RenderContext context) {
        context.println("Book: " + title);
        context.println("Authors:");
        RenderContext authorCtx = context.withIndent("  ");
        for (Author a : authors) {
            authorCtx.println("- " + a.getName() + " " + a.getSurname());
        }

        context.println("Contents:");
        RenderContext childCtx = context.withIndent("  ");
        for (Element e : elements) {
            e.print(childCtx);
        }
    }
}
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

    private final TableOfContents tableOfContents= new TableOfContents(id);
    private final List<Author> authors = new ArrayList<>();
    private final List<Chapter> chapters = new ArrayList<>();

    public void addAuthor(Author author) { authors.add(author); }
    public void addChapter(Chapter chapter) { chapters.add(chapter); }
}
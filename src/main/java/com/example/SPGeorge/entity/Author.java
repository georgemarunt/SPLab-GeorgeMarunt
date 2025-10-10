package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Author {
    private Long id;
    private String name;

    private final List<Book> books = new ArrayList<>();
    public void addBook(Book book) { books.add(book); }
}
package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Author {
    private Long id;
    private String name;
    private List<Book> books = new ArrayList<>();
    public Author(long l, String name) {
    }
}
package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Chapter {
    private Long id;
    private String name;

    private final List<SubChapter> subChapters = new ArrayList<>();

    public void addSubChapter(SubChapter subChapter) { subChapters.add(subChapter); }
}
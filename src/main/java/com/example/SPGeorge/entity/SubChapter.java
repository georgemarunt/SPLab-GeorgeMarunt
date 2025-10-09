package com.example.SPGeorge.entity;

import com.example.SPGeorge.entity.Image;
import com.example.SPGeorge.entity.Paragraph;
import com.example.SPGeorge.entity.TableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SubChapter {
    private Long id;
    private String name;
    private final List<Paragraph> paragraphs = new ArrayList<>();
    private final List<Image> images = new ArrayList<>();
    private final List<TableEntity> tables = new ArrayList<>();
    private final List<SubChapter> subChapters = new ArrayList<>();

    public void addParagraph(Paragraph paragraph) { paragraphs.add(paragraph); }
    public void addImage(Image image) { images.add(image); }
    public void addTable(TableEntity table) { tables.add(table); }
    public void addSubChapter(SubChapter subChapter) { subChapters.add(subChapter); }
}
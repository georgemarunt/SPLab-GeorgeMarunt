package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Section implements Element {
    private String title;
    private final List<Element> children = new ArrayList<>();

    @Override
    public void add(Element e) { children.add(e); }

    @Override
    public void remove(Element e) { children.remove(e); }

    @Override
    public Element get(int index) { return children.get(index); }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Section: " + title);
        String childIndent = indent + "  ";
        for (Element e : children) {
            e.print(childIndent);
        }
    }
}
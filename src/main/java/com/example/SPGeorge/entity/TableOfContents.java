package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@AllArgsConstructor
public class TableOfContents implements Element{
    private String content;

    @Override
    public void print(String indent) {
        System.out.print(indent + "TableOfContents " + content + "\n");
    }
}
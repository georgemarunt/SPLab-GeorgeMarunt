package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Paragraph implements Element{
    private String text;

    @Override
    public void print(String indent) {

    }
}
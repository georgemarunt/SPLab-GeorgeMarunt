package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Paragraph implements Element{
    private Long id;
    private String text;

    @Override
    public void print() {

    }
}
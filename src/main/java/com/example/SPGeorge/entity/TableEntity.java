package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableEntity implements Element {
    private Long id;
    private String title;

    @Override
    public void print() {

    }
}
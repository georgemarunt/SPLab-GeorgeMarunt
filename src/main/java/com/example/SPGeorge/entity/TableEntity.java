package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableEntity implements Element {
    private String description;

    @Override
    public void print(String indent) {

    }
}
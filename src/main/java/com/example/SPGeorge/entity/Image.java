package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Image implements Element {
    private Long id;
    private String imageName;

    @Override
    public void print() {
    }
}
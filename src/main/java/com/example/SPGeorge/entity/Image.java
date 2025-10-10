package com.example.SPGeorge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Image implements Element {
    private String url;

    @Override
    public void print(String indent) {
        System.out.println(indent + "Image: " + url);
    }
}
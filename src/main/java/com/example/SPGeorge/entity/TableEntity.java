package com.example.SPGeorge.entity;

import com.example.SPGeorge.helper.strategy.RenderContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableEntity implements Element {
    private String description;

    @Override
    public void print(RenderContext renderContext) {

    }
}
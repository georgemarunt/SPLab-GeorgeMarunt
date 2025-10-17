package com.example.SPGeorge.helper.strategy;

import com.example.SPGeorge.entity.Paragraph;

public interface AlignStrategy {
    void render(Paragraph paragraph, RenderContext renderContext);
}
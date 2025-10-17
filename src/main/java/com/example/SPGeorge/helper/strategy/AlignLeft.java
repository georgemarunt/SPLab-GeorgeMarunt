package com.example.SPGeorge.helper.strategy;

import com.example.SPGeorge.entity.Paragraph;

public class AlignLeft implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, RenderContext renderContext) {
        renderContext.println(paragraph.getText());
    }
}

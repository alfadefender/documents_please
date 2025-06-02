package com.github.documents_please.documents;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class DocumentText {
    private String text;
    private Label label;
    private LabelStyle style;
    private float x;
    private float y;

    public DocumentText(String text, LabelStyle style, float x, float y) {
        this.text = text;
        this.style = style;
        this.label = new Label(text, style);
        this.label.setPosition(x, y);
        this.x = x;
        this.y = y;
    }

    public void render(Batch batch, float parentAlpha) {
        label.draw(batch, parentAlpha);
    }

    public void setText(String text) {
        this.text = text;
        this.label = new Label(text, style);
        this.label.setPosition(x, y);
    }
}

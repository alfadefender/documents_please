package com.github.documents_please.documents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Document extends Actor {
    protected Texture documentTextureIcon;
    protected Texture documentTexture;

    protected float x;
    protected float y;
    protected float xI;
    protected float yI;
    protected float width;
    protected float height;

    protected boolean isExtended;

    public Document(Texture textureIcon, Texture texture, float xI, float yI, float x, float y) {
        super();
        documentTextureIcon = textureIcon;
        documentTexture = texture;
        isExtended = false;
        this.x = x;
        this.y = y;
        this.xI = xI;
        this.yI = yI;
        width = documentTexture.getWidth();
        height = documentTexture.getHeight();
        this.setSize(100, 100);
        this.setPosition(xI, yI);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                extendDocument();
            }
        });
    }

    protected void extendDocument() {
        isExtended = !isExtended;
        if (isExtended) {
            this.setSize(width, height);
            this.setPosition(x, y);
        }
        else {
            this.setSize(100, 100);
            this.setPosition(xI, yI);
        }
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (isExtended) batch.draw(documentTexture, x, y);
        else batch.draw(documentTextureIcon, xI, yI, 100, 100);
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

package com.github.documents_please.documents;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class DocumentImage {
    private AtlasRegion atlasTexture;
    private Texture texture;
    private float x;
    private float y;
    private float width;
    private float height;

    public DocumentImage(AtlasRegion atlasTexture, float x, float y, float width, float height) {
        this.atlasTexture = atlasTexture;
        texture = null;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public DocumentImage(Texture texture, float x, float y, float width, float height) {
        this.texture = texture;
        this.atlasTexture = null;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(Batch batch) {
        if (texture != null) batch.draw(texture, x, y, width, height);
        else batch.draw(atlasTexture, x, y, width, height);
    }
}

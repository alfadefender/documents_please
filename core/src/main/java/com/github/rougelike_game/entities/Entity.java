package com.github.rougelike_game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    protected final Vector2 position = new Vector2();
    protected final Texture texture;
    protected final Vector2 textureSize = new Vector2();
    protected final float moveSpeed = 2;

    public Entity(float x, float y, String textureName) {
        position.set(x, y);
        texture = new Texture(textureName);
        textureSize.set(texture.getWidth(),texture.getHeight());
    }

    public void render(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }

    public void moveTo(Vector2 direction) {
        position.add(direction.setLength(moveSpeed));
    }

    public boolean collidepoint(Vector2 position){
        return ((this.position.x <= position.x) && ( position.x <= this.position.x + this.textureSize.x) && (this.position.y <= position.y) && ( position.y <= this.position.y + this.textureSize.y));
    }
}

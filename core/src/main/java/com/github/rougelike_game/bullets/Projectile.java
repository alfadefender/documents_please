package com.github.rougelike_game.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    protected final Vector2 position = new Vector2();
    protected final Vector2 direction = new Vector2();
    protected final Texture bulletTexture;
    protected final Vector2 textureSize = new Vector2();
    protected float speed;

    protected Projectile(Vector2 position, Vector2 direction, String textureName) {
        this.position.set(position);
        this.direction.set(direction);
        bulletTexture = new Texture(textureName);
        this.textureSize.set(bulletTexture.getWidth() / 2, bulletTexture.getHeight() / 2);
        this.speed = 1f;
        this.direction.setLength(this.speed);
    }

    public void move() {
        position.add(direction);
    }

    public void render(Batch batch) {
    }

    public void dispose() {
    }

    public boolean isOnScreen(int width, int height) {
        return (position.x + textureSize.x < width) && (position.y + textureSize.y < height) && (position.x + textureSize.x > 0) && (position.y + textureSize.y > 0);
    }

    public Vector2 getPositionOnScreen() {
        return new Vector2(position.x + textureSize.x, position.y + textureSize.y);
    }
}

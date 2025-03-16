package com.github.rougelike_game.bullets;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    protected final Vector2 position = new Vector2();
    protected final Vector2 direction = new Vector2();
    protected float speed;

    protected Projectile(Vector2 position, Vector2 direction) {
        this.position.set(position);
        this.direction.set(direction);
        this.speed = 0.5f;
        this.direction.setLength(this.speed);
    }

    public void move() {
        position.add(direction);
    }

    public void render(Batch batch) {}

    public void dispose() {}

    public boolean isOnScreen(int width, int height) {
        return (position.x < width) && (position.y < height) && (position.x > 0) && (position.y > 0);
    }
}

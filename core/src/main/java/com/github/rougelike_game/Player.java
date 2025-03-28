package com.github.rougelike_game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private final Vector2 position = new Vector2();
    private final Texture texture;
    private final Vector2 center = new Vector2();
    private final Vector2 angle = new Vector2();
    private final float moveSpeed = 2;

    public Player(float x, float y) {
        texture = new Texture("player.png");
        center.set(texture.getWidth() / 2 + x, texture.getHeight() / 2 + y);
        position.set(x, y);
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

    public void rotateTo(Vector2 direction) {
        angle.set(direction).sub(position);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getCenter() {
        center.set(texture.getWidth() / 2 + position.x, texture.getHeight() / 2 + position.y);
        return center;
    }
}

package com.github.rougelike_game.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class CommonBullet extends Projectile {
    private final Texture bulletTexture;

    public CommonBullet(Vector2 position, Vector2 direction, String textureName) {
        super(position, direction);
        bulletTexture = new Texture(textureName);
    }

    public void render(Batch batch) {
        batch.draw(bulletTexture, position.x, position.y);
    }

    public void dispose() {
        bulletTexture.dispose();
    }

}

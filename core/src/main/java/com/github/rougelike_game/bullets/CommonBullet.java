package com.github.rougelike_game.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class CommonBullet extends Projectile {

    public CommonBullet(Vector2 position, Vector2 direction, String textureName) {
        super(position, direction, textureName);
        this.position.sub(textureSize);
        speed = 3.0f;
        this.direction.setLength(speed);
    }

    public void render(Batch batch) {
        batch.draw(bulletTexture, position.x, position.y);
    }

    public void dispose() {
        bulletTexture.dispose();
    }

}

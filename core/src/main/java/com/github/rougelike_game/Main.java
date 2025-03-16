package com.github.rougelike_game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.github.rougelike_game.bullets.CommonBullet;
import com.github.rougelike_game.bullets.Projectile;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;

    private Player player;
    private KeyboardAdapter inputProcessor = new KeyboardAdapter();
    private Array<Projectile> all_bullets;
    private boolean bulletFlag = true;

    public void playerBehaivor() {
        player.moveTo(inputProcessor.getDirection());
        var mousePosition = inputProcessor.getMousePosition();
        player.rotateTo(mousePosition);
        if (inputProcessor.isLeftMouseButtonPressed()) {
            if (bulletFlag) {
                System.out.println("Left MB is pressed");
                all_bullets.add(new CommonBullet(player.getPosition(), mousePosition.sub(player.getPosition()), "common_bullet.png"));
                bulletFlag = false;
            }
        }
        else {
            bulletFlag = true;
        }
    }

    public void bulletsBehaivor() {
        for (Projectile bullet : all_bullets) {
            bullet.move();
            if (!bullet.isOnScreen(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())) {
                all_bullets.removeValue(bullet, true);
                continue;
            }
            bullet.render(batch);
        }
    }

    @Override
    public void create() {
        all_bullets = new Array<>();
        player = new Player(100, 100);
        Gdx.input.setInputProcessor(inputProcessor);
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        playerBehaivor();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();

        player.render(batch);
        bulletsBehaivor();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
    }
}

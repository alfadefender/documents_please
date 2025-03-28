package com.github.rougelike_game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.github.rougelike_game.bullets.CommonBullet;
import com.github.rougelike_game.bullets.Projectile;
import com.github.rougelike_game.entities.Enemy;
import com.github.rougelike_game.entities.Entity;
import com.github.rougelike_game.entities.NPC;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;

    private Player player;
    private KeyboardAdapter inputProcessor = new KeyboardAdapter();
    private Array<Projectile> all_bullets;
    private Array<Entity> entities;
    private boolean bulletFlag = true;

    public void playerBehaivor() {
        player.moveTo(inputProcessor.getDirection());
        var mousePosition = inputProcessor.getMousePosition();
        player.rotateTo(mousePosition);
        if (inputProcessor.isLeftMouseButtonPressed()) {
            if (bulletFlag) {
                System.out.println("Left MB is pressed");
                Vector2 bulletDirection = new Vector2(mousePosition);
                Vector2 bulletPosition = new Vector2(player.getCenter());

                bulletDirection.sub(bulletPosition);


                System.out.println("mouse pos = " + mousePosition);
                System.out.println("bullet start pos = " + bulletPosition);
                System.out.println("bullet direction = " + bulletDirection);

                all_bullets.add(new CommonBullet(bulletPosition, bulletDirection, "common_bullet.png"));
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
            for (Entity entity : entities) {
                if (entity.collidepoint(bullet.getPositionOnScreen())){
                    all_bullets.removeValue(bullet, true);
                    if (entity instanceof Enemy)
                        entities.removeValue(entity, true);
                }

            }
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
        entities = new Array<>();
        entities.add(new Enemy(300,300,"enemy-zloy.png"));
        entities.add(new NPC(700,400,"npc-dobryak.png"));
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

        entities.forEach(e -> e.render(batch));

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        entities.forEach(e -> e.dispose());
    }
}

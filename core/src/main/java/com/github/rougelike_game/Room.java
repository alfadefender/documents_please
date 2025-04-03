package com.github.rougelike_game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.github.rougelike_game.bullets.Projectile;
import com.github.rougelike_game.entities.Entity;

import java.util.List;

public class Room {

    private Array<Projectile> allProjectiles;
    private Array<Entity> allEntities;
    private Array<Object> allObjects;

    private Texture background;
    private List<Integer> nextRooms;

    public Room(int seed) {

    }

    public void render(Batch batch) {

    }

    public void dispose() {

    }

}

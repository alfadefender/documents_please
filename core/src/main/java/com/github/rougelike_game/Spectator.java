package com.github.rougelike_game;

import com.badlogic.gdx.utils.Array;
import com.github.rougelike_game.entities.Entity;


/*
Spectator:
    -> generate new Room by seed
    -> generate Room's entities
    -> generate type and count of rewards
    -> manage to spawn some special location
*/


public class Spectator {

    private int pointsToSpawn;

    public Spectator() {

    }

    private Array<Entity> generateEntities() {
        return new Array<>();
    }

    private int generateSeed() {
        return 0;
    }

    public void generateRoom(int seed) {

    }

}

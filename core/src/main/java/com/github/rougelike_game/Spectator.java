package com.github.rougelike_game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.github.rougelike_game.entities.Entity;


/*
Spectator:
    -> generate new Room by seed
    -> generate Room's entities
    -> generate type and count of rewards
    -> manage to spawn some special location

    seed = long: * | * | * | * * * * * * * * * * | * * * * * *
    1 - (1-4) difficulty
    2 - (0-9) type of room
    3 - (0-3) type of location
    4-13 - (0-9) count of entities, T10 -> T1
    14-19 - reserved

    хотелось бы иметь игрока в этом классе и прокидывать его в каждую новую комнату, дабы не пересоздавать его
    и иметь возможность описать его поведение
    поведение Entity можно оставить на их же класс в условном методе .behaivor(), который будет у каждого экземпляра
    взаимодействие и проверку коллизий предполагаю оставить на Room и его методы, тк там буквально все есть для этих
    проверок, но возможны проблемы с коллизиями (хотя если мы прокидываем игрока в комнату, то он определенно там есть)

    возможно часть ответственности можно перекинуть на иной класс, но пока что не могу представить его функционал

*/


public class Spectator {

    private final int maxLocations = 3;

    private int pointsToSpawn;
    private long seed;
    private Room currentRoom;
    private int currentLocation;

    public Spectator() {
        pointsToSpawn = 5;
        currentLocation = 0;
        generateNewSeed();
        generateNextRoom(seed);
    }

    // для остановки игрового процесса, например для паузы игры или открытия диалоговых окон
    public void pause() {

    }

    // возвращение к игровому процессу
    public void unpause() {

    }

    public void changeLocation() {
        currentLocation = (currentLocation + 1) % maxLocations;
    }

    public void generateNextRoom(long seed) { // нужны ли параметры
        currentRoom.dispose();
        // ????
        currentRoom = new Room(seed);
    }

    // generate seed from room door
    private void generateNewSeed() {
        seed = 1000000000000000000L;
    }

    private void prerenderRooms(int countDoors) {

    }

    // TODO
    public void render(Batch batch) {

    }

    // TODO
    public void dispose() {

    }

    // TODO func(current stage) ???????????????
    private void changePoints() {
        pointsToSpawn = pointsToSpawn + 1;
    }

}

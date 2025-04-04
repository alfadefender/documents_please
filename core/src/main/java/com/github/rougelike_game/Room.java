package com.github.rougelike_game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.github.rougelike_game.bullets.Projectile;
import com.github.rougelike_game.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Array<Projectile> allProjectiles;
    private Array<Entity> allEntities;
    private Array<Object> allObjects;

    private Texture background;
    private List<Integer> nextRooms;
    private int difficulty;
    private int typeOfRoom;
    private int locationType;

    public Room(long seed) {
        long tempSeed = seed / 1000000;
        long entities = tempSeed % 10000000000L;
        tempSeed /= 10000000000L;

        locationType = (int)(tempSeed % 10);
        tempSeed /= 10;

        typeOfRoom = (int)(tempSeed % 10);
        tempSeed /= 10;

        difficulty = (int)(tempSeed % 10);
        tempSeed /= 10;

        // TODO logic of creation all attributes of Room

        // распарсить <entities> и заполнить массив <allEntities> в соответствии с этим числом
        // либо же передать это число в <generateEntities> в качестве аргумента и пусть оно само там как-нибудь
    }

    private Array<Entity> generateEntities() {
        // если она нужна, то только вместе с передачей числа, отвечающего за кол-во противников
        return new Array<>();
    }

    public void render(Batch batch) {
        // рендер бг-шки, а также всех остальных ее обитателей и предметов
    }

    public void dispose() {
        // освобождение ресурсов бг-шки и всего что осталось в комнате
        // хорошая тема на подумать - а нужно ли нам каждый раз иметь этот метод и у каждого объекта свою текстуру
        // или же иметь в мейн-е все картинки и просто передавать их по ссылке и в мейн-е их освобождать единожды
    }

    public void start() {
        // начало уровня - типа бой с противниками
    }

    public void end() {
        // конец уровня - вызывается с условиями окончания и предполагается для получения наград, возможных покупок и тд
    }

}

package com.github.rougelike_game.entities;

import com.badlogic.gdx.math.Vector2;


public class Enemy extends Entity{
    public Enemy(float x, float y, String textureName){
        super(x,y,textureName);
    }

    @Override
    public boolean collidepoint(Vector2 position){
        return ((this.position.x <= position.x) && ( position.x <= this.position.x + this.textureSize.x) && (this.position.y <= position.y) && ( position.y <= this.position.y + this.textureSize.y));
    }
}

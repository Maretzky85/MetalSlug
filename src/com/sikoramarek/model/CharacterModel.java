package com.sikoramarek.model;

import com.sikoramarek.common.CharacterType;
import com.sikoramarek.common.PlayerAction;

public class CharacterModel {

    private int VELOCITY = 10;

    public int x_pos;

    public int y_pos;

    public PlayerAction action;

    public CharacterType type;

    public String skin_type;

    public CharacterModel(int x_pos, int y_pos){
        action = PlayerAction.STANDING;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public void setX_pos(int x_pos){
        if(x_pos != this.x_pos){
            action = PlayerAction.RUNNING;
        }else {
            action = PlayerAction.STANDING;
        }

        this.x_pos = x_pos;
    }

    public void setY_pos(int y_pos){
        this.y_pos = y_pos;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
}

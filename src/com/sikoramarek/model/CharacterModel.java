package com.sikoramarek.model;

public class CharacterModel {

    public int x_pos;

    public int y_pos;

    public String type;

    public String skin_type;

    public CharacterModel(int x_pos, int y_pos){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
}

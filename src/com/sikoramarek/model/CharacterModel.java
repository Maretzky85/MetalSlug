package com.sikoramarek.model;

import com.sikoramarek.common.CharacterType;
import com.sikoramarek.common.PlayerAction;
import com.sikoramarek.common.SharedResources;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class CharacterModel {

    public ArrayList<Bullet> bullets = new ArrayList<>();

    private int GROUND_LEVEL = 160;

    private double MAX_VELOCITY = 30;

    private float X_VELOCITY = 0;
    private float Y_VELOCITY = 0;

    public float x_pos;
    public float last_x_pos;

    public float y_pos;

    public int orientation = 1;

    public PlayerAction action;

    public CharacterType type;

    public String skin_type;

    public CharacterModel(int x_pos, int y_pos){
        action = PlayerAction.STANDING;
        this.x_pos = x_pos;
        this.last_x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public void fireWeapon(){
        bullets.add(new Bullet(x_pos+20+(orientation*20), y_pos+20, 60*orientation));
    }

    public void update() {
        last_x_pos = x_pos;

        for (Bullet bullet : bullets
                ) {
            bullet.update();
        }


        if(SharedResources.Keyboard.contains(KeyCode.SPACE)){
            fireWeapon();
        }

        if (SharedResources.Keyboard.contains(KeyCode.D)){
            orientation = 1;
            if (X_VELOCITY < MAX_VELOCITY){
                X_VELOCITY += 2;
            }
            x_pos = x_pos + X_VELOCITY * SharedResources.DT;
        }else
        if (SharedResources.Keyboard.contains(KeyCode.A)){
            orientation = -1;
            if (X_VELOCITY < MAX_VELOCITY){
                X_VELOCITY += 2;
            }
            x_pos = x_pos - X_VELOCITY * SharedResources.DT;
        }else{
            X_VELOCITY = 0;}

        if ( y_pos < GROUND_LEVEL ){
            Y_VELOCITY -= 5;
        }else {
            Y_VELOCITY = 0;
            if (SharedResources.Keyboard.contains(KeyCode.W)){
                Y_VELOCITY += 35;
            }
        }

        y_pos = y_pos - Y_VELOCITY * SharedResources.DT;

        if (last_x_pos == x_pos){
            action = PlayerAction.STANDING;
        }else{
            action = PlayerAction.RUNNING;
        }
    }
}

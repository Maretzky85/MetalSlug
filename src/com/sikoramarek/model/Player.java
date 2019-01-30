package com.sikoramarek.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;

public class Player {

    int currentSkin = 0;

    List<String> skins = new LinkedList<String>();

    public ImageView skinView;
    public int x_pos = 20;
    public int y_pos = 160;

    public Player(){
        skins.add("Eri/Body/Standing/Body/eri-stand-01.png");
        skins.add("Eri/Body/Standing/Body/eri-stand-02.png");
        skins.add("Eri/Body/Standing/Body/eri-stand-03.png");
        skins.add("Eri/Body/Standing/Body/eri-stand-04.png");
        skinView = new ImageView(new Image(skins.get(currentSkin)));
        skinView.setX(x_pos);
        skinView.setY(y_pos);
    }

    public void updateSkin(){
        if (currentSkin < skins.size() - 1){
            currentSkin += 1;
        }else{
            currentSkin = 0;
        }
        skinView.setX(x_pos);
        skinView.setImage(new Image(skins.get(currentSkin)));
//        System.out.println(skin);
    }

}

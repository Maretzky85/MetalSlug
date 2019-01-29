package com.sikoramarek.view;

import com.sikoramarek.model.CharacterModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;

public class SkinManager extends ImageView {

    public SkinManager(CharacterModel model){
        this.model = model;
    }

    private CharacterModel model;

    public int offset;

    public Image currentImage;

    List<String> skins = new LinkedList<String>();

    int currentSkin = 0;


    public void loadSkins(String[] skinList){
        for (String skin:skinList){
            skins.add(skin);
        }
        currentImage = new Image(skins.get(currentSkin));
        this.setImage(currentImage);
    }

    public void update(){
        this.setX(model.getX_pos());
        this.setY(model.getY_pos()+offset);
        if (currentSkin < skins.size() - 1){
            currentSkin += 1;
        }else{
            currentSkin = 0;}
        currentImage = new Image(skins.get(currentSkin));
        this.setImage(currentImage);
    }

}

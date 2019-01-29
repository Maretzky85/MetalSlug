package com.sikoramarek.view;

import com.sikoramarek.model.CharacterModel;
import javafx.scene.Group;

public class CharacterView{

    Group scene;

    public CharacterView(Group scene, CharacterModel model){
        this.scene = scene;
        legs = new SkinManager(model);
        body = new SkinManager(model);
        loadSkins();
    }

    public SkinManager body;
    public SkinManager legs;

    public void loadSkins(){

        legs.loadSkins(new String[]{"Eri/Body/Standing/eri-stand-legs-01.png"});

        body.loadSkins(new String[]{"Eri/Body/Standing/eri-stand-01.png", "Eri/Body/Standing/eri-stand-02.png",
                "Eri/Body/Standing/eri-stand-03.png", "Eri/Body/Standing/eri-stand-04.png"});

        legs.offset = 15;
        scene.getChildren().add(legs);
        scene.getChildren().add(body);
    }

    public void update(){
        body.update();
        legs.update();
    }
}

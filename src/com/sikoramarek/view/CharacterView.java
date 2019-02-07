package com.sikoramarek.view;

import com.sikoramarek.common.PlayerAction;
import com.sikoramarek.common.ResourceLoader;
import com.sikoramarek.model.Bullet;
import com.sikoramarek.model.CharacterModel;
import javafx.application.Platform;
import javafx.scene.Group;

public class CharacterView{

    Group scene;
    CharacterModel model;

    public CharacterView(Group scene, CharacterModel model){
        this.scene = scene;
        this.model = model;
        legs = new SkinManager(model);
        body = new SkinManager(model);
        loadSkins();
    }

    public SkinManager body;
    public SkinManager legs;

    public void loadSkins(){
        legs.loadSkinMap(PlayerAction.RUNNING, "Eri/Body/Running/legs");
        legs.loadSkinMap(PlayerAction.STANDING, "Eri/Body/Standing/Legs");

        body.loadSkinMap(PlayerAction.STANDING, "Eri/Body/Standing/Body");
        body.loadSkinMap(PlayerAction.RUNNING,"Eri/Body/Running/body");

        legs.offset = 15;
        scene.getChildren().add(legs);
        scene.getChildren().add(body);
    }

    public void update(){
        for (Bullet bullet : model.bullets
                ) {
            if (!bullet.alive){
                Platform.runLater(() -> {
                    model.bullets.remove(bullet);
                });

            }
            if (!scene.getChildren().contains(bullet))
                Platform.runLater(() -> {
                    scene.getChildren().add(bullet);
                });

        }
        body.update();
        legs.update();
    }
}

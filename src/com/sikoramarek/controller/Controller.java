package com.sikoramarek.controller;

import com.sikoramarek.model.CharacterModel;
import com.sikoramarek.view.JavaFXview;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Controller{

    private FrameControlLoop loop;
    private JavaFXview view;
    private CharacterModel player1 = new CharacterModel(50, 0);

    public void controllerInit(Stage primaryStage){

        loop = new FrameControlLoop(this::updateModel);
        loop.setDaemon(true);
        view = new JavaFXview(primaryStage);
        view.viewInit();
        view.createPlayer(player1);
    }

    public void updateModel() {
        player1.update();
        view.update();
    }

    public void startLoop() {
        loop.start();
    }
}

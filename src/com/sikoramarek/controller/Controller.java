package com.sikoramarek.controller;

import com.sikoramarek.model.CharacterModel;
import com.sikoramarek.view.JavaFXview;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private FrameControlLoop loop;
    private JavaFXview view;
    private CharacterModel player1 = new CharacterModel(50, 160);

    public void controllerInit(Stage primaryStage){

        loop = new FrameControlLoop(this::updateModel);
        loop.setDaemon(true);
        view = new JavaFXview(primaryStage);
        view.viewInit();
        view.attachObserver(this);
        view.createPlayer(player1);
    }

    public void updateModel(){
        view.update();
    }

    @Override
    public void update(Observable o, Object arg) {
        String key = (String) arg;
        switch (key) {
            case "d":
                player1.x_pos += 5;
                break;
            case "a":
                player1.x_pos -= 5;
                break;
        }
    }

    public void startLoop() {
        loop.start();
    }
}

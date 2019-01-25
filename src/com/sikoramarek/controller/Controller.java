package com.sikoramarek.controller;

import com.sikoramarek.view.JavaFXview;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private FrameControlLoop loop;
    private JavaFXview view;

    public void controllerInit(Stage primaryStage){

        loop = new FrameControlLoop(this::updateModel);
        view = new JavaFXview(primaryStage);
        view.viewInit();

    }

    public void updateModel(){

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void startLoop() {
        loop.start();
    }
}

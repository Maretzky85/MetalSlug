package com.sikoramarek;

import com.sikoramarek.controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        controller.controllerInit(primaryStage);
        controller.startLoop();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

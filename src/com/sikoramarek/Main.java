package com.sikoramarek;

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

        Image background = new Image("bg/lvl1Bg.png");
        ImageView imageView = new ImageView(background);

        Parent root = new Group(imageView);
        primaryStage.setTitle("Metal Slug");
        primaryStage.setScene(new Scene(root, 300, 275));


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package com.sikoramarek.view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class JavaFXview {

    private Stage primaryStage;

    Image background = new Image("bg/lvl1Bg.png");
    ImageView imageView = new ImageView(background);

    public JavaFXview(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void viewInit(){
        Parent root = new Group(imageView);
        primaryStage.setTitle("Metal Slug");
        primaryStage.setScene(new Scene(root, 300, 260));
        primaryStage.show();
    }

}

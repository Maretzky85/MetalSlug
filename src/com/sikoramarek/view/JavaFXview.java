package com.sikoramarek.view;

import com.sikoramarek.common.SharedResources;
import com.sikoramarek.controller.Controller;
import com.sikoramarek.model.Bullet;
import com.sikoramarek.model.CharacterModel;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JavaFXview {

    private CharacterView player1;

    private Stage primaryStage;
    private Group root;

    Image background = new Image("bg/lvl1Bg.png");
    ImageView imageView = new ImageView(background);

    public JavaFXview(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void viewInit(){
        root = new Group(imageView);
        primaryStage.setTitle("Metal Slug");
        primaryStage.setScene(new Scene(root, 300, 260));
        primaryStage.show();
        attachKeyboardHandler();
    }

    public void createPlayer(CharacterModel playerModel){
        player1 = new CharacterView(root, playerModel);
    }

    private void attachKeyboardHandler(){
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if ( !SharedResources.Keyboard.contains(key.getCode()) ) {
                SharedResources.Keyboard.add(key.getCode());
            }
        }
        );

        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if ( SharedResources.Keyboard.contains(key.getCode()) ) {
                SharedResources.Keyboard.remove(key.getCode());
            }
        });

    }


    public void update() {
        root.getChildren().forEach((object) -> {
            if (object.getClass().equals(Bullet.class)){
                Bullet bullet = (Bullet) object;
                if (!bullet.alive){
                    Platform.runLater(() -> {
                        root.getChildren().remove(object);
                    });

                }
            }
        });
        player1.update();
    }
}

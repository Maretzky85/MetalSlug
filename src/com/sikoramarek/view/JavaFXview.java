package com.sikoramarek.view;

import com.sikoramarek.model.Player;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class JavaFXview {

    private Stage primaryStage;

    Player player = new Player();

    Image background = new Image("bg/lvl1Bg.png");
    ImageView imageView = new ImageView(background);

    public JavaFXview(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void viewInit(){
        Group root = new Group(imageView,player.skinView);
        primaryStage.setTitle("Metal Slug");
        primaryStage.setScene(new Scene(root, 300, 260));
        primaryStage.show();
        attachKeyboardHandler();
    }

    private void attachKeyboardHandler(){
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> handleKey(key));
    }

    private void handleKey(KeyEvent key) {
        if (key.getCode() == KeyCode.D){
            player.x_pos += 5;
        }
        if (key.getCode() == KeyCode.A){
            player.x_pos -= 5;
        }
    }

    public void update() {
        player.updateSkin();
    }
}

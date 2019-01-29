package com.sikoramarek.view;

import com.sikoramarek.controller.Controller;
import com.sikoramarek.model.CharacterModel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class JavaFXview {

    private InputHandler inputHandler = new InputHandler();

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
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> inputHandler.handleInput(key));
    }

    private void handleKey(KeyEvent key) {
//        if (key.getCode() == KeyCode.D){
//            player.setX(player.getX() + 5);
//        }
//        if (key.getCode() == KeyCode.A){
//            player.setX(player.getX() - 5);
//        }
    }

    public void attachObserver(Controller controller){
        inputHandler.addObserver(controller);
    }

    public void update() {
        player1.update();
    }
}

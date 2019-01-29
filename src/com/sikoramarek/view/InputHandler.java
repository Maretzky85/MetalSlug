package com.sikoramarek.view;
import javafx.scene.input.KeyEvent;

import java.util.Observable;

public class InputHandler  extends Observable {

    void handleInput(KeyEvent event) {
        setChanged();
        notifyObservers(event.getText());
    }

}

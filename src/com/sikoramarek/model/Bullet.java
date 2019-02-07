package com.sikoramarek.model;

import com.sikoramarek.common.SharedResources;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends Circle {

	double VELOCITY;
	public boolean alive = true;
	double x_origin;

	public Bullet(double x, double y, double v){
		super(x, y, 5, Color.YELLOW);
		this.x_origin = x;
		this.VELOCITY = v;
		if(SharedResources.Keyboard.contains(KeyCode.SPACE)){
			SharedResources.Keyboard.remove(KeyCode.SPACE);
		}
	}

	public void update(){
		if( Math.abs(x_origin-this.getCenterX()) > 500 ){
			alive = false;
		}
		if (alive){
			Platform.runLater(() -> {
				this.setCenterX(this.getCenterX()+(VELOCITY* SharedResources.DT));
			});
		}


	}

}

package com.daniel.evolutionary_sine.gui;


import com.daniel.evolutionary_sine.engine.Engine;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SettingsPane extends VBox{
	public SettingsPane() {
		Button b = new Button("Start");
		b.setStyle("-fx-alignment: center; align-content: center;");
		Task<Void> engineStart = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				Engine.start();
				return null;
			}};
		b.setOnAction(e->{Thread t = new Thread(engineStart);
		try {	
		t.start();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
			//new Thread(()->Engine.step()).start();
		});
		
		this.getChildren().add(b);
	}

}

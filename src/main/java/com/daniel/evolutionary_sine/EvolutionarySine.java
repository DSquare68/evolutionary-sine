package com.daniel.evolutionary_sine;

import java.io.IOException;
import java.util.ArrayList;

import com.daniel.evolutionary_sine.gui.GraphPane;
import com.daniel.evolutionary_sine.gui.VariableVBox;
import com.daniel.evolutionary_sine.gui.VariablesPane;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class EvolutionarySine extends Application {
	public static Pane scene;
    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var width = DimensionInfo.getWidth();
        var height = DimensionInfo.getHeight();

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        scene =FXMLLoader.load(getClass().getResource("/pane/MainPane.fxml"));
        scene.getStylesheets().add(getClass().getResource("/pane/pane.css").toExternalForm());
        ((GridPane) scene).setHgap(width*0.6/7);
        ((GridPane) scene).setVgap(height*0.6/5);
        stage.setScene(new Scene(scene,width*0.6/7*8, height*0.6));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
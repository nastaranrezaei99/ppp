package main;

import gui.BahnhoefeAnwendungssystem;
import gui.BahnhoeferControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BahnhoeferControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}

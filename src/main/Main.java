package main;

import guiBahnhoefe.BahnhoeferControl;
import guiBahnhoefe.MobilitaetsangeboteControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BahnhoeferControl(primaryStage);
		
		Stage fensterStaedtischeEinrichtungen = new Stage();
		new MobilitaetsangeboteControl(fensterStaedtischeEinrichtungen);
		
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.BahnhoeferModel;
import javafx.stage.Stage;

public class BahnhoeferControl {
	
	private BahnhoeferView bView;
	private BahnhoeferModel bModel;
	public BahnhoeferControl(Stage primaryStage) {
		super();
		this.bModel = new BahnhoeferModel();
		this.bView = new BahnhoeferView(primaryStage, this, bModel);
	
	}
	
	 void schreibeBahnhoefeInCsvDatei(String typ) {
		try {
			bModel.schreibeBahnhoefeInCsvDatei();
			bView.zeigeInformationsfensterAn(
  	  	   			"Der Bahnhof wurde gelesen!");
		}	
		catch(IOException exc){
			bView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			bView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

	
	  void leseAusDatei(String typ){
		 try {
		 if("csv".equals(typ)) {
			 bModel.leseAusDatei(typ);
			 bView.zeigeInformationsfensterAn(
   	  	   			"Der Bahnhof wurde gelesen!");
			 
		 }
		 else{
			 bView.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
			 
		 }
		 }catch(IOException exc){
				bView.zeigeFehlermeldungsfensterAn(
						"IOException beim Speichern!");
			}
		catch(Exception exc){
				bView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
						}
	 }
	

}

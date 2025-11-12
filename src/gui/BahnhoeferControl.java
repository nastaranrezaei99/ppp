package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.BahnhoeferModel;
import business.Bahnhof;
import javafx.stage.Stage;

public class BahnhoeferControl {
	
	private BahnhoeferView bView;
	private BahnhoeferModel bModel;
	public BahnhoeferControl(Stage primaryStage) {
		
		this.bView = new BahnhoeferView(primaryStage, this, bModel);
		this.bModel = new BahnhoeferModel();
		
	
	}
	
	 void schreibeBahnhoefeInCsvDatei() {
		try {
			bModel.schreibeBahnhoefeInCsvDatei();
			bView.zeigeInformationsfensterAn(
  	  	   			"Die Bahnhof wurden gespeichert!");
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
		 }
		catch(Exception exc){
				bView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
						}
	 }
	  
	  void nehmeBahnhofAuf(){
	    	try{ 
	    		bModel.setBahnhof(new Bahnhof(
	    			bView.getTxtName().getText(), 
	   	            bView.getTxtOrt().getText(),
	   	            Integer.parseInt(bView.getTxtAnzahlGleise().getText()),
	   	        	Integer.parseInt(bView.getTxtLetzteRenovierung().getText()),
	    		    bView.getTxtZugarten().getText().split(";")));
	    		
	       	}
	       	catch(Exception exc){
	       		bView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	  }

	  
	  void zeigeBahnhoefeAn(){
		  if(bModel.getBahnhof() != null){
			  bView.getTxtAnzeige().setText(
					  bModel.getBahnhof().gibBahnhofZurueck(' '));
	}
		  else{
			  bView.zeigeInformationsfensterAn("Bisher wurde keine Bahnhof aufgenommen!");
	}
}   
}
	  

package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import gui.BahnhoeferControl;
import gui.BahnhoeferView;

public class BahnhoeferModel {
	
	private Bahnhof bahnhof;
	
	

	public Bahnhof getBahnhof() {
		return bahnhof;
	}



	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}
	
	
	public void schreibeBahnhoefeInCsvDatei() throws Exception{
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
			aus.write(bahnhof.gibBahnhofZurueck(';'));
			aus.close();
		
			

}



	public void leseAusDatei(String typ) throws Exception{
		 BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.csv"));
			String[] zeile = ein.readLine().split(";");
			bahnhof = new Bahnhof(zeile[0], 
				zeile[1], 
				Integer.parseInt(zeile[2]), 
				Integer.parseInt(zeile[3]), 
				zeile[4].split("_"));
				ein.close();
	 }
	 
	 
	 
}
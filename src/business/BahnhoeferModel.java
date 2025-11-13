package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import fileCreatorsRezaei.ConcreteCsvReaderCreator;
import fileCreatorsRezaei.ConcreteCsvReaderCreatorB;
import fileCreatorsRezaei.ReaderCreatorRezaei;
import fileCreatorsRezaei.ReaderProductRezaei;
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



	
	public void leseAusCsvDatei() throws Exception {
		ReaderCreatorRezaei rc = new ConcreteCsvReaderCreator();
		ReaderProductRezaei rp = rc.factoryMethode();
		String[] zeile = rp.leseAusDatei();
		this.bahnhof = new Bahnhof(zeile[0], 
				Float.parseFloat(zeile[1]),
				Float.parseFloat(zeile[2]), 
				zeile[3], zeile[4].split("_"));
		
		rp.schliesseDatei();
		
	}
	
	public void leseAusTxtDatei() throws Exception {
		ReaderCreatorRezaei rc = new ConcreteCsvReaderCreatorB();
		ReaderProductRezaei rp = rc.factoryMethode();
		String[] zeile = rp.leseAusDatei();
		this.bahnhof = new Bahnhof(zeile[0], 
				Float.parseFloat(zeile[1]),
				Float.parseFloat(zeile[2]), 
				zeile[3], zeile[4].split("_"));
		
		rp.schliesseDatei();
	}
	
	
	
	
	 
	 
	 
}
package fileCreatorsRezaei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Bahnhof;

public class ConcreteCsvReaderProduct extends ReaderProductRezaei {

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.csv"));
		String[] zeile = ein.readLine().split(";");
		Bahnhof bahnhof = new Bahnhof(zeile[0], 
			zeile[1], 
			Integer.parseInt(zeile[2]), 
			Integer.parseInt(zeile[3]), 
			zeile[4].split("_"));
			ein.close();
		return zeile;
 }
	

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		
		

	}

}

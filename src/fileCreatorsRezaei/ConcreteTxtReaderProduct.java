package fileCreatorsRezaei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Bahnhof;

public class ConcreteTxtReaderProduct extends ReaderProductRezaei {

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
	     BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.txt"));
	        String[] ergebnisZeile = new String[5];
	        String zeile = ein.readLine();
	        int i=0;
	        while(i<ergebnisZeile.length) {
	        	ergebnisZeile[i] = zeile;
	        	zeile = ein.readLine();
	        	i++;
	        }
	        return ergebnisZeile;
	    }
 
	

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		
	}

}


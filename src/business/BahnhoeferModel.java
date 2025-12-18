package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fileCreatorsRezaei.ConcreteCsvReaderCreator;
import fileCreatorsRezaei.ConcreteCsvReaderCreatorB;
import fileCreatorsRezaei.ReaderCreatorRezaei;
import fileCreatorsRezaei.ReaderProductRezaei;
import ownUtil.Observable;
import ownUtil.Observer;

public class BahnhoeferModel implements Observable {

    private Vector<Observer> observers = new Vector<Observer>();
    private static BahnhoeferModel instance;

    private ArrayList<Bahnhof> bahnhof = new ArrayList<Bahnhof>();

    private BahnhoeferModel() {
    }

    public static BahnhoeferModel getInstance() {
        if (instance == null) {
            instance = new BahnhoeferModel();
        }
        return instance;
    }

    public ArrayList<Bahnhof> getBahnhof() {
        return bahnhof;
    }

    public void addBahnhof(Bahnhof bahnhof) {
        this.bahnhof.add(bahnhof);
        
        
        notifyObserver();
    }

    public void leseAusDatei(String typ) throws IOException {

        

        /*if("csv".equals(typ)){
			BufferedReader ein = new BufferedReader(new FileReader("Bahnhof.csv"));
			String[] zeile = ein.readLine().split(";");
			setBahnhof(new Bahnhof(zeile[0], 
								zeile[1], 
								Integer.parseInt(zeile[2]), 
								Integer.parseInt(zeile[3]), 
								zeile[4].split("_")));
			ein.close();
		}
	return null;*/
    	
    	ReaderCreatorRezaei readerCreator =new ConcreteCsvReaderCreator();
        ReaderProductRezaei readerProduct = readerCreator.factoryMethode();
	
	
        String[] zeile = readerProduct.leseAusDatei();
        Bahnhof b = new Bahnhof(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), zeile[4].split("_"));
        
        addBahnhof(b);
	
}

    public void schreibeBahnhoefeInCsvDatei() throws IOException {
    	BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
    	
    	for (Bahnhof b : bahnhof) {
            aus.write(b.gibBahnhofZurueck(';'));
        }
    	
		//aus.write(bahnhof.gibBahnhofZurueck(';'));
		aus.close();
	
        notifyObserver();
    }

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
        this.observers.addElement(obs);

	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (Observer obs : observers) {
            obs.update();
        }
	}



    
}
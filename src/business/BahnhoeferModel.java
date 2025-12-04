package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    private Bahnhof bahnhof;

    private BahnhoeferModel() {
    }

    public static BahnhoeferModel getInstance() {
        if (instance == null) {
            instance = new BahnhoeferModel();
        }
        return instance;
    }

    public Bahnhof getBahnhof() {
        return bahnhof;
    }

    public void setBahnhof(Bahnhof bahnhof) {
        this.bahnhof = bahnhof;
        notifyObserver();
    }

    public void leseAusDatei(String typ) throws IOException {

        ReaderCreatorRezaei readerCreator;

        if ("csv".equalsIgnoreCase(typ)) {
            readerCreator = new ConcreteCsvReaderCreator();
        } else if ("txt".equalsIgnoreCase(typ)) {
            readerCreator = new ConcreteCsvReaderCreatorB();
        } else {
            throw new IllegalArgumentException("Unbekannter Typ: " + typ);
        }

        ReaderProductRezaei readerProduct = readerCreator.factoryMethode();

        String[] zeile = readerProduct.leseAusDatei();
        readerProduct.schliesseDatei();

        Bahnhof b = new Bahnhof(
                zeile[0],
                zeile[1],
                Integer.parseInt(zeile[2]),
                Integer.parseInt(zeile[3]),
                zeile[4].split("_")
        );

        setBahnhof(b);
    }

    public void schreibeBahnhoefeInCsvDatei() throws IOException {
        if (bahnhof == null) {
            throw new IllegalStateException("Kein Bahnhof zum Export vorhanden");
        }

        try (BufferedWriter aus = new BufferedWriter(
                new FileWriter("BahnhoefeAusgabe.csv", true))) {
            aus.write(bahnhof.gibBahnhofZurueck(';'));
        }

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

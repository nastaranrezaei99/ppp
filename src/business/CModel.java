package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

public class CModel implements Observable {

    
    private static CModel instance;


    private CModel() {
    }
    
    

    public static CModel getInstance() {
        if (instance == null) {
            instance = new CModel();
        }
        return instance;
    }
    
    
    
    private ArrayList<Carsharing> car1 = new ArrayList<>();
    public ArrayList<Carsharing> getCModel() {
        return car1;
    }
    

    
    
    
    
    
    private Vector<Observer> observers = new Vector<Observer>();


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
            obs.update(this);
        }
	}



	public void leseCarsharingAusCsvDatei()throws IOException {
		// TODO Auto-generated method stub
		BufferedReader ein= new BufferedReader(new FileReader("BahnhoeferNew.csv"));
		   ArrayList<Carsharing> ergebnis = new ArrayList<Carsharing>();
		   String zeileStr = ein.readLine();
		   while(zeileStr!=null) {
			   String[] zeile = zeileStr.split(";");
			   ergebnis.add(new Carsharing(zeile[0], zeile[1],zeile[2]));
			   zeileStr = ein.readLine();
			   
		   }
		   ein.close();
		   this.car1=ergebnis;
		
	}



    
}
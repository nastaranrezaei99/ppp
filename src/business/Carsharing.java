package business;

public class Carsharing {
	
	private String treffpunkt;
	private int kostenProKilometer;
	private int kostenProStunde;
	
	public Carsharing(String treffpunkt, String kostenProKilometer, String kostenProStunde) {
		super();
		this.treffpunkt = treffpunkt;
		this.kostenProKilometer = Integer.parseInt(kostenProKilometer);
		this.kostenProStunde = Integer.parseInt(kostenProStunde);
	}
	
	public String gibCarsharingZurueck(char trenner){
  		return this.getTreffpunkt() + trenner 
  			+ this.getKostenProKilometer() + trenner
  		    + this.getKostenProStunde();
   	}

	public String getTreffpunkt() {
		return treffpunkt;
	}

	public void setTreffpunkt(String treffpunkt) {
		this.treffpunkt = treffpunkt;
	}

	public int getKostenProKilometer() {
		return kostenProKilometer;
	}

	public void setKostenProKilometer(int kostenProKilometer) {
		this.kostenProKilometer = kostenProKilometer;
	}

	public int getKostenProStunde() {
		return kostenProStunde;
	}

	public void setKostenProStunde(int kostenProStunde) {
		this.kostenProStunde = kostenProStunde;
	}
	
	

}

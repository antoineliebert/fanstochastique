package la_main;

import java.util.Observable;

public class ClickID extends Observable{

	private int IDCaisse;
	private int IDClient;
	private int IDPause;
	
	public ClickID (){
		IDCaisse = -1;
		IDClient = -1;
		IDPause = 0;
	}

	public void setIDPause(int IDPause){
		setChanged();
		notifyObservers();
		this.IDPause = IDPause;
	}
	
	
	public int getIDCaisse() {
		return IDCaisse;
	}

	public void setIDCaisse(int iDCaisse, String comingFrom) {
		IDCaisse = iDCaisse;
		if (comingFrom == "Caisse")
		{
			setChanged();
			notifyObservers();
			System.out.println("set changed");
		}
	}

	public int getIDClient() {
		return IDClient;
	}

	public void setIDClient(int iDClient) {
		IDClient = iDClient;
		setChanged();
		notifyObservers();

	}
	
	
}

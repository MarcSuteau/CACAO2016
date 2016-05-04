package abstraction.equipe4;
import abstraction.fourni.*;
import abstraction.commun.*;

public class Tresorerie {
	// argent totale dans la cagnote
	private Indicateur fond;
	// nous
	private Producteur prod;
	
	public Tresorerie(Producteur p) {
		this.fond = new Indicateur("Fond de" + p.getNom(),p,0.0);
		this.prod= p;
		Monde.LE_MONDE.ajouterIndicateur( this.fond );
	}
	
	
	public Producteur getProd(){
		return this.prod;
	}


	public Indicateur getFond(){
		return this.fond;
	}

	public void coutStock(){
		this.fond.setValeur(this.prod, this.getFond().getValeur()-this.getProd().getStock().getCoutStock()*this.getProd().getStock().getStockCacao().getValeur());
	}
	
	
	public void vente(double qtVendue){		
		this.fond.setValeur(prod, this.getFond().getValeur()+ qtVendue*this.getProd().getMarche().getCours());
	}
		
}
	

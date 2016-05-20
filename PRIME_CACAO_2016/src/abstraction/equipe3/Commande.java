package abstraction.equipe3;

import java.util.ArrayList;

import abstraction.commun.ITransformateur;
import abstraction.commun.Produit;

public class Commande {
	
	private ArrayList<Double[]> commande;
	private Leclerc leclerc;
	private Stock stock;

	public Commande(Leclerc leclerc) {
		this.commande = new ArrayList<Double[]>();
		this.leclerc = leclerc;
		this.stock = stock;
	}
	
	public double getCommande(ITransformateur t, Produit p){
		double x=0;
		for (int i =0; i<this.leclerc.nombreTransformateur();i++){
			if (t.equals(this.leclerc.getTransformateurs(i))) {
				Double[] produittransfo = this.commande.get(i);
				if (p.getRatioCacao()==0.5){
					x = produittransfo[0];
				}
				else{
					if (p.getRatioCacao()==0.6){
						x = produittransfo[1];
					}
					else{
						x = produittransfo[2];
					}
				}
			}
		} return x;	
	}
	
	public void setCommande(Stock stock){
		
	}

}

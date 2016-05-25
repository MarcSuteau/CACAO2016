package abstraction.equipe5;
import abstraction.equipe5.Lindt;
import abstraction.commun.Constantes;

import java.util.ArrayList;
import java.util.List;

import abstraction.commun.CommandeDistri;
import abstraction.commun.IProducteur;


public class VenteDist {

	private Lindt lindt;
	
	public VenteDist(Lindt lindt){
	
		this.lindt=lindt;
	}
	
	class variable{
		
		private Stock stock50;
		private Stock stock60;
		private Stock stock70;
		private List<CommandeDistri> commandeDist;
		
		public variable(Stock stock50, Stock stock60, Stock stock70, List<CommandeDistri> commandeDist) {
			super();
			this.stock50 = stock50;
			this.stock60 = stock60;
			this.stock70 = stock70;
			this.commandeDist = commandeDist;
		}
		
		public Stock getStock50() {
			return stock50;}

		public void setStock50(Stock stock50) {
			this.stock50 = stock50;}

		public Stock getStock60() {
			return stock60;}

		public void setStock60(Stock stock60) {
			this.stock60 = stock60;}

		public Stock getStock70() {
			return stock70;}

		public void setStock70(Stock stock70) {
			this.stock70 = stock70;}

		public List<CommandeDistri> getCommandeDist() {
			return commandeDist;}

		public void setCommandeDist(List<CommandeDistri> commandeDist) {
			this.commandeDist = commandeDist;}

	}
	
	//creation d'une fonction qui renvoie le prix d'un produit 
//	public double prixProduit(String p){
//		double marge=0.0;
//		if (p=='50%'){
//			marge=7;
//		}
//		else{
//			if(p)
//		}
//	
//		return Tresorerie.coutRevientParProduit() + marge ;
//	}
	
	
	//creation d'une fonction qui calcule la quantité totale demandée par les 3 distrib pour chacun des produits (dans l'ordre 50%,60%,70%)
	public List <Double> QuantiteDemandeeProduit( List<CommandeDistri> listeCommandesDist){
		List <Double> quantiteTotale = new ArrayList <Double> ();

		for (int i=0; i<Constante.LISTE_PRODUIT.length ; i++){
			double quantiteProduit=0.0;
			for (CommandeDistri c : listeCommandesDist ){
				if (Constante.LISTE_PRODUIT[i].getNomProduit()==c.getProduit().getNomProduit()) {
					quantiteProduit += c.getQuantite();
				}
			}
			quantiteTotale.add(quantiteProduit);
		}
		return quantiteTotale;
	}

	//Creation d'une fonction qui calcule la quantité de chocolat à mettre dans chaque commande pour le 1er échange (offre) 
	//Ne pas oublier de changer le prix!!!!
	
	public List<CommandeDistri> Offre (List<CommandeDistri> listeCommandesDist){
		return this.Offre(listeCommandesDist).get(3);
	}
	
	public variable OffreInterne (List<CommandeDistri> listeCommandesDist){
		variable var = new variable (lindt.getStockChocolat50(),lindt.getStockChocolat60(),lindt.getStockChocolat70(),listeCommandesDist);

		for(int i=0; i<lindt.getDistributeurs().size(); i++){
			
			
			double stockChocolatI=lindt.getStocksChocolat().get(i).getStock(); //stock de chocolat i
			double QteDemandeeChocolatI=this.QuantiteDemandeeProduit(listeCommandesDist).get(i).doubleValue();// quantite totale de chocolat i demandée par les 3 dist
			
			if(QteDemandeeChocolatI <= stockChocolatI){ //ok on peut fournir aux distrib la quantité de chocolats i qu'ils demandent donc on valide les commandes
					//lindt.getStocksChocolat().get(i).setStock(stockChocolatI-QteDemandeeChocolatI); //mise à jour du stock de chocolat i
					// a faire varier au step n+3
				
				 for(CommandeDistri c : listeCommandesDist){
					 if(c.getProduit().getNomProduit()==Constante.LISTE_PRODUIT[i].getNomProduit()){
						 c.setValidation(true);}}} //on valide les commandes de produit i puisqu'on a assez de chocolats i
			
			else{
				double quantiteRepartie=lindt.getStocksChocolat().get(i).getStock()/(lindt.getDistributeurs().size()); //Répartition équitable, donc si 3 dist, on divise la quantité totale par 3)
				
				for (CommandeDistri c : listeCommandesDist){
					if(c.getProduit().getNomProduit()==Constante.LISTE_PRODUIT[i].getNomProduit()){
						while(stockChocolatI>0){// tant qu'il me reste du stock de chocolat i
							int j=0; 
							if(c.getQuantite()<=quantiteRepartie){ //si la quantite demandee dans la commande est inférieure à quantiteRepartie
								c.setValidation(true); //on valide la commande
								//lindt.getStocksChocolat().get(i).setStock(stockChocolatI-quantiteRepartie); // on met à jour le stock de chocolat i
								stockChocolatI -= c.getQuantite();
								quantiteRepartie=stockChocolatI/(lindt.getDistributeurs().size()-j);
								j++;	
							}
							else{
								c.setQuantite(quantiteRepartie);
								}}}}}
		}return var; //liste de commandes pour le premier echange => offre		
	}
	
	
	//Creation d'une fonction qui répartie le chocolat pour le 2eme échange (échange final) Ne pas oublier le boolean validation
	
	public List<CommandeDistri> CommandeFinale(List<CommandeDistri> cf){
		
		ArrayList<CommandeDistri> CommandesNonValidees= new ArrayList<CommandeDistri>();																																
		for(CommandeDistri c : cf ){
			if(c.getValidation()==false){	
				CommandesNonValidees.add(c);
			}
		}
		for(int i=0; i<Constante.LISTE_PRODUIT.length ; i++){
				if(
						){ //si il nous reste du chocolat i
					for(CommandeDistri c : cf ){
						if (c.getProduit().getNomProduit()==Constante.LISTE_PRODUIT[i].getNomProduit()){
							
						}
					}
					}
						
		}
		
		return cf;
	}
	
	
	
	
	
    //exemple avec une hashmap
	//	for (abstraction.commun.Produit p : Constante.listeProduit) {
	//		if(this.QuantiteDemandeeProduit(listeCommandesDist).get(0).doubleValue() <= lindt.getStocks().get(p).getStock()){
	
}
			

	

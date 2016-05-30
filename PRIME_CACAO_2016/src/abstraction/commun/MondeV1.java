
package abstraction.commun;

import abstraction.fourni.Monde;

import java.util.ArrayList;

import abstraction.commun.Constantes;
import abstraction.equipe5.Lindt;
import abstraction.equipe1.Producteur;
import abstraction.fourni.Monde;
import abstraction.fourni.v0.Detaillant;
import abstraction.commun.Constantes;


import abstraction.equipe3.Leclerc;
import abstraction.equipe3.Leclercv2;
import abstraction.equipe2.*;
import abstraction.equipe6.Carrefour;

import abstraction.equipe4.*;
import abstraction.equipe6.Carrefour;


public class MondeV1 extends Monde {
	
	public void peupler() {
		// Il faut créer les acteurs et les ajouter au monde ici.
		
		// Distributeurs

		Leclercv2 Le = new Leclercv2("Leclerc", this);


		Carrefour Ca = new Carrefour("Carrefour", this, 15, 20, 50000);
		this.ajouterActeur(Le);
		this.ajouterActeur(Ca);
		
		// Transformateurs

		Nestle nestle = new Nestle();

		ResteDesTransformateursMondiaux t3 = new ResteDesTransformateursMondiaux();

		this.ajouterActeur(nestle);

		Lindt lindt = new Lindt();
		ajouterActeur(lindt);
		lindt.ajouterDistributeur(Ca);
		lindt.ajouterDistributeur(Le);

		this.ajouterActeur(t3);

		
		
		// Marché Producteur
		MarcheProducteur marcheProducteur = new MarcheProducteur();
		MarcheProducteur.LE_MARCHE = marcheProducteur;
		this.ajouterActeur(marcheProducteur);
		
		// Marché Consommateur
		MarcheConsommateurs marcheConsommateurs = new MarcheConsommateurs();
		MarcheConsommateurs.LE_MARCHE = marcheConsommateurs;
		this.ajouterActeur(marcheConsommateurs);
		
		// Producteurs
		Producteur p1 = new Producteur(Constantes.NOM_PRODUCTEUR_1, 1000.0, 0.0, Monde.LE_MONDE);
		abstraction.equipe4.Producteur p2 = new abstraction.equipe4.Producteur(Monde.LE_MONDE);
		this.ajouterActeur(p1);
		this.ajouterActeur(p2);
		
		// Ajout des acteurs dans les listes des acteurs

		lindt.ajouterProducteur(p1);
		lindt.ajouterProducteur(p2);

		t3.ajouterTransformateur(nestle);

		t3.ajouterTransformateur(lindt);

		nestle.AjouterClient(Le);
		nestle.AjouterClient(Ca);
		nestle.AjouterFournisseur(p1);
		nestle.AjouterFournisseur(p2);

		
		nestle.creer();
		Le.ajouterVendeur(nestle);
		Le.ajouterVendeur(lindt);
		Ca.ajouterVendeur(nestle);
		Ca.ajouterVendeur(lindt);
		
		p1.ajouterTransformateur(nestle);
		p1.ajouterTransformateur(lindt);
		p1.ajouterTransformateur(t3);

		marcheProducteur.ajouterProducteur(p1);
		marcheProducteur.ajouterProducteur(p2);
		marcheProducteur.ajouterTransformateur(nestle);
		marcheProducteur.ajouterTransformateur(lindt);
		
		p2.ajoutClient(nestle);
		p2.ajoutClient(lindt);

		p2.ajoutClient(t3);		
		p2.AjoutVariableVente();

	}
}

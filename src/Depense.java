/**
 *
 * @author POUROUCHOTTAMANE Srivatsa
 */

//Classe Depense qui permettra de gérer les dépenses des usagers
public class Depense {
	private String type;
	private float valeur;
	private Projet projet;
	
	public Depense(String type, float valeur, Projet projet)
	{
		this.type=type;
		this.valeur=valeur;
		this.projet=projet;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getValeur() {
		return valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String toString() {
		
		return this.getType();
		
	}
	
	

}

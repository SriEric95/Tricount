import java.util.ArrayList;

/**
*
* @author POUROUCHOTTAMANE Srivatsa
*/

//Classe Projet permettant de gérer les usagers du projet 
public class Projet {
	private String nom;
	private ArrayList<Usager> listUsager;
	private float prix;
	private String description;
	
	public Projet(String nom,float prix) {
		this.nom=nom;
		this.prix=prix;
		listUsager = new ArrayList<Usager>();
	}
	
	//Ajouter un usager à la liste
	public void ajoutUsager(Usager u) {
		listUsager.add(u);
	}
	 //Supprimer un usager de la liste
	public void suppUsager(Usager u) {
		listUsager.remove(u);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Usager> getListUsager() {
		return listUsager;
	}

	public void setListUsager(ArrayList<Usager> listUsager) {
		this.listUsager = listUsager;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return this.nom;
	}
	
	//Calcul total des dépense pour le projet
	public float totaldep() {
		
		float total=0;
    	for (int i = 0; i < this.getListUsager().size(); i++) {
    		for(int j=0; j< this.getListUsager().get(i).getListdepense().size();j++)
    		{
    			total=total+this.getListUsager().get(i).getListdepense().get(j).getValeur();
        	  //System.out.println(p.getListUsager().get(i)+" dépense :"+p.getListUsager().get(i).getListdepense().get(j).getType()); 
    		}
    	}
    	return total;
	}
	
	public float equilibre() {
		
		
		return this.totaldep()/this.getListUsager().size();
	}

}

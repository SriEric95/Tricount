import java.util.ArrayList;

/**
 *
 * @author POUROUCHOTTAMANE Srivatsa
 */

// Classe usager qui contient la liste des dépenses de l'usager et ses projets
public class Usager {
    private String nom;
    private ArrayList<Depense> listdepense;
    private ArrayList<Projet> listProjet;
    
    public Usager( String nom){
        this.nom=nom;
        this.listdepense=new ArrayList<Depense>();
        listProjet=new ArrayList<Projet>();
    }
    
    //Ajouter une dépense pour l'usager
    public void ajoutDepense(Depense d) {
    	this.listdepense.add(d);
    }
    
    //Supprimer une dépense pour l'usager
    public void suppDepense(Depense d) {
    	this.listdepense.remove(d);
    }
     
    public ArrayList<Projet> getListProjet() {
		return listProjet;
	}

	public void setListProjet(ArrayList<Projet> listProjet) {
		this.listProjet = listProjet;
	}

	public String getNom(){
        return this.nom;
    }
    
    public ArrayList<Depense> getListdepense() {
		return listdepense;
	}

	public void setListdepense(ArrayList<Depense> listdepense) {
		this.listdepense = listdepense;
	}

	public String toString() {
		return this.nom;
	}
    
    
    
    
    
    
    
}

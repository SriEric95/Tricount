import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
*
* @author POUROUCHOTTAMANE Srivatsa
*/

// Classe Tricount contenant la liste des projets
public class Tricount {
	private ArrayList<Projet> listProjet;
	
	
	public Tricount() {
		listProjet=new ArrayList<Projet>();
	}
	
	//Ajouter un Projet au Tricount
	public void ajoutProjet(Projet p)
	{
		listProjet.add(p);
	}
	
	//Supprimer un Projet au Tricount
	public void suppProjet(Projet p) {
		listProjet.remove(p);
	}
   
	public ArrayList<Projet> getListProjet() {
		return listProjet;
	}

	public void setListProjet(ArrayList<Projet> listProjet) {
		this.listProjet = listProjet;
	}
	
	public static void main(String[] args) {
	        
		JOptionPane info;
		//Boîte du message d'information
		info = new JOptionPane();
		info.showMessageDialog(null, "Bienvenu sur Tricount ! Si vous rencontrez des problèmes d'affichage veuillez agrandir la fenêtre Tricount, actualiser les combobox pour synchronisation", "Information", JOptionPane.INFORMATION_MESSAGE);
	    Menu m=new Menu();
	    
	    
	    	 
	 }
    
}

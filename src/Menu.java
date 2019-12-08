import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.management.ValueExp;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;


/**
*
* @author POUROUCHOTTAMANE Srivatsa
*/

//Classe Menu qui permettra de gérer le Tricount
public class Menu extends JFrame implements ActionListener{
    
   private JLabel titre;
   private JButton creerprojet;
   private JButton supprojet;
   private JButton equilibre;
   private JButton bilan;
   private JPanel panelCreationProjet;
   private JPanel panelbtn;
   private JLabel Nomprojet;
   private JLabel listprojet;
   private JComboBox<Projet> comboprojet;
   private JTextField textprojet;
   
   private JLabel NomUsager;
   private JLabel listUsager;
   private JTextField textUsager;
   private JComboBox<Usager>comboUsager;
   private JButton ajoutUsager;
   private JButton suppUsager;
   private JPanel panelUsager;
   private Box b;
   private Box b1;
   
   private JLabel listUsagerdepense;
   private JLabel typeDepense;
   private JLabel montant; 
   private JTextField textdepense;
   private JTextField textmontant;
   private JComboBox<Usager> personneDepense;
   private JComboBox<Depense> listDepense;
   private JLabel lbldepense; 
   private JButton ajouterDepense;
   private JButton supprimerDepense;
   private JButton bilandepense;
   private JPanel panelDepense;
   private Box b2;
   private Box b3;
   
   private Box bfinal;
   
   private Projet projet;
   private Tricount tricount;
   private Usager usager;
   private Depense depense;
   
   private JPanel panBilan;
   private JPanel panEquilibre;
   
   private JLabel labelBilan;
   private JLabel labelEq;
   
   //Initialisation des paramètre de la fenêtre
    public Menu(){
        
        this.setTitle("Tricount");
        this.setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tricount=new Tricount();
        
        Nomprojet=new JLabel("Nom projet :");
        listprojet=new JLabel("Liste projets :");
        comboprojet=new JComboBox<>();
        textprojet=new JTextField();

        titre=new JLabel("Bienvenu");
        creerprojet=new JButton("Creer");
        creerprojet.setActionCommand("Creer");
        supprojet=new JButton("supprimer");
        bilan=new JButton("Bilan Graphique");
        equilibre=new JButton("Equilibre");
        
        
        NomUsager=new JLabel("Nom usager :");
        listUsager=new JLabel("Liste participant : ");
        comboUsager=new JComboBox<>();
        textUsager=new JTextField();
        ajoutUsager=new JButton("Ajouter");
        suppUsager=new JButton("Supprimer");
        
        typeDepense=new JLabel("Type depense");
        listUsagerdepense=new JLabel("Qui fait la dépense ?");
        typeDepense.setSize(10, 2);
        montant=new JLabel("Montant");
        lbldepense=new JLabel("Liste dépense");
        textdepense=new JTextField();
        textmontant=new JTextField();
        personneDepense=new JComboBox<Usager>();
        listDepense=new JComboBox<Depense>();
        ajouterDepense=new JButton("Ajouter depense");
        supprimerDepense=new JButton("Supprimer");
        bilandepense=new JButton("Bilan chiffré");
 
        comboprojet.addActionListener(this);
        comboUsager.addActionListener(this);
        personneDepense.addActionListener(this);
        listDepense.addActionListener(this);
        
        creerprojet.addActionListener(this);
        supprojet.addActionListener(this);       
        
        ajoutUsager.addActionListener(this);
        suppUsager.addActionListener(this);
        
        ajouterDepense.addActionListener(this);
        supprimerDepense.addActionListener(this);
        bilandepense.addActionListener(this);
        equilibre.addActionListener(this);
        
        //
        GridLayout gl = new GridLayout(1,1);
        gl.setHgap(5);
        gl.setVgap(10);
        
        //Panel contenant les composants partie 'Création de projet'
        b=Box.createHorizontalBox();
        b.setBorder(BorderFactory.createTitledBorder( "Création de projet"));
        b.add(Nomprojet);
        b.add(textprojet);
        b.add(listprojet);
        b.add(comboprojet);
        b.add(creerprojet);
        b.add(supprojet);
        b.add(equilibre);
        b.add(bilan);
    
        //Panel contenant les composants partie 'Ajout de participants'
        b1=Box.createHorizontalBox();
        b1.setBorder(BorderFactory.createTitledBorder( "Ajout de participants"));
        b1.add(NomUsager);
        b1.add(textUsager);
        textUsager.setMaximumSize(new Dimension(Integer.MAX_VALUE, textUsager.getMinimumSize().height));
        b1.add(listUsager);
        b1.add(comboUsager);
        b1.add(ajoutUsager);
        b1.add(suppUsager);
        
        //Panel contenant les composants partie 'Les dépenses'
        b2=Box.createHorizontalBox();
        b2.setBorder(BorderFactory.createTitledBorder( "Les dépenses"));
        b2.add(typeDepense);
        b2.add(textdepense);
        b2.add(montant);
        b2.add(textmontant);
        b2.add(listUsagerdepense);
        b2.add(personneDepense);
        b2.add(lbldepense);
        b2.add(listDepense);
        b2.add(ajouterDepense);
        b2.add(supprimerDepense);
        b2.add(bilandepense);
        
        b3=Box.createHorizontalBox();
        
        //Panel contenant tous les composants '
        bfinal = Box.createVerticalBox();
        bfinal.add(b);
        bfinal.add(b1);
        bfinal.add(b2);
        bfinal.add(b3);
        
        //Panel contenant le composants partie 'Panel le bilan à droite'
        panBilan = new JPanel();
        panBilan.setName("panEQ");
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(panBilan,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,300));
        panBilan.setBackground(Color.white);
        panBilan.setPreferredSize(new Dimension(500, 300));
        panBilan.setBorder(BorderFactory.createTitledBorder("Bilan"));
        
        //Panel contenant le composants partie 'Panel équilibre à gauche'
        panEquilibre = new JPanel();
        panBilan.setName("panEQ");
        JScrollPane scrollPane2;
        scrollPane2 = new JScrollPane(panEquilibre,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setPreferredSize(new Dimension(300,300));
        panEquilibre.setBackground(Color.white);
        panEquilibre.setPreferredSize(new Dimension(500, 100));
        panEquilibre.setBorder(BorderFactory.createTitledBorder("Equilibre"));
        
        //Position des panels
        getContentPane().add(panBilan, BorderLayout.WEST);
        getContentPane().add(panEquilibre, BorderLayout.EAST);
        getContentPane().add(bfinal,BorderLayout.NORTH);
        
        //Rendre visible la fenêtre
        setVisible(true);
        
    }

	public void actionPerformed(ActionEvent e) {
		
		//Créer un projet
		if(e.getSource()==this.creerprojet)
		{	JOptionPane  info;
			if(this.textprojet.getText().length()==0) {
				info = new JOptionPane();
				info.showMessageDialog(null, "Veuillez remplir le champ projet !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				this.projet=new Projet(this.textprojet.getText(), 500);
				this.tricount.ajoutProjet(projet);
				this.comboprojet.addItem(projet);
			}
		}
		
		//Créer un projet des combobox projets et le combobox 'qui fait la dépense' 
		if(e.getSource()==this.comboprojet)  {
			if(this.comboprojet.getSelectedItem()!=null)  {
               
				// on dit que le projet courant est celui sélectionné
				projet = (Projet)this.comboprojet.getSelectedItem(); 
        
                this.comboUsager.removeAllItems();
				for(Usager usager : projet.getListUsager()) {
					this.comboUsager.addItem(usager);
				}
				
				this.personneDepense.removeAllItems();
				for(Usager usager : projet.getListUsager()) {
					this.personneDepense.addItem(usager);
				}
				
				this.listDepense.removeAllItems();
				for(int i=0;i<projet.getListUsager().size();i++)
				{
					for(int j=0; j<usager.getListdepense().size();j++)
					{
						this.listDepense.addItem(usager.getListdepense().get(j));
					}
				}
			
			}
		}
		if(e.getSource()==this.personneDepense)  {
			if(this.personneDepense.getSelectedItem()!=null)  {
				
                usager = (Usager)this.personneDepense.getSelectedItem(); 
            
                
                this.listDepense.removeAllItems();
				for(Depense d : usager.getListdepense()) {
					this.listDepense.addItem(d);
				}
				
				for(int j=0; j<usager.getListdepense().size();j++)
		        {
	        		System.out.println(" dépense:"+usager.getListdepense().get(j).getType());
		        }
			}
		}
		
		//supprimer projet
		if(e.getSource()==this.supprojet)
		{
			this.tricount.suppProjet(projet);
			this.comboprojet.removeItem(projet);
		}
		
		//ajouter des usager
		if(e.getSource()==this.ajoutUsager)
		{	
			JOptionPane  info;
			if(this.textUsager.getText().length()==0) {
				info = new JOptionPane();
				info.showMessageDialog(null, "Veuillez remplir le champ usager !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else {
				this.usager=new Usager(this.textUsager.getText());
				this.projet.ajoutUsager(usager);
				this.comboUsager.addItem(usager);
				
				for(Projet p: tricount.getListProjet()) 
				{
					for(Usager u: p.getListUsager())
					{
						System.out.println(p.getNom()+ " : "+u.getNom());
					}
				}
			}
		}
		
		//supprimer des usager
		if(e.getSource()==this.suppUsager)
		{
			this.projet.suppUsager(usager);
			this.comboUsager.removeItem(usager);
			this.personneDepense.removeItem(usager);
		}
		
		//ajouter des dépenses pour l'usager correspondant au combobox
		if(e.getSource()==this.ajouterDepense)
		{	
			JOptionPane  info;
			if(this.textmontant.getText().length()==0 || this.textdepense.getText().length()==0) {
				info = new JOptionPane();
				info.showMessageDialog(null, "Veuillez remplir les champs dépenses !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String montant=this.textmontant.getText();
				float amount=Float.parseFloat(montant);
				 projet = (Projet)this.comboprojet.getSelectedItem();
				depense=new Depense(this.textdepense.getText(),amount,this.projet);
				usager = (Usager)this.personneDepense.getSelectedItem();
				this.usager.ajoutDepense(depense);
				this.listDepense.addItem(depense);
				
				System.out.println(projet.getNom()+ " : "+usager.getNom()+" dépense :"+ depense.getType()+"/"+depense.getValeur()+"/"+depense.getProjet());
			}
		}
		
		//supprimer les dépenses de l'usager correspondant à la valeur du combobox
		if(e.getSource()==this.supprimerDepense)
		{
			usager = (Usager)this.personneDepense.getSelectedItem();
			this.usager.suppDepense(depense);
			this.listDepense.removeItem(depense);
		}
		
		//Affichage du bilan, détails des dépenses des usagers du projet
		if(e.getSource()==this.bilandepense)
		{
			JOptionPane  info;
			if(tricount.getListProjet().size()==0) {
				info = new JOptionPane();
				info.showMessageDialog(null, "Créer un projet avant d'afficher le bilan !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		else {
			 String TabBilan="<html>\n\n<table>\n";
             TabBilan +="<tr>"+"<th> Les dépenses prévue pour projet :</th>"+" "+projet.getNom()+"</tr>"+
            		 	"<tr>\n"+
                         "<td>Nom Participants</td>\n"+
                         "<td>Type dépense</td>\n"+
                         "<td>Montant</td>\n"+
                         "</tr>\n";
             
          for (int i = 0; i < projet.getListUsager().size(); i++) {
        	  for(int j=0; j< projet.getListUsager().get(i).getListdepense().size();j++)
        	  {
        		  TabBilan += "<tr>\n"+
                          "<td>"+projet.getListUsager().get(i)+"</td>\n"+
                          "<td>"+projet.getListUsager().get(i).getListdepense()+"</td>"+
                          "<td>"+projet.getListUsager().get(i).getListdepense().get(j).getValeur()+"€</td>\n"+
                          "</tr>\n";
        	  }
		  			
          }
          
	         TabBilan+="<tr><td>Total : "+ projet.totaldep()+"€</td></tr>\n";
	         TabBilan += "</table>\n\n</html>";
	         labelBilan = new JLabel(TabBilan);
	         panBilan.add(labelBilan);
		}
	
		}
		
		//L'équilibre
		if(e.getSource()==this.equilibre)
		{
			JOptionPane  info;
			if(tricount.getListProjet().size()==0) {
				info = new JOptionPane();
				info.showMessageDialog(null, "Créer un projet avant de calculer l'équilibre !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else {
				float valEq = 0;
				valEq=projet.equilibre();
				String TabEq="<html>\n\n<table>\n";
				TabEq +="<tr>"+"<th> Les dépenses des participants Projet:</th>"+" "+projet.getNom()+"</tr>"+
	        		 	"<tr>\n"+
	                     "<td>Nom Participants</td>\n"+
	                     "<td>Montant</td>\n"+
	                     "</tr>\n";
				
				for (int i = 0; i < projet.getListUsager().size(); i++) {
		        		  TabEq += "<tr>\n"+
		                          "<td>"+projet.getListUsager().get(i)+"</td>\n"+
		                          "<td>"+valEq+"€</td>\n"+
		                          "</tr>\n";  			
		         }
				
				TabEq+="<tr><td>Total : "+ projet.totaldep()+"€</td></tr>\n";
		        TabEq += "</table>\n\n</html>";
				labelEq=new JLabel(TabEq);
				panEquilibre.add(labelEq);
			}
			
		}
	}
}
	

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Evenement
{
	private Direction direction;
	private boolean bloquant;
	private final String[][] actions;
	private final String nom;
	private BufferedImage apparence;
	private boolean[] interrupteursLocaux;
	
	private enum Action {
		MESSAGE, // MESSAGE message
		TELEPORTER, // TELEPORTER carte x y
		INTERRUPTEUR, // INTERRUPTEUR id_interrupteur
		APPARENCE, // APPARENCE url_texture [carte nom_evenement]
		COLLISION, // COLLISION true/false [carte nom_evenement]
		CHOIX, // CHOIX option1 id_branche_option1 option2 id_branche_option2 question
		ALLERA, // ALLERA id_branche id_action
		TESTERMOI, // TESTERMOI id_interrupteur id_branche_option_si_on id_branche_option_si_off
		TESTEREVENT; // TESTEREVENT id_interrupteur id_branche_option_si_on id_branche_option_si_off [carte nom_evenement]
	}

	public Evenement(String nom, String texture_url, Direction direction, boolean bloquant, String[][] actions)
	{
		this.actions = actions;
		this.apparence = null;
		try {
			this.apparence = ImageIO.read(new File(texture_url));
		} catch (IOException e) {
		}
		this.direction = direction;
		this.bloquant = bloquant;
		this.nom = nom;
		this.interrupteursLocaux = new boolean[5];
	}
	
	public Image obtenirApparence() {
		BufferedImage img_event_decoupe = new BufferedImage(apparence.getWidth(null), apparence.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = img_event_decoupe.createGraphics();
		bGr.drawImage(apparence, 0, 0, null);
		bGr.dispose();
		
		return img_event_decoupe.getSubimage(0,this.direction.obtenirIndexTexture()*Application.HAUTEUR_TILE,Application.LARGEUR_TILE, Application.HAUTEUR_TILE);
	}
	
	public boolean estBloquant() {
		return this.bloquant;
	}
	
	public void changerBloquant(boolean nouvelEtat) {
		this.bloquant = nouvelEtat;
	}
	
	public void changerApparence(String texture_url) {
		this.apparence = null;
		try {
			this.apparence = ImageIO.read(new File(texture_url));
		} catch (IOException e) {
		}
	}
	
	public boolean testerInterrupteur(int idInterrupteur) {
		return this.interrupteursLocaux[idInterrupteur];
	}
	
	public void modifierInterrupteur(int idInterrupteur) {
		this.interrupteursLocaux[idInterrupteur] = !this.interrupteursLocaux[idInterrupteur];
	}

	public void effectuerActions(IHM ihm) {
		int indexAction;
		String[] actionCourante;
		int indexBranche = 0;
		Evenement cible;
		for(indexAction = 0; indexAction < this.actions[0].length; indexAction++)
		{
			if(actions[indexBranche][indexAction]!=null)
			{
				actionCourante = actions[indexBranche][indexAction].split(" ");
				switch(Action.valueOf(actionCourante[0]))
				{
					case MESSAGE:
						String message = "";
						for(int i = 1; i<actionCourante.length; i++)
						{
							message += actionCourante[i]+" ";
						}
						ihm.afficherMessage(this.nom, message);
						message = null;
						break;
					case TELEPORTER:
						ihm.renvoyerPartie().changerCarte(actionCourante[1], new Position(Integer.parseInt(actionCourante[2]),Integer.parseInt(actionCourante[3])));
						break;
					case INTERRUPTEUR:
						this.interrupteursLocaux[Integer.parseInt(actionCourante[1])] = !this.interrupteursLocaux[Integer.parseInt(actionCourante[1])];
						break;
					case APPARENCE:
						cible = this;
						if(actionCourante.length>2)
							cible = recupererEvenement(ihm.renvoyerPartie().obtenirEnsembleCartes().get(actionCourante[2]),actionCourante[3]);
						cible.changerApparence(actionCourante[1]);
						break;
					case COLLISION:
						cible = this;
						if(actionCourante.length>2)
							cible = recupererEvenement(ihm.renvoyerPartie().obtenirEnsembleCartes().get(actionCourante[2]),actionCourante[3]);
						cible.changerBloquant(Boolean.valueOf(actionCourante[1]));
						break;
					case CHOIX:
						String question = "";
						for(int i = 5; i<actionCourante.length; i++)
						{
							question += actionCourante[i]+" ";
						}
						int reponse = ihm.proposerChoix(this.nom, question, new String[] {actionCourante[1], actionCourante[3]});
						if(reponse == 0)
							indexBranche = Integer.parseInt(actionCourante[2]);
						else
							indexBranche = Integer.parseInt(actionCourante[4]);
						question = null;
						break;
					case ALLERA:
						indexBranche = Integer.parseInt(actionCourante[1]);
						indexAction = Integer.parseInt(actionCourante[2]);
						indexAction--;
						break;
					case TESTERMOI:
						if(this.testerInterrupteur(Integer.parseInt(actionCourante[1])))
							indexBranche = Integer.parseInt(actionCourante[2]);
						else
							indexBranche = Integer.parseInt(actionCourante[3]);
						break;
					case TESTEREVENT:
						cible = this;
						if(actionCourante.length>4)
							cible = recupererEvenement(ihm.renvoyerPartie().obtenirEnsembleCartes().get(actionCourante[4]),actionCourante[5]);
						if(cible.testerInterrupteur(Integer.parseInt(actionCourante[1])))
							indexBranche = Integer.parseInt(actionCourante[2]);
						else
							indexBranche = Integer.parseInt(actionCourante[3]);
						break;
				}
			}
		}
	}

	private Evenement recupererEvenement(Carte carte, String nom_event) {
		Position position;
		for (int ligne = 0; ligne < carte.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < carte.obtenirLargeur(); colonne++)
			{
				position = new Position(ligne,colonne);
				if(carte.evenementPresent(position))
				{
					if(carte.obtenirEvenement(position).obtenirNom().equals(nom_event))
					{
						return carte.obtenirEvenement(position);
					}
				}
			}
		}
		return null;
	}

	private String obtenirNom() {
		return this.nom;
	}
}

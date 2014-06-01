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
		MESSAGE, TELEPORTER, INTERRUPTEUR;
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
	
	public void changerBloquant() {
		this.bloquant = !this.bloquant;
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
		for(indexAction = 0; indexAction < this.actions[0].length; indexAction++)
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
			}
		}
	}
}

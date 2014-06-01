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
		this.interrupteursLocaux = new boolean[4];
	}
	
	public Image obtenirApparence() {
		BufferedImage img_event_decoupe = new BufferedImage(apparence.getWidth(null), apparence.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = img_event_decoupe.createGraphics();
		bGr.drawImage(apparence, 0, 0, null);
		bGr.dispose();
		
		return img_event_decoupe.getSubimage(0,this.direction.obtenirIndexTexture()*32,32,32);
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

}

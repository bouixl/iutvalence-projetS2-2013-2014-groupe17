import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Evenement
{
	private final String texture_url;
	private Direction direction;
	private boolean bloquant;
	private final String[][] actions;
	private final String nom;

	public Evenement(String nom, String texture_url, Direction direction, boolean bloquant, String[][] actions)
	{
		this.actions = actions;
		this.texture_url = texture_url;
		this.direction = direction;
		this.bloquant = bloquant;
		this.nom = nom;
	}
	
	public Image obtenirApparence() {
		ImageIcon texture = new ImageIcon(this.texture_url);
		Image img_event = texture.getImage();
		if(this.direction != Direction.HAUT)
		{
			BufferedImage img_event_decoupe = new BufferedImage(img_event.getWidth(null), img_event.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		    Graphics2D bGr = img_event_decoupe.createGraphics();
		    bGr.drawImage(img_event, 0, 0, null);
		    bGr.dispose();
		
			img_event = img_event_decoupe.getSubimage(0,this.direction.obtenirIndexTexture()*32,32,32);
		}
		return img_event;
	}
	
	public boolean estBloquant() {
		return this.bloquant;
	}
	
	public void changerBloquant() {
		this.bloquant = !this.bloquant;
	}

}

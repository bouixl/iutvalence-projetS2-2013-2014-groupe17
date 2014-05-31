import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class Equipe
{
	
	private Position position;
	private Direction direction;
	private Personnage[] composition; 
	
	public Equipe()
	{
		this.position = new Position(7,7);
		this.direction = Direction.BAS;
		this.composition = new Personnage[4];
		this.composition[0] = new Personnage("Bob", Classes.ASSASSIN);
		this.composition[1] = new Personnage("Bub", Classes.BARBARE);
		this.composition[2] = new Personnage("Bib", Classes.DRUIDE);
		this.composition[3] = new Personnage("Bab", Classes.MAGISTER);
	}
	
	public Position obtenirPosition()
	{
		return this.position;
	}

	public void deplacer(Direction direction)
	{
		this.direction = direction;
		this.position = this.position.ajouterOffset(direction);
	}
	public void changerDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	public Direction obtenirDirection()
	{
		return this.direction;
	}
	
	public Image obtenirApparence()
	{
		ImageIcon texture = new ImageIcon("textures/personnages/equipe.png");
		Image img_equipe = texture.getImage();

		BufferedImage img_equipe_decoupe = new BufferedImage(img_equipe.getWidth(null), img_equipe.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = img_equipe_decoupe.createGraphics();
	    bGr.drawImage(img_equipe, 0, 0, null);
	    bGr.dispose();

		img_equipe = img_equipe_decoupe.getSubimage(0,this.direction.obtenirIndexTexture()*32,32,32);

		return img_equipe;
	}
	
	public void ajouterPersonnage(Personnage personnage, int emplacement)
	{
		this.composition[emplacement] = personnage;
	}

	public int obtenirNiveauMoyen() {
		int niveauMoyen = 0;
		for (int i = 0; i < this.composition.length; i++)
		{
			niveauMoyen += this.composition[i].obtenirNiveau();
		}
		niveauMoyen /= this.composition.length;
		return niveauMoyen;
	}
	
	
}


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Equipe
{
	private Position position;
	private Direction direction;
	private Personnage[] composition;
	private BufferedImage apparence;
	private Inventaire inventaire;
	
	public Equipe()
	{
		this.position = new Position(7,7);
		this.inventaire = new Inventaire();
		this.direction = Direction.BAS;
		this.apparence = null;
		try {
			this.apparence = ImageIO.read(new File("textures/personnages/equipe.png"));
		} catch (IOException e) {
		}
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
	
	public Inventaire obtenirInventaire()
	{
		return this.inventaire;
	}
	
	public BufferedImage obtenirApparence()
	{
		BufferedImage img_equipe_decoupe = new BufferedImage(apparence.getWidth(null), apparence.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = img_equipe_decoupe.createGraphics();
	    bGr.drawImage(apparence, 0, 0, null);
	    bGr.dispose();

		return img_equipe_decoupe.getSubimage(0,this.direction.obtenirIndexTexture()*Application.HAUTEUR_TILE,Application.LARGEUR_TILE, Application.HAUTEUR_TILE);
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

	public void forcerPosition(Position position) {
		this.position = position;
	}
	
	
}


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Carte
{
	private final Tile[][] cases;
	private final int largeur;
	private final int hauteur;
	private HashMap<Position, Evenement> evenements;
	private boolean combatsAleatoires;

	public Carte(Tile[][] cases, int largeur, int hauteur, boolean combatsAleatoires)
	{
		this.cases = cases;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.evenements = new HashMap<Position, Evenement> ();
		this.combatsAleatoires = combatsAleatoires;
	}

	public boolean obtenirCombatAleatoires() {
		return this.combatsAleatoires;
	}
	public int obtenirLargeur() {
		return this.largeur;
	}
	public int obtenirHauteur() {
		return this.hauteur;
	}

	public Image obtenirCase(Position position) {
		int indexCase = position.obtenirColonne()+(this.largeur*(position.obtenirLigne()));
		
		BufferedImage img_case = new BufferedImage(32, 32, 1);
		Graphics2D g2 = img_case.createGraphics();
		g2.drawImage(cases[0][indexCase].obtenirApparence(), 0, 0, null);
		if (indexCase-1 >= 0 && cases[0][indexCase] != Tile.MUR_PIERRE && cases[0][indexCase] != Tile.SOL_TROU)
		{
			if (cases[0][indexCase-1] == Tile.MUR_PIERRE && position.obtenirColonne()!=0)
			{
				g2.drawImage(Tile.OMBRE.obtenirApparence(), 0, 0, null);
			}
		}
		if (cases[1][indexCase] != null)
		{
			g2.drawImage(cases[1][indexCase].obtenirApparence(), 0, 0, null);
		}
		g2.dispose();
		
		return img_case;
	}
	
	public Evenement obtenirEvenement(Position position) {
		return evenements.get(position);
	}

	public boolean peutAller(Direction direction, Position position) 
	{
		Position positionArrivee = position.ajouterOffset(direction);
		int indexCase = positionArrivee.obtenirColonne()+(this.largeur*(positionArrivee.obtenirLigne()));
		
		if (positionArrivee.estValideDansCarte(this))
		{
			if (cases[0][indexCase].estBloquant())
				return false;
			if (cases[1][indexCase] != null)
			{
				if (cases[1][indexCase].estBloquant())
					return false;
			}
			if(evenementPresent(positionArrivee))
			{
				if (obtenirEvenement(positionArrivee).estBloquant())
					return false;
			}
			return true;
		}
		return false;
	}

	public boolean evenementPresent(Position position) {
		return evenements.containsKey(position);
	}
	
	public void ajouterEvenement(Position position, Evenement evenement) {
		this.evenements.put(position, evenement);
	}
	
	public void retirerEvenement(Position position) {
		this.evenements.remove(position);
	}
}

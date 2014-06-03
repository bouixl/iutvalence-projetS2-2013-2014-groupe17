import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Carte
{
	private Tile[][] cases;
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
		g2.drawImage(this.cases[0][indexCase].obtenirApparence(), 0, 0, null);
		if (indexCase-1 >= 0 && this.cases[0][indexCase] != Tile.MUR_PIERRE && this.cases[0][indexCase] != Tile.SOL_TROU)
		{
			if (this.cases[0][indexCase-1] == Tile.MUR_PIERRE && position.obtenirColonne()!=0)
			{
				g2.drawImage(Tile.OMBRE.obtenirApparence(), 0, 0, null);
			}
		}
		if (this.cases[1][indexCase] != null)
		{
			g2.drawImage(this.cases[1][indexCase].obtenirApparence(), 0, 0, null);
		}
		g2.dispose();
		
		return img_case;
	}
	
	public Evenement obtenirEvenement(Position position) {
		return this.evenements.get(position);
	}

	public boolean peutAller(Direction direction, Position position) 
	{
		Position positionArrivee = position.ajouterOffset(direction);
		int indexCase = positionArrivee.obtenirColonne()+(this.largeur*(positionArrivee.obtenirLigne()));
		
		if (positionArrivee.estValideDansCarte(this))
		{
			if (this.cases[0][indexCase].estBloquant())
				return (Partie.GHOST || false);
			if (this.cases[1][indexCase] != null)
			{
				if (this.cases[1][indexCase].estBloquant())
					return (Partie.GHOST || false);
			}
			if(evenementPresent(positionArrivee))
			{
				if (obtenirEvenement(positionArrivee).estBloquant())
					return (Partie.GHOST || false);
			}
			return true;
		}
		return false;
	}

	public boolean evenementPresent(Position position) {
		return this.evenements.containsKey(position);
	}
	
	public void ajouterEvenement(Position position, Evenement evenement) {
		this.evenements.put(position, evenement);
	}
	
	public void retirerEvenement(Position position) {
		this.evenements.remove(position);
	}
	
	public void setCase(Position position, Tile tile, int couche) {
		int indexCase = position.obtenirColonne()+(this.largeur*(position.obtenirLigne()));
		
		this.cases[couche][indexCase] = tile;
	}

	public String toString()
	{
		String chaine = "this.ensemble_cartes.put(\"UneCarte\", new Carte(new Tile[][] {{";
		int indexCase;
		Position position;
		for (int ligne = 0; ligne < this.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < this.obtenirLargeur(); colonne++)
			{
				position = new Position(ligne,colonne);
				indexCase = position.obtenirColonne()+(this.largeur*(position.obtenirLigne()));
				chaine += "Tile."+this.cases[0][indexCase].name();
				if(indexCase+1!=this.largeur*this.hauteur)
					chaine+=",";
			}
		}
		chaine += "},{";
		for (int ligne = 0; ligne < this.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < this.obtenirLargeur(); colonne++)
			{
				position = new Position(ligne,colonne);
				indexCase = position.obtenirColonne()+(this.largeur*(position.obtenirLigne()));
				if(this.cases[1][indexCase] != null)
					chaine += "Tile."+this.cases[1][indexCase].name();
				else
					chaine += "null";
				if(indexCase+1!=this.largeur*this.hauteur)
					chaine+=",";
			}
		}
		chaine += "}},"+this.obtenirLargeur()+","+this.obtenirHauteur()+",false));";
		return chaine;
	}
}

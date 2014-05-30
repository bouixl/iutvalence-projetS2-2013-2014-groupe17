import javax.swing.ImageIcon;


public class Equipe
{
	
	private int ligne;
	private int colonne;
	private String orientation;
	private Personnage[] composition; 
	
	public Equipe()
	{
		this.ligne = 7;
		this.colonne = 7;
		this.orientation = "bas";
		this.composition = new Personnage[4];
		this.composition[0] = new Personnage("Bob", Classes.ASSASSIN);
		this.composition[1] = new Personnage("Bub", Classes.BARBARE);
		this.composition[2] = new Personnage("Bib", Classes.DRUIDE);
		this.composition[3] = new Personnage("Bab", Classes.MAGISTER);
	}
	
	public int obtenirLigne()
	{
		return this.ligne;
	}

	public int obtenirColonne()
	{
		return this.colonne;
	}
	
	public void deplacer(int direction)
	{
		switch (direction)
		{
			case 0:
				this.orientation = "haut";
				this.ligne--;
				break;
			case 1:
				this.orientation = "droite";
				this.colonne++;
				break;
			case 2:
				this.orientation = "bas";
				this.ligne++;
				break;
			case 3:
				this.orientation = "gauche";
				this.colonne--;
				break;
		}
	}
	public void changerDirection(int direction)
	{
		switch (direction)
		{
			case 0:
				this.orientation = "haut";
				break;
			case 1:
				this.orientation = "droite";
				break;
			case 2:
				this.orientation = "bas";
				break;
			case 3:
				this.orientation = "gauche";
				break;
		}
	}
	
	public String obtenirOrientation()
	{
		return this.orientation;
	}
	
	public ImageIcon obtenirApparence()
	{
		return new ImageIcon(this.orientation+".png");
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


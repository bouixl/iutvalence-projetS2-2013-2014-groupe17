import javax.swing.ImageIcon;

public enum Carte
{
	CARTE_DEPART(new Tile[][] 
		{
			{Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
			{Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR}
		},
		new Evenement[][] 
		{
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,new Evenement("livre",new ImageIcon("livre.png"),true,null),Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL},
			{Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL,Evenement.NULL}
		},
		true);
	
	private final Tile[][] cases;
	private final int largeur;
	private final int hauteur;
	private Evenement[][] evenements;
	private boolean combatsAleatoires;

	private Carte(Tile[][] cases, Evenement[][] evenements, boolean combatsAleatoires)
	{
		this.cases = cases;
		this.hauteur = cases.length;
		this.largeur = cases[0].length;
		this.evenements = evenements;
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

	public Tile obtenirTile(int ligne, int colonne) {
		return cases[ligne][colonne];
	}
	
	public Evenement obtenirEvenement(int ligne, int colonne) {
		return evenements[ligne][colonne];
	}

	public boolean peutAller(int direction, int ligne, int colonne) 
	{
		int x = ligne;
		int y = colonne;
		switch (direction)
		{
			case 0:
				x--;
				break;
			case 1:
				y++;
				break;
			case 2:
				x++;
				break;
			case 3:
				y--;
				break;
		}
		if ((x < cases.length) && (y < cases[0].length) && (x >= 0) && (y >= 0))
		{
			if (cases[x][y].estBloquant() || evenements[x][y].estBloquant())
				return false;
			return true;
		}
		return false;
	}
}

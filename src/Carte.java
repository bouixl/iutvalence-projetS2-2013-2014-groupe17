public enum Carte
{
	CARTE_DEPART;
	
	private final Tile[][] cases;
	private final int largeur;
	private final int hauteur;
	private Evenement[] evenements;
	private boolean combatsAleatoires;

	private Carte()
	{
		Tile[][] cases = {
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
						};
		this.cases = cases;
		this.hauteur = cases.length;
		this.largeur = cases[0].length;
		this.evenements = null;
		this.combatsAleatoires = true;
	}
	
	private Carte(Tile[][] cases, int largeur, int hauteur, Evenement[] evenements, boolean combatsAleatoires)
	{
		this.cases = cases;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.evenements = evenements;
		this.combatsAleatoires = combatsAleatoires;
	}
	
	public String toString()
	{
		String chaine = null;
		
		for(int i=0; i<this.hauteur; i++)
		{
			for(int j=0; j<this.largeur; j++)
			{
				chaine += this.cases[i][j].obtenirApparence();
			}
			chaine += "\n";
		}
		return chaine;
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
		if (cases[x][y].estBloquant())
			return false;
		return true;
	}
}

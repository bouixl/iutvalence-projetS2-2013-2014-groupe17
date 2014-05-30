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
		this.largeur = 10;
		this.hauteur = 8;
		Tile[][] cases = {
							{Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL},
							{Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.SOL},
							{Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL},
							{Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.MUR,Tile.MUR,Tile.SOL,Tile.SOL},
							{Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL},
							{Tile.SOL,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.MUR,Tile.SOL,Tile.MUR,Tile.SOL,Tile.SOL},
							{Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR},
							{Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.SOL,Tile.MUR,Tile.MUR}
						};
		this.cases = cases;
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
}

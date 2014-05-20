public enum Carte
{
	CARTE_DEPART;
	
	private final int[][] layers;
	private final int largeur;
	private final int hauteur;
	private Evenement[] evenements;
	private boolean combatsAleatoires;

	private Carte()
	{
		this.largeur = 10;
		this.hauteur = 8;
		int[][] layers = 	{
								{
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1,
									1,1,1,1,1,1,1,1,1,1
								},{
									0,0,0,0,0,0,0,0,0,0,
									0,2,0,0,0,0,5,0,0,0,
									0,0,0,0,0,0,0,0,2,0,
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,2,0,0,0,0,0,
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,0,0,0,0,0,0
								},{
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,0,0,4,0,0,0,
									0,0,0,0,0,0,0,0,0,0,
									0,0,0,0,3,0,0,0,0,0,
									0,2,0,0,0,0,0,0,0,0,
									0,0,0,0,0,0,0,0,0,0
								}
							};
		this.layers = layers;
		this.evenements = null;
		this.combatsAleatoires = false;
	}
	
	private Carte(int[][] layers, int largeur, int hauteur, Evenement[] evenements, boolean combatsAleatoires)
	{
		this.layers = layers;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.evenements = evenements;
		this.combatsAleatoires = combatsAleatoires;
	}
	
	public void afficher()
	{
		
	}
}

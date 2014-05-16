public enum Carte
{
	CARTE_DEPART();
	
	private Tile[][][] tiles;
	private Evenement[][] evenements;
	private boolean combatsAleatoire;

	private Carte(Tile[][][] tiles, Evenement[][] evenements, boolean combatsAleatoire)
	{
		this.tiles = tiles;
		this.evenements = evenements;
		this.combatsAleatoire = combatsAleatoire;
	}
}

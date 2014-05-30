public enum Tile
{
	SOL(' ',false),
	MUR('#',true);
	
	private final char apparence;
	private final boolean bloquant;
			
	private Tile(char apparence, boolean bloquant)
	{
		this.apparence = apparence;
		this.bloquant = bloquant;
	}
	
	public char obtenirApparence()
	{
		return this.apparence;
	}
	public boolean estBloquant()
	{
		return this.bloquant;
	}
}

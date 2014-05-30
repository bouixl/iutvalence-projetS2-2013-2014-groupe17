import javax.swing.ImageIcon;

public enum Tile
{
	VIDE("vide.png",false),
	SOL("sol.png",false),
	MUR("mur.png",true);
	
	private final ImageIcon apparence;
	private final String url;
	private final boolean bloquant;
			
	private Tile(String url, boolean bloquant)
	{
		this.apparence = new ImageIcon(url);
		this.url = url;
		this.bloquant = bloquant;
	}
	
	public ImageIcon obtenirApparence()
	{
		return this.apparence;
	}
	public String obtenirUrl()
	{
		return this.url;
	}
	public boolean estBloquant()
	{
		return this.bloquant;
	}
}

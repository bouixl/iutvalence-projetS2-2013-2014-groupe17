import javax.swing.ImageIcon;

public enum Tile
{
	MUR_PIERRE("textures/tiles/mur_pierre.png",true),
	SOL_PIERRE_1("textures/tiles/sol_pierre_1.png",false),
	SOL_PIERRE_2("textures/tiles/sol_pierre_2.png",false),
	SOL_BOIS("textures/tiles/sol_bois.png",false),
	SOL_TROU("textures/tiles/sol_trou.png",true),
	ROCHER("textures/tiles/rocher.png",true),
	TABLE_CASSE("textures/tiles/table_casse.png",true),
	TABLE("textures/tiles/table.png",true),
	TABOURET_CASSE("textures/tiles/tabouret_casse.png",true),
	TABOURET("textures/tiles/tabouret.png",false),
	TAS_PIERRE("textures/tiles/tas_pierre.png",true),
	TOMBE("textures/tiles/tombe.png",true),
	OMBRE("textures/tiles/ombre.png",false);
	
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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Tile
{
	MUR_PIERRE("textures/tiles/mur_pierre.png",true),
	SOL_PIERRE_1("textures/tiles/sol_pierre_1.png",false),
	SOL_PIERRE_2("textures/tiles/sol_pierre_2.png",false),
	SOL_BOIS("textures/tiles/sol_bois.png",false),
	SOL_TROU("textures/tiles/sol_trou.png",true),
	VIDE("textures/tiles/vide.png",true),
	ROCHER("textures/tiles/rocher.png",true),
	TAS_PIERRE("textures/tiles/tas_pierre.png",true),
	TABOURET("textures/tiles/tabouret.png",false),
	TABLE("textures/tiles/table.png",true),
	TABLE_CASSE("textures/tiles/table_casse.png",true),
	TABOURET_CASSE("textures/tiles/tabouret_casse.png",true),
	TOMBE("textures/tiles/tombe.png",true),
	OMBRE("textures/tiles/ombre.png",false);
	
	private BufferedImage apparence;
	private final String url;
	private final boolean bloquant;
			
	private Tile(String url, boolean bloquant)
	{
		this.apparence = null;
		try {
			this.apparence = ImageIO.read(new File(url));
		} catch (IOException e) {
		}
		this.url = url;
		this.bloquant = bloquant;
	}
	
	public BufferedImage obtenirApparence()
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

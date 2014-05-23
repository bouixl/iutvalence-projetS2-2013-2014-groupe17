import java.awt.Image;

public class Tile
{
	public final static int LARGEUR_TILE = 32;
	public final static int HAUTEUR_TILE = 32;
	private final Image image;
	private final boolean collision;
			
	public Tile(int id)
	{
		switch(id)
		{
			case 1: // Sol pierre
				this.image = null;
				this.collision = false;
				break;
			case 2: // Sol herbe
				this.image = null;
				this.collision = false;
				break;
			case 3: // Rocher
				this.image = null;
				this.collision = true;
				break;
			case 4: // Foin - coin bas gauche
				this.image = null;
				this.collision = true;
				break;
			case 5: // Foin - coin bas droit
				this.image = null;
				this.collision = true;
				break;
			case 6: // Foin - coin haut gauche
				this.image = null;
				this.collision = false;
				break;
			case 7: // Foin - coin haut droit
				this.image = null;
				this.collision = false;
				break;
			default: // Tile transparent
				this.image = null;
				this.collision = false;
				break;
		}
	}
}

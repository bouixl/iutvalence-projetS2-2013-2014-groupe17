import java.awt.Image;

public class Tile
{
	private final Image image;
	private final boolean collision;
	
	public Tile(int id)
	{
		switch(id)
		{
			default:
				this.image = null;
				this.collision = false;
				break;
		}
	}
}

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;

public enum Carte
{
	CARTE_DEPART(new Tile[][] 
		{
			{Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,
			Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE},
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
			null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
		},26,24,
		new HashMap<Position, Evenement> (),
		false);
	
	private final Tile[][] cases;
	private final int largeur;
	private final int hauteur;
	private HashMap<Position, Evenement> evenements;
	private boolean combatsAleatoires;

	private Carte(Tile[][] cases, int largeur, int hauteur, HashMap<Position, Evenement> evenements, boolean combatsAleatoires)
	{
		this.cases = cases;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.evenements = evenements;
		this.combatsAleatoires = combatsAleatoires;
	}

	public boolean obtenirCombatAleatoires() {
		return this.combatsAleatoires;
	}
	public int obtenirLargeur() {
		return this.largeur;
	}
	public int obtenirHauteur() {
		return this.hauteur;
	}

	public Image obtenirCase(Position position) {
		int indexCase = position.obtenirColonne()+(this.largeur*(position.obtenirLigne()));
		
		ImageIcon apparence_layer1 = cases[0][indexCase].obtenirApparence(); 
		Image img_layer1 = apparence_layer1.getImage();
		BufferedImage img_case = new BufferedImage(32, 32, 1);
		Graphics2D g2 = img_case.createGraphics();
		g2.drawImage(img_layer1, 0, 0, null);
		if (indexCase-1 >= 0 && cases[0][indexCase] != Tile.MUR_PIERRE && cases[0][indexCase] != Tile.SOL_TROU)
		{
			if (cases[0][indexCase-1] == Tile.MUR_PIERRE)
			{
				ImageIcon ombre = Tile.OMBRE.obtenirApparence();
				Image img_ombre = ombre.getImage();
				g2.drawImage(img_ombre, 0, 0, null);
			}
		}
		if (cases[1][indexCase] != null)
		{
			ImageIcon apparence_layer2 = cases[1][indexCase].obtenirApparence();
			Image img_layer2 = apparence_layer2.getImage();
			g2.drawImage(img_layer2, 0, 0, null);
		}
		g2.dispose();
		
		return img_case;
	}
	
	public Evenement obtenirEvenement(Position position) {
		return evenements.get(position);
	}

	public boolean peutAller(Direction direction, Position position) 
	{
		Position positionArrivee = position.ajouterOffset(direction);
		int indexCase = positionArrivee.obtenirColonne()+(this.largeur*(positionArrivee.obtenirLigne()));
		
		if (positionArrivee.estValideDansCarte(this))
		{
			if (cases[0][indexCase].estBloquant())
				return false;
			if (cases[1][indexCase] != null)
			{
				if (cases[1][indexCase].estBloquant())
					return false;
			}
			if(evenementPresent(positionArrivee))
			{
				if (obtenirEvenement(positionArrivee).estBloquant())
					return false;
			}
			return true;
		}
		return false;
	}

	public boolean evenementPresent(Position position) {
		return evenements.containsKey(position);
	}
}

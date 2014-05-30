
public class Equipe
{
	
	private int x;
	private int y;
	private Personnage[] composition; 
	
	public Equipe()
	{
		this.x = 3;
		this.y = 3;
		//this.composition[0] = new Personnage("Bob", Classes.ASSASSIN);
		//this.composition[1] = new Personnage("Bub", Classes.BARBARE);
		//this.composition[2] = new Personnage("Bib", Classes.DRUIDE);
		//this.composition[3] = new Personnage("Bab", Classes.MAGISTER);
	}
	
	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}
	
	public void ajouterPersonnage(Personnage personnage, int emplacement)
	{
		this.composition[emplacement] = personnage;
	}
	
	
}


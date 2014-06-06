/**
 * 
 * @author rougen
 *
 */
public class Combat
{
	private boolean etat;
	private Ennemi[] ennemis;
	private int tour;
	private IHM ihm;
	
	public Combat(Equipe equipe, Ennemi[] ennemis, IHM ihm)
	{
		this.tour = Application.RNG.nextInt(2);		
		this.ennemis = ennemis;
		this.ihm = ihm;
	}
	
	public void tourGlobal()
	{
		if(this.tour%2==0)
			this.tourJoueur();
		else 
			this.tourEnnemi();
	}
	
	public void tourJoueur()
	{
		
		this.tour++;
	}
	
	public void tourEnnemi()
	{
		
		this.tour++;
	}
}

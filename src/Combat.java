/**
 * 
 * @author rougen
 *
 */
public class Combat
{
	private boolean etat;
	private int tour;
	
	public Combat(Equipe equipe,Ennemi[] ennemis)
	{
		this.tour = Application.RNG.nextInt(2);		
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
		
	}
	
	public void tourEnnemi()
	{
		
	}
}

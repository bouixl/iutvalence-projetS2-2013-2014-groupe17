/** 
 * @author bouixl
 * Represente la partie de jeu
 */
public class Partie
{
	/**
	 * L'équipe qui sera utilisée par le joueur
	 */
	private Equipe equipe;
	/**
	 * La carte actuellement chargée
	 */
	private Carte carte;
	/**
	 * L'état de la partie
	 */
	private String etat;
	
	/**
	 * Genère la partie et applique des valeurs par défaut à ses attributs
	 */
	public Partie()
	{
		this.equipe = new Equipe();
		this.carte = Carte.CARTE_DEPART;
		this.etat = "init";
	}
	
	/**
	 * Lance la partie
	 */
	public void lancerPartie()
	{
		
	}
	
	/**
	 * Boucle principale du jeu
	 */
	public void gameLoop()
	{
		
	}
}

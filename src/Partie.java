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
	private IHM ihm;
	
	/**
	 * Genère la partie et applique des valeurs par défaut à ses attributs
	 * @param ihm 
	 */
	public Partie(IHM ihm)
	{
		this.equipe = new Equipe();
		this.carte = Carte.CARTE_DEPART;
		this.etat = "init";
		this.ihm = ihm;
	}
	
	/**
	 * Lance la partie
	 */
	public void lancerPartie()
	{
		this.etat = "Carte";
		boucleJeu();
	}
	
	/**
	 * Boucle principale du jeu
	 */
	public void boucleJeu()
	{
		while (etat != "Fin")
		{
			if (etat == "Carte")
			{
				this.ihm.afficherCarte(carte, equipe);
				this.ihm.attendreReaction();
			}
			else if (etat == "Combat")
			{
				
			}
			else if (etat == "Menu")
			{
				
			}
			else
			{
				System.out.println("Erreur, état imprévu.");
			}
			attendreReaction();
		}
	}
	
	public void ecranSuivant()
	{
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		System.out.println("-------- "+etat+" --------");
	}
	
	public void attendreReaction()
	{
		
	}
	
	public void afficherCarte()
	{
		System.out.println(this.carte.toString());
	}
}

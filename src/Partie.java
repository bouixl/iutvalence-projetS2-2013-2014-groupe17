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
	private Combat combat;
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
		this.combat = null;
		this.ihm = ihm;
		this.ihm.transmettrePartie(this);
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
				this.ihm.afficherCarte();
			}
			else if (etat == "Combat")
			{
				this.ihm.afficherCombat();
			}
			else if (etat == "Menu")
			{
				
			}
			else
			{
				System.out.println("Erreur, état imprévu.");
			}
			this.ihm.attendreReaction();
			System.out.println("test");
		}
	}
	
	public void ecranSuivant()
	{
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		System.out.println("-------- "+etat+" --------");
	}
	
	public void afficherCarte()
	{
		System.out.println(this.carte.toString());
	}
	
	public void changerEtat(String etat)
	{
		this.etat = etat;
	}
	
	public void changerCarte(Carte carte)
	{
		this.carte = carte;
	}
	
	public void changerCombat(Combat combat)
	{
		this.combat = combat;
	}
	
	public String obtenirEtat()
	{
		return this.etat;
	}
	
	public Carte obtenirCarte()
	{
		return this.carte;
	}
	
	public Combat obtenirCombat()
	{
		return this.combat;
	}
	
	public Equipe obtenirEquipe()
	{
		return this.equipe;
	}
}

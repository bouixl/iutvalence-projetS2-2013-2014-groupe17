import java.util.HashMap;

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
	 * Les cartes du jeu
	 */
	private HashMap<String, Carte> ensemble_cartes;
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
		this.ensemble_cartes = new HashMap<String, Carte> ();
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
		creerCartes();
		this.carte = ensemble_cartes.get("TestZone");
		this.etat = "Carte";
		boucleJeu();
	}
	
	private void creerCartes() {
		this.ensemble_cartes.put("TestZone", new Carte(new Tile[][] 
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
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,Tile.TABLE,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,Tile.TABOURET,null,null,null,null,null,null,null,null,null,null,
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
				},26,24,false));
		ensemble_cartes.get("TestZone").ajouterEvenement(new Position(13,12), new Evenement("EventTest","textures/evenements/livre.png",Direction.BAS,true,null));
		
		
		this.ensemble_cartes.put("MiniZone", new Carte(new Tile[][] 
				{
					{Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.MUR_PIERRE,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_2,Tile.MUR_PIERRE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,
					Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE,Tile.VIDE},
					{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,Tile.SOL_TROU,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
					null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}
				},20,15,false));
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
		}
	}
	
	public void essaiCombat()
	{
		if(Application.RNG.nextInt(45)==0 && this.carte.obtenirCombatAleatoires())
			this.etat = "Combat";
			Ennemi[] ennemis = new Ennemi[Application.RNG.nextInt(4)+1];
			for (int i = 0; i < ennemis.length; i++)
			{
				ennemis[i] = Ennemi.genererEnnemi(this.equipe.obtenirNiveauMoyen());
			}
			this.combat = new Combat(this.equipe, ennemis, this.ihm);
	}
	
	public void changerEtat(String etat)
	{
		this.etat = etat;
		System.gc();
	}
	
	public void changerCarte(String carte, Position position)
	{
		this.carte = ensemble_cartes.get(carte);
		this.equipe.forcerPosition(position);
		System.gc();
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

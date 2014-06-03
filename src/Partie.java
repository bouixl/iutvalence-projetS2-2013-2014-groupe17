import java.util.HashMap;

/** 
 * @author bouixl
 * Represente la partie de jeu
 */
public class Partie
{
	public static final boolean GHOST = false;
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
	public static HashMap<String, Integer> variables = new HashMap<String, Integer> ();
	
	/**
	 * Genère la partie et applique des valeurs par défaut à ses attributs
	 * @param ihm interface
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
		this.carte = this.ensemble_cartes.get("TestZone");
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
		this.ensemble_cartes.get("TestZone").ajouterEvenement(new Position(13,12), new Evenement("Livre","textures/evenements/livre.png",Direction.BAS,true,new String[][] {{"MESSAGE blargh\nblargh autre ligne","CHOIX Oui 1 Blargh 0 Cette option marche ?","MESSAGE Pourquoi non ?",null},{null,null,"MESSAGE Les embranchements semblent marcher.","ALLERA 0 0"}}));
		this.ensemble_cartes.get("TestZone").ajouterEvenement(new Position(13,9), new Evenement("Grille","textures/evenements/portes/grille_fermee.png",Direction.BAS,true,new String[][] {{"TESTEREVENT 0 1 0 TestZone LevierRouge ","MESSAGE La grille est fermée..."},{null,null}}));
		this.ensemble_cartes.get("TestZone").ajouterEvenement(new Position(9,7), new Evenement("LevierRouge","textures/evenements/leviers/levier_rouge_gauche.png",Direction.BAS,true,new String[][] {{"TESTEREVENT 0 2 0","CHOIX Oui 1 Non 0 Pousser le levier ?",null,null,null,null,null},{null,null,"MESSAGE Un clic metallique se faite entendre non loin.","INTERRUPTEUR 0","APPARENCE textures/evenements/leviers/levier_rouge_droite.png","APPARENCE textures/evenements/portes/grille_ouverte.png TestZone Grille","COLLISION false TestZone Grille"},{null,"MESSAGE Le levier est bloqué...",null,null,null,null,null}}));
		
		
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
		this.ensemble_cartes.put("Blargh", new Carte(new Tile[][] {{Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_2,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.SOL_PIERRE_1,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE,Tile.MUR_PIERRE},{null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TAS_PIERRE,null,null,null,null,null,null,null,null,null,null,null,null,null,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,null,null,Tile.TABOURET_CASSE,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,Tile.TABOURET,Tile.TOMBE,Tile.ROCHER,null,Tile.TABLE_CASSE,null,null,null,null,null,null,null,null,null,null,null,null,Tile.ROCHER,Tile.TABLE_CASSE,Tile.ROCHER,Tile.ROCHER,Tile.ROCHER,Tile.ROCHER,Tile.ROCHER,Tile.TABOURET,null,null,null,null,null,null,null,null,null,null,null,Tile.TABLE_CASSE,null,Tile.TABLE_CASSE,Tile.TOMBE,Tile.TOMBE,Tile.TOMBE,null,null,Tile.TABLE,null,null,null,null,null,null,null,null,null,null,null,Tile.ROCHER,Tile.TABOURET_CASSE,null,null,null,null,Tile.ROCHER,null,Tile.ROCHER,null,null,null,null,null,null,null,null,null,null,null,Tile.ROCHER,null,null,null,Tile.TABOURET,null,null,null,Tile.ROCHER,null,null,null,null,null,null,null,null,null,null,null,Tile.ROCHER,null,null,Tile.TABOURET,Tile.TABLE_CASSE,Tile.TABOURET,null,null,Tile.ROCHER,null,null,null,null,null,null,null,null,null,null,null,null,Tile.ROCHER,Tile.ROCHER,Tile.ROCHER,Tile.ROCHER,Tile.ROCHER,null,Tile.ROCHER,Tile.ROCHER,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}},20,15,false));

	}

	/**
	 * Boucle principale du jeu
	 */
	public void boucleJeu()
	{
		while (this.etat != "Fin")
		{
			if (this.etat == "Carte")
			{
				this.ihm.afficherCarte();
			}
			else if (this.etat == "Combat")
			{
				this.ihm.afficherCombat();
			}
			else if (this.etat == "Menu")
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
		if (this.carte.obtenirCombatAleatoires())
		{
			if(Application.RNG.nextInt(45)==0)
			{
				this.etat = "Combat";
				Ennemi[] ennemis = new Ennemi[Application.RNG.nextInt(4)+1];
				for (int i = 0; i < ennemis.length; i++)
				{
					ennemis[i] = Ennemi.genererEnnemi(this.equipe.obtenirNiveauMoyen());
				}
				this.combat = new Combat(this.equipe, ennemis, this.ihm);
			}
		}
	}
	
	public void changerEtat(String etat)
	{
		this.etat = etat;
	}
	
	public void changerCarte(String carte, Position position)
	{
		this.carte = this.ensemble_cartes.get(carte);
		this.equipe.forcerPosition(position);
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
	
	public HashMap<String, Carte> obtenirEnsembleCartes()
	{
		return this.ensemble_cartes;
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

/**
 * Classe qui cree un personnage
 * Un personnage dans le jeu possede un nom unique un niveau avec de l'experience 
 * Un personnage appartient � une classe, a des statistiques(force intelligence dexterite hp mp ...)
 * 
 * @author rougen
 *
 */
public class Personnage
{
	/**
	 * le nom ou pseudo du personnage creer
	 */
 	protected String nom;
	 
	/**
	 * le niveau actuel du personnage
	 * une montee de niveau augmente les statistiques et peut debloquer des sorts
	 */
	protected int niveau;
	
	/**
	 * l'experience du personnage
	 * gagner de l'experience permet de monter de niveau
	 * on gagne de l'experience en battant des ennemis et en finissant des quetes 
	 */
	protected int experience;
	
	/**
	 * La classe du personnage
	 * Une classe donne acces� des sorts uniques de classes et des statistiques plus elevee pour cette classe
	 * un personnage peut être barbare magicien prêtre ...(a rajouter)
	 */
	protected Classes classe;
	
	/**
	 *un personnage peut avoir de l'equipement 
	 *On equipe la  tete, le corps, les jambes et les armes(mains) 
	 */
	
	protected Item[] equipement;
	
	/**
	 * la force du personnage definit ses degats physiques avec ses armes ou ses sorts physiques
	 */
	protected int force;
	
	/**
	 * La constitution du personnage definit la defense physique et magique du personnage aux degats
	 * Augmente aussi les points de vie du personnage
	 */
	protected int constitution;
	
	/**
	 * La dexterite du personnage definit les chances d'esquives, de toucher et de critiques du personnage
	 */
	protected int dexterite;
	
	/**
	 * L'intelligence du personnage definit la puissance des sorts magiques et augmente les points de mana du personnage
	 */
	protected int intelligence;
	
	/**
	 * Les points de vies actuels du personnage
	 * Si ils tombent à zéro, le personnage meure
	 */
	protected int pointsDeVie;
	
	/**
	 * les points de vies maximum d'un personnage
	 * Ces points de vies augmentent à chaque niveau en fonction de la constitution
	 */
	protected int pointsDeVieMax;
	
	/**
	 * Les points de mana actuels du personnage
	 * on utilise des points de mana pour chaque utilisation de compétence
	 * si les points de mana sont plus bas que le cout nécessaire d'utilisation d'une compétence, on ne peut utiliser la compétence
	 */
	protected int pointsDeMana;
	
	/**
	 * les points de mana max du personnage 
	 * Ces points de mana augmentent à chaque niveau en fonction de l'intelligence
	 */
	protected int pointsDeManaMax;
	
	/**
	 * Compte les tours consecutifs qu'un personnage utilise sa defense(seDefendre)
	 * se reinitialise quand le joueur arrete de se defendre
	 */
	protected int tourDeDefense;
	/**
	 * constructeur qui va cree un personnage en demandant un nom et une classe dans une liste au Joueur
	 * Le nouveau personnage sera au niveau 1 et aura 0 experience de base
	 * @param nom nom du personnage
	 * @param classe classe du personnage
	 */
	public Personnage(String nom, Classes classe)
	{
		this.nom = nom ; 
		this.niveau = 1;
		this.experience = 0 ;
		this.classe = classe ;
		this.force =  classe.obtenirForce() ;
		this.constitution = classe.obtenirConstitution();
		this.intelligence = classe.obtenirIntelligence() ;
		this.dexterite = classe.obtenirDexterite(); 
		this.pointsDeVieMax = classe.obtenirPv();
		this.pointsDeManaMax = classe.obtenirPm();
		this.pointsDeMana = classe.obtenirPm();
		this.pointsDeVie=classe.obtenirPv();
		this.tourDeDefense = 0;
	}

	/**
	 * 
	 */
	public Personnage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Permet au personnage d'attaquer avec son arme en melee
	 * @return le nombre de degats bruts que fait le personnage
	 */
	public int attaquer()
	{
		int degats = 0;
		this.tourDeDefense = 0;
		degats=this.obtenirForce();
		return degats;
	}
	/**
	 * Methode qui dis si le personnage est mort ou pas
	 * @return un boolean si le personnage est en vie ou pas
	 */
	public boolean estVaincu()
	{
		if(this.pointsDeVie==0)
		{
			return true;
			
		}
		else return false;
	}
	/**
	 * Methode qui donne les degats subis d'un personnage en fonction de l'attaque de l'adversaire  et de sa propre defense
	 * @param degatsBruts degats en fonction de la force du personnage
	 * @return les degats subis
	 */
	public int subirDegats(int degatsBruts)
	{
		int degatsSubis = 0;
		degatsSubis += degatsBruts-this.obtenirConstitution();
		if(this.tourDeDefense > 0)
			degatsSubis *= 0.5;
		if(degatsSubis < 1)
			degatsSubis = 1;
		return degatsSubis;
	}
	/**
	 * Permet au personnage de se defendre et donc de reduire les degats subis de 50%
	 */
	public void seDefendre()
	{
		if(this.tourDeDefense > 4)
		{
			this.tourDeDefense = 0;
		}
		else
		{
			this.tourDeDefense++;
		}
	}
	 public void monterDeNiveau()
	 {
		 this.force= force + this.classe.obtenirForceParNiveau();
		 this.constitution = constitution + this.classe.obtenirConstitutionParNiveau();
		 this.intelligence = intelligence + this.classe.obtenirIntelligenceParNiveau();
		 this.dexterite = dexterite + this.classe.obtenirDexteriteParNiveau();
		 this.niveau++;
	 }

	/**
	 * 
	 * @return le nom du personnage
	 */
	public String obtenirNom() {
		return this.nom;
	}

	/**
	 * 
	 * @return le niveau du personnage
	 */
	public int obtenirNiveau() {
		return this.niveau;
	}

	/**
	 * 
	 * @return l'experience du personnage
	 */
	public int obtenirExperience() {
		return this.experience;
	}

	/**
	 * 
	 * @return la classe du personnage
	 */
	public Classes obtenirClasse() {
		return this.classe;
	}

	/**
	 * 
	 * @return l'equipement que porte le personnage
	 */
	public Item[] obtenirEquipement() {
		return this.equipement;
	}

	/**
	 * 
	 * @return la force du personnage
	 */
	public int obtenirForce() {
		return this.force;
	}

	/**
	 * 
	 * @return la constitution du personnage
	 */
	public int obtenirConstitution() {
		return this.constitution;
	}

	/**
	 * 
	 * @return la dexterite du personnage
	 */
	public int obtenirDexterite() {
		return this.dexterite;
	}

	/**
	 * 
	 * @return l'intelligence du personnage
	 */
	public int obtenirIntelligence() {
		return this.intelligence;
	}

	/**
	 * 
	 * @return les points de vie actuel du personnage
	 */
	public int obtenirPointsDeVie() {
		return this.pointsDeVie;
	}

	/**
	 * 
	 * @return les points de vie max du personnage
	 */
	public int obtenirPointsDeVieMax() {
		return this.pointsDeVieMax;
	}

	/**
	 * 
	 * @return les points de mana actuel du personnage
	 */
	public int obtenirPointsDeMana() {
		return this.pointsDeMana;
	}

	/**
	 * 
	 * @return les points de mana maxdu personnage
	 */
	public int obtenirPointsDeManaMax() {
		return this.pointsDeManaMax;
	}
	
	/**
	 * 
	 * @return le nombre de tour consécutif de défense du personnage
	 */
	public int obtenirTourDeDefense() {
		return this.tourDeDefense;
	}
	
}

/**
 * Classe qui crée un personnage
 * Un personnage dans le jeu possède un nom unique un niveau avec de l'expérience 
 * Un personnage appartient à une classe, a des statistiques(force intelligence agilité hp mp ...)
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
	 * une montée de niveau augmente les statistiques et peut débloquer des sorts
	 */
	protected int niveau;
	
	/**
	 * l'expérience du personnage
	 * gagner de l'expérience permet de monter de niveau
	 * on gagne de l'expérience en battant des ennemis et en finissant des quêtes 
	 */
	protected int experience;
	
	/**
	 * La classe du personnage
	 * Une classe donne accès à des sorts uniques de classes et des statistiques plus élevé pour cette classe
	 * un personnage peut être barbare magicien prêtre ...(a rajouter)
	 */
	protected Classes classe;
	
	/**
	 *un personnage peut avoir de l'équipement 
	 *On equipe la  tete, le corps, les jambes et les armes(mains) 
	 */
	
	protected Item[] equipement;
	
	/**
	 * la force du personnage définit ses dégats physiques avec ses armes ou ses sorts physiques
	 */
	protected int force;
	
	/**
	 * La constitution du personnage définit la défense physique et magique du personnage aux d�gats
	 * Augmente aussi les points de vie du personnage
	 */
	protected int constitution;
	
	/**
	 * La dext�rit� du personnage d�finit les chances d'esquives, de toucher et de critiques du personnage
	 */
	protected int dexterite;
	
	/**
	 * L'intelligence du personnage d�finit la puissance des sorts magiques et augmente les points de mana du personnage
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
	 * Compte les tours cons�cutifs qu'un personnage utilise sa d�fense(seDefendre)
	 * se r�initialise quand le joueur arrete de se d�fendre
	 */
	protected int tourDeDefense;
	/**
	 * constructeur qui va crée un personnage en demandant un nom et une classe dans une liste au Joueur
	 * Le nouveau personnage sera au niveau 1 et aura 0 expérience de base
	 * @param nom nom du personnage
	 * @param classe classe du personnage
	 * @param nom
	 * @param classe
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

	
	public Personnage() {
		// TODO Auto-generated constructor stub
	}


	public int attaquer()
	{
		int degats = 0;
		this.tourDeDefense = 0;
		degats=this.obtenirForce();
		return degats;
	}
	
	public boolean estVaincu()
	{
		if(this.pointsDeVie==0)
		{
			return true;
			
		}
		else return false;
	}
	
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
	
	


	public String obtenirNom() {
		return this.nom;
	}


	public int obtenirNiveau() {
		return this.niveau;
	}


	public int obtenirExperience() {
		return this.experience;
	}


	public Classes obtenirClasse() {
		return this.classe;
	}


	public Item[] obtenirEquipement() {
		return this.equipement;
	}


	public int obtenirForce() {
		return this.force;
	}


	public int obtenirConstitution() {
		return this.constitution;
	}


	public int obtenirDexterite() {
		return this.dexterite;
	}


	public int obtenirIntelligence() {
		return this.intelligence;
	}


	public int obtenirPointsDeVie() {
		return this.pointsDeVie;
	}


	public int obtenirPointsDeVieMax() {
		return this.pointsDeVieMax;
	}


	public int obtenirPointsDeMana() {
		return this.pointsDeMana;
	}


	public int obtenirPointsDeManaMax() {
		return this.pointsDeManaMax;
	}
	
	public int obtenirTourDeDefense() {
		return this.tourDeDefense;
	}
	
}

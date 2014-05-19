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
 	public String nomPersonnage;
	 
	/**
	 * le niveau actuel du personnage
	 * une montée de niveau augmente les statistiques et peut débloquer des sorts
	 */
	public int niveauPersonnage;
	
	/**
	 * l'expérience du personnage
	 * gagner de l'expérience permet de monter de niveau
	 * on gagne de l'expérience en battant des ennemis et en finissant des quêtes 
	 */
	private int experiencePersonnage;
	
	/**
	 * La classe du personnage
	 * Une classe donne accès à des sorts uniques de classes et des statistiques plus élevé pour cette classe
	 * un personnage peut être barbare magicien prêtre ...(a rajouter)
	 */
	public Classes classePersonnage;
	
	/**
	 *un personnage peut avoir de l'équipement 
	 *On equipe la  tete, le corps, les jambes et les armes(mains) 
	 */
	
	public Item[] equipementPersonnage;
	
	/**
	 * la force du personnage définit ses dégats physiques avec ses armes ou ses sorts physiques
	 */
	private int force;
	/**
	 * La constitution du personnage définit la défense physique et magique du personnage aux dégats
	 * Augmente aussi les points de vie du personnage
	 */
	private int constitution;
	/**
	 * La dextérité du personnage définit les chances d'esquives, de toucher et de critiques du personnage
	 */
	private int dexterite;
	/**
	 * L'intelligence du personnage définit la puissance des sorts magiques et augmente les points de mana du personnage
	 */
	private int intelligence;
	/**
	 * Les points de vies actuels du personnage
	 * Si ils tombent à zéro, le personnage meure
	 */
	private int pointsDeVie;
	/**
	 * les points de vies maximum d'un personnage
	 * Ces points de vies augmentent à chaque niveau en fonction de la constitution
	 */
	private int pointsDeVieMax;
	/**
	 * Les points de mana actuels du personnage
	 * on utilise des points de mana pour chaque utilisation de compétence
	 * si les points de mana sont plus bas que le cout nécessaire d'utilisation d'une compétence, on ne peut utiliser la compétence
	 */
	public int pointsDeMana;
	/**
	 * les points de mana max du personnage 
	 * Ces points de mana augmentent à chaque niveau en fonction de l'intelligence
	 */
	
	public int pointsDeManaMax;
	/**
	 * constructeur qui va crée un personnage en demandant un nom et une classe dans une liste au Joueur
	 * Le nouveau personnage sera au niveau 1 et aura 0 expérience de base
	 * @param nom nom du personnage
	 * @param classe classe du personnage
	 */
	public Personnage(String nom, Classes classe)
	{
		this.nomPersonnage = nom ; 
		this.niveauPersonnage = 1;
		this.experiencePersonnage = 0 ;
		this.classePersonnage = classe ;
		this.force =  classe.getForce() ;
		this.constitution = classe.getConstitution();
		this.intelligence = classe.getIntelligence() ;
		this.dexterite = classe.getDexterite(); 
		this.pointsDeVieMax = classe.getPv();
		this.pointsDeManaMax = classe.getPm();
	}
	
	
	
}

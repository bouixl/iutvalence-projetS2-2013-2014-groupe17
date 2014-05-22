/**
 * 
 * @author rougen
 *
 */
public class Ennemi extends Personnage
{

/**
 * 
 */
private Item recompense;
/**
 * 
 */
private double chanceRecompense;
/**
 * 
 * @param nom
 * @param recompense
 * @param pointsDeVieMax 
 * @param pointsDeManaMax 
 * @param pointsDeMana 
 * @param pointsDeVie 
 */
	public Ennemi(String nom,Item recompense,int force,int dexterite,int constitution,int intelligence, int niveau, int pointsDeVieMax, int pointsDeManaMax, int pointsDeMana, int pointsDeVie)
	{
		this.nom = nom;
		this.recompense = recompense;
		this.force = force;
		this.dexterite = dexterite;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.niveau = niveau;
		this.pointsDeVieMax = pointsDeVieMax;
		this.pointsDeManaMax = pointsDeManaMax;
		this.pointsDeMana = pointsDeMana;
		this.pointsDeVie= pointsDeVie;
		this.tourDeDefense = 0;
	}
	public Item obtenirRecompense() 
	{
		return this.recompense;
	}
	public double obtenirChanceRecompense()
	{
		return this.chanceRecompense;
	}
}
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
 * @param nom nom de l'ennemi
 * @param recompense recompense donné par l'ennemi quand il est tue
 * @param force force de l'ennemi
 * @param dexterite dexterite de l'ennemi
 * @param constitution constitution de l'ennemi
 * @param intelligence intelligence de l'ennemi
 * @param niveau niveau de l'ennemi
 * @param pointsDeVieMax pv max de l'ennemi
 * @param pointsDeManaMax pm  max de l'ennemi
 * @param pointsDeMana  pm actuel de l'ennemi
 * @param pointsDeVie pv actuel de l'ennemi
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
	/**
	 * 
	 * @return la recompense
	 */
	public Item obtenirRecompense() 
	{
		return this.recompense;
	}
	/**
	 * 
	 * @return les chances de recompense
	 */
	public double obtenirChanceRecompense()
	{
		return this.chanceRecompense;
	}
}
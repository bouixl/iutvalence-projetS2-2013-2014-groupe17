/**
 * 
 * @author rougen
 *
 */
public enum Classes
{
	/**
	 * La classe bourrin 
	 */
	BARBARE(60,20,10,6,1,3),
	/**
	 * Classe de d�gats par sorts � distance
	 */
	MAGISTER(45,35,2,1,11,6),
	/**
	 * Classe d�gats en m�l�e ax� sur les d�gats
	 */
	ASSASSIN(50,25,6,3,2,9),
	/**
	 * Soigneur par les plantes
	 */
	DRUIDE(40,40,2,4,10,4);
	//Les noms des classes seront certainement redefinir
	
	/**
	 * Point de vie de base d'une classe
	 */
	private int pv;
	/**
	 * Poitn de vie de base d'une classe
	 */
	private int pm;
	/**
	 * Poitn de force de base d'une classe
	 */
	private int force;
	/**
	 * Point de constitution de base d'une classe
	 */
	private int constitution;
	/**
	 * Poitn d'intelligence de base d'une classe
	 */
	private int intelligence;
	/**
	 * Point de dexterite de base d'une classe
	 */
	private int dexterite;
	
	/**
	 * @param pv point de vie de la classe	
	 * @param pm point de mana de la classe
	 * @param force point de force de la classe
	 * @param constitution point de constitution de la classe
	 * @param intelligence point d'intelligence de la classe
	 * @param dexterite point de dexterite de la classe 
	 */
	private Classes(int pv,int pm,int force,int constitution, int intelligence,int dexterite)
	{
		this.pv = pv;
		this.pm = pm;
		this.force = force;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.dexterite = dexterite;
	}

	/**
	 * @return the pv
	 */
	public int obtenirPv()
	{
		return this.pv;
	}

	/**
	 * @return the pm
	 */
	public int obtenirPm()
	{
		return this.pm;
	}

	/**
	 * @return the force
	 */
	public int obtenirForce()
	{
		return this.force;
	}

	/**
	 * @return the constitution
	 */
	public int obtenirConstitution()
	{
		return this.constitution;
	}

	/**
	 * @return the intelligence
	 */
	public int obtenirIntelligence()
	{
		return this.intelligence;
	}

	/**
	 * @return the dexterite
	 */
	public int obtenirDexterite()
	{
		return this.dexterite;
	}
}

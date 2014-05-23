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
	BARBARE(60,20,10,6,1,3, 5,2,3,2,1,1),
	/**
	 * Classe de dégats par sorts à distance
	 */
	MAGISTER(45,35,2,1,11,6, 3,4,1,1,4,2),
	/**
	 * Classe dégats en mélée axé sur les dégats
	 */
	ASSASSIN(50,25,6,3,2,9, 4,3,2,2,1,2),
	/**
	 * Soigneur par les plantes
	 */
	DRUIDE(40,40,2,4,10,4, 2,4,1,2,4,2);
	//Les noms des classes seront certainement à  redéfinir
	
	/**
	 * 
	 */
	private int pv;
	/**
	 * 
	 */
	private int pm;
	/**
	 * 
	 */
	private int force;
	/**
	 * 
	 */
	private int constitution;
	/**
	 * 
	 */
	private int intelligence;
	/**
	 * 
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
	private Classes(int pv,int pm,int force,int constitution, int intelligence,int dexterite, int pvStat,int pmStat, int forceStat, int constitutionStat, int intelligenceStat, int dexteriteStat)
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

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
	BARBARE(60,20,4,2,0,1),
	/**
	 * Classe de dégats par sorts à distance
	 */
	MAGISTER(45,35,1,0,4,2),
	/**
	 * Classe dégats en mélée axée sur les dégats
	 */
	ASSASSIN(50,25,2,1,1,3),
	/**
	 * Soigneur par les plantes
	 */
	DRUIDE(40,40,0,2,4,2);
	//Les noms des classes seront certainement à redéfinir
	
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
	public int getPv()
	{
		return this.pv;
	}

	/**
	 * @return the pm
	 */
	public int getPm()
	{
		return this.pm;
	}

	/**
	 * @return the force
	 */
	public int getForce()
	{
		return this.force;
	}

	/**
	 * @return the constitution
	 */
	public int getConstitution()
	{
		return this.constitution;
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence()
	{
		return this.intelligence;
	}

	/**
	 * @return the dexterite
	 */
	public int getDexterite()
	{
		return this.dexterite;
	}
}

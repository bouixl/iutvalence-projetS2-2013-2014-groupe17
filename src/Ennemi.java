/**
 * 
 * @author rougen
 *
 */
public class Ennemi extends Personnage
{
private static final String[] NOMS_MONSTRES={"Rat","Zombie","Lucane","Loup","Squelette","Fleur Carnivore Mutante","Ours-Garou","Pousse de Bambou","Lapin-Garou","Chaton"};
private static final String[] ADJECTIFS_POSITIFS={"Intelligent","Monstrueux","Divin","Rusé","Rapide","Géant","Bien Constitué","Alpha","Habile","Rapide","Légendaire"};
private static final String[] ZONE_HABITAT = {"des Plaines","des Bois","des Montagnes Glacées","des Egouts","de la Mine Profonde","de la Toundra","D'enclos","de Mer"};
private static final String[] ADJECTIFS_NEGATIFS ={"Infecté","Boiteux","Affamé","Lépreux","Fiévreux","Immangeable","en Décomposition","à l'Esprit Faible"};
private static final String[] ADJECTIFS_NORMAL = {"Sauvage","Vaudou","Agressif","Pacifique","Primaire","Chasseur","Poli","Malveillant"};
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
	public static Ennemi genererEnnemi(int niveau) {
		String nomMonstre;
		String[] adjectifs;
		int pointsDeVie = 0;
		int pointsDeMana = 0;
		int force = 0;
		int dexterite = 0;
		int intelligence = 0;
		int constitution = 0;
		int id;
		int chance;
		double mult = 1.0;
		Item recompense =  (Item.genererEquipement(niveau));
		
		int type = Application.RNG.nextInt(2);
		
		
		
		id=Application.RNG.nextInt(NOMS_MONSTRES.length);
		nomMonstre = " "+NOMS_MONSTRES[id];
		

		chance = Application.RNG.nextInt(100);
		if (chance>60)
		{
			adjectifs = ADJECTIFS_POSITIFS;
			mult *= 1.5;
		}
		else if (chance>20)
		{
			adjectifs = ADJECTIFS_NEGATIFS;
			mult *= 0.5;
		}
		else
		{
			adjectifs = ADJECTIFS_NORMAL;
			mult *= 1;
		}
		
		id = Application.RNG.nextInt(adjectifs.length);
		nomMonstre += " "+adjectifs[id];
		
		chance = Application.RNG.nextInt(100);
		if(chance>99)
		{
			mult *= 2.0;
		}
		else if(chance>95)
		{
			mult *= 1.5;
		}
		else if(chance<5)
		{
			mult *= 0.5;
		}
		

		pointsDeVie += Application.RNG.nextInt(10) * niveau * mult;
			
		pointsDeMana += Application.RNG.nextInt(8) * niveau * mult;
			
		force += Application.RNG.nextInt(3) * niveau * mult;
			
		constitution += Application.RNG.nextInt(3) * niveau * mult;
			
		intelligence+= Application.RNG.nextInt(3) * niveau * mult;
		
		dexterite += Application.RNG.nextInt(3) * niveau * mult;


		id=Application.RNG.nextInt(ZONE_HABITAT.length);
		nomMonstre += " "+ZONE_HABITAT[id];
		
		return new Ennemi(nomMonstre, recompense, force, dexterite, constitution, intelligence, niveau, pointsDeVie, pointsDeMana, pointsDeMana, pointsDeVie);
	}
}
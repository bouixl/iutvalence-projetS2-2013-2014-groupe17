/**
 * 
 * @author rougen
 *
 */
public class Item
{
	private final int type;
	private String nom;
	private int[] effets;
	
	private static final int TYPE_ARME = 0;
	private static final int TYPE_ARMURE = 1;
	private static final int TYPE_POTION = 2;
	
	private static final String[] NOMS_ARMES={"Epée","Hache","Poêle à frire","Hallebarde","Katana","Lance","Arbalète","Batte","Gourdin","Masse","Arc","Marteau","Espadon","Bâton","Claymore","Dague","Morgenstern","Poignard","Epieux","Glaive","Sabre","Bardiche","Flamberge","Wakizashi"};
	private static final String[] NOMS_ARMURES={"Côte de mailles","Robe","Plastron","Harnois","Haubert","Brigandine"};
	private static final String[] NOMS_POTIONS={"Breuvage","Elixir","Tonique",};
	private static final String[] ADJECTIFS_POSITIFS={"Démonique","Brutal(e)","Enchanté(e)","Mystique","Aiguisé(e)","Légendaire","de Bonne Qualité","Luminescente","Fabuleux(se)"};
	private static final String[] ADJECTIFS_NEGATIFS={"Emoussé(e)","Tordu(e)","Rouillé(e)","Abimé(e)","de Débutant","de Mauvaise Qualité", "Cassé(e)"};
	private static final String[] ADJECTIFS_POTIONS={"Etrange","Inhabituel","Visqueux","Poisseux","Séché","Opaque","Puant","Intriguant","Infame","Crépitant","Appetissant","Coloré","Fluorescent","Vaporeux","Terne","annoté 'Mortel'","annoté 'Ne pas toucher'","un peu Vivant"};
	private static final String[] ADJECTIFS_VIDE = {""};
	private static final String[] MATERIAUX={"en Fer","en Cuivre","en Or","en Cuir","en Tissu","en Mithril","en Adamantium","en Cobalt","en Bois"};
	
	public Item(int type, String nom, int[] effets) {
		this.type = type;
		this.nom = nom;
		this.effets = effets;
	}


	/**
	 * @return le type de l'objet
	 */
	public int obtenirType() {
		return this.type;
	}


	/**
	 * @return le nom de l'objet
	 */
	public String obtenirNom() {
		return this.nom;
	}


	/**
	 * @return les effets(PV PM FORCE CONST INT DEX) de l'objet
	 */
	public int[] obtenirEffet() {
		return this.effets;
	}
	
	public static Item genererEquipement(int niveau) {
		String nomProduit;
		String[] categorie;
		String[] adjectifs;
		int[] effets = {0,0,0,0,0,0};
		int id;
		int chance;
		double mult = 1.0;
		
		int type = Application.RNG.nextInt(2);
		
		if (type==TYPE_ARME)
		{
			categorie=NOMS_ARMES;
			effets[2] += niveau + Application.RNG.nextInt(11);
		}
		else
		{
			categorie=NOMS_ARMURES;
			effets[3] += niveau + Application.RNG.nextInt(11);
		}
		
		id=Application.RNG.nextInt(categorie.length);
		nomProduit = " "+categorie[id];
		
		id=Application.RNG.nextInt(MATERIAUX.length);
		nomProduit += " "+MATERIAUX[id];
		
		chance = Application.RNG.nextInt(100);
		if (chance>70)
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
			adjectifs = ADJECTIFS_VIDE;
		}
		
		id = Application.RNG.nextInt(adjectifs.length);
		nomProduit += " "+adjectifs[id];
		
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
		
		chance = Application.RNG.nextInt(100);
		if(chance>90)
		{
			effets[2] += Application.RNG.nextInt(2) * niveau;
		}
		
		chance = Application.RNG.nextInt(100);
		if(chance>90)
		{
			effets[3] += Application.RNG.nextInt(2) * niveau;
		}
		
		chance = Application.RNG.nextInt(100);
		if(chance>80)
		{
			effets[4] += Application.RNG.nextInt(3) * niveau;
		}
		
		chance = Application.RNG.nextInt(100);
		if(chance>80)
		{
			effets[5] += Application.RNG.nextInt(3) * niveau;
		}
		
		for(int i=0; i<6; i++)
		{
			effets[i] *= mult;
		}
		
		return new Item(type, nomProduit, effets);
	}

	public static Item genererPotion(int niveau) {
		String nomProduit;
		int[] effets = {0,0,0,0,0,0};
		int id;
		int id_adjsup;
		int chance;
		double mult = 1.0;
		
		id = Application.RNG.nextInt(NOMS_POTIONS.length);
		nomProduit = " "+NOMS_POTIONS[id];
		
		id = Application.RNG.nextInt(ADJECTIFS_POTIONS.length);
		nomProduit += " "+ADJECTIFS_POTIONS[id];
		
		id_adjsup = Application.RNG.nextInt(ADJECTIFS_POTIONS.length);
		while (id_adjsup==id)
		{
			id_adjsup = Application.RNG.nextInt(ADJECTIFS_POTIONS.length);
		}
		nomProduit += " et "+ADJECTIFS_POTIONS[id_adjsup];
		
		chance = Application.RNG.nextInt(100);
		if (chance>60)
		{
			effets[0] += niveau * (Application.RNG.nextInt(20)-7);
		}
		else if (chance<40)
		{
			effets[1] += niveau * (Application.RNG.nextInt(20)-7);
		}
		else
		{
			effets[0] += niveau * (Application.RNG.nextInt(14)-5);
			effets[1] += niveau * (Application.RNG.nextInt(14)-5);
		}
		
		chance = Application.RNG.nextInt(100);
		if(chance>98)
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
		else if(chance<2)
		{
			mult *= -1.0;
		}
		
		for(int i=0; i<6; i++)
		{
			effets[i] *= mult;
		}
		
		return new Item(TYPE_POTION, nomProduit, effets);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String chaine;
		if (this.type==TYPE_ARME)
			chaine = "Arme: ";
		else if (this.type==TYPE_ARMURE)
			chaine = "Armure: ";
		else
			chaine = "Potion: ";
		chaine += this.nom+" [ ";
		
		for(int i=0; i<6; i++)
		{
			chaine += this.effets[i]+" ";
		}
		chaine += "]";
		
		return chaine;
	}

	
}

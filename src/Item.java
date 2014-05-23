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
	
	private static final String[] NOMS_ARMES={"Epée","Hache","Poêle à frire","Hallebarde","Katana","Lance","Arbalète","Batte", "Gourdin", "Masse","Arc","Marteau","Espadon","Bâton" };
	private static final String[] NOMS_ARMURES={"Côte de mailles","Armure","Robe","Plastron"};
	private static final String[] ADJECTIFS_POSITIFS={"Démonique","Brutal","Enchanté","Mystique","Aiguisé","Légendaire","de Bonne Qualité","Luminescente"};
	private static final String[] ADJECTIFS_NEGATIFS={"Emoussé","Tordu","Rouillé","Abimé","de Débutant","de Mauvaise Qualité", "Cassé"};
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
		double mult = 1.0;
		
		int type = Application.RNG.nextInt(2);
		
		if (type==TYPE_ARME)
		{
			categorie=NOMS_ARMES;
			effets[2] += niveau;
		}
		else
		{
			categorie=NOMS_ARMURES;
			effets[3] += niveau;
		}
		
		id=Application.RNG.nextInt(categorie.length);
		nomProduit=" "+categorie[id];
		
		id=Application.RNG.nextInt(MATERIAUX.length);
		nomProduit+=" "+MATERIAUX[id];
		
		if (Application.RNG.nextBoolean())
		{
			adjectifs=ADJECTIFS_POSITIFS;
			mult *= 1.2;
		}
		else
		{
			adjectifs=ADJECTIFS_NEGATIFS;
			mult *= 0.8;
		}
		
		id=Application.RNG.nextInt(adjectifs.length);
		nomProduit+=" "+adjectifs[id];
		
		if(Application.RNG.nextInt(100)>97)
		{
			mult *= 2.0;
		}
		else if(Application.RNG.nextInt(100)>90)
		{
			mult *= 1.5;
		}
		if(Application.RNG.nextInt(100)>80)
		{
			effets[2] = Application.RNG.nextInt(niveau/3)+1;
		}
		if(Application.RNG.nextInt(100)>80)
		{
			effets[3] = Application.RNG.nextInt(niveau/3)+1;
		}
		if(Application.RNG.nextInt(100)>70)
		{
			effets[4] = Application.RNG.nextInt(niveau/2)+1;
		}
		if(Application.RNG.nextInt(100)>70)
		{
			effets[5] = Application.RNG.nextInt(niveau/2)+1;
		}
		
		for(int i=0; i<6; i++)
		{
			effets[i] *= mult;
		}
		
		return new Item(type, nomProduit, effets);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String chaine;
		if(this.type==TYPE_ARME)
			chaine = "Arme: ";
		else
			chaine = "Armure: ";
		chaine += this.nom+" ";
		
		for(int i=0; i<6; i++)
		{
			chaine += this.effets[i];
		}
		
		return chaine;
	}

	
}

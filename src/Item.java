/**
 * 
 * @author rougen
 *
 */
public class Item
{
	private final int type;
	private String nom;
	private int[] effet;
	
	private static final String[] TYPES_ARMES={"Ep�e","Hache","Po�le � frire","Hallebarde","Katana","Lance","Arbal�te","Batte", "Gourdin", "Masse","Arc","Marteau","Espadon","B�ton" };
	private static final String[] TYPES_ARMURES={"C�te de mailles","Armure","Robe","Plastron"};
	private static final String[] ADJECTIFS_POSITIFS={"D�monique","Brutal","Enchant�","Mystique","Aiguis�","L�gendaire","de Bonne Qualit�","Luminescente"};
	private static final String[] ADJECTIFS_NEGATIFS={"Emouss�","Tordu","Rouill�","Abim�","de D�butant","de Mauvaise Qualit�", "Cass�"};
	private static final String[] MATERIAUX={"en Fer","en Cuivre","en Or","en Cuir","en Tissu","en Mithril","en Adamantium","en Cobalt","en Bois"};
	
	public Item(int type, String nom, int[] effet) {
		this.type = type;
		this.nom = nom;
		this.effet = effet;
	}


	/**
	 * @return the type
	 */
	public int obtenirType() {
		return this.type;
	}


	/**
	 * @return the nom
	 */
	public String obtenirNom() {
		return this.nom;
	}


	/**
	 * @return the effet
	 */
	public int[] obtenirEffet() {
		return this.effet;
	}
	
	public static Item genererEquipement(int niveau){
		String nomProduit;
		String[] categorie;
		String[] adjectifs;
		int[] effets;
		int id;
		double mult = 1.0;
		
		int type = Application.RNG.nextInt(2);
		
		if (type==1)
			categorie=TYPES_ARMES;
		else
			categorie=TYPES_ARMURES;
		
		id=Application.RNG.nextInt(categorie.length);
		nomProduit=" "+categorie[id];
		
		id=Application.RNG.nextInt(MATERIAUX.length);
		nomProduit+=" "+MATERIAUX[id];
		
		if (Application.RNG.nextBoolean())
		{
			adjectifs=ADJECTIFS_POSITIFS;
			mult=1.2;
		}
		else
		{
			adjectifs=ADJECTIFS_NEGATIFS;
			mult=0.8;
		}
		
		id=Application.RNG.nextInt(adjectifs.length);
		nomProduit+=" "+adjectifs[id];
		
		return new Item(type, nomProduit, effets);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nom;
	}

	
}

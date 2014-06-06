import java.util.HashMap;

public class Inventaire {
	private HashMap<String, Item> contenu;
	private int compteur;
	
	public Inventaire()
	{
		this.contenu = new HashMap<String, Item>();
		this.compteur = 0;
	}
	
	public void ajouterObjet(Item objet)
	{
		this.contenu.put(Integer.toString(this.compteur), objet);
		this.compteur++;
	}
	public void ajouterObjet(String key, Item objet)
	{
		this.contenu.put(key, objet);
	}
	
	public void retirerObjet(String key)
	{
		if(this.contenu.containsKey(key))
			this.contenu.remove(key);
	}
	
	public HashMap<String, Item> obtenirContenu()
	{
		return this.contenu;
	}
}

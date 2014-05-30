import javax.swing.ImageIcon;

public class Evenement
{
	public static final Evenement NULL = new Evenement("null",null,false,null);
	private final ImageIcon apparence;
	private boolean bloquant;
	private final String[][] actions;
	private final String nom;

	public Evenement(String nom, ImageIcon apparence, boolean bloquant, String[][] actions)
	{
		this.actions = actions;
		this.apparence = apparence;
		this.bloquant = bloquant;
		this.nom = nom;
	}
	
	public ImageIcon obtenirApparence() {
		
		return this.apparence;
	}
	
	public boolean estBloquant() {
		return this.bloquant;
	}
	
	public void changerBloquant() {
		this.bloquant = !this.bloquant;
	}

}

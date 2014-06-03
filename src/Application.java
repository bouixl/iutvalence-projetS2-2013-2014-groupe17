import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import javax.swing.SwingUtilities;

public class Application
{	
	public static Random RNG = new Random();
	public static final int LARGEUR_TILE = 32;
	public static final int HAUTEUR_TILE = 32;
	public static final int LARGEUR_ECRAN = 640;
	public static final int HAUTEUR_ECRAN = 480;
	public static final int TOUCHE_HAUT = KeyEvent.VK_Z; // Maintenue
	public static final int TOUCHE_DROITE = KeyEvent.VK_D; // Maintenue
	public static final int TOUCHE_GAUCHE = KeyEvent.VK_Q; // Maintenue
	public static final int TOUCHE_BAS = KeyEvent.VK_S; // Maintenue
	public static final int TOUCHE_ACTION = KeyEvent.VK_SPACE;
	public static final int TOUCHE_GHOST = KeyEvent.VK_9;
	public static final int TOUCHE_CYCLEMAP = KeyEvent.VK_0;
	public static final int TOUCHE_MAPPING = KeyEvent.VK_5;
	public static final int TOUCHE_CYCLETILE = KeyEvent.VK_7;
	public static final int TOUCHE_CHANGERLAYER = KeyEvent.VK_6;
	public static final int TOUCHE_EXPORTER = KeyEvent.VK_8;
	public static final int TOUCHE_CREERMAP = KeyEvent.VK_INSERT;
	public static final int TOUCHE_POSERTILE = KeyEvent.VK_SHIFT; // Maintenue
	
	
	/**
	 * Methode principale, initialise le programme et lance la partie
	 * @param args Arguments de lancement
	 */
	public static void main(String[] args)
	{
		System.out.println("Création de la partie");
		IHM ihm = new IHM();
		SwingUtilities.invokeLater(ihm);
		while(!ihm.obtenirPret()) 
		{
			try {
			    TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		Partie partie = new Partie(ihm);
		System.out.println("Demarrage de la partie");
		partie.lancerPartie();
		System.out.println("Fin de la partie");
	}
}

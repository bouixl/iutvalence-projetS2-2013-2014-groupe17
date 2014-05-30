import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

public class Application
{	
	public static Random RNG = new Random();
	
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

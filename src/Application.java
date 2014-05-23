import java.util.Random;

public class Application
{
	/**
	 * Methode principale, initialise le programme et lance la partie
	 * @param args Arguments de lancement
	 */
	
	public static Random RNG = new Random();
	
	public static void main(String[] args)
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(Item.genererEquipement(RNG.nextInt(20)).toString());
		}
		System.out.println("Création de la partie");
		Partie partie = new Partie();
		System.out.println("Demarrage de la partie");
		partie.lancerPartie();
		System.out.println("Fin de la partie");
	}
}

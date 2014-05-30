import java.util.Random;

public class Application
{	
	public static Random RNG = new Random();
	
	/**
	 * Methode principale, initialise le programme et lance la partie
	 * @param args Arguments de lancement
	 */
	public static void main(String[] args)
	{
		for(int i=0;i<25;i++)
		{
			System.out.println(Item.genererEquipement(1).toString());
		}
		for(int i=0;i<25;i++)
		{
			System.out.println(Item.genererPotion(1).toString());
		}
		for(int i=0;i<25;i++)
		{
			System.out.println(Ennemi.genererEnnemi(10).toString());
		}
		System.out.println("Création de la partie");
		Partie partie = new Partie();
		System.out.println("Demarrage de la partie");
		partie.lancerPartie();
		System.out.println("Fin de la partie");
	}
}

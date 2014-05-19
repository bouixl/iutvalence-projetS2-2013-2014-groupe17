public class Application
{
	/**
	 * Methode principale, initialise le programme et lance la partie
	 * @param args Arguments de lancement
	 */
	public static void main(String[] args)
	{
		System.out.println("Création de la partie");
		Partie partie = new Partie();
		System.out.println("Demarrage de la partie");
		partie.lancerPartie();
		System.out.println("Fin de la partie");
	}
}

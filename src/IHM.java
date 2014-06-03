import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class IHM implements Runnable, ActionListener, KeyListener {
	
	private volatile boolean pret;
	private JFrame fenetre;
	private JMenuItem menuItemFermer;
	private JMenuItem menuItemAPropos;
	private JPanel panneauCarte;
	private boolean attendreReaction;
	private JScrollPane panneau;
	
	private Partie partie;
	private JPanel panneauActuel;
	private JPanel panneauCombat;
	private Direction directionMouvement;
	private boolean toucheHautEnfoncee;
	private boolean toucheBasEnfoncee;
	private boolean toucheDroiteEnfoncee;
	private boolean toucheGaucheEnfoncee;
	private long lastMoveTime;
	private Direction lastMoveDirection;
	private Iterator<String> iterateurCartes;
	private boolean toucheShiftEnfoncee;
	private int tileEnMain;
	private int layerEnEdition;
	
	public IHM()
	{
		this.pret = false;
		this.toucheHautEnfoncee = false;
		this.toucheBasEnfoncee = false;
		this.toucheDroiteEnfoncee = false;
		this.toucheGaucheEnfoncee = false;
		this.directionMouvement = null;
	}
	
	public boolean obtenirPret()
	{
		return this.pret;
	}
	
	public void afficherCombat()
	{
		System.out.println("COMBAT");
		this.panneauActuel = this.panneauCombat;
		this.panneauActuel.updateUI();
		this.partie.changerEtat("Carte");
	}
	
	public void afficherMenu()
	{
		
	}
	
	public void afficherEcranDemarrage()
	{
		
	}
	
	public void afficherGainsCombat()
	{
		
	}
	
	public void afficherMessage(String nom, String message)
	{
		JOptionPane.showMessageDialog(this.fenetre, message, nom, JOptionPane.PLAIN_MESSAGE);
	}
	
	public int proposerChoix(String nom, String question, String[] options)
	{
		int reponse = JOptionPane.showOptionDialog(this.fenetre, question, nom, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		return reponse;
	}
	
	public void afficherCarte()
	{
		this.panneauActuel = this.panneauCarte;
		Position position;
		Carte carte = this.partie.obtenirCarte();
		Equipe equipe = this.partie.obtenirEquipe();
		this.panneauCarte.removeAll();
		this.panneauCarte.setLayout(new GridLayout(carte.obtenirHauteur(), carte.obtenirLargeur()));
		
		for (int ligne = 0; ligne < carte.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < carte.obtenirLargeur(); colonne++)
			{
				position = new Position(ligne,colonne);
				
				BufferedImage img_finale = new BufferedImage(Application.LARGEUR_TILE, Application.HAUTEUR_TILE, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2 = img_finale.createGraphics();
				g2.drawImage(carte.obtenirCase(position), 0, 0, null);
				if(carte.evenementPresent(position))
				{
					g2.drawImage(carte.obtenirEvenement(position).obtenirApparence(), 0, 0, null);
				}
				if(equipe.obtenirPosition().equals(position))
				{
					g2.drawImage(equipe.obtenirApparence(), 0, 0, null);
				}
				g2.dispose();
				
				this.panneauCarte.add((new JLabel(new ImageIcon(img_finale))));
				img_finale = null;
			}
		}
		
		this.panneauActuel.updateUI();
		this.panneau.getViewport().setViewPosition(equipe.obtenirPosition().toPointCentre());
	}

	public void finJeu()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();

		if (source == this.menuItemAPropos)
		{
			JOptionPane.showMessageDialog(this.fenetre, "Tentative de RPG\nPar Loïc BOUIX, Boris HENROT, Nicolas ROUGE, Max SANFILIPPO et Valentin VERVACKE", "A propos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if (source == this.menuItemFermer)
		{
			if (JOptionPane.showConfirmDialog(this.fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
		}
		else
		{
			
		}
	}

	@Override
	public void run() {
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Projet 17");
		this.fenetre.setSize(Application.LARGEUR_ECRAN+10, Application.HAUTEUR_ECRAN+54);
		this.fenetre.setResizable(false);
		this.fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.fenetre.setLocationRelativeTo(null);
		
		JMenuBar barreDeMenu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		this.menuItemAPropos = new JMenuItem("A propos");
		this.menuItemAPropos.addActionListener(this);
		menu.add(this.menuItemAPropos);
		this.menuItemFermer = new JMenuItem("Fermer");
		this.menuItemFermer.addActionListener(this);
		menu.add(this.menuItemFermer);
		barreDeMenu.add(menu);
		this.fenetre.setJMenuBar(barreDeMenu);

		this.panneau = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.panneauCombat = new JPanel();
		this.panneauCombat.setBackground(Color.RED);
		this.panneauCarte = new JPanel();
		this.panneauCarte.setBackground(Color.BLACK);
		this.panneauActuel = this.panneauCarte;
		this.panneau.getViewport().add(this.panneauActuel);
		this.panneau.getViewport().setBackground(Color.BLACK);
		this.panneau.setPreferredSize(new Dimension(Application.LARGEUR_ECRAN, Application.HAUTEUR_ECRAN));
		this.fenetre.add(this.panneau);
		
		this.fenetre.addKeyListener(this);
		this.fenetre.setVisible(true);
		
		this.pret = true;
	}
	
	public void attendreReaction() {
		this.attendreReaction = true;
		while(this.attendreReaction)
		{
			try {
			    TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
			if(this.toucheShiftEnfoncee&&Partie.MAPPING)
			{
				if(this.partie.obtenirCarte().obtenirTileCase(this.partie.obtenirEquipe().obtenirPosition(),this.layerEnEdition)!=Tile.values()[this.tileEnMain])
				{
					this.partie.obtenirCarte().setCase(this.partie.obtenirEquipe().obtenirPosition(), Tile.values()[this.tileEnMain], this.layerEnEdition);
					actualiserCarte(false);
				}
			}
			if(this.directionMouvement!=null && ((System.nanoTime()-this.lastMoveTime)>150000000 || this.lastMoveDirection!=this.directionMouvement))
			{
				this.lastMoveTime = System.nanoTime();
				this.lastMoveDirection = this.directionMouvement;
				if(this.partie.obtenirCarte().peutAller(this.directionMouvement, this.partie.obtenirEquipe().obtenirPosition()))
				{
					this.partie.obtenirEquipe().deplacer(this.directionMouvement);
					if(this.partie.obtenirCarte().evenementPresent(this.partie.obtenirEquipe().obtenirPosition()))
						if(this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition()).auContact())
							this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition()).effectuerActions(this);
					this.partie.essaiCombat();
				}
				else
				{
					this.partie.obtenirEquipe().changerDirection(this.directionMouvement);
				}
				try {
				    TimeUnit.MILLISECONDS.sleep(9);
				} catch (InterruptedException e) {
				}
				this.attendreReaction = false;
			}
		}
	}

	public void transmettrePartie(Partie partie) {
		this.partie = partie;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(this.attendreReaction)
		{
			int touche = arg0.getKeyCode();
			if(this.partie.obtenirEtat()=="Carte")
			{
				switch(touche)
				{
					case Application.TOUCHE_HAUT:
						this.directionMouvement = Direction.HAUT;
						this.toucheHautEnfoncee = true;
						break;
					case Application.TOUCHE_DROITE:
						this.directionMouvement = Direction.DROITE;
						this.toucheDroiteEnfoncee = true;
						break;
					case Application.TOUCHE_BAS:
						this.directionMouvement = Direction.BAS;
						this.toucheBasEnfoncee = true;
						break;
					case Application.TOUCHE_GAUCHE:
						this.directionMouvement = Direction.GAUCHE;
						this.toucheGaucheEnfoncee = true;
						break;
					case Application.TOUCHE_ACTION:
						if (this.partie.obtenirCarte().evenementPresent(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())))
							if(!this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())).auContact())
								this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())).effectuerActions(this);
						break;
					case Application.TOUCHE_CYCLEMAP:
						if(Partie.DEBUG)
						{
							if(this.iterateurCartes==null)
								this.iterateurCartes = this.partie.obtenirEnsembleCartes().keySet().iterator();
							if(this.iterateurCartes.hasNext())
								this.partie.changerCarte(this.iterateurCartes.next(), new Position(0,0));
							else
								this.iterateurCartes = null;
						}
						break;
					case Application.TOUCHE_GHOST:
						if(Partie.DEBUG)
						{
							Partie.GHOST = !Partie.GHOST;
							System.out.println("Mode ghost: "+Boolean.toString(Partie.MAPPING));
						}
						break;
					case Application.TOUCHE_MAPPING:
						if(Partie.DEBUG)
						{
							Partie.MAPPING = !Partie.MAPPING;
							Partie.GHOST = Partie.MAPPING;
							this.tileEnMain = 0;
							System.out.println("Mode mapping: "+Boolean.toString(Partie.MAPPING));
							System.out.println("Mode ghost: "+Boolean.toString(Partie.MAPPING));
						}
						break;
					case Application.TOUCHE_POSERTILE:
						if(Partie.MAPPING)
							this.toucheShiftEnfoncee = true;
						break;
					case Application.TOUCHE_CYCLETILE:
						if(Partie.MAPPING)
						{
							this.tileEnMain++;
							if(this.layerEnEdition==0)
							{
								if(this.tileEnMain==6)
									this.tileEnMain = 0;
							}
							else
							{
								if(this.tileEnMain==13)
									this.tileEnMain = 6;
							}
							System.out.println("Vous utilisez le tile: "+Tile.values()[this.tileEnMain]);
						}
						break;
					case Application.TOUCHE_CHANGERLAYER:
						if(Partie.MAPPING)
						{
							if(this.layerEnEdition==0)
							{
								this.layerEnEdition = 1;
								this.tileEnMain = 6;
								
							}
							else
							{
								this.layerEnEdition = 0;
								this.tileEnMain = 0;
							}
							System.out.println("Vous éditez la couche: "+this.layerEnEdition);
							System.out.println("Vous utilisez le tile: "+Tile.values()[this.tileEnMain]);
						}
						break;
					case Application.TOUCHE_EXPORTER:
						if(Partie.MAPPING)
						{
							System.out.println("N'oubliez pas de modifier le nom de la carte.");
							System.out.println(this.partie.obtenirCarte().toString());
						}
						break;
					case Application.TOUCHE_CREERMAP:
						if(Partie.MAPPING)
							this.partie.nouvelleCarte(Integer.parseInt(JOptionPane.showInputDialog(this.fenetre, "Largeur de la map ?", "Creation nouvelle map", JOptionPane.QUESTION_MESSAGE)), Integer.parseInt(JOptionPane.showInputDialog(this.fenetre, "Hauteur de la map ?", "Creation nouvelle map", JOptionPane.QUESTION_MESSAGE)), JOptionPane.showInputDialog(this.fenetre, "Nom de la map ?", "Creation nouvelle map", JOptionPane.QUESTION_MESSAGE));
						break;
					default:
						break;
				}
				this.attendreReaction = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int touche = arg0.getKeyCode();
		if(this.partie.obtenirEtat()=="Carte")
		{
			switch(touche)
			{
				case Application.TOUCHE_HAUT:
					this.toucheHautEnfoncee = false;
					if(this.directionMouvement==Direction.HAUT)
						this.directionMouvement = null;
					break;
				case Application.TOUCHE_DROITE:
					this.toucheDroiteEnfoncee = false;
					if(this.directionMouvement==Direction.DROITE)
						this.directionMouvement = null;
					break;
				case Application.TOUCHE_BAS:
					this.toucheBasEnfoncee = false;
					if(this.directionMouvement==Direction.BAS)
						this.directionMouvement = null;
					break;
				case Application.TOUCHE_GAUCHE:
					this.toucheGaucheEnfoncee = false;
					if(this.directionMouvement==Direction.GAUCHE)
						this.directionMouvement = null;
					break;
				case Application.TOUCHE_POSERTILE:
					this.toucheShiftEnfoncee = false;
					break;
				default:
					break;
			}
			if(!this.toucheHautEnfoncee&&!toucheDroiteEnfoncee&&!toucheBasEnfoncee&&!toucheGaucheEnfoncee)
			{
				this.directionMouvement = null;
			}
			else
			{
				if(this.directionMouvement == null)
				{
					if(this.toucheHautEnfoncee)
						this.directionMouvement = Direction.HAUT;
					else if(this.toucheDroiteEnfoncee)
						this.directionMouvement = Direction.DROITE;
					else if(this.toucheBasEnfoncee)
						this.directionMouvement = Direction.BAS;
					else if(this.toucheGaucheEnfoncee)
						this.directionMouvement = Direction.GAUCHE;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
	public Partie renvoyerPartie()
	{
		return this.partie;
	}

	public void actualiserCarte(boolean evenementsAussi) {
		Carte carte = this.partie.obtenirCarte();
		Equipe equipe = this.partie.obtenirEquipe();
		int indexCase;
		Position position;
		Graphics2D g2;
		BufferedImage img_finale;
		
		if(evenementsAussi)
		{
			for (int ligne = 0; ligne < carte.obtenirHauteur(); ligne++)
			{
				for (int colonne = 0; colonne < carte.obtenirLargeur(); colonne++)
				{
					position = new Position(ligne,colonne);
					if(carte.evenementPresent(position))
					{
						indexCase = position.obtenirColonne()+(carte.obtenirLargeur()*(position.obtenirLigne()));
						this.panneauCarte.remove(indexCase);
						img_finale = new BufferedImage(Application.LARGEUR_TILE, Application.HAUTEUR_TILE, BufferedImage.TYPE_INT_ARGB);
						g2 = img_finale.createGraphics();
						g2.drawImage(carte.obtenirCase(position), 0, 0, null);
						g2.drawImage(carte.obtenirEvenement(position).obtenirApparence(), 0, 0, null);
						if(equipe.obtenirPosition().equals(position))
						{
							g2.drawImage(equipe.obtenirApparence(), 0, 0, null);
						}
						g2.dispose();
					
						this.panneauCarte.add((new JLabel(new ImageIcon(img_finale))),indexCase);
					}
				}
			}
			position = null;
		}
		
		indexCase = equipe.obtenirPosition().obtenirColonne()+(carte.obtenirLargeur()*(equipe.obtenirPosition().obtenirLigne()));
		this.panneauCarte.remove(indexCase);
		img_finale = new BufferedImage(Application.LARGEUR_TILE, Application.HAUTEUR_TILE, BufferedImage.TYPE_INT_ARGB);
		g2 = img_finale.createGraphics();
		g2.drawImage(carte.obtenirCase(equipe.obtenirPosition()), 0, 0, null);
		if(carte.evenementPresent(equipe.obtenirPosition()))
		{
			g2.drawImage(carte.obtenirEvenement(equipe.obtenirPosition()).obtenirApparence(), 0, 0, null);
		}
		g2.drawImage(equipe.obtenirApparence(), 0, 0, null);
		g2.dispose();
		this.panneauCarte.add((new JLabel(new ImageIcon(img_finale))),indexCase);
		
		if(Partie.MAPPING)
		{
			indexCase = equipe.obtenirPosition().ajouterOffset(Direction.DROITE).obtenirColonne()+(carte.obtenirLargeur()*(equipe.obtenirPosition().obtenirLigne()));
			this.panneauCarte.remove(indexCase);
			img_finale = new BufferedImage(Application.LARGEUR_TILE, Application.HAUTEUR_TILE, BufferedImage.TYPE_INT_ARGB);
			g2 = img_finale.createGraphics();
			g2.drawImage(carte.obtenirCase(equipe.obtenirPosition().ajouterOffset(Direction.DROITE)), 0, 0, null);
			if(carte.evenementPresent(equipe.obtenirPosition().ajouterOffset(Direction.DROITE)))
			{
				g2.drawImage(carte.obtenirEvenement(equipe.obtenirPosition().ajouterOffset(Direction.DROITE)).obtenirApparence(), 0, 0, null);
			}
			g2.dispose();
			this.panneauCarte.add((new JLabel(new ImageIcon(img_finale))),indexCase);
		}
		
		indexCase = equipe.obtenirAnciennePosition().obtenirColonne()+(carte.obtenirLargeur()*(equipe.obtenirAnciennePosition().obtenirLigne()));
		this.panneauCarte.remove(indexCase);
		img_finale = new BufferedImage(Application.LARGEUR_TILE, Application.HAUTEUR_TILE, BufferedImage.TYPE_INT_ARGB);
		g2 = img_finale.createGraphics();
		g2.drawImage(carte.obtenirCase(equipe.obtenirAnciennePosition()), 0, 0, null);
		if(carte.evenementPresent(equipe.obtenirAnciennePosition()))
		{
			g2.drawImage(carte.obtenirEvenement(equipe.obtenirAnciennePosition()).obtenirApparence(), 0, 0, null);
		}
		if(equipe.obtenirPosition().equals(equipe.obtenirAnciennePosition()))
		{
			g2.drawImage(equipe.obtenirApparence(), 0, 0, null);
		}
		g2.dispose();
		this.panneauCarte.add((new JLabel(new ImageIcon(img_finale))),indexCase);
		
		img_finale = null;
		this.panneauActuel.updateUI();
		this.panneau.getViewport().setViewPosition(equipe.obtenirPosition().toPointCentre());
	}
	
}

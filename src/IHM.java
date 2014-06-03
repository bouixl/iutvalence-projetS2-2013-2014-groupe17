import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
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
					case KeyEvent.VK_Z:
						this.directionMouvement = Direction.HAUT;
						this.toucheHautEnfoncee = true;
						break;
					case KeyEvent.VK_D:
						this.directionMouvement = Direction.DROITE;
						this.toucheDroiteEnfoncee = true;
						break;
					case KeyEvent.VK_S:
						this.directionMouvement = Direction.BAS;
						this.toucheBasEnfoncee = true;
						break;
					case KeyEvent.VK_Q:
						this.directionMouvement = Direction.GAUCHE;
						this.toucheGaucheEnfoncee = true;
						break;
					case KeyEvent.VK_SPACE:
						if (this.partie.obtenirCarte().evenementPresent(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())))
							if(!this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())).auContact())
								this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())).effectuerActions(this);
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
				case KeyEvent.VK_Z:
					this.toucheHautEnfoncee = false;
					if(this.directionMouvement==Direction.HAUT)
						this.directionMouvement = null;
					break;
				case KeyEvent.VK_D:
					this.toucheDroiteEnfoncee = false;
					if(this.directionMouvement==Direction.DROITE)
						this.directionMouvement = null;
					break;
				case KeyEvent.VK_S:
					this.toucheBasEnfoncee = false;
					if(this.directionMouvement==Direction.BAS)
						this.directionMouvement = null;
					break;
				case KeyEvent.VK_Q:
					this.toucheGaucheEnfoncee = false;
					if(this.directionMouvement==Direction.GAUCHE)
						this.directionMouvement = null;
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

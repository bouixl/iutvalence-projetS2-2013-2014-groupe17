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
	
	public IHM()
	{
		this.pret = false;
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
	
	public void afficherCarte()
	{
		this.panneauActuel = panneauCarte;
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
				
				//Image img_case = carte.obtenirCase(position);
				BufferedImage img_finale = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
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
		this.fenetre.setSize(658, 544);
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

		//this.panneau = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.panneau = new JScrollPane();
		this.panneauCombat = new JPanel();
		this.panneauCombat.setBackground(Color.RED);
		this.panneauCarte = new JPanel();
		this.panneauCarte.setBackground(Color.BLACK);
		this.panneauActuel = panneauCarte;
		this.panneau.getViewport().add(this.panneauActuel);
		this.panneau.setPreferredSize(new Dimension(640, 480));
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
		}
	}

	public void transmettrePartie(Partie partie) {
		this.partie = partie;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(this.attendreReaction)
		{
			char touche = arg0.getKeyChar();
			if(this.partie.obtenirEtat()=="Carte")
			{
				Direction direction;
				switch(touche)
				{
					case 'z':
						direction = Direction.HAUT;
						if(this.partie.obtenirCarte().peutAller(direction, this.partie.obtenirEquipe().obtenirPosition()))
						{
							this.partie.obtenirEquipe().deplacer(direction);
							this.partie.essaiCombat();
						}
						else
						{
							this.partie.obtenirEquipe().changerDirection(direction);
						}
						break;
					case 'd':
						direction = Direction.DROITE;
						if(this.partie.obtenirCarte().peutAller(direction, this.partie.obtenirEquipe().obtenirPosition()))
						{
							this.partie.obtenirEquipe().deplacer(direction);
							this.partie.essaiCombat();
						}
						else
						{
							this.partie.obtenirEquipe().changerDirection(direction);
						}
						break;
					case 's':
						direction = Direction.BAS;
						if(this.partie.obtenirCarte().peutAller(direction, this.partie.obtenirEquipe().obtenirPosition()))
						{
							this.partie.obtenirEquipe().deplacer(direction);
							this.partie.essaiCombat();
						}
						else
						{
							this.partie.obtenirEquipe().changerDirection(direction);
						}
						break;
					case 'q':
						direction = Direction.GAUCHE;
						if(this.partie.obtenirCarte().peutAller(direction, this.partie.obtenirEquipe().obtenirPosition()))
						{
							this.partie.obtenirEquipe().deplacer(direction);
							this.partie.essaiCombat();
						}
						else
						{
							this.partie.obtenirEquipe().changerDirection(direction);
						}
						break;
					case 'n':
						this.partie.changerCarte("MiniZone", new Position(2,2));
						break;
					case 'b':
						this.partie.changerCarte("TestZone", new Position(3,2));
						break;
					case ' ':
						if (this.partie.obtenirCarte().evenementPresent(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())))
							this.partie.obtenirCarte().obtenirEvenement(this.partie.obtenirEquipe().obtenirPosition().ajouterOffset(this.partie.obtenirEquipe().obtenirDirection())).effectuerActions();
						break;
				}
				this.attendreReaction = false;
			}
		}
	}
	
	
}

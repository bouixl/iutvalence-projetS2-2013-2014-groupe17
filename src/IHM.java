import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.WindowConstants;

public class IHM implements Runnable, ActionListener {
	
	private volatile boolean pret;
	private JFrame fenetre;
	private JMenuItem menuItemFermer;
	private JMenuItem menuItemAPropos;
	private JPanel panneauCarte;
	private boolean attendreReaction;
	private JPanel panneau;
	
	public IHM()
	{
		this.pret = false;
	}
	
	public boolean obtenirPret()
	{
		return this.pret;
	}
	
	public void afficherCombat(Combat combat)
	{
		
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
	
	public void afficherCarte(Carte carte, Equipe equipe)
	{
		this.panneauCarte.removeAll();
		this.panneauCarte.setLayout(new GridLayout(carte.obtenirHauteur(), carte.obtenirLargeur()));
		
		for (int ligne = 0; ligne < carte.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < carte.obtenirLargeur(); colonne++)
			{
				if(equipe.obtenirColonne()==colonne && equipe.obtenirLigne()==ligne)
				{
					ImageIcon apparence_tile = carte.obtenirTile(ligne,colonne).obtenirApparence(); 
					ImageIcon apparence_equipe = equipe.obtenirApparence();
					Image img1 = apparence_tile.getImage();
					Image img2 = apparence_equipe.getImage();
					BufferedImage img3 = new BufferedImage(32, 32, 1);
					Graphics2D g2 = img3.createGraphics();
					g2.drawImage(img1, 0, 0, null);
					g2.drawImage(img2, 0, 0, null);
					g2.dispose();
					this.panneauCarte.add((new JLabel(new ImageIcon(img3))));
				}
				else
				{
					this.panneauCarte.add((new JLabel(carte.obtenirTile(ligne,colonne).obtenirApparence())));
				}
			}
		}
		this.panneauCarte.updateUI();
		
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
		this.fenetre.setSize(640, 480);
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

		this.panneau = new JPanel();
		this.panneauCarte = new JPanel();
		this.panneauCarte.setBackground(Color.BLACK);
		this.panneau.add(this.panneauCarte);
		
		this.fenetre.add(this.panneau);
		
		this.fenetre. setVisible(true);
		
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
}

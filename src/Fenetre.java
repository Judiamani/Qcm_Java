import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Fenetre extends JFrame {

	public int numeroQuestion = 0;
	public int indexChoix[];
	public static int score;

	CardLayout cardLayout = new CardLayout();
	JPanel container = new JPanel();
	ButtonGroup buttonGroup = new ButtonGroup();

	public Fenetre(Question[] questions, Joueur joueur) {
		// TODO Auto-generated constructor stub

		this.setTitle("QCM Concours Esatic");
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		indexChoix = new int[questions.length];
		Font police = new Font("Courier New", Font.PLAIN, 20);

		// Bordure entre les differents composants
		container.setBorder(new EmptyBorder(20, 20, 20, 20));

		// Jpanel pour card d'identification et affichage de score
		JPanel identificationPanel = new JPanel(new GridLayout(3, 0));
		JPanel centerIdentificationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel basIdentificationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel questionPanel = new JPanel();
		JPanel scorePanel = new JPanel(new GridLayout(2, 0));
		JPanel basScorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Jpanels pour l'affichage des questions
		JPanel centerPanelQuestion = new JPanel(new GridLayout(5, 0));
		// Pour aligner de maniere vertical les cases a cocher
		JPanel basPanelQuestion = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Creation des composants pour identificationPanel
		JLabel bienvenuLabel = new JLabel(
				"<html>Bienvenue au concours <br> Saisissez votre Nom et Prénoms puis cliquez sur suivant"
						+ "<br> </html>");
		JLabel labelChampNom = new JLabel("Nom et Prenom :");
		JTextField champNom = new JTextField();
		champNom.setFont(police);
		champNom.setPreferredSize(new Dimension(150, 30));
		JButton btnSlidePrecedent = new JButton("Précédent");
		JButton btnSlideSuivant = new JButton("Suivant");
		btnSlidePrecedent.setFont(police);
		btnSlideSuivant.setFont(police);

		// Création des composants pour questionPanel
		JLabel questionLabel = new JLabel();
		questionLabel.setFont(police);
		JRadioButton btnChoix1 = new JRadioButton();
		JRadioButton btnChoix2 = new JRadioButton();
		JRadioButton btnChoix3 = new JRadioButton();
		JRadioButton btnChoix4 = new JRadioButton();
		JRadioButton btnChoix5 = new JRadioButton();

		JButton btnPrecedent = new JButton();
		JButton btnSuivant = new JButton();
		btnPrecedent.setEnabled(false);

		// On charge tous les boutons dans un tableau
		JRadioButton[] btnRadioButtons = { btnChoix1, btnChoix2, btnChoix3, btnChoix4, btnChoix5 };

		// Creation des composants pour scorePanel
		JLabel remerciementLabel = new JLabel();
		JButton recommencerBtn = new JButton("Precedent");
		recommencerBtn.setFont(police);

		// Assignation des Listener
		btnChoix1.addActionListener(new EtatListener());
		btnChoix2.addActionListener(new EtatListener());
		btnChoix3.addActionListener(new EtatListener());
		btnChoix4.addActionListener(new EtatListener());
		btnChoix5.addActionListener(new EtatListener());

		// Assignation de la police aux boutons
		btnChoix1.setFont(police);
		btnChoix2.setFont(police);
		btnChoix3.setFont(police);
		btnChoix4.setFont(police);
		btnChoix5.setFont(police);

		// Assignation des commandes d'action
		btnChoix1.setActionCommand("0");
		btnChoix2.setActionCommand("1");
		btnChoix3.setActionCommand("2");
		btnChoix4.setActionCommand("3");
		btnChoix5.setActionCommand("4");

		buttonGroup.add(btnChoix1);
		buttonGroup.add(btnChoix2);
		buttonGroup.add(btnChoix3);
		buttonGroup.add(btnChoix4);
		buttonGroup.add(btnChoix5);

		centerPanelQuestion.add(btnChoix1);
		centerPanelQuestion.add(btnChoix2);
		centerPanelQuestion.add(btnChoix3);
		centerPanelQuestion.add(btnChoix4);
		centerPanelQuestion.add(btnChoix5);

		// Assignation des composants a identificationPanel
		identificationPanel.add(bienvenuLabel);
		
		centerIdentificationPanel.add(labelChampNom);
		centerIdentificationPanel.add(champNom);
		identificationPanel.add(centerIdentificationPanel);
		basIdentificationPanel.add(btnSlidePrecedent);
		basIdentificationPanel.add(btnSlideSuivant);
		
		identificationPanel.add(basIdentificationPanel);

		// Assignation des composants a scorePanel
		scorePanel.add(remerciementLabel);
		basScorePanel.add(recommencerBtn);
		scorePanel.add(basScorePanel);

		// Footer
		btnPrecedent.setFont(police);
		btnSuivant.setFont(police);
		btnPrecedent.setText("Precedent");
		btnSuivant.setText("Suivant");

		basPanelQuestion.add(btnPrecedent);
		basPanelQuestion.add(btnSuivant);
		questionPanel.setLayout(new GridLayout(3, 0));
		questionPanel.add(questionLabel);
		questionPanel.add(centerPanelQuestion);
		questionPanel.add(basPanelQuestion);

		btnSuivant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				numeroQuestion++;
				btnPrecedent.setEnabled(true);
				if (numeroQuestion > questions.length - 1) {

					joueur.score = genererScore(questions, indexChoix);
					remerciementLabel.setText("<html> Merci aurevoir <br> " + joueur.nom.toUpperCase()
							+ " <br> Vous avez obtenu : " + joueur.score + "/" + questions.length + "</html>");
					cardLayout.next(container);

				} else {
					genererQuestionSuivante(questions, btnRadioButtons, questionLabel);
				}
			}
		});

		btnPrecedent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				numeroQuestion--;
				//On desactive le bouton precedent a la premiere question s
				if(numeroQuestion == 0) {
					btnPrecedent.setEnabled(false);
				}
				if (numeroQuestion < 0) {
					numeroQuestion = questions.length - 1;
				}
				genererQuestionSuivante(questions, btnRadioButtons, questionLabel);

			}
		});

		btnSlideSuivant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//si le champ de text est non vide, on genere la question suivante
				if(champNom.getText().length()==0){
					joueur.nom = champNom.getText();
				}
				else { 
				// On génere les questions
					joueur.nom = champNom.getText();
					genererQuestionSuivante(questions, btnRadioButtons, questionLabel);
					cardLayout.next(container);
				}
			}
		});

		recommencerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				numeroQuestion = 0;
				score = 0;
				btnPrecedent.setEnabled(false);
				indexChoix = new int[questions.length];
				champNom.setText("");
				cardLayout.next(container);
			}
		});

		// Application de la police a tous les JLabels
		JLabel jlabels[] = { labelChampNom, remerciementLabel, bienvenuLabel };

		for (int i = 0; i < jlabels.length; i++) {
			jlabels[i].setFont(police);
		}

		container.setLayout(cardLayout);
		container.add(identificationPanel);
		container.add(questionPanel);
		container.add(scorePanel);
		this.setContentPane(container);

		this.setVisible(true);

	}

	// A chaque clique sur un boutonRadio, on assigne l'index de reponse a l'index
	// de choix
	class EtatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			// Parcourir les enumerations de Button
			for (Enumeration<AbstractButton> enumerationButtons = buttonGroup.getElements(); enumerationButtons
					.hasMoreElements();) {

				AbstractButton button = enumerationButtons.nextElement();

				if (button.isSelected()) {
					// On recupere l'index du BoutonRadio
					indexChoix[numeroQuestion] = Integer.valueOf(button.getActionCommand().toString());
					break;
				}

			}

		}

	}

	public void genererQuestionSuivante(Question[] questions, JRadioButton[] btnRadioButtons, JLabel questionLabel) {

		// On recupere la question suivante
		Question question = questions[numeroQuestion];
		// On assigne cette question au label affichant la question
		questionLabel.setText("Question N˚" + (numeroQuestion + 1) + "/" + questions.length + ": " + question.libelle);

		// On assigne chaque boutton radio à une proposition de reponse
		for (int i = 0; i < question.reponses.length; i++) {
			String reponse = question.reponses[i];

			btnRadioButtons[i].setText(reponse);

			if (i == question.reponses.length - 1) {
				// On selectionne par defaut le dernier BoutonRadio (Je ne connais pas)
				btnRadioButtons[i].setSelected(true);
				btnRadioButtons[i].doClick();

			}

		}

	}

	public int genererScore(Question[] questions, int[] indexChoix) {

		/*
		 * ON verifie chaque la reponse de chaque question avec les choix choix du
		 * joueur
		 */
		for (int i = 0; i < indexChoix.length; i++) {
			// Bonne reponse
			Question question = questions[i] ;
			if (question.indexReponseCorrect == indexChoix[i]) {
				score = score + 1;
				// Le joueur a selectionné la reponse je ne connais pas
			} else if (indexChoix[i] == questions[i].reponses.length - 1) {
				score = score + 0;
				// Dans les autres cas la reponse n'est pas correcte
			} else {
				score = score - 1;
			}
		}

		return score;
	}

}

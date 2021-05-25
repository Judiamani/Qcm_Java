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

public class Fenetre2 extends JFrame {

	public Fenetre2() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("Form1");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		CardLayout cardLayout = new CardLayout() ;
		
		//Jpanel principal
		JPanel container = new JPanel() ;
		container.setLayout(cardLayout);
		
		//Creation des panels sous-principaux 
		JPanel identificationPanel = new JPanel() ;
		JPanel questionPanel = new JPanel();
		JPanel scorePanel = new JPanel() ;
		
		//Composants de identificationPanel
		JButton btnSuivant = new JButton("Suivant") ;
		
		//Composant pour question panel
		JLabel questionLabel = new JLabel("Bienvenue sur le questionPanel") ;
		
		identificationPanel.add(btnSuivant) ;
		questionPanel.add(questionLabel) ;
		
		container.add(identificationPanel) ;
		container.add(questionPanel) ;
		container.add(scorePanel) ;
		
		btnSuivant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cardLayout.next(container);
			
			}
		});
		
		
		this.setContentPane(container) ;
		this.setVisible(true);
	}
}

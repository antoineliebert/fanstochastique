package la_main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;

public class JFrameClass extends JFrame {

	private ArrayList<ArrayList<Caisse>> data_AL;
	
	private PauseButton pauseButton;
	private JPanel simuPanel;
	private JPanel statsPanel;
	
	private int tempsEnCours;
	public JFrameClass(ArrayList<ArrayList<Caisse>> data_AL) {

		this.data_AL = data_AL;
		pauseButton = new PauseButton();
		
		
	}
	
	
	
	public PauseButton getPauseButton() {
		return pauseButton;
	}



	public void showFenetre() {
		JFrame frame = new JFrame("Processus stochastiques appliqués au problème de la file d'attente");
		frame.setLayout(new BorderLayout ()); 
		//frame.setLayout(new GridLayout(1, 2));
		
		
		JPanel pausePanel = new JPanel();
		simuPanel = new JPanel();
		statsPanel = new JPanel();
		
		pausePanel.setLayout(new BorderLayout ()); 
		simuPanel.setLayout(new BorderLayout ()); 
		statsPanel.setLayout(new BorderLayout ()); 
		
		
		pausePanel.add("Center", pauseButton);
		

		simuPanel.add("West", new JTextField());
		simuPanel.add("West", new JLabel("Last Name:"));
		
		statsPanel.add("West", new JTextField());
	    
	    
	    JSplitPane simuAndButtonPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pausePanel, simuPanel);
	    simuAndButtonPanel.setResizeWeight(0.08);
	    
	    JSplitPane fullPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simuAndButtonPanel, statsPanel);
	    fullPanel.setResizeWeight(0.7);
	    
	    
		frame.add(fullPanel);
		
		//int frameWidth = 1024;
	    //int frameHeight = 768;
	    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    //frame.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
	    
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		
		
	}




}

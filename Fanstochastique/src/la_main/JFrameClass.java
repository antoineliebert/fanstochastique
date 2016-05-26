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
	public JFrameClass(ArrayList<ArrayList<Caisse>> data_AL) {

		this.data_AL = data_AL;
		pauseButton = new PauseButton();
		
		
	}
	
	
	
	public PauseButton getPauseButton() {
		return pauseButton;
	}



	public void showFenetre() {
		
		
	}
	
	public void paint(Graphics g) {
		
		JFrame frame = new JFrame("Processus stochastiques appliqués au problème de la file d'attente");
		frame.setLayout(new BorderLayout ()); 
		//frame.setLayout(new GridLayout(1, 2));
		
		
		JPanel pausePanel = new JPanel();
		simuPanel = new JPanel();
		statsPanel = new JPanel();
		
		pauseButton.add(pauseButton);
		
		
		statsPanel.setLayout(new BorderLayout ()); 

		panel1.add("North", pauseButton);
		
		panel1.add(new JTextField());
		panel1.add(new JLabel("Last Name:"));
		panel1.add(new JTextField());
		
	    panel2.add(new PauseButton());

	    panel1.setSize(600,800);
	    //panel2.setSize(200,800);
	    
	    JSplitPane simuAndButtonPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pausePanel, simuPanel);
	    
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
	
	
	
	
	public void test(){
		button.setText("blablon");
	}




}

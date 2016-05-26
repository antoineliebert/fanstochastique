package la_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;

public class JFrameClass extends JFrame {

	private ArrayList<ArrayList<Caisse>> data_AL;
	
	private PauseButton pauseButton;
	private CaisseButton caisseButton1;
	private CaisseButton caisseButton2;
	private JPanel simuPanel;
	private JPanel statsPanel;
	private JPanel pausePanel;
	
	private JFrame frame;
	
	private int tempsEnCours;
	
	public JFrameClass(ArrayList<ArrayList<Caisse>> data_AL) {

		this.data_AL = data_AL;
		this.tempsEnCours = 0;
		this.pauseButton = new PauseButton();
		
		frame = new JFrame("Processus stochastiques appliqués au problème de la file d'attente");
	
	}

	
	public void setTempsEnCours(int tempsEnCours) {
		this.tempsEnCours = tempsEnCours;
	}


	public PauseButton getPauseButton() {
		return pauseButton;
	}



	public void paint() {
		
						
		pausePanel = new JPanel();
		simuPanel = new JPanel();
		statsPanel = new JPanel();
		
		pausePanel.setBackground(Color.white);
		simuPanel.setBackground(Color.white);
		
		int nbCaisses = data_AL.get(0).size();
		
		int nbClientsMax = data_AL.get(tempsEnCours).get(0).getClient_total();
		
		if (nbCaisses > 1){
			for (int i = 1; i<nbCaisses; i++){
				if (nbClientsMax < data_AL.get(tempsEnCours).get(i).getClient_total())
					nbClientsMax = data_AL.get(tempsEnCours).get(i).getClient_total();
			}
		}
		
		ArrayList<String> clientFake = new ArrayList<String>();
		clientFake.add("fake");
		clientFake.add("fake");
		
		for (int i = 0 ; i < nbCaisses; i++){
			if (data_AL.get(tempsEnCours).get(i).getClient_total() < nbClientsMax){
				while (data_AL.get(tempsEnCours).get(i).getClients().size() < nbClientsMax){
					data_AL.get(tempsEnCours).get(i).getClients().add(clientFake);
				}
			}
		}
		
		pausePanel.setLayout(new BorderLayout ()); 
		//simuPanel.setLayout(new BorderLayout ()); 
		//simuPanel.setLayout(new GridLayout(nbClientsMax,nbCaisses));	
		simuPanel.setLayout(new GridLayout(0,nbCaisses));
		
		statsPanel.setLayout(new BorderLayout ());
		
		System.out.println(nbClientsMax + " " + nbCaisses);

		for (int i = 0; i < nbCaisses; i++){
			simuPanel.add(new CaisseButton(i, (800/nbCaisses)-(800/(2*nbCaisses)), 0));
			//simuPanel.add(new CaisseButton(i,0, 0));
			
		}

		for (int j = 0; j < nbClientsMax; j++){
			for (int i = 0; i < nbCaisses; i++){

				simuPanel.add(new ClientButton(j, data_AL.get(tempsEnCours).get(i).getClients().get(j).get(0), data_AL.get(tempsEnCours).get(i).getClients().get(j).get(1), (800/nbCaisses)-(800/(2*nbCaisses)), 0));
			}
		}
		
		
			/*
		for (int i = 0; i < nbCaisses; i++){
			simuPanel.add(new CaisseButton(i, (800/nbCaisses)-(800/(2*nbCaisses))-30, 0));		
		}

		for (int j = 0; j < data_AL.get(tempsEnCours).get(i).getClient_total(); j++){
			simuPanel.add(new ClientButton(j, data_AL.get(tempsEnCours).get(i).getClients().get(j).get(0), data_AL.get(tempsEnCours).get(i).getClients().get(j).get(1), (800/nbCaisses)-(800/(2*nbCaisses))-30, 0));
		}*/
		
		pausePanel.add("Center", pauseButton);
		
		
		statsPanel.add("West", new JTextField());
	    
	    
	    JSplitPane simuAndButtonPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pausePanel, simuPanel);
	    simuAndButtonPanel.setResizeWeight(0.08);
	    
	    JSplitPane fullPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simuAndButtonPanel, statsPanel);
	    fullPanel.setResizeWeight(0.8);
	    
	    
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
	






}

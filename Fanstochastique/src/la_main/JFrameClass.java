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
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class JFrameClass extends JFrame implements Observer {

	private ArrayList<ArrayList<Caisse>> data_AL;
	
	private PauseButton pauseButton;
	private ForwardButton forwardButton;
	private RewindButton rewindButton;
	
	private JPanel simuPanel;
	private JPanel statsPanel;
	private JPanel pausePanel;
	
	private JPanel statsCaissePanel = new JPanel();
	private JPanel statsClientPanel = new JPanel();
	
	private JFrame frame;
	
	private ClickID clickID;
	
	private int tempsEnCours;
	
	public JFrameClass(ArrayList<ArrayList<Caisse>> data_AL, ClickID clickID) {

		this.data_AL = data_AL;
		this.clickID = clickID;
		
		this.tempsEnCours = 0;
		
		this.pauseButton = new PauseButton();
		this.forwardButton = new ForwardButton();
		this.rewindButton = new RewindButton();
		
		pausePanel = new JPanel();
		pausePanel.setLayout(new GridLayout(1,3));
		pausePanel.add(pauseButton);
		pausePanel.add(rewindButton);
		pausePanel.add(forwardButton);
		
		frame = new JFrame("Processus stochastiques appliqués au problème de la file d'attente");
	
	}

	
	public void setTempsEnCours(int tempsEnCours) {
		this.tempsEnCours = tempsEnCours;
	}


	public PauseButton getPauseButton() {
		return pauseButton;
	}



	public ForwardButton getForwardButton() {
		return forwardButton;
	}


	public RewindButton getRewindButton() {
		return rewindButton;
	}


	public void paint() {
				
		frame.getContentPane().removeAll();
		//pausePanel = new JPanel();
		simuPanel = new JPanel();
		statsPanel = new JPanel();
		
		statsCaissePanel = new JPanel();
		statsClientPanel = new JPanel();
		
		
		pausePanel.setBackground(Color.white);
		simuPanel.setBackground(Color.white);
		
		int nbCaisses = data_AL.get(0).size();		
		int nbClientsMax = data_AL.get(tempsEnCours).get(0).getTotalClients();
		
		if (nbCaisses > 1){
			for (int i = 1; i<nbCaisses; i++){
				if (nbClientsMax < data_AL.get(tempsEnCours).get(i).getTotalClients())
					nbClientsMax = data_AL.get(tempsEnCours).get(i).getTotalClients();
			}
		}
		
		ArrayList<Object> clientFake = new ArrayList<Object>();
		clientFake.add("fake");
		clientFake.add(0.0);
		
		for (int i = 0 ; i < nbCaisses; i++){
			if (data_AL.get(tempsEnCours).get(i).getTotalClients() < nbClientsMax){
				while (data_AL.get(tempsEnCours).get(i).getClients().size() < nbClientsMax){
					data_AL.get(tempsEnCours).get(i).getClients().add(clientFake);
				}
			}
		}
		
		
		simuPanel.setLayout(new GridLayout(0,nbCaisses));
		statsPanel.setLayout(new GridLayout(0,1));
		statsCaissePanel.setLayout(new GridLayout(0,1));
		statsClientPanel.setLayout(new GridLayout(0,1));
		
		if (clickID.getIDCaisse() == -1 )
			statsCaissePanel.add(new JLabel("Cliquez sur une caisse pour voir ses statistiques"));
		else
		{
			statsCaissePanel.add(new JLabel("Nom de la caisse : " + data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getName()));
			statsCaissePanel.add(new JLabel("Statut de la caisse : " + data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getStatus()));
			statsCaissePanel.add(new JLabel("Vitesse moyenne : " + String.valueOf(data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getAvgSpeed()) + " clients/minute"));
			statsCaissePanel.add(new JLabel("Vitesse maximale : " + String.valueOf(data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getMaxSpeed()) + " clients/minute"));
			statsCaissePanel.add(new JLabel("Nombre de clients total : " + String.valueOf(data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getTotalClients())));
			statsCaissePanel.add(new JLabel("Nombre de clients contents : " + String.valueOf(data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getHappyClient())));
			statsCaissePanel.add(new JLabel("Nombre de clients mécontents : " + String.valueOf(data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getUnhappyClient())));
			statsCaissePanel.add(new JLabel("Nombre de clients neutres : " + String.valueOf(data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getNeutralClient())));
		}
		
		
		if (clickID.getIDClient() == -1 )
			statsClientPanel.add(new JLabel("Cliquez sur un client pour voir ses statistiques"));
		else
		{
			int placement = clickID.getIDClient()+1;
			statsClientPanel.add(new JLabel("Placement du client dans la file : " + placement));
			statsClientPanel.add(new JLabel("Statut du client : " + data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getClients().get(clickID.getIDClient()).get(0)));
			statsClientPanel.add(new JLabel("Theta S du client : " + data_AL.get(tempsEnCours).get(clickID.getIDCaisse()).getClients().get(clickID.getIDClient()).get(1)));
		}
		
		//System.out.println(nbClientsMax + " " + nbCaisses);

		for (int i = 0; i < nbCaisses; i++){
			simuPanel.add(new CaisseButton(i, data_AL.get(tempsEnCours).get(i).getStatus(), (700/nbCaisses)-(700/(2*nbCaisses)), 0, clickID));
			//simuPanel.add(new CaisseButton(i,0, 0));
			
		}

		for (int j = 0; j < nbClientsMax; j++){
			for (int i = 0; i < nbCaisses; i++){
				simuPanel.add(new ClientButton(j, i, data_AL.get(tempsEnCours).get(i).getClients().get(j).get(0), data_AL.get(tempsEnCours).get(i).getClients().get(j).get(1), (700/nbCaisses)-(700/(2*nbCaisses)), 0, clickID));
			}
		}
		
	
		
		statsPanel.add(statsCaissePanel);
		statsPanel.add(statsClientPanel);
	    
	    
	    JSplitPane simuAndButtonPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pausePanel, simuPanel);
	    simuAndButtonPanel.setResizeWeight(0.08);
	    
	    JSplitPane fullPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simuAndButtonPanel, statsPanel);
	    fullPanel.setResizeWeight(0.95);
	    
	    
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


	@Override
	public void update(Observable o, Object arg) {
		paint();
		
	}
	






}

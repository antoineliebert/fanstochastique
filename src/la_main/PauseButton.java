package la_main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PauseButton extends JButton implements MouseListener{


  private boolean isPaused;
  
  private ImageIcon imgPause;
  private ImageIcon imgPlay;
  
	private JButton pauseLabel;
	
	private URL url;
	private URL url1;
	
	private ClickID clickID;
	
  public PauseButton(final ClickID clickID){

	  this.clickID = clickID;
	  
    url = Main.class.getResource(
            "/res/pause.png");
	final ImageIcon imgPause = new ImageIcon(url);

  
  url1 = Main.class.getResource(
          "/res/play.png");
	final ImageIcon imgPlay = new ImageIcon(url1);

	
	pauseLabel = new JButton(imgPause);
   
	pauseLabel.setBackground(Color.white);
	
	pauseLabel.addActionListener(new ActionListener() {          
	    public void actionPerformed(ActionEvent e) {
	         
	   	  if (isPaused){
			  pauseLabel.setIcon(imgPause);
			  isPaused = false;
			  clickID.setIDPause(1);
		  }
		  else
		  {
			  pauseLabel.setIcon(imgPlay);
			  isPaused = true;
			  clickID.setIDPause(-1);
		  }
	    }
	}); 
	
    isPaused = false;
    
    this.addMouseListener(this);
  }
  
  public JButton getPauseLabel(){
	  return pauseLabel;
  }
  
  public boolean getIsPaused() {
	return isPaused;
}

/*
public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
    //g2d.drawImage(imgDisp, 0, 0, this.getWidth(), this.getHeight(), this);
    //g2d.drawImage(imgDisp, this.getWidth()/3, 3, this);
    g2d.drawImage(imgDisp, 90, 3, this);
    //this.setBounds(0, 0, 50, 50);
}*/

  public void mouseClicked(MouseEvent event) { 
	  



	  
  }

  //M�thode appel�e lors du survol de la souris
  public void mouseEntered(MouseEvent event) { }

  //M�thode appel�e lorsque la souris sort de la zone du bouton
  public void mouseExited(MouseEvent event) { }

  //M�thode appel�e lorsque l'on presse le bouton gauche de la souris
  public void mousePressed(MouseEvent event) { }

  //M�thode appel�e lorsque l'on rel�che le clic de souris
  public void mouseReleased(MouseEvent event) { }       
  
  
  
}
package la_main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class PauseButton extends JButton implements MouseListener{

  private Image imgPause;
  private Image imgPlay;
  private Image imgDisp;
  private boolean isPaused;
  public PauseButton(){
   
    try {
      imgPause = ImageIO.read(new File("pause.png"));
      imgPlay = ImageIO.read(new File("play.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    imgDisp = imgPause;
    isPaused = false;
    
    this.addMouseListener(this);
  }
  
  
  public boolean isPaused() {
	return isPaused;
}


public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
    g2d.drawImage(imgDisp, 0, 0, this.getWidth(), this.getHeight(), this);
  }

  public void mouseClicked(MouseEvent event) { 
	  
	  if (imgDisp == imgPause){
		  imgDisp = imgPlay;
		  isPaused = true;
	  }		
	  else
	  {
		  imgDisp = imgPause;
		  isPaused = false;
	  }
	  repaint();
	  
  }

  //Méthode appelée lors du survol de la souris
  public void mouseEntered(MouseEvent event) { }

  //Méthode appelée lorsque la souris sort de la zone du bouton
  public void mouseExited(MouseEvent event) { }

  //Méthode appelée lorsque l'on presse le bouton gauche de la souris
  public void mousePressed(MouseEvent event) { }

  //Méthode appelée lorsque l'on relâche le clic de souris
  public void mouseReleased(MouseEvent event) { }       
  
  
  
}
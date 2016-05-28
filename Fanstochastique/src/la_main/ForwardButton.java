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

public class ForwardButton extends JButton implements MouseListener{

  private Image imgForward;
  private int forwardCpt;
  
  public ForwardButton(){
   
    try {
    	imgForward = ImageIO.read(new File("src/" + "forward.png"));
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
   
    forwardCpt = 1;
    
    this.addMouseListener(this);
  }
  
  
  public int getForwardCpt() {
	return forwardCpt;
}


public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
    //g2d.drawImage(imgDisp, 0, 0, this.getWidth(), this.getHeight(), this);
    g2d.drawImage(imgForward, 90, 3, this);
    //g2d.drawImage(imgForward, 0, 3, this);
    //this.setBounds(0, 0, 50, 50);
}

  public void mouseClicked(MouseEvent event) { 
	  
	  forwardCpt += 1;
	  
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
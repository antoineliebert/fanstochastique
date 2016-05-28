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

public class ForwardButton extends JButton implements MouseListener{

	private ImageIcon imgForward;
	private JButton forLabel;
	
  private int forwardCpt;
  
  public ForwardButton(){
   
	  URL url = Main.class.getResource(
              "/res/forward.png");
  	ImageIcon imgForward = new ImageIcon(url);
    forLabel = new JButton(imgForward);
    
    forLabel.setBackground(Color.white);
    
    forLabel.addActionListener(new ActionListener() {          
	    public void actionPerformed(ActionEvent e) {
	         System.out.println("forward");
	         forwardCpt += 1;
	    }
	}); 
    
    forwardCpt = 1;

    
    this.addMouseListener(this);
  }
  
  public JButton getForLabel(){
	  return forLabel;
  }
  
  public int getForwardCpt() {
	return forwardCpt;
}


  public void mouseClicked(MouseEvent event) { 
	  System.out.println("yo");
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
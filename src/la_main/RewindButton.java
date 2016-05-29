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
import javax.swing.JLabel;

public class RewindButton extends JButton implements MouseListener{

  //private Image imgRewind;
	private ImageIcon imgRewind;
	private JButton rewLabel;
  private int rewindCpt;
  
  public RewindButton(){
   /*
    try {
    	//imgRewind = ImageIO.read(new File("res/rewind.png"));
    	URL url = Main.class.getResource(
                "/resources/rewind.png");
    	
    	ImageIcon imgRewind = new ImageIcon(url);
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    */
	  URL url = Main.class.getResource(
              "/res/rewind.png");
  	ImageIcon imgRewind = new ImageIcon(url);
    rewLabel = new JButton(imgRewind);

    rewLabel.setBackground(Color.white);
    
    rewLabel.addActionListener(new ActionListener() {          
	    public void actionPerformed(ActionEvent e) {
	         System.out.println("Rewind");
	         rewindCpt += 1;
	    }
	}); 
    
    rewindCpt = 1;

    
    this.addMouseListener(this);
  }
  
  public JButton getRewLabel(){
	  return rewLabel;
  }
  
  public int getRewindCpt() {
	return rewindCpt;
}

/*
public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
    //g2d.drawImage(imgDisp, 0, 0, this.getWidth(), this.getHeight(), this);
    g2d.drawImage(imgRewind, 90, 3, this);
    //g2d.drawImage(imgrewind, 0, 3, this);
    //this.setBounds(0, 0, 50, 50);
}
*/
  public void mouseClicked(MouseEvent event) { 
	  System.out.println("rew");
	  rewindCpt += 1;
	  
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
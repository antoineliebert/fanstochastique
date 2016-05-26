package la_main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 

import javax.imageio.ImageIO;
import javax.swing.JComponent;

//public class CaisseButton extends JButton implements MouseListener{
public class ClientButton extends JComponent implements MouseListener{

  private Image imgDisp;
  
  private int clientID;
  private int dx;
  private int dy;
  private String happyness;
  private String theta_s;
  
  public ClientButton(int clientID, String happyness, String theta_s, int dx, int dy){
   
	  this.clientID = clientID;
	  this.happyness = happyness;
	  this.theta_s = theta_s;
	  this.dx = dx;
	  this.dy = dy;
    
    this.addMouseListener(this);
  }

/*
public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    
    //g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
    //g2d.drawImage(imgDisp, 0, 0, this.getWidth(), this.getHeight(), this);
    

    //g2d.drawImage(imgDisp, 0, 0, 30, 30, this);
    g2d.drawImage(imgDisp, dx, dy, this);
    
    //this.setBounds(0, 0, 30, 30);
    //this.setBounds(dx, dy, dx+30, dy+30);
    //this.setBounds(0, 0, this.getWidth(), this.getHeight());
    
}
*/
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

	Image img1 = Toolkit.getDefaultToolkit().getImage(happyness + ".png");
    
    if (happyness != "fake")
    	g2.drawImage(img1, dx, dy, this);
  }

  public void mouseClicked(MouseEvent event) { 
System.out.println("client : " + clientID);
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
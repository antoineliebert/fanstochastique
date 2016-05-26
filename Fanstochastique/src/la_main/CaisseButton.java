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
public class CaisseButton extends JComponent implements MouseListener{

  private Image imgDisp;
  
  private int caisseID;
  private int dx;
  private int dy;
  
  public CaisseButton(int caisseID, int dx, int dy){
   
	  this.caisseID = caisseID;
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

    Image img1 = Toolkit.getDefaultToolkit().getImage("caisse.png");
    g2.drawImage(img1, dx, dy, this);
    //g2.finalize();
  }

  public void mouseClicked(MouseEvent event) { 
System.out.println("caisse : " + caisseID);
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
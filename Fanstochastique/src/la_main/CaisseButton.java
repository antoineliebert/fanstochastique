package la_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

//public class CaisseButton extends JButton implements MouseListener{
public class CaisseButton extends JComponent implements MouseListener{

  private Image imgDisp;
  
  private int caisseID;
  private String status;
  private int dx;
  private int dy;
  
  private JButton caisseLabel;
  
  private ClickID clickID;
  
  public CaisseButton(int caisseID, String status, int dx, int dy, ClickID clickID){
   
	  this.caisseID = caisseID;
	  this.status = status;
	  this.dx = dx;
	  this.dy = dy;
	  this.clickID = clickID;
    this.addMouseListener(this);
    
    URL url = Main.class.getResource(
            "/res/" + status + ".png");
	ImageIcon imgCaisse = new ImageIcon(url);
	caisseLabel = new JButton(imgCaisse);
  
	caisseLabel.setBackground(Color.white);
	
	caisseLabel.addActionListener(new ActionListener() {          
	    public void actionPerformed(ActionEvent e) {
	    	clickID.setIDCaisse(caisseID, "Caisse");
	    }
	}); 
  
  }

/*
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    
    Image img1 = Toolkit.getDefaultToolkit().getImage(status + ".png");
    g2.drawImage(img1, dx, dy, this);
    //g2.finalize();
  }
*/
  
  public JButton getCaisseLabel(){
	  return caisseLabel;
  }
  
  public void mouseClicked(MouseEvent event) { 
	  
	  clickID.setIDCaisse(caisseID, "Caisse");
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
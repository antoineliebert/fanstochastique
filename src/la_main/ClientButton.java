package la_main;

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
import javax.swing.JPanel;

//public class CaisseButton extends JButton implements MouseListener{
public class ClientButton extends JComponent implements MouseListener{

  private Image imgDisp;
  
  private int clientID;
  private int caisseID;
  private int dx;
  private int dy;
  private String status;
  private double theta_s;
  
  private ClickID clickID;
  
  private JButton clientLabel;
  
  public ClientButton(final int clientID, final int caisseID, Object status, Object theta_s, int dx, int dy, final ClickID clickID){
   
	  this.clientID = clientID;
	  this.caisseID = caisseID;
	  this.status = status.toString();
	  this.theta_s = (double) theta_s;
	  this.dx = dx;
	  this.dy = dy;
	  
	  this.clickID = clickID;
    
	  clientLabel = new JButton();
	  
	  
	  if (status != "fake")
	  {
		  
	  URL url = Main.class.getResource(
	            "/res/" + status + ".png");
		ImageIcon imgClient = new ImageIcon(url);
		clientLabel .setIcon(imgClient);
	  
		clientLabel.setBackground(Color.white);
		
		clientLabel.addActionListener(new ActionListener() {          
		    public void actionPerformed(ActionEvent e) {
		    	clickID.setIDCaisse(caisseID, "Client");
		  	  clickID.setIDClient(clientID);
		    }
		}); 
		
	  }
    this.addMouseListener(this);
  }


  public JButton getClientLabel(){
	  return clientLabel;
  }
  
  /*
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

	Image img1 = Toolkit.getDefaultToolkit().getImage(status + ".png");
    
    if (status != "fake")
    	g2.drawImage(img1, dx, dy, this);
  }
*/
  public void mouseClicked(MouseEvent event) { 
	  clickID.setIDCaisse(caisseID, "Client");
	  clickID.setIDClient(clientID);
	  
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
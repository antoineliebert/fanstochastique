package la_main;

import java.util.Observable;
import java.util.Observer;

public class Thread_Simu {

	private JFrameClass jFrameClass;
	private int tMax;
	private ClickID clickID;
	
	public Thread_Simu (JFrameClass jFrameClass, int tMax, ClickID clickID) {
		
		this.jFrameClass = jFrameClass;
		this.tMax = tMax;
		this.clickID = clickID;
		
		int tNow = 0;
		
		while (tNow < tMax-1) {
		
			try {
		    	Thread.sleep(jFrameClass.getRewindButton().getRewindCpt()*1000/jFrameClass.getForwardButton().getForwardCpt());
		    	if (!jFrameClass.getPauseButton().getIsPaused())
		    	{
		    	tNow += 1;
		    	jFrameClass.setTempsEnCours(tNow);
		    	clickID.setIDCaisse(-1, "Thread");
		    	clickID.setIDClient(-1);
		    	jFrameClass.paint();
		    	}
		    	
		    }  catch (InterruptedException e) {
		        
		        // gestion de l'erreur
		    }
		}
	}


}

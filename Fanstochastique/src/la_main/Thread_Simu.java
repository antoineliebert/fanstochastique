package la_main;

public class Thread_Simu {

	private JFrameClass jFrameClass;
	private int tMax;
	
	public Thread_Simu (JFrameClass jFrameClass, int tMax) {
		
		this.jFrameClass = jFrameClass;
		this.tMax = tMax;
		
		int tNow = 0;
		
		while (tNow < tMax-1) {
		
			try {
		    	Thread.sleep(1000);
		    	tNow += 1;
		    	jFrameClass.setTempsEnCours(tNow);
		    	jFrameClass.paint();
		    	
		    }  catch (InterruptedException e) {
		        
		        // gestion de l'erreur
		    }
		}
	}

}

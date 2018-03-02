import javax.swing.SwingUtilities;

import Control.*;
import Model.*;
import View.*;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game() ; 
		Processor processor = new Processor(game);
		
		
		new FrmMain(processor , game); 
		//FrmMain frm = new FrmMain();
		 /*
		  SwingUtilities.invokeLater(new Runnable() {
		         public void run() {
		            new FrmMain(); // Let the constructor do the job
		         }
		      });
		      */
	}

}

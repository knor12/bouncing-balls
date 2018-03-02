package View;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import Model.Observer;
import Control.Processor;

public class pnlSpeed extends JPanel implements  Observer {
	
	JScrollBar scrolBar ;
	Processor processor ; 
	
	public pnlSpeed(Processor processor){
		
		scrolBar = new JScrollBar(JScrollBar.VERTICAL);
		scrolBar.setMaximum(100);
		scrolBar.setMinimum(2);
		scrolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setLayout( new BorderLayout() );
		this.add(scrolBar , "Center");
		this.setVisible(true);
		this.processor = processor ;
		scrolBar.setValue(processor.getTimerDelay());
		
		scrolBar.addAdjustmentListener(new MyAdjustmentListener());
		
	}
	
	 class MyAdjustmentListener implements AdjustmentListener {
		    public void adjustmentValueChanged(AdjustmentEvent e) {
		    	processor.setTimerDelay(scrolBar.getValue());
		    }
		  }

	public void ObserverCallEven(Object object) {
		// not really needed 
		scrolBar.setValue(processor.getTimerDelay());
	}

}

package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;


import Control.*;
import Model.*;

public class FrmMain extends JFrame implements Observer {
	
	int Width = 200 ; 
	int Height = 200 ; 
	Integer num_Iterations =0 ; 
	
	Processor processor; 
	
	Game game ; 
	
	public FrmMain(Processor processor , Game game  ){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
		setTitle("Test");
		pack();           // pack all the components in the JFrame
		setVisible(true); // show it
		this.setSize(Width, Height);
		requestFocus();   // set the focus to JFrame to receive KeyEvent
		setLayout( new BorderLayout() ); 
		add(new JPanel() , "North");
		add(new JPanel() , "South");
		add(new pnlSpeed(processor) , "East");
		add(new JPanel() , "West");
		add(new PnlGame( game ,  processor ) , "Center");
		processor.addObserver(this);
		
	}
	
	
	
	public void ObserverCallEven(Object object) {
		// TODO Auto-generated method stub

		setTitle();

	}
	
	private void setTitle() {
		// TODO Auto-generated method stub
		num_Iterations+=1; 
		this.setTitle(num_Iterations.toString());
		
		
	}



	public FrmMain(){
	
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
			setTitle("Test");
			pack();           // pack all the components in the JFrame
			setVisible(true); // show it
			this.setSize(Width, Height);
			requestFocus();   // set the focus to JFrame to receive KeyEvent
			setLayout( new BorderLayout() ); 
			add(new PnlGame() , "North");
			add(new PnlGame() , "South");
			add(new PnlGame() , "East");
			add(new PnlGame() , "West");
			add(new PnlGame() , "Center");
			
	}
	
	
	
	

}

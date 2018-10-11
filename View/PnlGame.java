package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Control.*;
import Model.*;

public class PnlGame extends JPanel implements Observer  {



	private Game game ;
	private Processor processor  ; 

	private Timer timer ; 
	//private int  delay = 10; //milliseconds timer update 
	private DrawableObjectFactory  DrawableObjectFactory ;
	
	private ArrayList<AbstractDrawable> DrawablesList = new ArrayList<AbstractDrawable>() ; 

	public PnlGame(Game game , Processor processor){

		this.game = game ; 
		this.processor = processor ;
		processor.addObserver(this);
		//graphics = this.getGraphics();
		DrawableObjectFactory = new DrawableObjectFactory(this);
		timer = new Timer(processor.getTimerDelay(), taskPerformer);
		timer.start();


	}

	public PnlGame(){



		this.setBackground(Color.WHITE);

	
		setBorder(BorderFactory.createLineBorder(Color.black));
		setVisible(true); // show it
	}

	public void ObserverCallEven(Object object) {
		// TODO Auto-generated method stub

		this.updateUI();

	}








	ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			
			timer.stop();
			processor.ProcessBalls();
			timer = new Timer(processor.getTimerDelay(), taskPerformer);
			timer.start();
			
			
		}
	};





	


	@Override   
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // paint background

		drawAll( g);
	}


	private void drawAll(Graphics g){
		
		int i ; 
		
		
		
		ArrayList<ObjectModel> ObjectModellist = game.getListOfObjects(Enum_Object_Model.ALL);
		ObjectModellist.add(game.getOutline());
		for (i=0 ; i <ObjectModellist.size() ;i++){
			DrawablesList.add(DrawableObjectFactory.getDrawableObject(ObjectModellist.get(i)));
		}
		
		for (i=0 ; i <ObjectModellist.size() ;i++){
			DrawablesList.get(i).draw(g);
		}
			
		
		ObjectModellist.removeAll(ObjectModellist);
		ObjectModellist.clear();
		DrawablesList.removeAll(DrawablesList);
		DrawablesList.clear();
	}

}

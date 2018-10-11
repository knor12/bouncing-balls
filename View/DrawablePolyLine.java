package View;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import Model.*;

public class DrawablePolyLine extends AbstractDrawable {
	
	private Outline outline ; 


	public DrawablePolyLine(JComponent canvas ,Outline outline) {
		super(canvas);
		// TODO Auto-generated constructor stub
		this.outline = outline ; 
	}
	
	
	public void  draw(Graphics g){
		
		ArrayList<ObjectModel> listLines = outline.getLines();
		DrawableLine drawableLine ;
		int i ;
		for (i=0; i < listLines.size(); i++){
			
			drawableLine = new DrawableLine(canvas ,(Line)listLines.get(i) );
			drawableLine.draw(g);
			
		}
		
	
	}

}

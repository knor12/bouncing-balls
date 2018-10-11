package View;

import java.awt.Graphics;

import javax.swing.JComponent;

import Model.*;

public class DrawableLine extends AbstractDrawable {
	
	private Line line ; 


	public DrawableLine(JComponent canvas , Line line) {
		super(canvas);
		// TODO Auto-generated constructor stub
		this.line = line ; 
	}
	
	
	public void  draw(Graphics g){
		
		int X1 = getRealX(line.getStartPoint().getX())  ; 
		int Y1 = getRealY(line.getStartPoint().getY()) ;
		int X2 = getRealX(line.getEndPoint().getX())  ; 
		int Y2 = getRealY(line.getEndPoint().getY()) ;
		
		g.setColor(line.getColor());
		g.drawLine(X1,Y1,X2,Y2);
	
	}
}

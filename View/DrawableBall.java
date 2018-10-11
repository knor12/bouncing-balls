package View;

import java.awt.Graphics;

import javax.swing.JComponent;

import Model.*;

public class DrawableBall extends AbstractDrawable {

	Ball ball ; 

	public DrawableBall(JComponent canvas , Ball ball) {
		super(canvas);
		// TODO Auto-generated constructor stub

		this.ball = ball ;
	}
	
	
	public void  draw(Graphics g){

		
		int x= getRealX(ball.getCenter().getX()); 
		int y= getRealY(ball.getCenter().getY()); 
		int radius =getRealDistance( ball.getRadius());
		
		g.setColor(ball.getColor());
		g.drawOval(x-radius, y-radius, radius*2, radius*2);
		
		g.setColor(ball.getFillColor());
		radius=radius-1 ; // so the outline is bigger than the fill
		g.fillOval(x-radius, y-radius, radius*2, radius*2);

		
		
	}


}

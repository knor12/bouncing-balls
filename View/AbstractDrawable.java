package View;

import java.awt.Graphics;

import javax.swing.*;

public class AbstractDrawable {
	
	
	/*
	 * 
	 * 
	 * 
	 * all objects drawn consider the full canvas as a 100/100 xy axis 
	 * 
	 * to simplify the drawing process the canvas is considered to be squared shape, if it is not then only 
	 * the shorted side of the rectangle is considered
	 * 
	 * 
	 *  (0.0,100.0)                (100.0,100.0)
	 *             +--------------+
	 *             |              |			   	
	 *             |              |	 
	 *             |              |	
	 *             |              |	 
	 *             |              |	 
	 *             +--------------+ 
	 *    (0.0,0.0)               (100.0,0.0)
	 */
	
	JComponent canvas  ; 
	public AbstractDrawable(JComponent canvas ){
		this.canvas = canvas ; 
		
	}
	
	public void  draw(Graphics g){
		 
	 }
	
	
	public int getRealX(double Zero_to_100_X){
		//find the smallest side and use it as reference. so the
		//drawable area on the canvas is squared
		
		double width = canvas.getWidth();
		double height = canvas.getHeight();
		
		
		if (width <= height){
			return (int) (width*(Zero_to_100_X/100)) ; 
		}else {
			double Offset = (width -height)/2;
			return (int) (height*(Zero_to_100_X/100)+Offset) ; 
			
			
			
		}
		
		
	}
	
	public int getRealY(double Zero_to_100_Y){
		double width = canvas.getWidth();
		double height = canvas.getHeight();
		
		if (height <= width){
			return (int) (height* (1-Zero_to_100_Y/100)) ; 
		}else{
			double Offset = (height - width )/2;
			return (int) (width*(Zero_to_100_Y/100)+Offset) ; 
			
		}
		

	}
	
	public int getRealDistance(double Zero_to_100_Distance){
		double width = canvas.getWidth();
		double height = canvas.getHeight();
		
		if (height <= width){
			return (int) (height* (Zero_to_100_Distance/100)) ; 
		}else{
		
			return (int) (width*(Zero_to_100_Distance/100)) ; 
			
		}
		
	}
	

}

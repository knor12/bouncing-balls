package Model;

public class Point {
	
	private double x , y; 
	
	Point(){
		x=0 ; 
		y = 0 ;
	}
	
	public Point(double x , double y ){
		 this .x = x ; 
		 this.y = y ;
	}
	
	
	
	public void setX(double x){
		this.x = x ; 
	}
	
	public double getX(){
		return this.x ; 
		
	}
	
	public void setY(double y){
		this.y = y ; 
	}
	
	public double getY(){
		return this.y ; 
		
	}

}

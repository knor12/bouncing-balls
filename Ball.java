package Model;

import java.util.ArrayList;

public class Ball extends ObjectModel{
	
	Point Currentlocation ; 
	Point PreviosLocation ;
	double Radius; 
	
	ArrayList<Observer> ObserverList = new ArrayList<Observer>(); 
	
	public Ball( Point PreviosLocation ,Point Currentlocation  , double Radius){
	
		this.Currentlocation = Currentlocation; 
		this.PreviosLocation = PreviosLocation ;
		this.Radius = Radius ;
		this.type = Enum_Object_Model.BALL ; 
		
	}
	
	public Point getCenter(){
		return Currentlocation ; 
	}
	
	public Point getOldCenter(){
		return PreviosLocation;
	}
	
	public double getRadius(){
		return Radius ;
	}
	
	public void move(Point newPoint ){
		
		Point tempLocation = new Point();
		tempLocation.setX(Currentlocation.getX());
		tempLocation.setY(Currentlocation.getY());
		
		Currentlocation.setX(newPoint.getX());
		Currentlocation.setY(newPoint.getY());
		
		PreviosLocation.setX(tempLocation.getX());
		PreviosLocation.setY(tempLocation.getY());
		
		
		
		/*
		 * for (int i = 0 ; i < ObserverList.lastIndexOf(ObserverList); i++ ){
			ObserverList.get(i).ObserverCallEven(this);
		}
		*/
		
	}
	
	/*
	 * public void AddObserver(Observer observer){
		ObserverList.add(observer);

	}
	*/

}

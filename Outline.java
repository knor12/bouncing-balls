package Model;

import java.util.ArrayList;

public class Outline extends ObjectModel  {
	
	Point point1 , point2 , point3 , point4 ; 
	
	Outline(){
		this.point1 = new Point(5 , 5);
		this.point2 = new Point(5 , 95);
		this.point3 = new Point(95, 95);
		this.point4 = new Point(95 , 5);
		this.type = Enum_Object_Model.OUTLINE ; 
	}
	
	
	public ArrayList<ObjectModel> getLines(){
		ArrayList<ObjectModel> list = new ArrayList<ObjectModel>();
		
		list.add(new Line(this.point1 ,this.point2 )); 
		list.add(new Line(this.point2 ,this.point3 )); 
		list.add(new Line(this.point3 ,this.point4 )); 
		list.add(new Line(this.point4 ,this.point1 )); 
		
		return list;
		
	}
	
	
	/*	
	 * This is how the outline is drawn, point locations are important for the processor logic 
	 * 
	 * 			Point2				Point3
	 * 				-----------------
	 * 				|				|
	 * 				|				|
	 * 				|				|
	 * 				|				|
	 * 				|				|
	 *				| 				|
	 * 				|				|
	 * 				-----------------	
	 * 			Point1				Point4
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public Point getPoint(int pointNum){
		switch (pointNum) {
		
		case 1: return point1 ;
		case 2: return point2 ; 
		case 3: return point3 ; 
		case 4: return point4 ; 
		default : return null ; 
		
		}
	} 
	

}

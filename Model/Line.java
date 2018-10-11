package Model;

public class Line extends ObjectModel{

	private Point StartPoint , EndPoint ; 



	public Line( Point StartPoint , Point EndPoint){
		this.type =  Model.Enum_Object_Model.LINE;
		this.StartPoint = StartPoint ; 
		this.EndPoint = EndPoint ; 

	}


	public Point getStartPoint(){
		return this.StartPoint; 


	}

	public Point getEndPoint(){
		return this.EndPoint; 


	}


	public void setStartPoint(Point StartPoint ){
		this.StartPoint =StartPoint; 

	}


	public void setEndPoint(Point EndPoint){
		this.EndPoint = EndPoint ;
	}

}

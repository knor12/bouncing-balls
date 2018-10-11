package Model;

import java.awt.Color;



public class ObjectModel {
	
	protected  Enum_Object_Model type ; // = Model.Enum_Object_Model.LINE;
	
	protected Color  color = Color.BLACK ; 
	protected Color FillColor = Color.WHITE ; 
	
	
	public Enum_Object_Model getObjectType(){
		return this.type ;
		
	}
	
	public void setColor(Color color){
		this.color = color ; 
		
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setFillColor(Color color){
		this.FillColor = color ; 
	}
	
	public Color  getFillColor(){
		return this.FillColor ; 
		
	}

}

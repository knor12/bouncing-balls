package View;

import javax.swing.JComponent;

import Model.*;

public class DrawableObjectFactory {

	JComponent canvas  ;

	public DrawableObjectFactory(JComponent canvas ){
		this.canvas = canvas ;
	}


	public AbstractDrawable getDrawableObject(ObjectModel object){

		switch (object.getObjectType()){

		case ALL: // this should never happen
			return null; 
		case BALL : 
			return new DrawableBall(canvas , (Ball)object);
		case LINE : 
			return new DrawableLine(canvas , (Line)object);
		case OUTLINE : 
			return new DrawablePolyLine(canvas , (Outline)object);	


		}
		return null; // this should never happen may have to add try catch statement


	}
}

/*
 * 
 * 	
	ALL,
	LINE , 
	BALL , 
	OUTLINE
 */

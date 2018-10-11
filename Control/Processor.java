package Control;

import java.awt.Color;
import java.util.*;

import Model.*;
import Model.Observer;

public class Processor {

	

	Game game ; 
	Outline outline ; 
	//Ball ball ; 
	ArrayList<Observer> ListObserver ; 
	
	private int TimerDelay = 100 ; 

	ArrayList<Ball> ListBals; 

	public void setTimerDelay(int TimerDelay){
		this.TimerDelay = TimerDelay;
	}
	
	public int getTimerDelay(){
		return this.TimerDelay ;
	}


	public void addObserver(Observer observer){
		ListObserver.add(observer);


	}

	public void RemoveObserver(Observer observer){
		ListObserver.remove(observer);

	}


	private void updateObservers(){
		int i ; 

		for (i=0;i<ListObserver.size();i++){
			ListObserver.get(i).ObserverCallEven(null);
		}
	}


	public Processor(Game game){
		this.game = game ; 
		outline = this.game.getOutline();

		ListObserver = new ArrayList<Observer> ();
		
		Color colorArr[]= { Color.cyan , Color.DARK_GRAY , Color.green , Color.MAGENTA , Color.ORANGE , Color.pink };


		Ball ball = new Ball(new Point(10 , 10) , new Point(10.5 , 10.7) , 3);
		ball.setFillColor(Color.blue);
		game.addObject(ball);

		Ball ball2 = new Ball(new Point(40 , 30) , new Point(40.2 , 30.5) , 3);
		ball2.setFillColor(Color.red);
		game.addObject(ball2);

		Ball ball3 = new Ball(new Point(55 , 50) , new Point(55.5 ,50.2) , 3);
		ball3.setFillColor(Color.green);
		game.addObject(ball3);

		Ball ball4 = new Ball(new Point(90 , 80) , new Point(90.1 , 80.2) , 3);
		ball4.setFillColor(Color.black);
		game.addObject(ball4);


	int i  ;
	Ball ballArr[] = new Ball[100]; 
	for (i =0 ; i < 100 ; i+=6){
		ballArr[i] = new Ball(new Point(10+i , 85-i) , new Point(10.2+i , 85-i) , 3);
		ballArr[i].setFillColor(colorArr[(i/6)%colorArr.length]);
		game.addObject(ballArr[i]);
		
	}
	}


	public  void ProcessBalls(){
		ProcessBalls_Outline();
		processBalls_with_Each_Other();
		updateObservers();

	}



	private void processBalls_with_Each_Other(){
		ArrayList<ObjectModel> ListBalls = game.getListOfObjects(Enum_Object_Model.BALL);
		
		
		int i ; 
		
		for (i=0 ; i<ListBalls.size() ; i++ ){
			process_One_Balls_with_Others((Ball)ListBalls.get(i) ,  ListBalls);
		}

		ListBalls.clear();
		ListBalls.removeAll(ListBalls);

	}

	private void process_One_Balls_with_Others(Ball ball ,  ArrayList<ObjectModel> ListBalls){
		
		
		ListBalls.remove(ball);
		
		Ball ball1; 
		
		int i ; 
		
		for (i=0 ; i<ListBalls.size() ; i++ ){
			ball1 = (Ball)ListBalls.get(i);
			if (!balls_Collision(ball , ball1)){
				//do nothing if no collision found 
			}else {
				
				double XD = ball.getCenter().getX()- ball.getOldCenter().getX();
				double YD = ball.getCenter().getY()- ball.getOldCenter().getY();
				
				
				
				double X1D = ball1.getCenter().getX()- ball1.getOldCenter().getX();
				double Y1D = ball1.getCenter().getY()- ball1.getOldCenter().getY();
				
				
				ball.move(new Point(ball.getCenter().getX()+X1D , ball.getCenter().getY()+Y1D));
				ball1.move (new Point(ball1.getCenter().getX()+XD , ball1.getCenter().getY()+YD));
				//ListBalls.remove(ball1);
				
			}
		}

	}
	
	
	private boolean balls_Collision(Ball ball1 , Ball ball2 ){
		
		// balls colide if the distance between then is less than or equal 
		//the sum of both raduis
		double raduis_sum = ball1.getRadius() + ball2.getRadius();
		double X1 = ball1.getCenter().getX();
		double Y1 = ball1.getCenter().getY();
		double X2 = ball2.getCenter().getX();
		double Y2 = ball2.getCenter().getY();
		double distance_between_centers = Math.sqrt((X1-X2)*(X1-X2) +(Y1-Y2)*(Y1-Y2) );
		
		
		return (distance_between_centers <= raduis_sum);
		

				
	}

	private void ProcessBalls_Outline(){

		ArrayList<ObjectModel> ListBalls = game.getListOfObjects(Enum_Object_Model.BALL);
		int i ; 

		for(i=0 ; i<ListBalls.size();i++ ){
			Process_One_Ball_Outline((Ball)ListBalls.get(i));
		}
		
		ListBalls.removeAll(ListBalls);
		ListBalls.clear();

	}



	private void  Process_One_Ball_Outline(Ball ball){

		double CurrentX , CurrentY , OldX, OldY , NewX , NewY ; 
		Point NewPoint; 

		Outline_Collision outline_Collision = colisionWithWall( ball) ; 


		CurrentX = ball.getCenter().getX(); 
		CurrentY = ball.getCenter().getY(); 

		OldX = ball.getOldCenter().getX();
		OldY = ball.getOldCenter().getY();


		switch(outline_Collision){

		case TOP : 

			NewY = OldY; 
			NewX = CurrentX +  (CurrentX -OldX );
			ball.move(new Point(NewX , NewY));
			
			break ;

		case BOTTOM: 

			NewY = OldY; 
			NewX = CurrentX +  (CurrentX -OldX );
			ball.move(new Point(NewX , NewY));
		
			break ;

		case RIGHT: 
			NewX = OldX ; 
			NewY = CurrentY + (CurrentY - OldY);
			ball.move(new Point(NewX , NewY));
		
			break ;

		case LEFT: 

			NewX = OldX ; 
			NewY = CurrentY + (CurrentY -OldY);
			ball.move(new Point(NewX , NewY));
		
			break ;

		case NONE :
			NewX = CurrentX +  (CurrentX -OldX );
			NewY = CurrentY + (CurrentY -OldY);
			ball.move(new Point(NewX , NewY));

			break ; 

		default : // do nothing 

		}



	}


	private Outline_Collision colisionWithWall(Ball ball){


		double radius = ball.getRadius();
		Point center = ball.getCenter();
		double centerX = center.getX(); 
		double centerY = center.getY();

		Point point1 =  outline.getPoint(1);
		double point1X = point1.getX();
		double point1Y = point1.getY();

		Point point2 =  outline.getPoint(2);
		double point2X = point2.getX();
		double point2Y = point2.getY();

		Point point3 =  outline.getPoint(3);
		double point3X = point3.getX();
		double point3Y = point3.getY();

		Point point4 =  outline.getPoint(4);
		double point4X = point4.getX();
		double point4Y = point4.getY();


		/*	
		 * This is how the outline is drawn, point locations are important for the processor logic 
		 * 					top	
		 * 			Point2				Point3
		 * 				-----------------
		 * 				|				|
		 * 				|				|
		 * 	left   		|				| right
		 * 				|				|
		 * 				|				|
		 *				| 				|
		 * 				|				|
		 * 				-----------------	
		 * 			Point1				Point4
		 * 					bottom
		 * */


		// check collision with the top  
		if(centerY+radius >= point2Y){
			return Outline_Collision.TOP ; 
		}

		//check collision with the bottom
		if(centerY-radius <= point1Y){
			return Outline_Collision.BOTTOM ; 
		}

		//check collision with the left
		if (centerX - radius <= point1X){
			return Outline_Collision.LEFT ; 
		}


		//check collision with the right
		if (centerX + radius >= point4X){
			return Outline_Collision.RIGHT ; 
		}


		return Outline_Collision.NONE;

	}


}

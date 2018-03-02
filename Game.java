package Model;

import java.util.ArrayList;

public class Game {

	private Outline outline = new Outline(); 



	ArrayList<ObjectModel> List = new ArrayList<ObjectModel>();

	public void addObject(ObjectModel object){
		this.List.add(object);
	}


	public void removeObject(ObjectModel object){
		this.List.remove(object);
	}

	public ArrayList<ObjectModel> getListOfObjects(Enum_Object_Model type){

		ArrayList<ObjectModel> list_ = new ArrayList<ObjectModel>();
		int i ; 

		for (i=0 ; i< this.List.size(); i++){
			if (type.equals(Enum_Object_Model.ALL)){
				
				list_.add(this.List.get(i));
				
			}else if(this.List.get(i).getObjectType().equals(type)) {
				
					
					list_.add(this.List.get(i));
				

			}else {
				//do nothing
			}



		}


		return list_ ; 
	}

	public Outline getOutline(){
		return outline ; 
	}








}

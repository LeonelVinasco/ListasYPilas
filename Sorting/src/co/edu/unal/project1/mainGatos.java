package co.edu.unal.project1;

import java.util.ArrayList;

public class mainGatos {

	static Gato ramon =new Gato(3,2);
	static Gato juan =new Gato(3,3);
	static Gato pepe =new Gato(3,6);
	static Gato leonel =new Gato(3,8);
	
	
	public static void main (String[] args){
		
		ArrayList<Gato> manada= new ArrayList<>();
		manada.add(juan);
		manada.add(leonel);
		manada.add(pepe);
		manada.add(ramon);
		
		for(int i=0;i<manada.size();i++)
			manada.get(i).showGato();
	}
}

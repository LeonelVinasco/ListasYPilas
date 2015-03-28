package com.linked;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Decidí utilizar la estructura "Pila" para resolver este problema,debido a que la forma 
//en la que está planteado el problema se puede notar un juego de sacar y poner datos.

public class ProblemaD {

	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		  TInicio = System.currentTimeMillis();
		Scanner scan;
		File f = new File("p4.txt");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
		
		MyStackLink<String> pila=new MyStackLink<>();
		MyStackLink<String> inverso=new MyStackLink<>();
		

		String comando[];
	pila.push("http://unal.edu.co");
	

		for(;;){
			
			comando=scan.nextLine().split(" ");
			
			if (comando[0].equals("VISIT")){
				for(int h=0;h<inverso.size();h++){ //Borra inverso
					inverso.pop();
					inverso.clear();
					}
				
				pila.push(comando[1]);
				System.out.println(pila.top());
				
			}
			else if (comando[0].equals("BACK")){
					if(pila.size()<=1){
						System.out.println("IGNORED");
					}
					else{
					inverso.push(pila.pop());	
					System.out.println(pila.top());
					}}
			else if (comando[0].equals("FORWARD")){
					
					
					if (inverso.size()==0){
						System.out.println("IGNORED");
					}	
					else{pila.push(inverso.pop());	
					System.out.println(pila.top());}
				}
			else if(comando[0].equals("QUIT")){
					break;
				}
				else{
					System.out.println("INSERTE UN COMANDO VALIDO");
				}
			
		}
		 TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
		  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
		  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);	
}
	
}

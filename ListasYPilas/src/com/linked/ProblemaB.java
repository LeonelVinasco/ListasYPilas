package com.linked;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

//Este problema lo resolví utilizando MyLinkedList, ya que en él se están utilizando muchas
//operaciones de eliminación de datos, lo que en ArrayList implica desplazar todo el arreglo para 
//llenar la posición vacia. En LinkedList esto no es necesario.



public class ProblemaB {


	public static void main(String[] args) throws FileNotFoundException {
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		  TInicio = System.currentTimeMillis();
		  
		  
		Scanner scan;
		File f = new File("p2.txt");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
		
		//scan.next(), scan.nextLine(), scan.nextInt()
		 int casos=0;
		 int q=0;
		 int x=0;
		 int pos=0;
		 int res=0;
		
			try {
				casos=scan.nextInt();
			} catch (InputMismatchException e1) {
				System.out.println("Ingrese números entero");
				casos=scan.nextInt();
			}
		
			
		
		 try {
				
				 q=scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Ingrese números entero");
				
				 q=scan.nextInt();
				
			}
		// MyArrayList<Integer> datos = new MyArrayList<>(); Gasta menos tiempo en mylinkedlist
		 MyLinkedList<Integer> datos = new MyLinkedList<>(); 
		 
		 
		if (casos<=0 || casos > 10){	
		System.out.println("Ingrese un número de casos entre [0,9]");
		}
		else if (q<1 || q > 1000000){
		System.out.println("Ingrese un número de operaciones entre [1,10^5]");
			}
		else{
		for (int i = 0; i < casos; i++) {
		
			System.out.println("Test #"+ (i+1) + ":");
			
		for (int j=1; j<=q; j++){
			
		String op= scan.next();
		
		if (op.equals("add")){
			x=scan.nextInt();
			pos=scan.nextInt();
			
		    datos.add(pos,x);
		   
		}
		if (op.equals("sub")){
			res =scan.nextInt();
			
			for (int k=0; k<datos.size();k++){	
				datos.set(k, datos.get(k)-res );
				if (datos.get(k)==0 || datos.get(k)<0){
					datos.remove(k);
				}
			}
			
		}	
		if (op.equals("view")){
			for(int l=0;l<datos.size();l++)
			{
				System.out.print(datos.get(l)+ " ");
				
			}
			System.out.println(" ");
			
		}
		
		
		
		}
			
			
			
			
			
			
		}
		}
		
	//	TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizo el algoritmo y la almacenamos en la variable T
	//	  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
	//	  System.out.println("Tiempo de ejecucion en milisegundos: " + tiempo);	
		
		//36971
	}
	
	
	
	
}

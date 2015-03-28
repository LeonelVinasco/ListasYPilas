package com.linked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proyecto2 {

	public Proyecto2() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
	//	long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecucion
		//		 TInicio = System.currentTimeMillis();
			
		
		//prueba github
		
				Scanner scan;
				File f = new File("prueba_1.in");
				if(f.exists()){
					scan = new Scanner(f);
				}else{
					scan = new Scanner(System.in);
				}	
		MyArrayList<MyQueueLinked> filas = new MyArrayList<MyQueueLinked>();

//filas  solo utiliza la funcion get y add, mejor con arraylist
		MyArrayList<Integer> contador = new MyArrayList<Integer>();
//contador guarda numero de usuarios en cada fila, arraylist porque solo usa get,set con indice
	
		MyArrayList<MyQueueLinked> copiaFilas = new MyArrayList<MyQueueLinked>();
		//se guardan tiempos acumulados de atencion para cada usuario
		//copiaFilas  solo utiliza la funcion get y add con indice,mejor con arraylist
				
	MyArrayList<Integer> tiempos = new MyArrayList<Integer>();//tiempo de ingreso cada usuario
	
				
	MyArrayList<Integer> tAc = new MyArrayList<Integer>();
	//MyArrayList<Integer> tFila = new MyArrayList<Integer>();
				//tiempo de fila, substituida por arreglo string tFilas de scan
		        int casos=0;//=scan.nextInt();
		        String s[];
		        s=scan.nextLine().split(" ");
		        casos=Integer.parseInt(s[0]);
		        if (casos<1 || casos>5){
					System.out.println("Ingrese numero de casos entre 1 y 5");
					casos=scan.nextInt();
				}
		        
		        int numFilas;
		       
		        s=scan.nextLine().split(" ");
		        numFilas=Integer.parseInt(s[0]);
		
		        if (numFilas<1 || numFilas>1000){
					System.out.println("Ingrese numero de filas entre 0 y 1000");
					numFilas=scan.nextInt();
				}
		   
				int numUsuarios;
				
				String tFilas[];
		        tFilas=scan.nextLine().split(" ");
		   
				int ini; //para activar acumulacion tAC1
				int tComp=0;//Guarda una suma para comparar en if de fila mas rapida

				int menor=0;
				s=scan.nextLine().split(" ");
		        numUsuarios=Integer.parseInt(s[0]);
				
				
				if (numUsuarios<1 || numUsuarios>1000){
					System.out.println("Ingrese numero de usuarios entre 0 y 1000");
					s=scan.nextLine().split(" ");
			        numUsuarios=Integer.parseInt(s[0]);
				}

				for( int h=0;h<casos;h++){
					ini=0;
					if (h!=0){
					//numFilas=scan.nextInt();
					s=scan.nextLine().split(" ");
					numFilas=Integer.parseInt(s[0]);
					tFilas=scan.nextLine().split(" ");
					s=scan.nextLine().split(" ");
			        numUsuarios=Integer.parseInt(s[0]);
					
					
					if (numFilas<1 || numFilas>1000){
						System.out.println("Ingrese numero de filas entre 0 y 1000");
						s=scan.nextLine().split(" ");
						numFilas=Integer.parseInt(s[0]);
					}
					}
					
			
					for (int z=0;z<numUsuarios;z++){//agregamos tiempos 
						s=scan.nextLine().split(" ");
				        tiempos.add(Integer.parseInt(s[0]));
						
						}
					
					
					for(int r=0;r<numFilas;r++){
						//tFila.add(Integer.parseInt(tFilas[r]));
						tAc.add(0);
						contador.add(0);
						MyQueueLinked<Integer> cola= new MyQueueLinked<Integer>();
						filas.add(cola);
						MyQueueLinked<Integer> copi= new MyQueueLinked<Integer>();
						copiaFilas.add(copi);
					}
					
			
				int falta=0;int hora=0;
				int ingresos=0;
				while(ingresos!=numUsuarios){
					
					
				for (int j=0;j<numUsuarios;j++){ //recorre usuarios para enque y desenqueue
					menor=0;
					
					if (hora==tiempos.get(j)  ){//agrega de acuerdo al tiempo de llegada
					for(int k=0;k<numFilas;k++){
						
						if (numFilas==k+1){}else{
					
							tComp=tAc.get(k+1)/*+tFila.get(k+1)*/+Integer.parseInt(tFilas[k+1]);
						}
						if (!copiaFilas.get(k).isEmpty()){
						if((Integer) copiaFilas.get(k).peek()==hora){//Desencola si ya es atendido
						
						filas.get(k).dequeue();
						copiaFilas.get(k).dequeue();
						
					}
						}
						
						
			if(tAc.get(menor)+Integer.parseInt(tFilas[menor])/*tFila.get(menor)*/== //Busca fila mas rapida
					tComp){
					}
			else if(tFilas.length==1){menor=0;}
			else if (tAc.get(menor)+Integer.parseInt(tFilas[menor])/*tFila.get(menor)*/< //Busca fila mas rapida
					tComp
					){
			}else if(tAc.get(menor)+Integer.parseInt(tFilas[menor])/*tFila.get(menor)*/> //Busca fila mas rapida
					tComp){		
				   menor=k+1;
					}
				}	
					
				
						ingresos++;
						ini=1;
						
		       filas.get(menor).enqueue(tiempos.get(j));	//enqueue usuario en la fila mas rapida
		       
		       tAc.set(menor, Integer.parseInt(tFilas[menor])+/*tFila.get(menor)*/+tAc.get(menor));//ghjkl
		       copiaFilas.get(menor).enqueue(tiempos.get(j)+tAc.get(menor));
		      
		       
		       contador.set(menor, contador.get(menor)+1);
		       System.out.println(menor+1);
		       
			}       
					
		}
			
				
			//System.out.println(hora+ " " + tAc + "  "+ filas+ " " + copiaFilas);	
					for(int r=0;r<numFilas;r++){
			if (tAc.get(r)!=0 && ini==1){	//resta 1 al tiempo acumulado en cada ciclo de reloj
						
		     tAc.set(r,tAc.get(r)-1);
					}
		   }

					
				hora++;
				}
				for (Integer i: contador){
					
					System.out.print(i+" "); //imprime valor acumulado en cada fila
					
				}
				System.out.print("\n");
				for(int b=0;b<numFilas;b++){ //ciclo para cerrar la ejecucion
					if (!filas.get(b).isEmpty()){
						copiaFilas.get(b).dequeue();
						filas.get(b).dequeue();
						b--;
					}
					
				}
				tFilas=null;
				//tFila.clear();
				tAc.clear();
				contador.clear();
				tiempos.clear();
			//	System.out.println(hora+ " " + tAc + "  "+ filas+ " " + copiaFilas);
				
				

				//System.out.println(tAc+ " " + tiempos);

				}
				
				//TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizo el algoritmo y la almacenamos en la variable T
				//  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
				 // System.out.println("Tiempo de ejecucion en milisegundos: " + tiempo);	

	}
	
	
}


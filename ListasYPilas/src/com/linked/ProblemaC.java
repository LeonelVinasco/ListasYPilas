package com.linked;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Para este ejercicio utilicé arraylist ya que el problema requiere recorrer 
//el arreglo de datos varias veces, lo que requeriría más tiempo con MyLinkedList

public class ProblemaC {

	
	public static void main(String[] args) throws FileNotFoundException {
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		  TInicio = System.currentTimeMillis();	
		Scanner scan;
		File f = new File("p3.in");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
	
		 int casos=1;
		MyArrayList<Integer> copia = new MyArrayList<>();
		MyArrayList<Integer> lista = new MyArrayList<>();
		
		 String s[];
	
		
			 try {
				s= scan.nextLine().split(" ");
				casos=Integer.parseInt(s[0]);
				
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				System.out.println("Ingrese un número entero de casos mayor que 0 menor que 100 ");
				 s= scan.nextLine().split(" ");
					casos=Integer.parseInt(s[0]);
			}
		
			
		
		
		
		System.out.println("corre");
		 int total=0;
		 int participantes;
		 int clasificados;
		 
		 if (casos<0 || casos > 100){	
				System.out.println("Ingrese un número de casos entre [0,100]");
				}
		 else {
			 for (int i = 0; i < casos; i++) {
			
				 lista.clear();
				 copia.clear();
				 total=0;
				participantes=0;
				clasificados=0;
					

				 try {
					s= scan.nextLine().split(" ");
					
					participantes=Integer.parseInt(s[0]);
					clasificados=Integer.parseInt(s[1]);
				} catch (NumberFormatException e) {
					
					System.out.println("Ingrese número entero de participantes, seguido número de clasificados");
					s= scan.nextLine().split(" ");
					participantes=Integer.parseInt(s[0]);
					clasificados=Integer.parseInt(s[1]);
				}
				
				if (participantes<1 || participantes > 1000){
					System.out.println("Ingrese un número de particpantes entre [1,1000]");
					break;
						}
			if (clasificados<1 || clasificados > 1000){
						System.out.println("Ingrese un número de clasificados entre [1,1000]");
						break;
							}
				 System.out.println("Test #"+ (i+1) + ":");
				 
				 try {
					s= scan.nextLine().split(" ");
					 
for (int j=0;j<s.length;j++){ //El límite no es el número de participantes, sino el número de datos ingresados

lista.add(j,Integer.parseInt(s[j]));

if (lista.get(j)<=0){
					lista.remove(j);
					System.out.println("Ingrese números positivos");
}
}
				} catch (NumberFormatException e) {
					System.out.println("Ingrese valores enteros separados por espacios");
					lista.clear();
					s= scan.nextLine().split(" ");
					 
					for (int j=0;j<s.length;j++){ //El límite no es el número de participantes, sino el número de datos ingresados

					lista.add(j,Integer.parseInt(s[j]));

					if (lista.get(j)<=0){
										lista.remove(j);
										System.out.println("Ingrese números positivos");
					}
					}
				}
		
             
			
              for(int l=0;l<lista.size();l++) //busca valores y los agrega en "copia" sin repetición
			{
            	 if (l==0){
            		copia.add(0,lista.get(0));
            	 }
            	 else if(lista.get(l)==lista.get(l-1)){
            		
           	  }
            	  else{
            		  copia.add(lista.get(l));
            		           		  
            	  }
            	  
			}
			//imprime contenido de la lista nueva
           /*   
             for (Integer k:lista){
				
				System.out.print(k+ " ");
				
			}
              System.out.println(" ");
             for (Integer m:copia){
  				
  				System.out.print(m+ " ");
  				
  			}
            System.out.println("");
			
          	System.out.println(copia.size());
          		*/
          	
          	
          	
          	for (int p=0;p<lista.size();p++){
          		
          		if (copia.size()-1<clasificados){  //Sucede cuando el número de "diferentes puntajes" es menor
          			for (int q=0;q<copia.size();q++){ //que el número de posibles clasificados, es decir sobra un cupo
                  		if (lista.get(p)==copia.get(q)){
                  				total++;
                  			}
          			}
          			}
          		else {
          			
          			for (int q=0;q<clasificados;q++){
                  		if (lista.get(p)==copia.get(q)){
                  				total++;
                  			}
                  			
                  		}
          			
          			
          		}
          	}
          	
      	System.out.println(total);
			 }
			
			
			 }
			 
		 TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
		  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
		  System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);	
			 
		 }
	
	}
	
	


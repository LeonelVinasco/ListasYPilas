package com.linked;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Para este ejercicio utilic� arraylist ya que el problema requiere recorrer 
//el arreglo de datos varias veces, lo que requerir�a m�s tiempo con MyLinkedList

public class ProblemaC {

	
	public static void main(String[] args) throws FileNotFoundException {
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecuci�n
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
				System.out.println("Ingrese un n�mero entero de casos mayor que 0 menor que 100 ");
				 s= scan.nextLine().split(" ");
					casos=Integer.parseInt(s[0]);
			}
		
			
		
		
		
		System.out.println("corre");
		 int total=0;
		 int participantes;
		 int clasificados;
		 
		 if (casos<0 || casos > 100){	
				System.out.println("Ingrese un n�mero de casos entre [0,100]");
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
					
					System.out.println("Ingrese n�mero entero de participantes, seguido n�mero de clasificados");
					s= scan.nextLine().split(" ");
					participantes=Integer.parseInt(s[0]);
					clasificados=Integer.parseInt(s[1]);
				}
				
				if (participantes<1 || participantes > 1000){
					System.out.println("Ingrese un n�mero de particpantes entre [1,1000]");
					break;
						}
			if (clasificados<1 || clasificados > 1000){
						System.out.println("Ingrese un n�mero de clasificados entre [1,1000]");
						break;
							}
				 System.out.println("Test #"+ (i+1) + ":");
				 
				 try {
					s= scan.nextLine().split(" ");
					 
for (int j=0;j<s.length;j++){ //El l�mite no es el n�mero de participantes, sino el n�mero de datos ingresados

lista.add(j,Integer.parseInt(s[j]));

if (lista.get(j)<=0){
					lista.remove(j);
					System.out.println("Ingrese n�meros positivos");
}
}
				} catch (NumberFormatException e) {
					System.out.println("Ingrese valores enteros separados por espacios");
					lista.clear();
					s= scan.nextLine().split(" ");
					 
					for (int j=0;j<s.length;j++){ //El l�mite no es el n�mero de participantes, sino el n�mero de datos ingresados

					lista.add(j,Integer.parseInt(s[j]));

					if (lista.get(j)<=0){
										lista.remove(j);
										System.out.println("Ingrese n�meros positivos");
					}
					}
				}
		
             
			
              for(int l=0;l<lista.size();l++) //busca valores y los agrega en "copia" sin repetici�n
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
          		
          		if (copia.size()-1<clasificados){  //Sucede cuando el n�mero de "diferentes puntajes" es menor
          			for (int q=0;q<copia.size();q++){ //que el n�mero de posibles clasificados, es decir sobra un cupo
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
			 
		 TFin = System.currentTimeMillis(); //Tomamos la hora en que finaliz� el algoritmo y la almacenamos en la variable T
		  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
		  System.out.println("Tiempo de ejecuci�n en milisegundos: " + tiempo);	
			 
		 }
	
	}
	
	


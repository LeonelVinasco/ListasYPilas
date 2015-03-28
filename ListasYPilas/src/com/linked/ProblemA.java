package com.linked;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ProblemA {
	

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		Scanner scan;
		File f = new File("p1.in");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
		//TODO Este código sirve de ejemplo para resolver el problema pero puede ser mejorado.
		// 1. Entienda muy bien la solución propuesta
		// 2. Mejórela.
		
		// t: casos de prueba
		int t = Integer.parseInt(scan.nextLine());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {
			System.out.println("Test #"+ (i+1) + ":");
			// n: número de estudiantes
			int n = Integer.parseInt(scan.nextLine());
			int arr[] = readInts(scan.nextLine(), n);
			list.clear();
			for (int x: arr){
				list.add(x);
			}
			// Q: número de operaciones
			int Q = Integer.parseInt(scan.nextLine());
			for (int j = 0; j < Q; j++) {
				String s[] = scan.nextLine().split(" ");
				// Operacion add X, Z
				if(s[0].equals("add")){
					// X: estudiante elegido inicialmente (el estudiante #1, 
					// será el que está en la posición 0 de la lista)
					int X = Integer.parseInt(s[1]);
					// Z: número de estudiantes llamados después del estudiante X 
					int Z = Integer.parseInt(s[2]);
					// arrSum: notas a sumar de los Z+1 estudiantes, contados a partir de X
					int arrSum[] = readInts(scan.nextLine(), Z+1);
					for (int l = 0; l < Z+1; l++) {
						list.set(X+l-1, list.get(X+l-1) + arrSum[l]);
					}
				}else if(s[0].equals("view")){
					// Imprime el máximo de la lista
					int max = 0;
					for(Integer item: list){
						if (item>max)
							max = item;
					}
					System.out.println(max);
					
				}else if(s[0].equals("viewAll")){
					// Imprime la lista 
					for(Integer item: list){
						System.out.print(item + " ");
					}
					System.out.println();		
				}
			}	
		}	
	}
	
	public static int[] readInts(String cad, int n){
		String lines[] = cad.split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(lines[i]);
		}
		return arr;
	}

}

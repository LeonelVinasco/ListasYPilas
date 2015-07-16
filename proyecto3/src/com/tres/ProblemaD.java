package com.tres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ProblemaD {
	
	public Integer fcl(Integer x, MyArrayList<Integer> ya, String[] preOrden,int i){
		ya.add(x);
		
		return Integer.parseInt(preOrden[i+1]);
		
	}
	
	public Integer fcr(Integer x, String[] posOrden){
		
		for (int k=posOrden.length-1; k>0; k--){
			Integer v=Integer.parseInt(posOrden[k]);
			if (v.equals(x)){
				return Integer.parseInt(posOrden[k-1]);
				
			}
			
		}
		return -1;
	}

	public ProblemaD() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		ProblemaD pD= new ProblemaD();
		Scanner scan;
		File f = new File("D_1.in");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
		
		String casos[];
		String preOrden[];
		String posOrden[];
		
		casos=scan.nextLine().split(" ");
		
		
		for (int i=0; i < Integer.parseInt(casos[0]);i++){
			
			preOrden=scan.nextLine().split(" ");
			
			posOrden=scan.nextLine().split(" ");
			
			boolean a=false;
			BinarySearchTree<Integer> arbol= new BinarySearchTree<Integer>();
			
			MyArrayList<Integer> ya = new MyArrayList<Integer>();
			
			arbol.insert(Integer.parseInt(preOrden[0]));
			ya.add(Integer.parseInt(preOrden[0]));
			ya.add(3);
			Integer father=0;
			int izq=0;
			int der=0;
			
			for (int j=0; j<preOrden.length-1; j++){
				
			 a=ya.find(Integer.parseInt(preOrden[j+1]))	;
			
			 if (a==false){
				 
				ya.add(Integer.parseInt(preOrden[j+1]));
				
				father=Integer.parseInt(preOrden[j]);
				izq=Integer.parseInt(preOrden[j+1]);
				der=pD.fcr(Integer.parseInt(preOrden[i]), posOrden);
				arbol.insert1(father, izq ,der) ;
				 
			 }
			 
			 
			 
			}
			
			
			
			
			
		}
		
		
	}
	
	
	
}




package com.cinco;
 import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class ProA {

	public ProA() {
		// TODO Auto-generated constructor stub
	}
	public static class Nodo<AnyType> implements Comparable<Nodo<AnyType>>{

		public Nodo(String val, String key) {
		vale=val;
		
		if(Integer.parseInt((key))<10){
			keye=masCero.concat(key);
        }else{
		keye=key;}
		
		
		
		total=Integer.parseInt(vale.concat(keye));
		}
		
		public String keye;
		public String vale;
		public String masCero="0";
        public int total;
        public int meseros=0;
		public int compareTo(Nodo segundo) {
			
			total=Integer.parseInt(vale.concat(keye));
			if (this.total==segundo.total)
				return 0;
			if (this.total<segundo.total)
			    return -1;
			if (this.total>segundo.total)
				return 1;
		return 1;
		}
		public void mesero(int mes){
			
				meseros=1+mes;
		
		}
		public int hashCode() {
			
			return total;
		
			}
		public String toString(){  
		
			return vale+" "+keye;
		
			}
		
	}
	
	public int hallarMayor(ArrayList<Integer> lista){
		int a=lista.get(0);
		for(int itr:lista){
			if (itr>a)
				a=itr;
			
			
		}
		
		
		
		return a;
	}
	
		public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		ProA pa= new ProA();

Scanner scan;
File f = new File("A_1.in");
if(f.exists()){
	scan = new Scanner(f);
}else{
	scan = new Scanner(System.in);
}

String[] input;
input=scan.nextLine().split(" ");
int casos= Integer.parseInt(input[0]);
int ops=0;
 
for(int i=0;i<casos;i++){/////////////////////////***************+
	
	System.out.println("Test #" +(i+1)+":");	
	
TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
input=scan.nextLine().split(" ");
ops= Integer.parseInt(input[0]);

ArrayList<Integer> horas=new ArrayList<Integer>();
ArrayList<Integer> veces=new ArrayList<Integer>();

for(int j=0;j<ops;j++){///////////////////////////*****************
	input=scan.nextLine().split(" ");
	Nodo<Integer> nodo=new Nodo<>(input[0],input[1]);

    veces.add(1);
 	

	if(tree.containsKey(nodo.total)){
		int num=nodo.meseros;
		nodo.mesero(num);
		
		int indice=horas.indexOf(nodo.total);
	 veces.set(indice,(veces.get(indice))+1);	
	}else{
		horas.add(nodo.total);
	}
tree.put(nodo.total,j);

}
System.out.println(pa.hallarMayor(veces));
System.out.println(tree);

}}

}

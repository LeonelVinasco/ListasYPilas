package com.linked;

public class Prueba_linkedList {

	public Prueba_linkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		MySingleLinkedList<Integer> list = new MySingleLinkedList<Integer>();
		
	
	
		//list.add(2);
		for (int i=0;i<10;i++)
			list.add(i);
		System.out.println( list );
	list.add( 0,9);
	System.out.println( list );
		
	/*	
		for( int i = 20; i < 30; i++ )
	       
		System.out.println( list );
		list.remove(0);
		System.out.println( list );
			
		list.remove(list.size()-1);
		System.out.println( list );
		
		System.out.println( list.get(3) );
    
	
}
/*/}
}

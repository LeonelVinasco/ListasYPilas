package com.linked;

public class Prueba_MySingleLL {

	public Prueba_MySingleLL() {
		MySingleLinkedList<Integer> list = new MySingleLinkedList<Integer>();
		
		
		for (int i=0;i<10;i++)
			list.add(i);
		System.out.println( list );
		for( int i = 20; i < 30; i++ )
	        list.add( 0, i );
		System.out.println( list );
		list.remove(0);
		System.out.println( list );
			
		list.remove(list.size()-1);
		System.out.println( list );
		
		System.out.println( list.get(3) );
		
		
		
		 MyLinkedList<String> ll = new MyLinkedList<>();
	    
	     ll.add("C");
	     ll.add("D");
	     ll.addLast("Z");
	     ll.add("E");
	     ll.add("F");
	  ;
	     ll.addFirst("A");
	     ll.add(1, "A2");
	     System.out.println("Contenido original: " + ll);
	     ll.addFirst("B");
	     ll.set(3,"fre");
	   // ll.find("F");
	     ll.removeLast();
	     System.out.println("Contenido después de borrar: " + ll);
	   //  ll.removeFirst();
	    ll.remove("C");
	     System.out.println("Después de borrar el primero y el último: " + ll+ ll.find("F"));
	     String val = ll.get(2);
	     ll.set(2, val + " modificada");
	     System.out.println("Después del cambio: " + ll);
	     // Recorrer la lista usando el iterador
	     for(String i: ll){
	         System.out.print(i+"; ");
	     }
	}

}

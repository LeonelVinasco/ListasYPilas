package com.linked;

public class Prueba_Queue {

	public Prueba_Queue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		MyQueueLinked<String> cola= new MyQueueLinked<String>();
		
		String primero;
		cola.enqueue("uno");
		cola.enqueue("dos");
		cola.enqueue("tres");
		cola.enqueue("cuatro");
		
		primero=cola.peek();
		
		
			System.out.println(cola);
			System.out.println(primero);
		cola.dequeue();
		System.out.println(cola);
		cola.enqueue("cinco");
		cola.print(cola);
		
	}
	

	
}

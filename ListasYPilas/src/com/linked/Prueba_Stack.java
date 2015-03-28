package com.linked;

public class Prueba_Stack {

	public Prueba_Stack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		MyStackLink<String> ll=new MyStackLink<>();
		
		ll.push("ert");
		
		ll.push("eretht");
		ll.push("euytrt");
		ll.push("123t");
		ll.push("456");
		ll.push("0987t");
		
		 System.out.print(ll.top() +"; ");
	         System.out.print(ll.pop()+"; ");
	         System.out.print(ll.pop()+"; ");
	         System.out.print(ll.pop()+"; ");
	         System.out.print(ll.pop()+"; ");
	         System.out.print(ll.top() +"; ");
	         System.out.print(ll.pop()+"; ");
	         System.out.println(ll.pop()+"; ");
	    
		MyStackArr<String> pila= new MyStackArr<>();
		
		pila.push("hola");
		pila.push("adios");
		System.out.print(pila.top() +"; ");
		pila.push("jelou");
		pila.push("tres");
		System.out.print(pila.top() +"; ");
		pila.pop();
		System.out.print(pila.top() +"; ");
		
	}

}

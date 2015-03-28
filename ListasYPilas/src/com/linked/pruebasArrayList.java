package com.linked;

public class pruebasArrayList {

	public pruebasArrayList() {
		
	}

	public static void main(String[] args) {
		
	MyArrayList<Integer> items= new MyArrayList<>();
		
		items.add(2);
		items.add(5);
		items.add(7);
		items.add(9);
	
		System.out.println(items);

	items.remove(2);

	items.set(1, 56);
	System.out.println(items);
     System.out.println(items.get(2));
	}

}



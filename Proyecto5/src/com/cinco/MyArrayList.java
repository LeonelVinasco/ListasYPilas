package com.cinco;



public class MyArrayList <E> implements Iterable<E> {

	
	private static final int DEFAULT_CAPACITY = 10;
	private int theSize;
	private E[] theItems;
	
	
	
	public MyArrayList() {
	
		clear();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public String toString(){
		String result = "[";
		for (int i=0; i<theSize-1; i++)
			result += theItems[i].toString() + ",";
		if(theSize>0){
			result += theItems[theSize-1].toString();
		}
		return result + "]";
	}
public boolean add(E dato){

	add(size(),dato);
	
	return true;
}

public boolean find (E dato){

for (int j=0; j<theItems.length;j++){
	
	if (theItems[j]==dato){
		return true;
	}
	
}

return false;
}




public void add(int idx, E dato){
	
	if (theItems.length == size())
		ensureCapacity( size()*2+1);
	
	for (int i = theSize; i>idx; i--)
		{theItems[i] = theItems[i-1];}
	
	theItems[idx]=dato;
	theSize++;	
}
	public void clear() {
		
		theSize = 0;
		ensureCapacity( DEFAULT_CAPACITY );

	}
	
	public E get(int idx){
		
		if (idx<0 || idx>=size())
			throw new ArrayIndexOutOfBoundsException("Index"
					+ idx+ ";size" + size());
		return theItems[idx];
	}
	
	
	
	public E set(int idx, E newVal){
		if (idx<0 || idx>=size())
			throw new ArrayIndexOutOfBoundsException("Index"
					+ idx+ ";size" + size());
		E old = theItems[idx];
		theItems[idx]=newVal;
		return old;
		
		
	}
	
@SuppressWarnings("unchecked")
public void ensureCapacity(int newCapacity){
	if (newCapacity < theSize)
		return;
	E [] old = theItems;
	theItems = (E[]) new Object [newCapacity];
	for( int i =0; i< size(); i++)
		theItems[i]= old[i];
}
public int size(){
	//theSize= theItems.length;
	return theSize;
}
	public java.util.Iterator<E> iterator()
	{return new ArrayListIterator();}
	
	
public E remove(int idx){
	
	E erased= theItems[idx];
	
	for (int i =idx; i< size()-1; i++){
		theItems[i]=theItems[i+1];
	}
	theSize--;
	return erased;
	
}
	private class ArrayListIterator implements java.util.Iterator<E>{
		
		private int current=0;
		
		public boolean hasNext()
		{return current < size();}
		
		public E next(){
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}
		public void remove()
		{ MyArrayList.this.remove(--current);}

		
	
	}
	}


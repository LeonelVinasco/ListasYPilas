/**
 * 
 */
package co.edu.unal.practice5;

/**
 * @author Practice 5
 *
 */
public class MyArrayList <E> {
private static final int DEFAULT_CAPACITY =10;
private int theSize;
private E [] theItems;
private boolean  ok;	
	
public MyArrayList(){
	this.theSize=0;
	ensureCapacity(DEFAULT_CAPACITY);
}

@SuppressWarnings("unchecked")
public void ensureCapacity (int newCapacity){
	if (newCapacity < theSize){
		return;}
		E[] old = theItems;
		theItems = (E []) new Object [newCapacity];
		for (int i=0; i < size( ); i++)
			theItems[i] =old[i];
	}
	

public int size(){
	
	
	
	return this.theSize;
	
}

public void add(int idx, E x){
	if ( theItems.length ==size())
		ensureCapacity(size()*2+1);
	for( int i = theSize; i>idx; i--)
		theItems[i]=theItems[i-1];
	theItems[idx]=x;
	theSize++;
}

public boolean add(E e){

add(theSize,e);

this.ok=true;

return this.ok;
}	

public E get(int idx){
		
return theItems[idx];	
	

}


}





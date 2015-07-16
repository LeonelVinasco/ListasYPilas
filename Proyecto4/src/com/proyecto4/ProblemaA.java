package com.proyecto4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
//Leonel Armando Vinasco Zapata Cod. 285869 Materia: Estructuras de datos

public class ProblemaA {

/*******************************************************************************************************
************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/
	public static class Nodo<AnyType> implements Comparable<Nodo<AnyType>>{

		public Nodo(AnyType ide, int prior) {
		id=ide;	
		prioridad=prior;		
		}
		public int prioridad;
		public AnyType id;
		
		public int compareTo(Nodo segundo) {
			if (this.prioridad==segundo.prioridad)
				return 0;
			//Para que la clase de heapsort ordene al reves los numero
			//es decir el mayor en la raiz, se juega con este metodo
			if (this.prioridad<segundo.prioridad)//normal= a<b->1
				return 1;
			if (this.prioridad>segundo.prioridad)//normal= a>b->1
				return -1;
		return -30;
		}
		public static void main(String[] args) {
		}
	}
	/*******************************************************************************************************
	************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/	
	
	
	public ProblemaA() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		ProblemaA pa= new ProblemaA();

Scanner scan;
File f = new File("A_3.in");
if(f.exists()){
	scan = new Scanner(f);
}else{
	scan = new Scanner(System.in);
}

String[] input;
input=scan.nextLine().split(" ");
int casos= Integer.parseInt(input[0]);
int ops=0;

for (int i=0; i<casos;i++){
	BinaryHeap<Nodo<Integer>> procesos= new BinaryHeap<Nodo<Integer>>();
	
	System.out.println("Test #" +(i+1)+":");
	input=scan.nextLine().split(" ");
	ops= Integer.parseInt(input[0]);
	int cont=0;
	for (int j=0; j<ops;j++){
	cont=j;
		input=scan.nextLine().split(" ");
		
		if (input[0].equals("Execute")){
			System.out.println(procesos.findMin().id);
			procesos.deleteMin();
			
		}else{
			Nodo<Integer> myNodo = new Nodo<Integer>(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
			procesos.insert(myNodo);
		}		
}	
	}

}


	public static class BinaryHeap<AnyType extends Comparable<? super AnyType>>
	{
		
	    /**
	     * Construct the binary heap.
	     */
	    public BinaryHeap( )
	    {
	        this( DEFAULT_CAPACITY );
	        
	    }

	    /**
	     * Construct the binary heap.
	     * @param capacity the capacity of the binary heap.
	     */
	    public BinaryHeap( int capacity )
	    {
	        currentSize = 0;
	        array = (AnyType[]) new Comparable[ capacity + 1 ];
	    }
	    
	    /**
	     * Construct the binary heap given an array of items.
	     */
	    public BinaryHeap( AnyType [ ] items )
	    {
	            currentSize = items.length;
	            array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

	            int i = 1;
	            for( AnyType item : items )
	                array[ i++ ] = item;
	            buildHeap( );
	    }

	    /**
	     * Insert into the priority queue, maintaining heap order.
	     * Duplicates are allowed.
	     * @param x the item to insert.
	     */
	    public void insert( AnyType x )
	    {
	        if( currentSize == array.length - 1 )
	            enlargeArray( array.length * 2 + 1 );

	            // Percolate up
	        int hole = ++currentSize;
	        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
	            array[ hole ] = array[ hole / 2 ];
	        array[ hole ] = x;
	    }
	 

	    private void enlargeArray( int newSize )
	    {
	            AnyType [] old = array;
	            array = (AnyType []) new Comparable[ newSize ];
	            for( int i = 0; i < old.length; i++ )
	                array[ i ] = old[ i ];        
	    }
	    
	    /**
	     * Find the smallest item in the priority queue.
	     * @return the smallest item, or throw an UnderflowException if empty.
	     */
	    public AnyType findMin( )
	    {
	        if( isEmpty( ) )
	            throw new InputMismatchException( );
	        return array[ 1 ];
	    }

	    /**
	     * Remove the smallest item from the priority queue.
	     * @return the smallest item, or throw an UnderflowException if empty.
	     */
	    public AnyType deleteMin( )
	    {
	        if( isEmpty( ) )
	            throw new InputMismatchException( );

	        AnyType minItem = findMin( );
	        array[ 1 ] = array[ currentSize-- ];
	        percolateDown( 1 );

	        return minItem;
	    }

	    /**
	     * Establish heap order property from an arbitrary
	     * arrangement of items. Runs in linear time.
	     */
	    private void buildHeap( )
	    {
	        for( int i = currentSize / 2; i > 0; i-- )
	            percolateDown( i );
	    }

	    /**
	     * Test if the priority queue is logically empty.
	     * @return true if empty, false otherwise.
	     */
	    public boolean isEmpty( )
	    {
	        return currentSize == 0;
	    }

	    /**
	     * Make the priority queue logically empty.
	     */
	    public void makeEmpty( )
	    {
	        currentSize = 0;
	    }

	    private static final int DEFAULT_CAPACITY = 10;

	    private int currentSize;      // Number of elements in heap
	    private AnyType [ ] array; // The heap array

	    /**
	     * Internal method to percolate down in the heap.
	     * @param hole the index at which the percolate begins.
	     */
	    private void percolateDown( int hole )
	    {
	        int child;
	        AnyType tmp = array[ hole ];

	        for( ; hole * 2 <= currentSize; hole = child )
	        {
	            child = hole * 2;
	            if( child != currentSize &&
	                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
	                child++;
	            if( array[ child ].compareTo( tmp ) < 0 )
	                array[ hole ] = array[ child ];
	            else
	                break;
	        }
	        array[ hole ] = tmp;
	    }

	        // Test program
	    public static void main( String [ ] args )
	    {
	        int numItems = 10000;
	        BinaryHeap<Integer> h = new BinaryHeap<>( );
	        int i = 37;

	        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
	            h.insert( i );
	        for( i = 1; i < numItems; i++ )
	            if( h.deleteMin( ) != i )
	                System.out.println( "Oops! " + i );
	    }
	}
	
	
	
}

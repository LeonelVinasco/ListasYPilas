package com.proyecto4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
//Leonel Armando Vinasco Zapata Cod. 285869 Materia: Estructuras de datos


public class ProblemaC {
    //Esta clase se crea para invertir el orden del heap, es decir numero mayor en la raiz
	public static class Valor<AnyType> implements Comparable<Valor<AnyType>>{

		public Valor(int numero) {
		num=numero;
		}
		public int num;
		public int compareTo(Valor segundo) {
			if (this.num==segundo.num)
				return 0;
			if (this.num<segundo.num)//normal= a<b->1
				return 1;
			if (this.num>segundo.num)//normal= a>b->1
				return -1;
		return -30;
		}
		public static void main(String[] args) {
		}
	}
   
   int lksMaximo=0;//Este metodo halla el costo maximo. Pone en la raiz al valor maximo 
                    //y apartir de alli llena los puestos del avion.Utiliza el objeto valor creado en la clase de arriba.
	public int numMaximo(BinaryHeap<Valor<Integer>> maximo, int estudiantes){

		for(;;){
			if (estudiantes==0){
				break;
			}
			lksMaximo+=maximo.findMin().num;
			Valor<Integer> temp= new Valor<Integer>(maximo.findMin().num-1);
			maximo.deleteMin();
		    maximo.insert(temp);
		    estudiantes--;
		}
		return lksMaximo;
	}
	int lksMinimo=0;//Este metodo halla el costo minimo. Pone en la raiz al valor minimo de puestos y 
	                //apartir de alli llena los puestos del avion.
	public int numMinimo(BinaryHeap<Integer> minimo, int estudiantes){
		int tempEstudiantes=estudiantes;
		for(;;){
			if (tempEstudiantes==0){
				break;
			}
			lksMinimo+=minimo.findMin();
			
			int temp= minimo.findMin()-1;
			minimo.deleteMin();
			if (temp>0)
		    minimo.insert(temp);
		    tempEstudiantes--;
		}
		return lksMinimo;
		
		
		
		
		
	}
	 
	public ProblemaC() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException {
	
			ProblemaC pc= new ProblemaC();

			Scanner scan;
			File f = new File("C_4.in");
			if(f.exists()){
				scan = new Scanner(f);
			}else{
				scan = new Scanner(System.in);
			}
			
			String[] input;
			
			input=scan.nextLine().split(" ");
			int casos= Integer.parseInt(input[0]);
			int aviones=0;
			int estudiantes=0;
			
			for(int i=0;i<casos;i++){//CASOS**************************
			System.out.println("Test #"+(i+1)+":");		
				
  BinaryHeap<Valor<Integer>> maximo= new BinaryHeap<Valor<Integer>>();//heap que organiza elementos al revez
  BinaryHeap<Integer> valores= new BinaryHeap<Integer>();//heap normal, numero menor en la raiz
  
          input=scan.nextLine().split(" ");
          aviones= Integer.parseInt(input[0]);
          input=scan.nextLine().split(" ");
          estudiantes= Integer.parseInt(input[0]);
     
          input=scan.nextLine().split(" ");  
          
          for (int j=0; j<input.length; j++){ //Inserta en los heaps los valores del numero de asientos
              valores.insert(Integer.parseInt(input[j]));
              Valor<Integer> myValor = new Valor<Integer>(Integer.parseInt(input[j]));
              maximo.insert(myValor);
          } 
         
       pc.lksMaximo=0; 
       pc.lksMinimo=0; 
    
      System.out.println( pc.numMaximo(maximo, estudiantes)+ " "+pc.numMinimo(valores, estudiantes));  
		
		
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
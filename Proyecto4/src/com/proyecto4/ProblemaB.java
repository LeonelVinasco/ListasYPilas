package com.proyecto4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
//Leonel Armando Vinasco Zapata Cod. 285869 Materia: Estructuras de datos



public class ProblemaB {

	public static class Nodo<AnyType> implements Comparable<Nodo<AnyType>>{

		public Nodo(int chocolate, int arequipe) {
		choco=chocolate;	
		areq=arequipe;
		suma=chocolate+arequipe;
		} //Comparador no leia bien por tener declaradas variables con objetos(Integer) y no tipos 
		public int choco;//primitivos (int)
		public int areq;
		public int suma;
		
		public int compareTo(Nodo segundo) {
//***********************************************************************************************			
			if (this.suma==segundo.suma){      //Utilizado por si la suma da igual, y se
				if (this.choco>segundo.choco)  //imprimime primero el que menos chocolate tenga
					return 1;
				if (this.choco==segundo.choco)  //En esta parte los signos son contrarios porque el menor nivel de chocolate
					return 0;                   //es el que va arriba en el heapSort
				if (this.choco<segundo.choco)
					return -1;
			}
//**********************************************************************************************			
			//El compareTo se modifica para que la clase de heap ordene al revez los numeros
			//es decir el mayor en la raiz, se juega con este metodo
			
			if (this.suma<segundo.suma){//normal= a<b->1
				return 1;}else{return -1;}
		//	if (this.suma>segundo.suma){//normal= a>b->1
			//	return -1;}
		//return -30;
		}
		public static void main(String[] args) {
		}
	}
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
	
	
	public void setniveluno(){
	nivel=0;nivelare=0;		
	}
	int nivel=0;
	int nivelare=0;
	
	//Metodo ineficiente crea todas las parejas posibles**********************************************
	//***************************************************************************************
	public BinaryHeap<Nodo<Integer>> armar(BinaryHeap<Nodo<Integer>> torta, BinaryHeap<Valor<Integer>> chocolate, BinaryHeap<Valor<Integer>> arequipe,int niveles){
	//utilizar arreglos iniciales
	Valor<Integer> temp;
	Nodo<Integer> generico=new Nodo<Integer>(chocolate.findMin().num, arequipe.findMin().num);
	
	torta.insert(generico);
	
	if (nivel!=niveles-1 && !chocolate.isEmpty()){nivel++;
	temp=chocolate.findMin();
    chocolate.deleteMin();
    armar(torta,chocolate,arequipe,niveles);
    chocolate.insert(temp);}
	if (nivel>0){
	nivel--;
	return torta;	
	}
    if (nivelare!=niveles-1 && !arequipe.isEmpty()){nivelare++;
    temp=arequipe.findMin();
    arequipe.deleteMin();
    armar(torta,chocolate,arequipe,niveles);
    arequipe.insert(temp);
    }
	 return torta;
	}
	
	public ProblemaB() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)throws FileNotFoundException {
	//Las clase anteriores se crearon con el fin de ordenar el heapSort 
	//de tal manera que le mayor valor este en la raiz.	
		
		ProblemaB pb= new ProblemaB();

		Scanner scan;
		File f = new File("B_3.in");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}

		String[] input;
		String[] ch;
		String[] ar;
		input=scan.nextLine().split(" ");
		int casos= Integer.parseInt(input[0]);
		int niveles=0;
        int parejas=0;
	//Inicia el programa*********************	
        for (int i=0; i<casos;i++){
        	System.out.println("Test #"+(i+1)+":");	
		pb.setniveluno();	
	BinaryHeap<Valor<Integer>> chocolate= new BinaryHeap<Valor<Integer>>();
	BinaryHeap<Valor<Integer>> arequipe= new BinaryHeap<Valor<Integer>>();
	
	BinaryHeap<Nodo<Integer>> torta= new BinaryHeap<Nodo<Integer>>(); //heap dónde se va a guardar la pareja y la suma
	
	input=scan.nextLine().split(" "); //Lee cantidad de niveles 
	niveles=Integer.parseInt(input[0]);
	ch=scan.nextLine().split(" "); //Lee niveles de chocolate
	
	for (int j=0; j<niveles;j++){
	Valor<Integer> myValor = new Valor<Integer>(Integer.parseInt(ch[j]));	
	chocolate.insert(myValor);
	}
    ar=scan.nextLine().split(" "); //Lee niveles de arequipe
	
	for (int j=0; j<niveles;j++){
	Valor<Integer> myValor = new Valor<Integer>(Integer.parseInt(ar[j]));	
	arequipe.insert(myValor);
	}
	input=scan.nextLine().split(" "); //Lee numero de parejas	
	parejas=Integer.parseInt(input[0]);
	
//	if (niveles<parejas){
	
	//	for(int k=0;k<=niveles;k++){
		
	Nodo<Integer> myNodo = new Nodo<Integer>(chocolate.findMin().num,arequipe.findMin().num);
			                                          //Recordar que valor es objeto que incluye int
	//torta.insert(myNodo);		
	
	pb.armar(torta, chocolate, arequipe,(niveles));
		
	for(int l=0;l<parejas;l++){
		//System.out.println(torta.findMin().suma);
		System.out.println(torta.findMin().choco + " " + torta.findMin().areq);
		torta.deleteMin();
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



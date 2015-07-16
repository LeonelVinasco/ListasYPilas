package com.tres;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileNotFoundException;


//Integrantes: Vanessa Gonzales Duque
//             Leonel Armando Vinasco Zapata


public class problemC {

	public problemC() {
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args) throws FileNotFoundException {
	
	problemC pc = new problemC(); 	
		
	Scanner scan;
	File f = new File("C_1.in");
	if(f.exists()){
		scan = new Scanner(f);
	}else{
		scan = new Scanner(System.in);
	}
	
	AvlTree<String> arbol = new AvlTree<String>();
	
	String[] input;
	input=scan.nextLine().split(" ");
	int casos= Integer.parseInt(input[0]);
	int ops=0;
	
	

for (int i=0; i<casos;i++){
	
	arbol.makeEmpty();
	System.out.println("Test #"+(i+1)+":");
	input=scan.nextLine().split(" ");
	ops= Integer.parseInt(input[0]);
	
	//System.out.println(ops);
	for (int j=0; j<ops;j++){
		
		input=scan.nextLine().split(" ");
		
		switch (input[0]){
		
		case "Insert":
			
			if (arbol.contains(input[1])){//si la cadena fue ingresada anteriormente
				
				arbol.aumentar(arbol.contains2(input[1]));
				//aumenta numero de veces que ha sido insertada
				
			}else{
			arbol.insert(input[1]);	
			}	
			break;
			
		case "Find":
			if (arbol.contains(input[1])){//muestra numero de veces ha sido insertada
				System.out.println(arbol.mostrarVeces(arbol.contains2(input[1])));
			}else{
				System.out.println(0);	
				}
			break;
		case "FindMin":
			arbol.findMin2();
			break;
		case "FindMax":
			arbol.findMax2();
			break;
		case "Height":
			arbol.setVars();
			
			if (arbol.contains(input[1])){
				
            System.out.println(arbol.hallarAltura(arbol.contains2(input[1]), arbol.raiz(arbol)));
			}else{
				System.out.println(0);
					
				
			}
            
            
            break;
		case "NumberNodes":
			
			arbol.setVars();
			
			if (arbol.contains(input[1])){
				System.out.println(arbol.numberNodes(arbol.contains2(input[1]),1));
	            }else{
					System.out.println(0);
						
					
				}
	            
			
			break;
		    
		}
		
	}
		
}
	}
	
	
	public static class AvlTree<AnyType extends Comparable<? super AnyType>>
	{
	    /**
	     * Construct the tree.
	     */
	    public AvlTree( )
	    {
	        root = null;
	    }

	    /**
	     * Insert into the tree; duplicates are ignored.
	     * @param x the item to insert.
	     */
	    public void insert( AnyType x )
	    {
	        root = insert( x, root );
	    }

	    /**
	     * Remove from the tree. Nothing is done if x is not found.
	     * @param x the item to remove.
	     */
	    public void remove( AnyType x )
	    {
	        root = remove( x, root );
	    }

	       
	    /**
	     * Internal method to remove from a subtree.
	     * @param x the item to remove.
	     * @param t the node that roots the subtree.
	     * @return the new root of the subtree.
	     */
	    private AvlNode<AnyType> remove( AnyType x, AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return t;   // Item not found; do nothing
	            
	        int compareResult = x.compareTo( t.element );
	            
	        if( compareResult < 0 )
	            t.left = remove( x, t.left );
	        else if( compareResult > 0 )
	            t.right = remove( x, t.right );
	        else if( t.left != null && t.right != null ) // Two children
	        {
	            t.element = findMin( t.right ).element;
	            t.right = remove( t.element, t.right );
	        }
	        else
	            t = ( t.left != null ) ? t.left : t.right;
	        return balance( t );
	    }
	    
	    /**
	     * Find the smallest item in the tree.
	     * @return smallest item or null if empty.
	     */
	    public AnyType findMin( )
	    {
	        if( isEmpty( ) )
	            throw new InputMismatchException( );
	        return findMin( root ).element;
	    }

	    /**
	     * Find the largest item in the tree.
	     * @return the largest item of null if empty.
	     */
	    public AnyType findMax( )
	    {
	        if( isEmpty( ) )
	            throw new InputMismatchException( );
	        return findMax( root ).element;
	    }

	    

	    /**
	     * Make the tree logically empty.
	     */
	    public void makeEmpty( )
	    {
	        root = null;
	    }

	    /**
	     * Test if the tree is logically empty.
	     * @return true if empty, false otherwise.
	     */
	    public boolean isEmpty( )
	    {
	        return root == null;
	    }

	    /**
	     * Print the tree contents in sorted order.
	     */
	    public void printTree( )
	    {
	        if( isEmpty( ) )
	            System.out.println( "Empty tree" );
	        else
	            printTree( root );
	    }

	    private static final int ALLOWED_IMBALANCE = 1;
	    
	    // Assume t is either balanced or within one of being balanced
	    private AvlNode<AnyType> balance( AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return t;
	        
	        if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE )
	            if( height( t.left.left ) >= height( t.left.right ) )
	                t = rotateWithLeftChild( t );
	            else
	                t = doubleWithLeftChild( t );
	        else
	        if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE )
	            if( height( t.right.right ) >= height( t.right.left ) )
	                t = rotateWithRightChild( t );
	            else
	                t = doubleWithRightChild( t );

	        t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
	        return t;
	    }
	    
	    public void checkBalance( )
	    {
	        checkBalance( root );
	    }
	    
	    private int checkBalance( AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return -1;
	        
	        if( t != null )
	        {
	            int hl = checkBalance( t.left );
	            int hr = checkBalance( t.right );
	            if( Math.abs( height( t.left ) - height( t.right ) ) > 1 ||
	                    height( t.left ) != hl || height( t.right ) != hr )
	                System.out.println( "OOPS!!" );
	        }
	        
	        return height( t );
	    }
	    
	    
	    /**
	     * Internal method to insert into a subtree.
	     * @param x the item to insert.
	     * @param t the node that roots the subtree.
	     * @return the new root of the subtree.
	     */
	    private AvlNode<AnyType> insert( AnyType x, AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return new AvlNode<>( x,0, null, null );
	        
	        int compareResult = x.compareTo( t.element );
	        
	        if( compareResult < 0 )
	            t.left = insert( x, t.left );
	        else if( compareResult > 0 )
	            t.right = insert( x, t.right );
	        else
	            ;  // Duplicate; do nothing
	        return balance( t );
	    }

	    /**
	     * Internal method to find the smallest item in a subtree.
	     * @param t the node that roots the tree.
	     * @return node containing the smallest item.
	     */
	   
	    int result=1;
	    int nodo=0;
	     
	    public int numberNodes(AvlNode<AnyType> t,int nodos){
	    	
	    	if( t.left!=null){
	    		nodos++;
	    		result++;
	    	numberNodes(t.left,nodos);}
	        
	    	if( t.right!=null){
	       		nodos++;
	       		result++;
	        numberNodes(t.right,nodos);}
	    	this.nodo=nodos;
	    	
	    	return result;
	    	
	    }
	public void setVars(){ //modifico valor variable nodo
	    	this.result=1;
	    	this.altura=1;
	    	return ;
	    }
	    public int getVarNodo(){ //obtengo valor variable nodo
	    	
	    	return this.nodo;
	    }
	    
	    private AvlNode<AnyType> findMin( AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return t;

	        while( t.left != null )
	            t = t.left;
	        
	        return t;
	    }
	    

	    
	    
	    
	    
	    /**
	     * Find the smallest item in the tree.
	     * @return smallest item or null if empty.
	     */
	    public AnyType findMin2( )
	    {
	        if( isEmpty( ) )
	            throw new InputMismatchException( );
	        return findMin2( root ).element;
	    }
	    
	    private AvlNode<AnyType> findMin2( AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return t;

	        while( t.left != null )
	            t = t.left;
	        System.out.println(t.element + " " + t.veces);
	        return t;
	    }
	    /**
	     * Internal method to find the largest item in a subtree.
	     * @param t the node that roots the tree.
	     * @return node containing the largest item.
	     */
	   
	    private AvlNode<AnyType> findMax( AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return t;

	        while( t.right != null )
	            t = t.right;
	        return t;
	    }
	    
	    public AnyType findMax2( )
	    {
	        if( isEmpty( ) )
	            throw new InputMismatchException( );
	        return findMax2( root ).element;
	    }
	    private AvlNode<AnyType> findMax2( AvlNode<AnyType> t )
	    {
	        if( t == null )
	            return t;

	        while( t.right != null )
	            t = t.right;
	        System.out.println(t.element + " " + t.veces);
	        return t;
	    }
	    
	    /**
	     * Find an item in the tree.
	     * @param x the item to search for.
	     * @return true if x is found.
	     */
	    public boolean contains( AnyType x )
	    {
	        return contains( x, root );
	    }
	    /**
	     * Internal method to find an item in a subtree.
	     * @param x is item to search for.
	     * @param t the node that roots the tree.
	     * @return true if x is found in subtree.
	     */
	    private boolean contains( AnyType x, AvlNode<AnyType> t )
	    {
	        while( t != null )
	        {
	            int compareResult = x.compareTo( t.element );
	            
	            if( compareResult < 0 )
	                t = t.left;
	            else if( compareResult > 0 )
	                t = t.right;
	            else
	                return true;    // Match
	        }

	        return false;   // No match
	    }
	    public AvlNode contains2( AnyType x )
	    {
	        return contains2( x, root );
	    }
	    //Metodo me devuelve apuntador al nodo repetido
	private AvlNode contains2( AnyType x, AvlNode<AnyType> t ){
		while( t != null )
	    {
	        int compareResult = x.compareTo( t.element );
	        
	        if( compareResult < 0 )
	            t = t.left;
	        else if( compareResult > 0 )
	            t = t.right;
	        else
	            return t;    // Match
	    }

	    return t;   // No match
	}


	public AvlNode raiz(AvlTree<AnyType> arbol){ //devuelve la raiz de un arbol

		return arbol.root;
	}
	int altura=1;
	public int hallarAltura(AvlNode<AnyType> t, AvlNode<AnyType> padre){
		
	   int compareResult = t.element.compareTo( padre.element );
	   
	   if( compareResult < 0 )
	   { altura++;hallarAltura( t, padre.left);}
	   else if( compareResult > 0 )
	   { altura++;hallarAltura( t, padre.right);}
	   else
	       return altura;    // Match

	  
	 
	   return altura;
		
		
	}




	    /**
	     * Internal method to print a subtree in sorted order.
	     * @param t the node that roots the tree.
	     */
	    private void printTree( AvlNode<AnyType> t )
	    {
	        if( t != null )
	        {
	            printTree( t.left );
	            System.out.println( t.element );
	            printTree( t.right );
	        }
	    }

	    /**
	     * Return the height of node t, or -1, if null.
	     */
	    public int height( AvlNode<AnyType> t )
	    {
	        return t == null ? -1 : t.height;
	    }
	    public int height2( AvlNode<AnyType> t )
	    {
	        return t.height;
	    }
	    /**
	     * Rotate binary tree node with left child.
	     * For AVL trees, this is a single rotation for case 1.
	     * Update heights, then return new root.
	     */
	    private AvlNode<AnyType> rotateWithLeftChild( AvlNode<AnyType> k2 )
	    {
	        AvlNode<AnyType> k1 = k2.left;
	        k2.left = k1.right;
	        k1.right = k2;
	        k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
	        k1.height = Math.max( height( k1.left ), k2.height ) + 1;
	        return k1;
	    }

	    /**
	     * Rotate binary tree node with right child.
	     * For AVL trees, this is a single rotation for case 4.
	     * Update heights, then return new root.
	     */
	    private AvlNode<AnyType> rotateWithRightChild( AvlNode<AnyType> k1 )
	    {
	        AvlNode<AnyType> k2 = k1.right;
	        k1.right = k2.left;
	        k2.left = k1;
	        k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
	        k2.height = Math.max( height( k2.right ), k1.height ) + 1;
	        return k2;
	    }

	    /**
	     * Double rotate binary tree node: first left child
	     * with its right child; then node k3 with new left child.
	     * For AVL trees, this is a double rotation for case 2.
	     * Update heights, then return new root.
	     */
	    private AvlNode<AnyType> doubleWithLeftChild( AvlNode<AnyType> k3 )
	    {
	        k3.left = rotateWithRightChild( k3.left );
	        return rotateWithLeftChild( k3 );
	    }

	    /**
	     * Double rotate binary tree node: first right child
	     * with its left child; then node k1 with new right child.
	     * For AVL trees, this is a double rotation for case 3.
	     * Update heights, then return new root.
	     */
	    private AvlNode<AnyType> doubleWithRightChild( AvlNode<AnyType> k1 )
	    {
	        k1.right = rotateWithLeftChild( k1.right );
	        return rotateWithRightChild( k1 );
	    }

	    private static class AvlNode<AnyType>
	    {
	            // Constructors
	        AvlNode( AnyType theElement )
	        {
	            this( theElement, 0, null, null );//agrego un dato adicional que va a lmacenar el nodo que es el numero de veces
	        }

	        AvlNode( AnyType theElement,int numero, AvlNode<AnyType> lt, AvlNode<AnyType> rt )
	        {
	            element  = theElement;
	            left     = lt;
	            right    = rt;
	            height   = 0;
	            numero=1;
	            veces= numero;
	        }

	        AnyType           element;      // The data in the node
	        AvlNode<AnyType>  left;         // Left child
	        AvlNode<AnyType>  right;        // Right child
	        int               height;       // Height
	        int veces;
	    }

	    public int aumentar(AvlNode nodo){
	    	
	    	nodo.veces=nodo.veces+1;
	    	
	    	return nodo.veces;
	    }
	public int mostrarVeces(AvlNode nodo){
	    
	    	return nodo.veces;
	    }
	    
	      /** The tree root. */
	    private AvlNode<AnyType> root;


	        // Test program
	    public static void main( String [ ] args )
	    {
	        AvlTree<Integer> t = new AvlTree<>( );
	        final int SMALL = 40;
	        final int NUMS = 1000000;  // must be even
	        final int GAP  =   37;

	        System.out.println( "Checking... (no more output means success)" );

	        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
	        {
	        //    System.out.println( "INSERT: " + i );
	            t.insert( i );
	            if( NUMS < SMALL )
	                t.checkBalance( );
	        }
	        
	        for( int i = 1; i < NUMS; i+= 2 )
	        {
	         //   System.out.println( "REMOVE: " + i );
	            t.remove( i );
	            if( NUMS < SMALL )
	                t.checkBalance( );
	        }
	        if( NUMS < SMALL )
	            t.printTree( );
	        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
	            System.out.println( "FindMin or FindMax error!" );

	        for( int i = 2; i < NUMS; i+=2 )
	             if( !t.contains( i ) )
	                 System.out.println( "Find error1!" );

	        for( int i = 1; i < NUMS; i+=2 )
	        {
	            if( t.contains( i ) )
	                System.out.println( "Find error2!" );
	        }
	    }
	}
	
	
	}



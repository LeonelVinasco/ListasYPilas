package com.linked;


public class MyQueueLinked<E> implements Iterable<E>{

	
	private int theSize;
	private int modCount = 0;
	private Node<E> beginMarker;
	private Node<E> endMarker;

	private static class Node<E>{
		public Node (E d, Node<E> p, Node<E> n)
		{data=d; prev=p; next=n;}
			public E data;
			public Node<E> prev;
			public Node<E> next;
			
		}



		public void enqueue(E data){
			
			addFirst(data);
		}
		public E peek(){
			return get(size()-1);
		}
		public E dequeue(){
			return remove(size()-1);
		}
		public MyQueueLinked() {
		clear();	
		}
		public void makeEmpty() {
			clear();	
			}
		
		public boolean isEmpty(){
			
			if (theSize==0)
				return true;
			else
				return false;
		}
		public void print(MyQueueLinked<E> cola){
			
			System.out.println(cola);
		}
		public int size()
		{
			return theSize;
		}
	private void clear(){
		doClear();
	}
		private void doClear(){
			beginMarker= new Node<>(null, null, null);
			endMarker = new Node<> (null, beginMarker, null);
			beginMarker.next = endMarker;
			theSize=0;
			modCount++;
		}
		
		

		private boolean add(E x){
			add(size(),x); return true;
		}
		
		private void add(int idx, E x){
			addBefore(getNode(idx,0,size()),x);
			
		}
		
		private E get(int idx){
			return getNode(idx).data;
		}
		
		private Node <E> getNode (int idx){
			
			if (idx==0)
			{
				return getNode(idx,0,size());
			}
			else{
				return getNode(idx,0,size()-1);
			}
		}
		private Node<E> getNode (int idx, int lower, int upper)
		{
			Node<E> p;
			if (idx<lower || idx>upper){
				throw new IndexOutOfBoundsException("getNode index"+idx+";size:" + size());
			}
			if (idx < size()/2){
				p=beginMarker.next;
				for(int i=0; i<idx;i++)
					p=p.next;
			}
			else {
				p=endMarker;
				for(int i= size(); i>idx;i--)
					p=p.prev;
			}
			return p;
			
		}
		private E set(int idx, E newVal){
			Node<E> p= getNode(idx);
			E oldVal = p.data;
			p.data = newVal;
			return oldVal;	
		}

		
		private void addFirst(E p){
			add(0,p);	
		}
		private void addLast(E p){
			add(size(),p);	
		}
		private boolean remove (E dato){
			int i= find(dato);
			
			remove(i);
			
			return true;
		}
		
		private E remove(int idx){
			return remove(getNode(idx));
		}
		private E remove (Node<E> p){
			p.next.prev = p.prev;
			p.prev.next= p.next;
			theSize--;
			modCount++;
			return p.data;
		}
		private E removeLast(){
			return remove(getNode(size()-1));
		}
		
		private int find (E x){
			Node<E> p;
				
			for (int i=0;i<size();i++)
				{p= getNode(i);	
			if (p.data==x){
				return i;
			}}
			return 0;
			//Buscar solución Devuelve -40 cuando dato no se encuentra
			
		}
		
		private void addBefore(Node<E> p, E x){
			Node<E> newNode = new Node<>(x,p.prev,p);
			newNode.prev.next = newNode;
			p.prev = newNode;
			theSize++;
			modCount++;
		}
		
		
		public String toString( )
		    {
		        StringBuilder sb = new StringBuilder( "[ " );

		        for( E x : this )
		            sb.append( x + " " );
		        sb.append( "]" );

		        return new String( sb );
		    }	
		@Override
		public java.util.Iterator<E> iterator()
	{
		return new LinkedListIterator();
		
	}

		private class LinkedListIterator implements java.util.Iterator<E>
	    {
	        private Node<E> current = beginMarker.next;
	        private int expectedModCount = modCount;
	        private boolean okToRemove = false;
	        
	        public boolean hasNext( )
	        {
	            return current != endMarker;
	        }
	        
	        public E next( )
	        {
	            if( modCount != expectedModCount )
	                throw new java.util.ConcurrentModificationException( );
	            if( !hasNext( ) )
	                throw new java.util.NoSuchElementException( ); 
	                   
	            E nextItem = current.data;
	            current = current.next;
	            okToRemove = true;
	            return nextItem;
	        }
	        
	        public void remove( )
	        {
	            if( modCount != expectedModCount )
	                throw new java.util.ConcurrentModificationException( );
	            if( !okToRemove )
	                throw new IllegalStateException( );
	                
	            MyQueueLinked.this.remove( current.prev );
	            expectedModCount++;
	            okToRemove = false;       
	        }
	    }
		
		



}

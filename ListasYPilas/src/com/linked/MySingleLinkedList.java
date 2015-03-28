package com.linked;


public class MySingleLinkedList<E> implements Iterable<E>
{
private int theSize;
private int modCount = 0;
private Node<E> beginMarker;
private Node<E> endMarker;

private static class Node<E>{
	public Node (E d, /*Node<E> p,*/ Node<E> n)
	{data=d; /*prev=p;*/ next=n;}
		public E data;
		public Node<E> prev;
		public Node<E> next;
		
	}


	public MySingleLinkedList() {
	clear();	
	}
	
	public int size()
	{
		return theSize;
	}
public void clear(){
	doClear();
}
	public void doClear(){
		beginMarker= new Node<>(null, null);
		endMarker = new Node<> (null, null);
		beginMarker.next = endMarker;
		theSize=0;
		modCount++;
	}
	
	//public static void main(String[] args) {
		
	//}

	
	
	
	public E get(int idx){
		return getNode(idx).data;
	}
	
	public Node <E> getNode (int idx){
		if (idx==0){
		return getNode(idx,0,size());
	}else{
		return getNode(idx,0,size()-1);
	}}
	public Node<E> getNode (int idx, int lower, int upper)
	{
		Node<E> p=beginMarker.next;;
		if (idx<lower || idx>upper){
			throw new IndexOutOfBoundsException("getNode index"+idx+";size:" + size());
		}	
		
			for(int i=0; i<idx;i++)
				p=p.next;
			
		return p;
	}
	public E set(int idx, E newVal){
		Node<E> p= getNode(idx);
		E oldVal = p.data;
		p.data = newVal;
		return oldVal;	
	}

	
	public void addFirst(E p){
		add(0,p);	
	}
	public void addLast(E p){
		add(size(),p);	
	}
	public boolean remove (E dato){
		int i= Integer.parseInt(find(dato));
		
		remove(i);
		
		return true;
	}
	//Remove for singleLinkedList
	public E remove(int idx){
		
		Node<E> r=getNode(idx);
		E oldVal=r.data;
		if( idx>0){
		getNode(idx-1).next=getNode(idx+1);}
		else {
			beginMarker.next=r;
			}
		
		return oldVal;
	}
	public E remove (Node<E> p){
		//Utilizado para el remove del iterador
	remove(find(p)-1);
		return p.data;
	}
	public E removeLast(){
		return remove(size()-1);
	}
	public int find (Node<E> x){
		
		Node<E> p;
		for (int i=0;i<size();i++)
			{p= getNode(i);
		if (p.data==x.data && p.next==x.next){
			return i;
		}}
		return 0;
		//Buscar solución Devuelve -40 cuando dato no se encuentra
	}
	
	
	public String find (E x){
		Node<E> p;
	boolean found=false;
		int i;
		for (i=0;i<size();i++)
			{p= getNode(i);	
		if (p.data==x){
			found=true;
			break;
		}}
		
		if (found==true){
		return Integer.toString(i);}
		else {
		return "No encontrado";	
		}
		//Buscar solución Devuelve -40 cuando dato no se encuentra
		
	}
	
	public boolean add(E x){
		add(size(),x); return true;
	}
	public void add(int idx, E x){
		
		addBefore(idx,getNode(idx,0,size()),x);
		
	}
	private void addBefore(int idx,Node<E> p, E x){
		Node<E> newNode = new Node<>(x,p);
		
		if(idx>0 || size()>0){
		getNode(idx-1).next=newNode;
		newNode.next = p;
		}  //Codigo para agregar datos, singlelinkedlist !!
		else{
			
			beginMarker.next=newNode;
		newNode.next=p;
		}
		
		//p.prev = newNode;
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
                
            MySingleLinkedList.this.remove( current );
            expectedModCount++;
            okToRemove = false;       
        }
    }
	
	



}
	
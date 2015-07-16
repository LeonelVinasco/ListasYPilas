
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

//autores: vanessa gonzalez duque y Leonel Armando Vinasco
public class Super_D
{
	
	public static class MyQueueLinked<E> implements Iterable<E>
	{

		private int theSize;
		private int modCount = 0;
		private Node<E> beginMarker;
		private Node<E> endMarker;

		private static class Node<E>
		{
			public Node(E d, Node<E> p, Node<E> n)
			{
				data = d;
				prev = p;
				next = n;
			}

			public E data;
			public Node<E> prev;
			public Node<E> next;

		}

		public void enqueue(E data)
		{

			addFirst(data);
		}

		public E peek()
		{
			return get(size() - 1);
		}

		public E dequeue()
		{
			return remove(size() - 1);
		}

		public MyQueueLinked()
		{
			clear();
		}

		public void makeEmpty()
		{
			clear();
		}

		public boolean isEmpty()
		{

			if (theSize == 0)
				return true;
			else
				return false;
		}

		public void print(MyQueueLinked<E> cola)
		{

			System.out.println(cola);
		}

		public int size()
		{
			return theSize;
		}

		private void clear()
		{
			doClear();
		}

		private void doClear()
		{
			beginMarker = new Node<>(null, null, null);
			endMarker = new Node<>(null, beginMarker, null);
			beginMarker.next = endMarker;
			theSize = 0;
			modCount++;
		}

		private boolean add(E x)
		{
			add(size(), x);
			return true;
		}

		private void add(int idx, E x)
		{
			addBefore(getNode(idx, 0, size()), x);

		}

		private E get(int idx)
		{
			return getNode(idx).data;
		}

		private Node<E> getNode(int idx)
		{

			if (idx == 0)
			{
				return getNode(idx, 0, size());
			} else
			{
				return getNode(idx, 0, size() - 1);
			}
		}

		private Node<E> getNode(int idx, int lower, int upper)
		{
			Node<E> p;
			if (idx < lower || idx > upper)
			{
				throw new IndexOutOfBoundsException("getNode index" + idx
						+ ";size:" + size());
			}
			if (idx < size() / 2)
			{
				p = beginMarker.next;
				for (int i = 0; i < idx; i++)
					p = p.next;
			} else
			{
				p = endMarker;
				for (int i = size(); i > idx; i--)
					p = p.prev;
			}
			return p;

		}

		private E set(int idx, E newVal)
		{
			Node<E> p = getNode(idx);
			E oldVal = p.data;
			p.data = newVal;
			return oldVal;
		}

		private void addFirst(E p)
		{
			add(0, p);
		}

		private void addLast(E p)
		{
			add(size(), p);
		}

		private boolean remove(E dato)
		{
			int i = find(dato);

			remove(i);

			return true;
		}

		private E remove(int idx)
		{
			return remove(getNode(idx));
		}

		private E remove(Node<E> p)
		{
			p.next.prev = p.prev;
			p.prev.next = p.next;
			theSize--;
			modCount++;
			return p.data;
		}

		private E removeLast()
		{
			return remove(getNode(size() - 1));
		}

		private int find(E x)
		{
			Node<E> p;

			for (int i = 0; i < size(); i++)
			{
				p = getNode(i);
				if (p.data == x)
				{
					return i;
				}
			}
			return 0;
			
		}

		private void addBefore(Node<E> p, E x)
		{
			Node<E> newNode = new Node<>(x, p.prev, p);
			newNode.prev.next = newNode;
			p.prev = newNode;
			theSize++;
			modCount++;
		}

		public String toString()
		{
			StringBuilder sb = new StringBuilder("[ ");

			for (E x : this)
				sb.append(x + " ");
			sb.append("]");

			return new String(sb);
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

			public boolean hasNext()
			{
				return current != endMarker;
			}

			public E next()
			{
				if (modCount != expectedModCount)
					throw new java.util.ConcurrentModificationException();
				if (!hasNext())
					throw new java.util.NoSuchElementException();

				E nextItem = current.data;
				current = current.next;
				okToRemove = true;
				return nextItem;
			}

			public void remove()
			{
				if (modCount != expectedModCount)
					throw new java.util.ConcurrentModificationException();
				if (!okToRemove)
					throw new IllegalStateException();

				MyQueueLinked.this.remove(current.prev);
				expectedModCount++;
				okToRemove = false;
			}
		}

	}
	
	
	
	
	
	
	public static class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
	{
		/**
		 * Construct the tree.
		 */
		public BinarySearchTree()
		{
			root = null;
		}

		/**
		 * Insert into the tree; duplicates are ignored.
		 * 
		 * @param x
		 *            the item to insert.
		 */
		public void insert(AnyType x)
		{
			root = insert(x, root);
		}

		/**
		 * Remove from the tree. Nothing is done if x is not found.
		 * 
		 * @param x
		 *            the item to remove.
		 */
		public void remove(AnyType x)
		{
			root = remove(x, root);
		}

		/**
		 * Find the smallest item in the tree.
		 * 
		 * @return smallest item or null if empty.
		 * @throws Exception
		 */
		public AnyType findMin() throws Exception
		{
			if (isEmpty())
				throw new Exception();// UnderflowException( );
			return findMin(root).element;
		}

		/**
		 * Find the largest item in the tree.
		 * 
		 * @return the largest item of null if empty.
		 * @throws Exception
		 */
		public AnyType findMax() throws Exception
		{
			if (isEmpty())
				throw new Exception();// UnderflowException( );
			return findMax(root).element;
		}

		/**
		 * Find an item in the tree.
		 * 
		 * @param x
		 *            the item to search for.
		 * @return true if not found.
		 */
		public boolean contains(AnyType x)
		{
			return contains(x, root);
		}

		/**
		 * Make the tree logically empty.
		 */
		public void makeEmpty()
		{
			root = null;
		}

		/**
		 * Test if the tree is logically empty.
		 * 
		 * @return true if empty, false otherwise.
		 */
		public boolean isEmpty()
		{
			return root == null;
		}

		/**
		 * Print the tree contents in sorted order.
		 */
		public void printTree()
		{
			if (isEmpty())
				System.out.println("Empty tree");
			else
				printTreeInorden(root);
		}

		/**
		 * Internal method to insert into a subtree.
		 * 
		 * @param x
		 *            the item to insert.
		 * @param t
		 *            the node that roots the subtree.
		 * @return the new root of the subtree.
		 */
		private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t)
		{
			if (t == null)
				return new BinaryNode<>(x, null, null);

			int compareResult = x.compareTo(t.element);

			if (compareResult < 0)
				t.left = insert(x, t.left);
			else if (compareResult > 0)
				t.right = insert(x, t.right);
			else
				; // Duplicate; do nothing
			return t;
		}

		/**
		 * Internal method to remove from a subtree.
		 * 
		 * @param x
		 *            the item to remove.
		 * @param t
		 *            the node that roots the subtree.
		 * @return the new root of the subtree.
		 */
		private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t)
		{
			if (t == null)
				return t; // Item not found; do nothing

			int compareResult = x.compareTo(t.element);

			if (compareResult < 0)
				t.left = remove(x, t.left);
			else if (compareResult > 0)
				t.right = remove(x, t.right);
			else if (t.left != null && t.right != null) // Two children
			{
				t.element = findMin(t.right).element;
				t.right = remove(t.element, t.right);
			} else
				t = (t.left != null) ? t.left : t.right;
			return t;
		}

		/**
		 * Internal method to find the smallest item in a subtree.
		 * 
		 * @param t
		 *            the node that roots the subtree.
		 * @return node containing the smallest item.
		 */
		private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t)
		{
			if (t == null)
				return null;
			else if (t.left == null)
				return t;
			return findMin(t.left);
		}

		/**
		 * Internal method to find the largest item in a subtree.
		 * 
		 * @param t
		 *            the node that roots the subtree.
		 * @return node containing the largest item.
		 */
		private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t)
		{
			if (t != null)
				while (t.right != null)
					t = t.right;

			return t;
		}

		/**
		 * Internal method to find an item in a subtree.
		 * 
		 * @param x
		 *            is item to search for.
		 * @param t
		 *            the node that roots the subtree.
		 * @return node containing the matched item.
		 */
		private boolean contains(AnyType x, BinaryNode<AnyType> t)
		{
			if (t == null)
				return false;

			int compareResult = x.compareTo(t.element);

			if (compareResult < 0)
				return contains(x, t.left);
			else if (compareResult > 0)
				return contains(x, t.right);
			else
				return true; // Match
		}

		/**
		 * Internal method to print a subtree in sorted order.
		 * 
		 * @param t
		 *            the node that roots the subtree.
		 */
		ArrayList<AnyType> b = new ArrayList<AnyType>();
		String b1 = "";

		public void prinTreePreorder(BinaryNode<AnyType> t)
		{
			if (t != null)
			{

				// System.out.print(t.element);
				b.add(t.element);
				b1 += t.element;
				prinTreePreorder(t.left);
				prinTreePreorder(t.right);

			}

		}

		ArrayList<AnyType> a = new ArrayList<AnyType>();
		String a1 = "";

		public void prinTreepostorden(BinaryNode<AnyType> t)
		{
			if (t != null)
			{

				prinTreepostorden(t.left);

				prinTreepostorden(t.right);

				// System.out.print(t.element);
				a.add(t.element);
				a1 += t.element;

			}
		}

		private void printTreeInorden(BinaryNode<AnyType> t)
		{
			if (t != null)
			{
				printTreeInorden(t.left);
				System.out.print(t.element);
				printTreeInorden(t.right);
			}

		}

		/**
		 * Internal method to compute height of a subtree.
		 * 
		 * @param t
		 *            the node that roots the subtree.
		 */
		public int height(BinaryNode<AnyType> t)
		{
			if (t == null)
				return -1;
			else
				return 1 + Math.max(height(t.left), height(t.right));
		}

		// Basic node stored in unbalanced binary search trees
		public static class BinaryNode<AnyType>
		{
			// Constructors
			BinaryNode(AnyType theElement)
			{
				this(theElement, null, null);
			}

			BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,
					BinaryNode<AnyType> rt)
			{
				element = theElement;
				left = lt;
				right = rt;
			}

			AnyType element; // The data in the node
			BinaryNode<AnyType> left; // Left child
			BinaryNode<AnyType> right; // Right child
		}

		/** The tree root. */
		private BinaryNode<AnyType> root;


		BinaryNode<AnyType> result = null;

		public BinaryNode<AnyType> contains1(AnyType x, BinaryNode<AnyType> t)
		{

			if (t.element.equals(x))
			{
				result = t;
				return result;
			}

			else
			{
				if (result != null)
					return result;
				else
				{
					if (t.left != null)
					{
						contains1(x, t.left);
					}
					if (t.right != null)
					{
						contains1(x, t.right);
					}
				}
			}
			return result;
		}

		public void insert1(AnyType father, AnyType izq, AnyType der)
		{
			BinaryNode<AnyType> p = contains1(father, root);
			p.right = new BinaryNode<AnyType>(der);
			p.left = new BinaryNode<AnyType>(izq);
			result = null;
		}

		public void insertIzq(AnyType father, AnyType izq)//metodo para agregar solo un hijo
		{
			BinaryNode<AnyType> p = contains1(father, root);
			p.left = new BinaryNode<AnyType>(izq);
			result = null;
			
		}
		
		
		public void levelOrder(BinaryNode<AnyType> a)
		{
			MyQueueLinked<BinaryNode<AnyType>> c = new MyQueueLinked<>();
			BinaryNode<AnyType> aux = null;
			c.enqueue(a);
			while (!c.isEmpty())
			{
				aux = c.dequeue();
				System.out.print(aux.element+" ");
				if (aux.left != null)
					c.enqueue(aux.left);
				if (aux.right != null)
					c.enqueue(aux.right);
			}
			System.out.println();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan;
		File f = new File("D_1.in");
		if (f.exists())
		{
			scan = new Scanner(f);
		} else
		{
			scan = new Scanner(System.in);
		}
		
		StringTokenizer st = new StringTokenizer(scan.nextLine()," ");
		int cases =  Integer.parseInt(st.nextToken());
		int countCases = 0;
		while(countCases < cases)
		{
			String preOrder = scan.nextLine();
			String postOrder = scan.nextLine();
			StringTokenizer aux1 = new StringTokenizer(preOrder," ");
			StringTokenizer aux2 = new StringTokenizer(postOrder," ");
			ArrayList<Integer> preArray = new ArrayList<Integer>();
			ArrayList<Integer> postArray = new ArrayList<Integer>();
			
			for (int i = 0; i < (preOrder.length()/2)+1; i++)
			{
				preArray.add(Integer.parseInt(aux1.nextToken()));
				postArray.add(Integer.parseInt(aux2.nextToken()));
			}
			
			ArrayList<Integer> alreadyAdded = new ArrayList<Integer>();
			BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
			tree.insert(preArray.get(0));
			alreadyAdded.add(preArray.get(0));
			
			for (int i = 0; i < preArray.size()-1; i++)
			{int rightRoot = postArray.indexOf(preArray.get(i));
				
			if (rightRoot>=1){
			if (preArray.get(i+1).equals(postArray.get(rightRoot-1))){ //para cuando tiene solo un hijo
				
					tree.insertIzq(preArray.get(i), preArray.get(i+1));	//nuevo metodo insert
					alreadyAdded.add(preArray.get(i+1));	
					}else if(alreadyAdded.indexOf(preArray.get(i+1)) == -1 )
				{
					//	if (postArray.indexOf(preArray.get(index))) exepción para outofbounds
					
					tree.insert1(preArray.get(i), preArray.get(i+1), postArray.get(rightRoot-1));
					alreadyAdded.add(preArray.get(i+1));
					alreadyAdded.add(postArray.get(rightRoot-1));
				}else{}
			}}
			System.out.println("Test #"+(countCases+1)+":");
			tree.levelOrder(tree.root);
			countCases++;
		}
	}
}

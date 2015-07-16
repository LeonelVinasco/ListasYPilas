package com.tres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class problem1
{

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
		ArrayList<AnyType> b= new ArrayList<AnyType>();
		String b1="";
		public void prinTreePreorder(BinaryNode<AnyType> t)
		{
			if (t != null)
			{

				//System.out.print(t.element);
				b.add(t.element);
				b1+=t.element;
				prinTreePreorder(t.left);
				prinTreePreorder(t.right);

			}

		}
		ArrayList<AnyType> a= new ArrayList<AnyType>();
		String a1= "";
		public void prinTreepostorden(BinaryNode<AnyType> t)
		{	
			if (t != null)
			{

				prinTreepostorden(t.left);

				prinTreepostorden(t.right);

				//System.out.print(t.element);
				a.add(t.element);
				a1+=t.element;

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

		// Nuestros metodos

		/*
		 * public BinaryNode<AnyType> contains1( AnyType x, BinaryNode<AnyType>
		 * t ) { BinaryNode<AnyType> p=t ; BinaryNode<AnyType> res=null ;
		 * boolean compareResult = x.equals(t.element );
		 * 
		 * if( compareResult ==true ) { return p; } else { if(t.left!=null)
		 * res=contains1( x, t.left );
		 * 
		 * else if (t.right!=null && res==null)
		 * 
		 * res=contains1( x, t.right );
		 * 
		 * } return res; }
		 */

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

		public void insert2(AnyType father, AnyType izq, AnyType der)
		{
			BinaryNode<AnyType> p = contains1(father, root);
			p.right = new BinaryNode<AnyType>(der);
			p.left = null;
			result = null;

		}

		public void insert3(AnyType father, AnyType izq, AnyType der)
		{
			BinaryNode<AnyType> p = contains1(father, root);
			p.right = null;
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

	// public static void main ( String[] args )
	// {
	// System.out.println(Integer.parseInt("0"));
	// }

	public static void main(String[] args) throws FileNotFoundException
	{
		problem1 pA = new problem1();
		Scanner scan;
		File f = new File("A_1.in");

		if (f.exists())
		{
			scan = new Scanner(f);
		} else
		{
			scan = new Scanner(System.in);
		}

		int cases = Integer.parseInt(scan.nextLine());

		int countCases = 0;
		while (countCases < cases)
		{
			int root = Integer.parseInt(scan.nextLine());
			BinarySearchTree<Integer> arbol = new BinarySearchTree<Integer>();
			arbol.insert(root);
			//
			int Fathers = Integer.parseInt(scan.nextLine());
			int countOperation = Fathers;
			System.out.print("Test #" + (countCases + 1) + ":");
			while (countOperation > 0)
			{

				StringTokenizer st = new StringTokenizer(scan.nextLine(), " ");
				Integer father = Integer.parseInt(st.nextToken());
				String izq = st.nextToken();
				String der = st.nextToken();
				Integer aux = -1;

				if (izq.equals("Null"))
					arbol.insert2(father, aux, Integer.parseInt(der));
				else if (der.equals("Null"))
					arbol.insert3(father, Integer.parseInt(izq), aux);
				else
					arbol.insert1(father, Integer.parseInt(izq),
							Integer.parseInt(der));

				countOperation--;
				
			}
			
			arbol.levelOrder(arbol.root);
			/*
			 * 
			 * 
			 *  desde aca emppieza lo de medir los nodos mas lejanos... no funciona :(
			arbol.prinTreepostorden(arbol.root);
			arbol.prinTreePreorder(arbol.root);
			
			System.out.println(arbol.a1);
			System.out.println(arbol.b1);
			
			System.out.print(2 + arbol.height(arbol.root.left)
					+ arbol.height(arbol.root.right));
			System.out.print(" ");
			System.out.print(Math.min(Integer.parseInt(arbol.a.get(1)+""), Integer.parseInt(arbol.b.get(arbol.b.size()-2)+"")));
			System.out.print(" ");
			System.out.print(Math.max(Integer.parseInt(arbol.a.get(1)+""), Integer.parseInt(arbol.b.get(arbol.b.size()-2)+"")));
			
			arbol.b= new ArrayList<Integer>();
			arbol.a= new ArrayList<Integer>();
			// mide la altura de los arboles por derecha y por izquierda
			
			// imprime los mas lejanos
			 * 
			 */
			countCases++;
		}
	}
}
/**
 * 
 */
package co.edu.unal.practice4;

import java.util.Random;
/**
 * @author Odiseo
 *
 */
public class Runner {
	
	private static int size=100;
	private static double [] nums=new double[size];
	private static double [] clone=new double[size];
	
	
	public static void generateSequence(){
		Random randomObj = new Random();
		
		for (int i=0;i<size;i++)			
			getNums()[i] =randomObj.nextInt(size);

	}

	public static void cloneSequence(){
		for (int i=0;i<size;i++){
			getClone()[i] =getNums()[i];
		}
	}
	
	public static void printSequence(double[] nums){
		System.out.print("\n Sequence:");
		for(int i=0;i<size;i++)
		System.out.print(String.valueOf(nums[i]).replace(".0", "")+" ");
		
		
		
	}
	


    
	
	public static void main(String[] args){
		BubbleSort bubble=new BubbleSort();
//		SelectionSort selection=new SelectionSort();
//		MergeSortRec merge= new MergeSortRec();
		
		generateSequence();
		
		printSequence(getNums());
		cloneSequence();
		
		bubble.sort(getClone());
		System.out.println("\n"+bubble.getSortName());
		System.out.println(bubble.getReport());
		System.out.println("\nsecuencia ordenada");
		printSequence( getClone());//imprime secuencia ordenada
		System.out.println("\nDONE bubble");
		
		cloneSequence();
		Report rrp = new Report();
		bubble.recursiveBubble(getClone(),0,getClone().length, rrp);
		System.out.println("\n"+bubble.getSortName());
		System.out.println(bubble.getReport());
		printSequence(getClone()); //imprime secuencia ordenada
		System.out.println("\nDONE recursiveBubble");
		
		InsertionSort insertion= new InsertionSort();
		
		cloneSequence();
		insertion.sort(getClone());
		System.out.println("\n"+insertion.getSortName());
		System.out.println(insertion.getReport());
		printSequence(getClone()); //imprime secuencia ordenada
		System.out.println("\nDONE insertion");
		
		
		
		/*cloneSequence();
		selection.sort(clone);
		cloneSequence();
		merge.sort(clone);*/	
		
	}

	private static double [] getNums() {
		return nums;
	}

	private static void setNums(double [] nums) {
		Runner.nums = nums;
	}

	private static double [] getClone() {
		return clone;
	}

	private static void setClone(double [] clone) {
		Runner.clone = clone;
	}

}

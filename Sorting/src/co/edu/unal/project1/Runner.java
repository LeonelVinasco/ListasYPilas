package co.edu.unal.project1;
import java.util.*;

//@autors Leonel Vinasco zapata, Sergio tovar
public class Runner {

	private static int size=100;
	private static double [] nums = new double[size];
	private static double [] clone= new double[size];
	public String text="po!";
	

	public static void generateSequence(){
		
		
Random randomObj = new Random();
		
		for (int i=0;i<size;i++)			
			getNums()[i] =randomObj.nextInt(size);
	}
	


	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Runner.size = size;
	}

	public static double[] getNums() {
		return nums;
	}

	public static void setNums(double[] nums) {
		Runner.nums = nums;
	}

	public static double[] getClone() {
		return clone;
	}

	public static void setClone(double[] clone) {
		Runner.clone = clone;
	}

	public static void cloneSequence(){
		for (int i=0;i<size;i++){
			getClone()[i] =getNums()[i];
		}
	}
	
	
	
	public static void main (String[] args){

		int firstArg=0;int secondArg=0;
		String [] auxArg=new String[7]; 
		Scanner keyboard = new Scanner(System.in);
		int sp = 0;
		int mx = 0;
		if (args.length > 0) { 
		firstArg = Integer.parseInt(args[0]);
		sp = firstArg;
		secondArg = Integer.parseInt(args[1]); 
		mx = secondArg; 
		
		
		try {
			auxArg[2]=args[2]; 
			auxArg[3]=args[3];
			auxArg[4]=args[4];
			auxArg[5]=args[5];
			auxArg[6]=args[6];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}}
		
		
		System.out.println("1) "+sp + "  2) " + mx +"  3) "+auxArg[2] + "  4) "
		+auxArg[3]+ "  5)  "+ auxArg[4]+ "  6) " +auxArg[5]+ "  7)  "+auxArg[6]);
		
		Random randomObj = new Random();
		double[] num= new double[mx];
		
		for (int i=0;i<mx;i++){			
			num[i] =randomObj.nextInt(mx);
	}
		
		double[] copy= new double[mx];
		for (int i=0;i<mx;i++){	
			copy[i]=num[i];
			}
	
		
		for (int i=2;i<7;i++){
			
		try {
			if (auxArg[i].equals("msi")){
				
						MergeSort merge = new MergeSort();	
						merge.sort(num);
						System.out.println(merge.getReport());
						System.out.println("DONE");		
					
			}
			if (auxArg[i].equals("is")){
			InsertionSort insertion= new InsertionSort();
			insertion.sort(num);
			System.out.println(insertion.getReport());
			System.out.println("DONE");
			}
			if (auxArg[i].equals("ss")){
			SelectionSort selection= new SelectionSort();
			selection.sort(num);
			System.out.println(selection.getReport());
			System.out.println("DONE");
			}
			if (auxArg[i].equals("hs")){
			HeapSort heap= new HeapSort();
			heap.sort(num);
			System.out.println(heap.getReport());
			System.out.println("DONE");
			}
			if (auxArg[i].equals("qsz")){
			QuickSort quick =new QuickSort();
			quick.sort(num);
			System.out.println(quick.getReport());
			System.out.println("DONE");
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		}
		
	

	}
	
	}


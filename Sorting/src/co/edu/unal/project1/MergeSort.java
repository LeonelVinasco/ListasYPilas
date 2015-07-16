package co.edu.unal.project1;
//@autors Leonel Vinasco zapata, Sergio tovar
public class MergeSort extends SortMethod {
	 private double[] numbers;
	 private double[] helper;

	 private int number;
	public MergeSort(){
		
		sortName= "Merge sort";
		
	}
	
	
	 public void sort(double [] Items){
	     this.numbers = Items;
	     number = Items.length;
	     this.helper = new double[number];
	     MergeSortIter(Items);
	 }
	 
	 public void MergeSortIter(double [] Items){
	    Report rp= new Report();
	    rp.setInstanceSize(Items.length);
	    long start = System.currentTimeMillis();
	    
	       for (int i = 1; i <= Items.length / 2 + 1; i *= 2){
	    for (int j = i; j < Items.length; j += 2 * i) {
	       merge(j - i, j, Math.min(j + i, Items.length), rp);
	    }
	    }
	       long end=System.currentTimeMillis();
	       rp.setTime(end-start);
	       this.report=rp; 
	 }

	 private void merge(int low, int middle, int high, Report rp){
	     // Copy both parts into the helper array
	     for (int i = low; i <= high; i++){
	       helper[i] = numbers[i];
	        }
	     int i = low;
	     int j = middle + 1;
	     int k = low;
	     // Copy the smallest values from either the left or the right side back
	     // to the original array
	     while (i <= middle && j <= high) {
	       if (helper[i] <= helper[j]) {
	      rp.addComparisons(1);
	      rp.addMovements(1);
	         numbers[k] = helper[i];
	         i++;
	       } else {
	      rp.addComparisons(1);
	         numbers[k] = helper[j];
	         j++;
	       }
	       k++;
	     }
	     // Copy the rest of the left side of the array into the target array
	     while (i <= middle) {
	       numbers[k] = helper[i];
	       rp.addMovements(1);
	       k++;
	       i++;
	     }
	   }
	
	
}




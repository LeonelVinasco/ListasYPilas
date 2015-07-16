/**
 * 
 */
package co.edu.unal.practice4;

import java.util.Arrays;

/**
 * @author Practice 4
 *
 */
public class BubbleSort extends SortMethod {
	public BubbleSort(){
		setSortName("Bubble sort");
}

public void sort(double [] items){
	setSortName("Bubble sort");
	Report rp=new Report();
	rp.setInstanceSize(items.length);
	long start = System.currentTimeMillis();
	for(int i=items.length-1; i>0; i--){
		for(int j=0; j<i; j++){
			if (items[j]>items[j+1]){
				double aux=items[j];
				items[j] = items[j+1];
				items[j+1] = aux;
				rp.addMovements(2);
			}
			rp.addComparisons(1);
		}
	}
	long end=System.currentTimeMillis();
	rp.setTime(end-start);
	this.report=rp;
}

public void recursiveBubble(double[] items, int startIndex, int endIndex, Report rp) {
    
	setSortName("Recursive Bubble sort ");
	rp.setInstanceSize(items.length);
	long start = System.currentTimeMillis();

	if (startIndex == endIndex - 1) {
        recursiveBubble(items, 0, endIndex - 1,rp);
        rp.addComparisons(1);
    } else if (items[startIndex] > items[startIndex+1]) {
        double currentNumber = items[startIndex];
        items[startIndex] = items[startIndex + 1];
        items[startIndex + 1] = currentNumber;
        rp.addMovements(2);
        rp.addComparisons(2);
        recursiveBubble(items, startIndex + 1, endIndex,rp);
    }	else if(startIndex > endIndex){
		rp.addComparisons(3);
    } 
    
    else  {
        recursiveBubble(items, startIndex + 1, endIndex,rp);
        rp.addComparisons(4);
    } 
	long end=System.currentTimeMillis();
	rp.setTime(end-start);
	this.report=rp;
}
}




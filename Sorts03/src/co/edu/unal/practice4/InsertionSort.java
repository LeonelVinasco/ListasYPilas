/**
 * 
 */
package co.edu.unal.practice4;

/**
 * @author Odiseo
 *
 */
public class InsertionSort extends SortMethod {

	/* (non-Javadoc)
	 * @see co.edu.unal.practice4.SortMethod#sort(double[])
	 */
	
	public InsertionSort() {
		// TODO Auto-generated method stub
		setSortName("Insertion sort");
	}
	
	public void sort(double[] items) {
		Report rp=new Report();
		rp.setInstanceSize(items.length);
		long start = System.currentTimeMillis();
	    for (int i = 0; i < items.length; i++) {
	        double aux = items[i];
	        rp.addMovements(1);
	        int j = i;
	        while (j > 0 && aux < items[j-1]) {
	            items[j] = items[j-1];
	            rp.addMovements(1);
	            j--;
	            rp.addComparisons(1);
	        }
	        items[j] = aux;
	        rp.addMovements(1);
	    }
		long end=System.currentTimeMillis();
		rp.setTime(end-start);
		this.report=rp;
	}

}

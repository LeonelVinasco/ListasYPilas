package co.edu.unal.project1;
//@autors Leonel Vinasco zapata, Sergio tovar
public class QuickSort extends SortMethod {
int c=0;
int m=0;
public QuickSort(){
	
		sortName= "Quick sort";
		
	}
	
	
public void sort(double [] items, int lo0, int hi0){
		
	//Report rp= new Report();
	//rp.setInstanceSize(items.length);
	
	
	  int lo = lo0;
		int hi = hi0;
	
		if (lo >= hi) {
		    return;
		}
	        else if( lo == hi - 1 ) {
	            if (items[lo] > items[hi]) {
	                double T = items[lo];
	                items[lo] = items[hi];
	                items[hi] = T;
	            }
	           
	           // rp.addMovements(2);
	           
	             m=m+2;
	            return;
		}
		// rp.addComparisons(1);
		c=c+1;
      
		double pivot = items[(lo + hi) / 2];
		items[(lo + hi) / 2] = items[hi];
	        items[hi] = pivot;
	        
	       // rp.addMovements(2);
	     
            m=m+2;
	        while( lo < hi ) {
	            while (items[lo] <= pivot && lo < hi) {
			lo++;
			// rp.addComparisons(1);
			 c=c+1;
            
		    }
		    while (pivot <= items[hi] && lo < hi ) {
			hi--;
		//	rp.addComparisons(1);
		    }
	            if( lo < hi ) {
	                double T = items[lo];
	                items[lo] = items[hi];
	                items[hi] = T;   
	               // rp.addMovements(2);
	               
		             m=m+2;
	            }  
	            
		}
	        items[hi0] = items[hi];
	        items[hi] = pivot;

		sort(items, lo0, lo-1);
		sort(items, hi+1, hi0);
		
	//	this.report=rp;
}
public void sort(double[] items){
	
	Report rp= new Report();
	rp.setInstanceSize(items.length);
	long start = System.currentTimeMillis();
	
	
	sort(items, 0, items.length-1);
	rp.addComparisons(c);
	rp.addMovements(m);
	
	long end=System.currentTimeMillis();
	rp.setTime(end-start);
	this.report=rp;	
	
   }
	
	
}

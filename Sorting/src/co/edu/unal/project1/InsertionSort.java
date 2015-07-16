package co.edu.unal.project1;

public class InsertionSort extends SortMethod {

public InsertionSort(){
		
		sortName= "Insertion sort";
		
	}
	
	
public void sort(double [] items){
	
/*
	Report rp = new Report();
	
	long start = System.currentTimeMillis();
	for( int i = 1; i < items.length; i++){
		double temp = items[i];
		int j = i-1;
		boolean flag = true;
		while (j >= 0 && flag) {
			rp.addComparisons(1);
			if (items[j] > temp){ 
				items[j + 1] = items[j];
				rp.addMovements(1);
				j--;
			}
			else
				flag = false;
		}
		items[j+1] = temp;
		rp.addMovements(1);
	}
	long end = System.currentTimeMillis();
	rp.setTime(end-start);
	this.report= rp;
	
	*/

	Report rp=new Report();
	rp.setInstanceSize(items.length);
	long start = System.currentTimeMillis();
    for (int i = 0; i < items.length; i++) {
        double aux = items[i];
        rp.addMovements(1);
        
        for(int j=i; j>0; j--){
        	
        if  (aux < items[j-1]) {
            items[j] = items[j-1];
            rp.addMovements(1);
            j--;
        }
        rp.addComparisons(1);
        items[j] = aux;
        rp.addMovements(1);
        
        
        }
    }
	long end=System.currentTimeMillis();
	rp.setTime(end-start);
	this.report=rp;
}
	
	
}
	
	
	
	


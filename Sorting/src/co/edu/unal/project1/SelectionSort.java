package co.edu.unal.project1;
//@autors Leonel Vinasco zapata, Sergio tovar
public class SelectionSort extends SortMethod {

public SelectionSort(){
		
		sortName= "Selection sort";
		
	}
	
	
public void sort(double [] items){
	
	
	
	Report rp= new Report();
	rp.setInstanceSize(items.length);
	long start = System.currentTimeMillis();
	
	for (int i=0; i< items.length; i++){
		
		int min=i;
	
		for (int j= i + 1; j< items.length; j++){
			if (items[j] < items[min]){	
				min=j;					
			}
			rp.addComparisons(1);
			double aux = items[min];
			items[min]=items[i];
			items[i]=aux;
			rp.addMovements(2);			
		}
	}
	long end=System.currentTimeMillis();
	rp.setTime(end-start);
	this.report=rp;	
 	}
	
}

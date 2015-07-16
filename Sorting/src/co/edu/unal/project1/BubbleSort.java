package co.edu.unal.project1;

//@autors Leonel Vinasco zapata, Sergio tovar

public class BubbleSort extends SortMethod {

	
	
	public BubbleSort(){
		sortName= "Bubble sort";
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
	
	
	
}

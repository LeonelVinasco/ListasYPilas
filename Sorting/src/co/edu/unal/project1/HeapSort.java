package co.edu.unal.project1;
//@autors Leonel Vinasco zapata, Sergio tovar
public class HeapSort extends SortMethod{
	int c=0;
	int m=0;
	double aux=0;
public HeapSort(){
		
	
	
		sortName= "Heap sort";
		
	}
	
	
public void sort(double [] items){
	
	Report rp= new Report();
	rp.setInstanceSize(items.length);
	long start = System.currentTimeMillis();
	
	
	int t= items.length;
	
	int i=0;
	
	for(i= t/2; i>0 ; i-- ){
	
		downHeap(items, i, t);
		rp.addComparisons(c);
		rp.addMovements(m);
		
		m=0;c=0;
		

		
	}
	do{
		
		double aux= items[0];
		items[0]=items[t-1];
		items[t-1]=aux;
		rp.addMovements(2);
		t=t-1;
		
		
	downHeap(items,1,t);
	rp.addComparisons(c);
	rp.addMovements(m);
	
	m=0;c=0;

		
	}while (t>1);
	long end=System.currentTimeMillis();
	rp.setTime(end-start);
	this.report=rp;		
	}
	


public void downHeap (double [] items, int i, int N){
	aux= items[i-1];
	
		while (i<=N/2){
			
			int j= i+i;
			
			if ((j<N) && items[j-1]<items[j]){
				j++;	
				
		}
			//rp.addComparisons(1);
			
		if (aux>= items[j-1]){
			break;
		}else{
			items[i-1]= items[j-1];
			i=j;
		}
	}		
	items[i-1]=aux;	
	m=m+1;
	c=c+2;
	//rp.addmovements(2);
	//rp.addcomparisons(1);
	//this.report=rp;
	}



}

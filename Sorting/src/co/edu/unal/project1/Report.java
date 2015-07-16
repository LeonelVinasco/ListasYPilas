package co.edu.unal.project1;
//@autors Leonel Vinasco zapata, Sergio tovar
public class Report {

	public long instanceSize=100;
	public long comparisons=4950;
	public long movements=9900;
	public double time=1.0;
	
	
	
	public Report() {
		
		instanceSize=0;
		comparisons=0;
		movements=0;
		time=0;
		
	}

public void addMovements (long k){
	
	
	movements=movements+ k;
}

public void addComparisons (long k){
	
	comparisons=comparisons + k;
}


	public long getInstanceSize() {
		return instanceSize;
	}



	public void setInstanceSize(long instanceSize) {
		this.instanceSize = instanceSize;
	}



	public long getComparisons() {
		return comparisons;
	}



	public void setComparisons(long comparisons) {
		this.comparisons = comparisons;
	}



	public long getMovements() {
		return movements;
	}



	public void setMovements(long movements) {
		this.movements = movements;
	}



	public double getTime() {
		return time;
	}



	public void setTime(double time) {
		this.time = time;
	}



	@Override
	public String toString() {
		return "Report [instanceSize=" + instanceSize + ", comparisons="
				+ comparisons + ", movements=" + movements + ", time=" + time
				+ "]";
	}
	
}

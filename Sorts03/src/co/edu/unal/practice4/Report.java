/**
 * 
 */
package co.edu.unal.practice4;

/**
 * @author Practice 4
 *
 */
public class Report {
	long instanceSize;
	long comparisons;
	long movements;
	double time;
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
	public Report(){
		instanceSize=0;
		comparisons=0;
		movements=0;
		time=0.0;
	}
	
	public String toString(){
		
		return "\n Instance Size: "+String.valueOf(getInstanceSize())+
				"\n Comparisons: "+String.valueOf(getComparisons())+
				"\n Movements: "+String.valueOf(getMovements())+
				"\n Execution Time: "+String.valueOf(getTime());		
	}
	public void addMovements(long k){
		movements+=k;
	}
	public void addComparisons(long k){
		comparisons+=k;
	}
}

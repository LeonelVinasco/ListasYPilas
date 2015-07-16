/**
 * 
 */
package co.edu.unal.practice4;

/**
 * @author Odiseo
 *
 */
public abstract class SortMethod {
	private String sortName;
	protected Report report;
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public abstract void sort(double[] items);

}

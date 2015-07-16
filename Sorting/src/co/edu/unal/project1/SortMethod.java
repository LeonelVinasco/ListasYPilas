package co.edu.unal.project1;
//@autors Leonel Vinasco zapata, Sergio tovar
public abstract class SortMethod {
protected String sortName;
protected Report report;

public abstract void sort(double [] items);

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




}

package co.edu.unal.project1;

public class Gato {
	int patas=0;
	int orejas=0;
	
	public Gato(int orejas, int patas ){
		this.orejas= orejas;
		this.patas=patas;
	}
	
	public void showGato(){
		System.out.println("este gato tiene"+patas +"patas");
	}

}

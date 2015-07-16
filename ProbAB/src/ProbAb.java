import java.util.Scanner;


public class ProbAb {
	
	//Funciona pero el programa falla cuando se ingresan dos errores seguidos

	public static void main(String[] args) {

		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese dos números enteros");
		int c=0;
	
		while (true){
		c= ingreso(entrada);	
		System.out.println(c);
		}
	}
		
	public static int ingreso (Scanner entrada){
        
		int a,b,c =0;
		
		try {
			a = entrada.nextInt();
					
		} catch (Exception e) {
			a=0;
			entrada.nextLine();
			System.out.println("error caracter");
			a= entrada.nextInt();
			b=0;
		}
		
		try {
			
			b = entrada.nextInt();
			
		} catch (Exception e) {
			b=0;
			entrada.nextLine();
			System.out.println("error caracter ");		
		//	b=ingreso(entrada);//  ¿Por qué no va?!!!! Se necesita recursión para 
			//admitir dos errores seguidos ¿cómo?
			b= entrada.nextInt();
			a=0;
		}		
		 c= a+b;
		return c;
	}
	
	
}


/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;
public class Main

{
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
	    	
	    	int[] Numeros = new int[5];
	         double Suma = 0;
	    	
	    	for(int i = 0; i < Numeros.length; i++) {
	    		System.out.println("Ingrese los valores para la suma porfavor: ");
	    		Numeros[i]= scanner.nextInt();
	    		Suma += Numeros[i];
	    	}
	    	
	    	double promedio = Suma /5;
	    	System.out.println("El valor del promedio es de: " + promedio);
     
    }
}

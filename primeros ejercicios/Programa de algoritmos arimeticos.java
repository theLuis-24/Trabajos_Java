
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
	    int resultado;
	    	
	    	Scanner scanner =new Scanner(System.in);
	    	System.out.println("Introduzca dos numeros porfavor :D");
	        
	    	System.out.println("Introduzca el primer numero");

	    	float numero1 =scanner.nextFloat();
	    	System.out.println("Introduzca el segundo numero");

	    	float numero2 =scanner.nextFloat();
	    	
	    	float suma =numero1 +numero2;
	    	System.out.println("el resultado de la suma es: "+ suma);
	    	
	    	float resta =numero1 -numero2;
	    	System.out.println("el resultado de la resta es: "+ resta);
	    	
	    	float multiplicacion =numero1 *numero2;
	    	System.out.println("el resultado de la multiplicacion es: "+ multiplicacion);
	    	
	    	float division =numero1 /numero2;
	    	System.out.println("el resultado de la division es: "+ division);
	    	
	    	float modulo =numero1 %numero2;
	    	System.out.println("el resultado del modulo es: "+ modulo);
    }
}

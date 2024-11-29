
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;
public class Main //operadores logicos
{
    public static void main(String[] args) {
 
     Scanner Scanner=new Scanner(System.in);
     System.out.println("Introduzca el primer numero");
	  int numero1 =Scanner.nextInt();
	  System.out.println("Introduzca el segundo numero");
	  int numero2 =Scanner.nextInt();
	  System.out.println("Introduzca el tercer numero");
	  int numero3 =Scanner.nextInt();
    
    if(numero1 > numero2 && numero1 < numero3){
         System.out.println("El primer valor es mayor que el segundo y menor que el tercero ");
          System.out.println("(numero1 > numero2 && numero1< numero3) " + (numero1 > numero2 && numero1< numero3));
    }
    
    else if(numero1 > numero2 && numero1 > numero3){
        
         System.out.println("El primer valor es mayor que el segundo y mayor que el tercero ");
          System.out.println("(numero1 > numero2 && numero1 > numero3) " + (numero1 > numero2 && numero1> numero3));
          
        }else{
        System.out.println("fallaste");
    }
    }
}

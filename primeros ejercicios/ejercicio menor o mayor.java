
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
      int num1 = 43;
      int num2 = 40;
      
      Scanner Scanner=new Scanner(System.in);
      System.out.println("Ingresa el primer valor");
      
      System.out.println("Introduzca el primer numero");
	  int numero1 =Scanner.nextInt();
	  System.out.println("Introduzca el segundo numero");
	  int numero2 =Scanner.nextInt();
	  
      if (numero1<numero2){
          System.out.println("el primer valor es menor al segundo ");
      } else {
          System.out.println("el segundo valor es menor al primero ");
      }
    }
}

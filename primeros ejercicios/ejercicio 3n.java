
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
       try (Scanner Scanner = new Scanner(System.in)){
           System.out.println("Ingresa el primer valor");
           double numero1 = Scanner.nextDouble();
           
           System.out.println("Ingresa el segundo valor");
           double numero2 = Scanner.nextDouble();
           
            System.out.println("Ingresa el tercer valor");
           double numero3 = Scanner.nextDouble();
           
           double average = (numero1 + numero2+ numero3)/3;
           System.out.println("El promedio de los 3 valores es de: "+ average);
           
       }
    }
}


/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

public class Main
{
    public static void main(String[] args) {
        int DineroInicial =1000;
        int retiro=200;
        int semanas= 4;
        
        int Saldo = DineroInicial -(retiro*semanas);
        
        System.out.println("El saldo al final del mes es de: " + Saldo + " $");
    }
}

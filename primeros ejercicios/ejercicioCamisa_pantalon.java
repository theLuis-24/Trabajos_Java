
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

public class Main
{
    public static void main(String[] args) {
      double precioCamisa =25.0;
      double precioPantalon =30.0;
      
     double descuento = 0.15;
     double descuentoCamisa = precioCamisa* descuento;
     double descuentoPantalon = precioPantalon* descuento;
     
     double camisaConDescuento = precioCamisa-descuentoCamisa;
     
     double descuentoExtra=0.05;
     double descuentoExtraCamisa = camisaConDescuento * descuentoExtra;


      System.out.println("El descuento de ambas prendas con el descuento es del: "+ descuentoCamisa + "$ la camisa y de "+ descuentoPantalon +"$ el pantalon");
      System.out.println("Si se compra otra camisa, el descuento de la camisa sera de: "+ descuentoExtraCamisa);
      
    }
}

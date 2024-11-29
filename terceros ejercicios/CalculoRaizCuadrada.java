import java.util.Scanner;


class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String mensaje) {
        super(mensaje);
    }
}

public class CalculoRaizCuadrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 
        System.out.print("Ingrese un número para calcular su raíz cuadrada: ");
        double numero = scanner.nextDouble();

        try {
  
            double resultado = calcularRaizCuadrada(numero);
            System.out.println("La raíz cuadrada de " + numero + " es: " + resultado);
        } catch (NumeroNegativoException e) {
  
            System.out.println("Error: " + e.getMessage());
        } finally {

            scanner.close();
        }
    }


    public static double calcularRaizCuadrada(double numero) throws NumeroNegativoException {
        if (numero < 0) {
            throw new NumeroNegativoException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(numero);
    }
}
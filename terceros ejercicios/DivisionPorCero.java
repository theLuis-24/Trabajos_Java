import java.util.Scanner;

public class DivisionPorCero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 
        System.out.print("Ingrese el primer número: ");
        double numerador = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double denominador = scanner.nextDouble();

        try {
   
            double resultado = dividir(numerador, denominador);
            System.out.println("El resultado de la división es: " + resultado);
        } catch (ArithmeticException e) {

            System.out.println("Error: No se puede dividir por cero.");
        } finally {

            scanner.close();
        }
    }


    public static double dividir(double numerador, double denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("División por cero");
        }
        return numerador / denominador;
    }
}
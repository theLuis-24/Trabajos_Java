public class primitivos {
    public static void main(String[] args) {
        int numero = 10;
        System.out.println("Valor inicial de numero: " + numero);

        cambiarValor(numero);
        System.out.println("Valor final de numero: " + numero);
    }

    public static void cambiarValor(int numero) {
        numero = 20;
        System.out.println("Valor de numero dentro del método: " + numero);
    }
}
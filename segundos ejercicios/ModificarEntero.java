public class ModificarEntero {

    public static void main(String[] args) {

        int x = 5;


        System.out.println("Antes de incrementar: " + x);

        int nuevoValor = incrementar(x);


        System.out.println("Después de incrementar: " + x);
        System.out.println("Valor retornado: " + nuevoValor);
    }

    public static int incrementar(int x) {
        x += 1; 
        return x; 
    }
}
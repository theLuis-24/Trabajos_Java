import java.util.ArrayList;
import java.util.Scanner;

public class GestionLista {
    private ArrayList<String> lista;


    public GestionLista() {
        lista = new ArrayList<>();
    }


    public void agregarElemento(String elemento) {
        lista.add(elemento);
        System.out.println("Elemento agregado: " + elemento);
    }

 
    public String obtenerElemento(int indice) {
        return lista.get(indice); 
    }


    public void mostrarLista() {
        System.out.println("Elementos en la lista:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
    }

    public static void main(String[] args) {
        GestionLista gestionLista = new GestionLista();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("\nComandos:");
            System.out.println("1. Agregar elemento");
            System.out.println("2. Obtener elemento por índice");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Salir");
            System.out.print("Ingrese un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "1":
                    System.out.print("Ingrese el elemento a agregar: ");
                    String elemento = scanner.nextLine();
                    gestionLista.agregarElemento(elemento);
                    break;
                case "2":
                    System.out.print("Ingrese el índice del elemento a obtener: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine());
                        String elementoObtenido = gestionLista.obtenerElemento(indice);
                        System.out.println("Elemento en índice " + indice + ": " + elementoObtenido);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: Índice fuera de los límites de la lista.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un número válido.");
                    }
                    break;
                case "3":
                    gestionLista.mostrarLista();
                    break;
                case "4":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intente de nuevo.");
            }
        } while (!comando.equals("4"));

        scanner.close();
    }
}

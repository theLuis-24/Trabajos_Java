import java.io.*;
import java.util.Scanner;

public class NotasPersistencia {
    private static final String NOMBRE_ARCHIVO = "notas.txt";


    public static void guardarNota(String nota) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(nota);
            writer.newLine(); 
            System.out.println("Nota guardada: " + nota);
        } catch (IOException e) {
            System.out.println("Error al guardar la nota: " + e.getMessage());
        }
    }


    public static void mostrarNotas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            System.out.println("Notas guardadas:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer las notas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("\nComandos:");
            System.out.println("1. Agregar nota");
            System.out.println("2. Mostrar notas");
            System.out.println("3. Salir");
            System.out.print("Ingrese un comando: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "1":
                    System.out.print("Ingrese la nota: ");
                    String nota = scanner.nextLine();
                    guardarNota(nota);
                    break;
                case "2":
                    mostrarNotas();
                    break;
                case "3":
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intente de nuevo.");
            }
        } while (!comando.equals("3"));

        scanner.close();
    }
}
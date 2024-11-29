import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn;
    }
}

public class GestionLibros {
    private static final String ARCHIVO_LIBROS = "libros.txt";
    private List<Libro> libros;

    public GestionLibros() {
        libros = new ArrayList<>();
        cargarLibrosDesdeArchivo();
    }

    public void cargarLibrosDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_LIBROS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    libros.add(new Libro(datos[0], datos[1], datos[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los libros: " + e.getMessage());
        }
    }

    public void guardarLibro(Libro libro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LIBROS, true))) {
            bw.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getIsbn());
            bw.newLine();
            libros.add(libro);
            System.out.println("Libro añadido: " + libro);
        } catch (IOException e) {
            System.out.println("Error al guardar el libro: " + e.getMessage());
        }
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la lista.");
        } else {
            System.out.println("Lista de libros:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void buscarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                System.out.println("Libro encontrado: " + libro);
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " no encontrado.");
    }

    public static void main(String[] args) {
        GestionLibros gestionLibros = new GestionLibros();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Libros");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    gestionLibros.guardarLibro(new Libro(titulo, autor, isbn));
                    break;
                case 2:
                    gestionLibros.listarLibros();
                    break;
                case 3:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    gestionLibros.buscarLibro(isbnBuscar);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
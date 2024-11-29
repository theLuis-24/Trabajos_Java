class Rectangulo {

    int ancho;
    int alto;


    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
}

public class ModificarObjeto {

    public static void main(String[] args) {

        Rectangulo rectangulo = new Rectangulo(5, 10);


        System.out.println("Antes de modificar:");
        System.out.println("Ancho: " + rectangulo.ancho);
        System.out.println("Alto: " + rectangulo.alto);

        modificarRectangulo(rectangulo);


        System.out.println("Después de modificar:");
        System.out.println("Ancho: " + rectangulo.ancho);
        System.out.println("Alto: " + rectangulo.alto);
    }


    public static void modificarRectangulo(Rectangulo r) {
        r.ancho = 20; 
        r.alto = 30;  
    }
}
public class EjemploReasignacion {
    private String nombre;
    private int edad;

    public EjemploReasignacion(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static void main(String[] args) {
        EjemploReasignacion ejemplo = new EjemploReasignacion("Juan", 30);
        System.out.println("Nombre inicial: " + ejemplo.getNombre());
        System.out.println("Edad inicial: " + ejemplo.getEdad());

        reasignarReferencia(ejemplo);
        System.out.println("Nombre final: " + ejemplo.getNombre());
        System.out.println("Edad final: " + ejemplo.getEdad());
    }

    public static void reasignarReferencia(EjemploReasignacion ejemplo) {
        ejemplo = new EjemploReasignacion("Pedro", 40);
        System.out.println("Nombre dentro del método: " + ejemplo.getNombre());
        System.out.println("Edad dentro del método: " + ejemplo.getEdad());
    }
}

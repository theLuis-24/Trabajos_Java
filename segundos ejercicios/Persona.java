public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
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
        Persona persona = new Persona("Juan", 30);
        System.out.println("Nombre inicial: " + persona.getNombre());
        System.out.println("Edad inicial: " + persona.getEdad());

        cambiarEstado(persona);
        System.out.println("Nombre final: " + persona.getNombre());
        System.out.println("Edad final: " + persona.getEdad());
    }

    public static void cambiarEstado(Persona persona) {
        persona.setNombre("Pedro");
        persona.setEdad(40);
        System.out.println("Nombre dentro del método: " + persona.getNombre());
        System.out.println("Edad dentro del método: " + persona.getEdad());
    }
}

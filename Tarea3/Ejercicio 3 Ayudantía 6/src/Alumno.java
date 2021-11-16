public class Alumno extends Persona implements Acciones {
    
    private String rol;
    private int prioridad;

    public Alumno(String nombre, int edad, String rol, int prioridad){
        super(nombre, edad);
        this.rol = rol;
        this.prioridad = prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public int getPrioridad() {
        return prioridad;
    }

    public String getRol() {
        return rol;
    }
    
    @Override
    public void comer(){
        System.out.println("El alumno está comiendo");
    }

    @Override
    public void dormir(){
        System.out.println("El alumno está durmiendo");
    }
}

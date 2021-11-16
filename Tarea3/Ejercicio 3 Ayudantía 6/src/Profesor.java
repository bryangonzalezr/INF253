public class Profesor extends Persona implements Acciones {

    private String departamento;
    private String ramo;

    public Profesor(String nombre, int edad, String departamento, String ramo){
        super(nombre, edad);
        this.departamento = departamento;
        this.ramo = ramo;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public String getRamo() {
        return ramo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    @Override
    public void comer(){
        System.out.println("El profesor está comiendo");
    }

    @Override
    public void dormir(){
        System.out.println("El profesor está durmiendo");
    }
}

public class Main {
    public static void main(String[] args) {
        Profesor profesor = new Profesor("Pepe", 30, "Informática", "LP");
        Alumno alumno = new Alumno("Lucio",23, "201773610-0",1000000);

        profesor.dormir();
        alumno.dormir();
        
        System.out.println("El nombre del estudiante es " + alumno.getNombre() + " y su rol es " + alumno.getRol());
        System.out.println("El nombre del profesor es " + profesor.getNombre() + " y su ramo es " + profesor.getRamo());
    }
}

public abstract class NPC {

    //Atributos//
    private String nombre;

    //Metodos//

    //Metodo abstracto que refiere a que todos los hijos de NPC deben//
    //tener una interaccion con el jugador//
    public abstract void interaccion(Jugador player);

    //Getter//
    public String getNombre() {
        return nombre;
    }
    //Setter//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}

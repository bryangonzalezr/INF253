public abstract class Tierra {
    //Atributos//
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;

    //Metodos//

    //Metodo abstracto que indica que todos los tipos de tierra//
    //deben tener una accion con respecto al jugador, que en este caso//
    //representa si el jugador es capaz de llegar a la tierra o no//
    public abstract boolean accion(Jugador player);

    //Setters//
    public void setJefe_final(Jefe_Final jefe_final) {
        this.jefe_final = jefe_final;
    }
    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }
    public void setNpc(NPC npc) {
        this.npc = npc;
    }
    public void setProbabilidad_enemigo(float probabilidad_enemigo) {
        this.probabilidad_enemigo = probabilidad_enemigo;
    }
    
    //Getters//
    public Jefe_Final getJefe_final() {
        return jefe_final;
    }
    public Monstruo getMonstruo() {
        return monstruo;
    }
    public NPC getNpc() {
        return npc;
    }
    public float getProbabilidad_enemigo() {
        return probabilidad_enemigo;
    }
    


}

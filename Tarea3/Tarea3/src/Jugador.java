import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jugador {

    //Atributos//
    private String nombre;
    private int vida;
    private int xp;
    private int fuerza;
    private int inteligencia;
    private int energia;
    private int mana;
    private int energiamax;
    private int vidamax;
    private int manamax;
    private ArrayList<Mision> lista_misiones = new ArrayList<Mision>();
    private int lvlactual;
    private Scanner input;
    
    //Metodos

    //Metodo abstracto para calcular el dano fisico de cada clase//
    public abstract int ataque();
    //Metodo abstracto para calcular el dano magico de cada clase//
    public abstract int hechizo();
    //Metodo abstracto para calcular la modificacion de atributos al subir de nivel//
    public abstract void subir_experiencia(int xpcant);
    
    //Metodo creado por mi para todas las clases//
    //Stats//

    //No recibe parametros//

    //No retorna nada, imprime las estadisticas actuales del jugador, independiente de//
    //su clase, con una interfaz que recuerda a juegos estilo Final Fantasy//
    public void stats() {
        
        System.out.println("\n-----------------------------------------");
        System.out.println(String.format("Estadisticas de %s\n", this.getNombre()));
        System.out.println(String.format("Vida:%d/%d\n",this.getVida(),this.getVidamax(),this.getMana(),this.getManamax()));
        System.out.println(String.format("Energia:%d/%d     Mana:%d/%d",this.getEnergia(),this.getEnergiamax(),this.getMana(),this.getManamax()));
        System.out.println(String.format("Fuerza:%d       Inteligencia:%d",this.getFuerza(),this.getInteligencia()));
        System.out.println(String.format("Xp actual:%d    Lvl Actual:%d ", this.getXp(),this.getLvlactual()));
        System.out.println("-----------------------------------------\n");
        



    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setManamax(int manamax) {
        this.manamax = manamax;
    }
    public void setVidamax(int vidamax) {
        this.vidamax = vidamax;
    }
    public void setLvlactual(int lvlactual) {
        this.lvlactual = lvlactual;
    }
    public void setEnergiamax(int energiamax) {
        this.energiamax = energiamax;
    }
    public void setListamisiones(ArrayList<Mision> listamisiones) {
        this.lista_misiones = listamisiones;
    }
    public void setInput(Scanner input) {
        this.input = input;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    public int getXp() {
        return xp;
    }
    public int getFuerza() {
        return fuerza;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public int getEnergia() {
        return energia;
    }
    public int getMana() {
        return mana;
    }
    public int getManamax() {
        return manamax;
    }
    public int getVidamax() {
        return vidamax;
    }
    public int getLvlactual() {
        return lvlactual;
    }
    public int getEnergiamax() {
        return energiamax;
    }
    public ArrayList<Mision> getListamisiones() {
        return lista_misiones;
    }
    public Scanner getInput() {
        return input;
    }

}

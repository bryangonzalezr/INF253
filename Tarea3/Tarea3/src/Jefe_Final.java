import java.util.Scanner;

public class Jefe_Final implements Enemigo{
    
    //Atributos//
    private String nombre;
    private int vida;
    private int dano_base;

    //Constructor//

    //Jefe_Final//

    //Parametros que recibe://
    //String nombre//
    //int vida//
    //int dano//

    //Crea un enemigo Jefe_Final con los datos entregados como parametros//
    public Jefe_Final(String nombre, int vida, int dano){
        this.nombre= nombre;
        this.vida= vida;
        this.dano_base=dano;

    }

    //Metodos//

    //Combate//

    //Parametros que recibe://
    //Jugador j//

    //Retorna://
    //No retorna nada, pero realiza un combate entre el jugador y el Jefe_Final//
    //Es un combate por turnos donde el jugador comienza siempre, puede seleccionar//
    //que tipo de dano hacer (hechizo o tacleada), o ver sus estadisticas//
    //El combate acaba cuando uno de los dos queda sin vida//
    //Al ser un jefe final, este posee fases, donde cambia el dano que hace dependiendo//
    //de la vida que tenga//
    @Override
    public void combate(Jugador player) {
        System.out.println("\n---------------------------------------");
        System.out.println(String.format("\nHA COMENZADO LA BATALLA FINAL CON %s\n", this.getNombre()));
        System.out.println("-----------------------------------------\n");

        Scanner input= player.getInput();
        while (true) {
            //Ataque del jugador//
            int opcion;
            while (true) {
                System.out.println("Su turno de ataque");
                System.out.println("");
                System.out.println("    1. Tacleada (ataque fisico)");
                System.out.println("    2. Hechizo");
                System.out.println("    3. Ver mis estadisticas");
                System.out.println("");
                if(this.vida<=(this.vida/2)){
                    System.out.println(String.format("Vida actual de %s: %d     Fase actual del jefe: %d",this.nombre, this.vida,1));
                    
                }else if(this.vida>this.vida/2){
                    System.out.println(String.format("Vida actual de %s: %d     Fase actual del jefe: %d",this.nombre, this.vida,2));
    
                }
                    
                System.out.print("Por favor escriba 1 o 2 segun la opcion que decida: ");
                opcion=  Integer.parseInt(input.nextLine());
                if (opcion==3){
                    player.stats();
                }else if (opcion==1 || opcion==2){
                    break;
                }else{
                    System.out.println("Opcion invalida");
                }
            }
            switch (opcion) {
                case 1:
                    int damage= player.ataque();
                    System.out.println("");
                    System.out.println(String.format("%s recibio %d de dano!" ,this.nombre, damage));
                    this.vida= this.vida - damage;
                    if (this.vida<0){
                        this.vida=0;
                    }
                    break;
            
                case 2:
                    int magicdmg= player.hechizo();
                    System.out.println(String.format("%s recibio %d de dano!" ,this.nombre, magicdmg));

                    this.vida= this.vida - magicdmg;
                    if (this.vida<0){
                        this.vida=0;
                    }
                    break;
                default:
                    break;
            }
            
            if(this.vida==0){
                break;
            }

            
            //Ataque del Jefe//
            System.out.println("\n-----------------------------------------");
            System.out.println(String.format("%s comienza su ataque...",this.nombre));
            if(this.vida<=(this.vida/2)){
                System.out.println("Dano calculado en Fase2");
                System.out.println(String.format("Recibes %d de dano!!",this.dano_base + 2));
            System.out.println("-----------------------------------------\n");
                player.setVida(player.getVida()- (this.dano_base+ 2));
            }else if(this.vida>this.vida/2){
                System.out.println("Dano calculado en Fase1");
                System.out.println(String.format("Recibes %d de dano!!",this.dano_base + 4));
            System.out.println("-----------------------------------------\n");
                player.setVida(player.getVida()- (this.dano_base+ 4));

            }
            if(player.getVida()<=0){
                player.setVida(0);
                break;
            }
        }
    }

    //Setters//
    public void setDano_base(int dano_base) {
        this.dano_base = dano_base;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    //Getters//
    public int getDano_base() {
        return dano_base;
    }
    public String getNombre() {
        return nombre;
    }   
    public int getVida() {
        return vida;
    }
}

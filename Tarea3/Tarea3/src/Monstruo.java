import java.util.Scanner;


public class Monstruo implements Enemigo{
    
    //Atributos//
    private int vida;
    private int dano;

    //Constructor//

    //Monstruo/

    //Parametros que recibe://
    //int vida//
    //int dano//

    //Crea una mision, que tiene de requisito matar o llegar a un lugar,//
    //esto almacenado en el char (puede ser 'v' o 'm' dependiendo del caso)//
    //con un valor al cual se debera llegar, y un recompensa de xp en caso//
    //de que se cumpla la mision//
    public Monstruo(int vida, int dano){
        this.vida = vida;
        this.dano = dano;
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
    
    @Override
    public void combate(Jugador player) {
        Scanner input= player.getInput();
        while (true) {
            //Ataque del jugador//
            int opcion;
            System.out.println("\n-----------------------------------------");
            while (true) {
                System.out.println("Su turno de ataque");
                System.out.println("");
                System.out.println("    1. Tacleada (ataque fisico)");
                System.out.println("    2. Hechizo");
                System.out.println("    3. Ver mis estadisticas");
                System.out.println("");
                System.out.println(String.format("Vida actual del enemigo: %d     Daño del enemigo: %d\n", this.vida,this.dano));
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
                    System.out.println(String.format("El enemigo recibio %d de dano!" , damage));
                    this.vida= this.vida - damage;
                    if (this.vida<0){
                        this.vida=0;
                    }
                    break;
            
                case 2:
                    int magicdmg= player.hechizo();
                    System.out.println(String.format("El enemigo recibio %d de dano!" , magicdmg));

                    this.vida= this.vida - magicdmg;
                    if (this.vida<0){
                        this.vida=0;
                    }
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------------------------\n");
            if(this.vida==0){
                for (Mision mision : player.getListamisiones()) {
                    if(mision.getRequisito()=='m'){
                        mision.setCantidad(mision.getCantidad()+1);
                    }
                }
                break;
            }
            

            //Ataque del monstruo//
            System.out.println("\n-----------------------------------------");
            System.out.println("El enemigo comienza su ataque...");
            System.out.println(String.format("Recibes %d de dano!!",player.getVida()-this.dano));
            System.out.println("-----------------------------------------\n");
            player.setVida(player.getVida()-this.dano);
            
            if(player.getVida()<=0){
                player.setVida(0);
                break;
            }
        }
    }

    //Setters//
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
    //Getters//
    public int getDano() {
        return dano;
    }
    public int getVida() {
        return vida;
    }
}

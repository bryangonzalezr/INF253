public class Malo extends NPC{

    //Atributos//
    private int cantidad_energia;
    private int cantidad_mana;

    //Construccion//

    //Malo//

    //Parametros que recibe://
    //String nombre//
    //int cantidad_energia//
    //int cantidad_mana//

    //Crea una NPC tipo Malo con los datos entregados como parametros//
    public Malo(String nombre, int cantidad_energia, int cantidad_mana){
        this.setNombre(nombre);
        this.cantidad_energia= cantidad_energia;
        this.cantidad_mana = cantidad_mana;

    }

    //Metodos//

    //Interaccion//

    //Parametros que recibe://
    //Jugador j//

    //Retorna://
    //No retorna nada, pero aleatoreamente(en funcion a lo pedido en la tarea) //
    //quita al jugador energia y mana, en la cantidad especificada en su creacion//
    
    @Override
    public void interaccion(Jugador player) {
        System.out.println("\n---------------------------------------");
        String message = String.format("%s: SOY MALO, VOY A DISMINUIRTE LA ENERGIA Y MANA EN %d Y %d",this.getNombre(),this.cantidad_energia,this.cantidad_mana);
        System.out.println(message);
        System.out.println("-----------------------------------------\n");

        int randenergy= (int)Math.floor(Math.random()*10+1);
        int randmana= (int)Math.floor(Math.random()*10+1);

        if (randenergy<=6) {
            System.out.println("\n---------------------------------------");
            System.out.println(String.format("\nEnergia reducida en %d",this.cantidad_energia));
            System.out.println("-----------------------------------------\n");

            if ((player.getEnergia()-this.cantidad_energia)<0){
                player.setEnergia(0);
            }else{
                player.setEnergia(player.getEnergia()-this.cantidad_energia);
            }
        }
        if (randmana<=6) {
            System.out.println("\n---------------------------------------");
            System.out.println(String.format("\nMana reducido en %d",this.cantidad_mana));
            System.out.println("-----------------------------------------\n");


            if ((player.getMana()-this.cantidad_mana<0)){
                player.setMana(0);
            }else{
                player.setMana(player.getMana()-this.cantidad_energia);
            }
        }
    }
    
    //Setters//
    public void setCantidad_energia(int cantidad_energia) {
        this.cantidad_energia = cantidad_energia;
    }
    public void setCantidad_mana(int cantidad_mana) {
        this.cantidad_mana = cantidad_mana;
    }
    //Getters//
    public int getCantidad_energia() {
        return cantidad_energia;
    }
    public int getCantidad_mana() {
        return cantidad_mana;
    }
}

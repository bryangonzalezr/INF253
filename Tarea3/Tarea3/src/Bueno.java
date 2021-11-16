
public class Bueno extends NPC{
    //Atributos//
    private String atributo;
    private int cantidad;

    //Construccion//

    
    //Bueno//

    //Parametros que recibe://
    //String nombre//
    //String atributo//
    //int cantidad//

    //Crea una NPC tipo Bueno con los datos entregados como parametros//
    public Bueno(String nombre, String atributo, int cantidad){
        setNombre(nombre);
        this.cantidad=cantidad;
        this.atributo=atributo;
    }
    //Metodos//


    //Interaccion//

    //Parametros que recibe://
    //Jugador j//

    //Retorna://
    //No retorna nada, pero binda al jugador la estadistica que fue especificada//
    //en su creacion, en la cantidad especificada tambien en su creacion//
    @Override
    public void interaccion(Jugador player) {
        System.out.println("\n---------------------------------------");

        String message = String.format("%s: Creo que necesitas un poco de ayuda, te subire %d a tu %s", getNombre(),getCantidad(),getAtributo());
        System.out.println(message);
        System.out.println("---------------------------------------\n");

        switch (getAtributo()) {
            case "vida":
                player.setVida(player.getVida()+this.cantidad);
                if (player.getVida()>player.getVidamax()){
                    player.setVida(player.getVidamax());
                }
                break;
            case "xp":
                player.subir_experiencia(player.getXp()+this.cantidad);
                
                break;
            case "energia":
                player.setEnergia(player.getEnergia()+this.cantidad);
                if (player.getEnergia()>player.getEnergiamax()){
                    player.setEnergia(player.getEnergiamax());
                }
                break;
            case "mana":
                player.setMana(player.getMana()+this.cantidad);
                if (player.getMana()>player.getManamax()){
                    player.setMana(player.getManamax());
                }
                break;
        
        }
        
    }

    //Getters de cada atributo//
    public String getAtributo() {
        return atributo;
    }
    public int getCantidad() {
        return cantidad;
    }

    //Setters//
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

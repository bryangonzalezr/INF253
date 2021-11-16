public class Mision {

    //Stributos//
    private char requisito;
    private int valor;
    private int cantidad;
    private int recompensa;

    //Constructor//

    //Mision/

    //Parametros que recibe://
    //char requisito//
    //int valor//
    //int recompensa//

    //Crea una mision, que tiene de requisito matar o llegar a un lugar,//
    //esto almacenado en el char (puede ser 'v' o 'm' dependiendo del caso)//
    //con un valor al cual se debera llegar, y un recompensa de xp en caso//
    //de que se cumpla la mision//
    public Mision(char requisito, int valor, int recompensa){
        this.requisito= requisito;
        this.valor = valor;
        this.recompensa= recompensa;
        this.cantidad= 0;
        
    }
    //Metodos//
    //Mago/

    //Parametros que recibe://
    //char requisito//
    //int valor//
    //int recompensa//

    //Crea una mision, que tiene de requisito matar o llegar a un lugar,//
    //esto almacenado en el char (puede ser 'v' o 'm' dependiendo del caso)//
    //con un valor al cual se debera llegar, y un recompensa de xp en caso//
    //de que se cumpla la mision//
    public boolean verificar_requisito(){
        if (this.valor==this.cantidad) {
            return true;
        } else {
            return false;
        }
    }
   

    //Getters
    public int getCantidad() {
        return cantidad;
    }
    public int getRecompensa() {
        return recompensa;
    }
    public char getRequisito() {
        return requisito;
    }
    public int getValor() {
        return valor;
    }

    //Setters
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
    public void setRequisito(char requisito) {
        this.requisito = requisito;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }


}

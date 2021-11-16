
import java.util.ArrayList;
import java.util.Scanner;

public class Neutro extends NPC{
    
    //Atributos//
    private char requisito;
    private int valor;
    private int recompensa;
    private int ya_dio_mision;

    //Constructor// 


    //Malo//

    //Parametros que recibe://
    //String nombre//
    //char requisito//
    //int valor//
    //int recompensa//

    //Crea una NPC tipo Neutro con los datos entregados como parametros//
    //Adicionalmente, ya_dio_mision se establece en 0 (falso) porque recien//
    //esta creado//
    public Neutro(String nombre, char requisito, int valor, int recompensa){
        this.setNombre(nombre);
        this.recompensa = recompensa;
        this.requisito = requisito;
        this.valor =valor;
        this.ya_dio_mision = 0;
    }

    //Metodos//

    //Interaccion//

    //Parametros que recibe://
    //Jugador j//

    //Retorna://
    //No retorna nada, pero primero evalua si ya dio mision, dependiendo del //
    //valor de este atributo (si ya_dio_mision es 1 o 0)//
    //Luego, en caso de que no haya dado mision, crea una mision con los mismos//
    //atributos que han sido brindados en el momento de la creacion del objeto de//
    //esta clase//
    //La mision creada es agregada a la lista de misiones del jugador//
    @Override
    public void interaccion(Jugador player) {
        if(this.ya_dio_mision==1){
            System.out.println("\n---------------------------------------");
            System.out.println(String.format("%s: ya te di mision, saludos", this.getNombre()));
            System.out.println("-----------------------------------------\n");

        }else{
            String keyword="";
            String keyword2="";
            switch (requisito) {
                case 'v':
                    keyword= "llegar a";
                    keyword2= "del mundo";
                    break;
            
                case 'm':
                    keyword = "matar";
                    keyword2= "Monstruos";
                    break;
                
            }
            Scanner input= player.getInput();
            System.out.println("\n---------------------------------------");

            System.out.println(String.format("%s: Hola, ¿Quieres cumplir esta mision? Deberas %s %d %s, y recibiras %d de xp.", this.getNombre(),keyword,this.valor,keyword2,this.recompensa));
            System.out.println("");
            System.out.println("    1. Aceptar");
            System.out.println("    2. Rechazar");
            System.out.println("");
            System.out.println("-----------------------------------------\n");

            System.out.print("Por favor escriba 1 o 2 segun la opcion que decida: ");
            int opcion = Integer.parseInt(input.nextLine());
            
            
            switch (opcion) {
                case 1:
                    Mision mneutro = new Mision(this.requisito, this.valor, this.recompensa);
                    mneutro.setCantidad(0);
                    ArrayList<Mision> nuevalista = player.getListamisiones();
                    nuevalista.add(mneutro);
                    player.setListamisiones(nuevalista);
                    System.out.println("Aceptado");
                    break;
            
                case 2:
                    System.out.println("Rechazado");
                    break;
            }

            this.ya_dio_mision=1;
        }
    }
    
    //Setters//
    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
    public void setRequisito(char requisito) {
        this.requisito = requisito;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setYa_dio_mision(int ya_dio_mision) {
        this.ya_dio_mision = ya_dio_mision;
    }
    //Getters//
    public int getRecompensa() {
        return recompensa;
    }
    public char getRequisito() {
        return requisito;
    }
    public int getValor() {
        return valor;
    }
    public int getYa_dio_mision(){
        return ya_dio_mision;
    }
}

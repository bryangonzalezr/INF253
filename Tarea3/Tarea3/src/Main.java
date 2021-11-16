import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        System.out.println("        The Legend Of Morio");
        System.out.println("        Autor: Bryan González");
        System.out.println("");
        System.out.println("Bienvenido a TLOM, para comenzar el Dungeon Mater debe crear el mundo");
        System.out.print("Ingrese el tamaño del mundo: ");
        Scanner input = new Scanner(System.in);

        //Tamano del mundo//
        int n = Integer.parseInt(input.nextLine());

        //Creacion del mundo//
        ArrayList<Tierra> mundo= new ArrayList<Tierra>();
        
        int opcion;
        for (int i = 0; i < n; i++) {
            //Se pregunta por el tipo de tierra//
            System.out.println(String.format("Ingrese el tipo de tierra de la posicion %d: ", i+1));
            System.out.println("");
            System.out.println("    1. Planicie");
            System.out.println("    2. Bosque");
            System.out.println("    3. Montana");
            System.out.println("");
            //La opcion de tierra//
            System.out.print("Su opcion: ");
            opcion = Integer.parseInt(input.nextLine());
            //Se pregunta por el tipo de enemigo//
            System.out.println("Ingrese el tipo de enemigo que puede aparecer");
            System.out.println("");
            System.out.println("    1. Monstruo");
            System.out.println("    2. Jefe Final");
            System.out.println("");
            //La opcion de enemigo//
            System.out.print("Su opcion: ");
            int tipoenemigo = Integer.parseInt(input.nextLine());

            //Declaramos los enemigos del terreno//
            Monstruo enemy;
            Jefe_Final finalboss;

            //Declaramos sus atributos//
            String nombreJefe;
            int vidaenemy, danoenemy;
            float enemyprob;
            //Creamos el posible enemigo//
            switch (tipoenemigo) {
                case 1:
                    //Pedimos los atributos//
                    System.out.print("Ingrese vida del enemigo en esta casilla: ");
                    vidaenemy = Integer.parseInt(input.nextLine());
                    System.out.print("Ingrese el dano del enemigo en esta casilla: ");
                    danoenemy =Integer.parseInt(input.nextLine());
                    //Creamos el monstruo y dejamos el boss en null//
                    enemy= new Monstruo(vidaenemy, danoenemy);
                    finalboss = null;
                    break;
                case 2:
                    //Pedimos los atributos//
                    System.out.print("Ingrese el nombre del Jefe Final: ");
                    nombreJefe = input.nextLine();
                    System.out.print("Ingrese vida del Jefe Final en esta casilla: ");
                    vidaenemy = Integer.parseInt(input.nextLine());
                    System.out.print("Ingrese el dano del Jefe Final en esta casilla: ");
                    danoenemy =Integer.parseInt(input.nextLine());
                    //Creamos el boss y dejamos el monstruo en null;
                    finalboss = new Jefe_Final(nombreJefe, vidaenemy, danoenemy);
                    enemy = null;
                    break;
                default:
                    enemy =null;
                    finalboss=null;
                
            }
            System.out.print("Ingrese la probabilidad de aparicion del enemigo (numero entre 0 y 1): ");
            enemyprob= Float.parseFloat(input.nextLine());
            //Se pregunta por el tipo de NPC//
            System.out.println("¿Desea un NPC en esta casilla?");
            System.out.println("");
            System.out.println("    1. Si");
            System.out.println("    2. No");
            System.out.println("");
            //La opcion de enemigo//
            System.out.print("Su opcion: ");
            int npcSino = Integer.parseInt(input.nextLine());
            NPC npccasilla;
            switch (npcSino) {
                case 1:
                    //Se pregunta por el tipo de enemigo//
                    System.out.println("Escoja el tipo de NPC que desea");
                    System.out.println("");
                    System.out.println("    1. Bueno");
                    System.out.println("    2. Malo");
                    System.out.println("    3. Neutro");
                    System.out.println("");
                    //La opcion de enemigo//
                    System.out.print("Su opcion: ");
                    int tipoNPC = Integer.parseInt(input.nextLine());
                    switch (tipoNPC) {
                        case 1:
                            //Atributos del NPC//
                            System.out.println("Ingrese los atributos del NPC Bueno");
                            System.out.println("");
                            System.out.print("Nombre del NPC: ");
                            String nombrebueno= input.nextLine();
                            System.out.print("Seleccione el atributo que da entre las siguientes opciones: ");
                            System.out.println("");
                            System.out.println("    1. Vida");
                            System.out.println("    2. Xp");
                            System.out.println("    3. Mana");
                            System.out.println("    4. Energia");
                            System.out.println("");
                            System.out.print("Su opcion: ");
                            int atrnpc= Integer.parseInt(input.nextLine());
                            String atribnpc;
                            switch (atrnpc) {
                                case 1:
                                    atribnpc = "vida";
                                    break;
                                case 2:
                                    atribnpc = "xp";
                                    break;
                                case 3:
                                    atribnpc = "mana";
                                    break;
                                case 4:
                                    atribnpc = "energia";
                                    break;
                                default:
                                    atribnpc= "";
                                    break;
                            }
                            System.out.print(String.format("Ingrese cantidad de %s que va a dar: ", atribnpc));
                            int cantNpc= Integer.parseInt(input.nextLine());
                            //Creamos el NPC//
                            npccasilla= new Bueno(nombrebueno, atribnpc, cantNpc);
                            
                            break;
                    
                        case 2:
                             //Atributos del NPC//
                             System.out.println("Ingrese los atributos del NPC Malo");
                             System.out.println("");
                             System.out.print("Nombre del NPC: ");
                             String nombremalo= input.nextLine();
                             System.out.print("Cantidad de energia que drena: ");
                             int enermenos = Integer.parseInt(input.nextLine());
                             System.out.print("Cantidad de mana que drena: ");
                             int manamenos = Integer.parseInt(input.nextLine());
                             //Creamos el NPC//
                             npccasilla= new Malo(nombremalo, enermenos, manamenos);
                            break;
                        case 3:
                            //Atributos del NPC//
                            System.out.println("Ingrese los atributos del NPC Neutro");
                            System.out.println("");
                            System.out.print("Nombre del NPC: ");
                            String nombreneutro= input.nextLine();
                            System.out.println("Seleccione el requisito de la mision entre las siguientes opciones: ");
                            System.out.println("");
                            System.out.println("    1. Llegar a un lugar");
                            System.out.println("    2. Matar enemigos");
                            System.out.println("");
                            System.out.print("Su opcion: ");
                            int requestvalue= Integer.parseInt(input.nextLine());
                            char request;
                            switch (requestvalue) {
                                case 1:
                                    System.out.println(String.format("Hint: Recuerde que las posiciones del mundo van desde 1 a %d",n));
                                    request = 'v';
                                    break;
                                case 2:
                                    request = 'm';
                                    break;
                                default:
                                    request= 'e';
                                    break;
                            }
                            System.out.print("Ingrese el valor que debe cumplir en la mision: ");
                            int value= Integer.parseInt(input.nextLine());
                            System.out.print("Ingrese la recompensa de xp por la mision: ");
                            int recomp = Integer.parseInt(input.nextLine());

                            npccasilla = new Neutro(nombreneutro,request,value,recomp);
                            break;
                        default:
                            npccasilla= null;
                            break;
                    }
                    break;
            
                case 2:
                    npccasilla=null;
                    break;
                default:
                    npccasilla=null;
                    break;
            }

           //Finalmente se crea la tierra con todo lo pedido anteriormente//
            switch (opcion) {
                case 1:
                    System.out.println("Creando Planicie");
                    mundo.add(new Planicie(enemyprob, enemy, finalboss, npccasilla));
                    break;
                case 2:
                    System.out.println("Creando Bosque");
                    mundo.add(new Bosque(enemyprob, enemy, finalboss, npccasilla));
                    break;
                case 3:
                    System.out.println("Creando Montana");
                    mundo.add(new Montana(enemyprob, enemy, finalboss, npccasilla));
                    break;
                
            }

        }
        
       
        //Ahora que ya creamos el mundo, hacemos el juego en si//
        System.out.println("");
        System.out.println("Mundo creado, seleccione la clase de su personaje entre las siguientes opciones: ");
        System.out.println("");
        System.out.println("    1. Mago");
        System.out.println("    2. Guerrero");
        System.out.println("    3. Druida");
        System.out.println("");
        int opcionplayer = Integer.parseInt(input.nextLine());
        //Pedimos el nombre//
        System.out.print("Nombre del jugador: ");
        String nombreplayer = input.nextLine();
        Jugador player;
        switch (opcionplayer) {
            case 1:
                player= new Mago(nombreplayer, input);
                break;
            case 2:
                player= new Guerrero(nombreplayer, input);

                break;
            case 3:
                player= new Druida(nombreplayer, input);

                break;
            default:
                player= null;
                break;
        }
        //Vemos la posicion inicial//
        System.out.println("");
        System.out.println("El mundo es el siguiente:");
        int count =0;
        for (Tierra lugar : mundo) {
            String clase= lugar.getClass().getSimpleName();
            System.out.println(String.format("%d: %s", count+1, clase));
            count+=1;
        }
        System.out.print("Ingrese en que posicion del mundo donde desea comenzar: ");
        int posicion = (Integer.parseInt(input.nextLine()))-1;
        //Comenzamos el juego//
        boolean flag= true;
        while (flag) {
            System.out.println(String.format("\nUsted se encuentra en la posicion %d de %d. ¿Que desea hacer?\n",posicion+1,n));
            System.out.println("    1. Moverse hacia la derecha");
            System.out.println("    2. Moverse hacia la izquierda");
            System.out.println("    3. Ver mis estadisticas");
            System.out.println("    4. Ver lista de misiones");
            System.out.println("    5. Ver mundo\n");
            System.out.print("Su opcion: ");
            opcion = Integer.parseInt(input.nextLine());
            Iterator<Mision> it;
            switch (opcion) {
                case 1:
                    //parte del mundo ciclico//
                    if (posicion+1>(n-1)){
                        posicion=0;
                    }else{
                        posicion=posicion+1;
                    }
                    //se ejecuta accion, si retorna falso, se verifica por que razon no llego//
                    if(!mundo.get(posicion).accion(player)){
                        //si esta muerto termina el juego//
                        if(player.getVida()==0){
                            System.out.println("\nJuego terminado, has perdido.");
                            flag=false;
                            break;
                        //Si no esta muerto, es por falta de energia/mana//
                        }else{
                            posicion=posicion-1;
                            System.out.println("\n---------------------------------------");

                            System.out.println("No se pudo llegar a la casilla seleccionada.");
                            System.out.println("-----------------------------------------\n");

                        }
                        
                    }   
                    //finalmente se chequea si hubo combate con el jefe final, si existe en la tierra y su vida es 0,//
                    //significa que se termina el juego y ganas/
                    if(mundo.get(posicion).getJefe_final()!=null &&mundo.get(posicion).getJefe_final().getVida()==0){
                        System.out.println("\nJuego terminado, has vencido al jefe final.\nFelicitaciones, has gando!!!\n");
                        flag=false;
                        break;
                    }
                    //Se chequea si al cambiar de posicion se cumple una mision de llegar a un lugar//
                    it = player.getListamisiones().iterator();
                    while(it.hasNext()){
                        Mision mision= it.next();
                        switch (mision.getRequisito()) {
                            case 'v':
                                mision.setCantidad(posicion+1);
                                break;
                        
                            default:
                                break;
                        }
                        if (mision.verificar_requisito()) {
                            player.subir_experiencia(mision.getRecompensa());
                            System.out.println("");
                            System.out.println(String.format("Has completado la mision!! Recibes %d de xp.", mision.getRecompensa()));
                            System.out.println("");
                            it.remove();
                        }
                        
                    }
                    
                    break;
                case 2:
                    //parte del mundo ciclico//
                    if(posicion-1<0){
                        posicion=(n-1);
                    }else{
                        posicion=posicion-1;
                    }
                    //se ejecuta accion, si retorna falso, se verifica por que razon no llego//
                    if(!mundo.get(posicion).accion(player)){
                        //si esta muerto termina el juego//
                        if(player.getVida()==0){

                            System.out.println("Juego terminado, has perdido.");

                            flag=false;
                            break;
                        //Si no esta muerto, es por falta de energia/mana//
                        }else{
                            posicion=posicion+1;
                            System.out.println("\n-----------------------------------------");

                            System.out.println("No se pudo llegar a la casilla seleccionada.");
                            System.out.println("-----------------------------------------\n");

                        }
                        
                    }
                    //finalmente se chequea si hubo combate con el jefe final, si existe en la tierra y su vida es 0,//
                    //significa que se termina el juego y ganas/
                    if(mundo.get(posicion).getJefe_final()!=null &&mundo.get(posicion).getJefe_final().getVida()==0){
                        System.out.println("Juego terminado, has vencido al jefe final, felicitaciones!!!");
                        flag=false;
                        break;
                    }
                    //Se chequea si al cambiar de posicion se cumple una mision de llegar a un lugar//
                    it = player.getListamisiones().iterator();
                    while(it.hasNext()){
                        Mision mision= it.next();
                        switch (mision.getRequisito()) {
                            case 'v':
                                mision.setCantidad(posicion+1);
                                break;
                        
                            default:
                                break;
                        }
                        if (mision.verificar_requisito()) {
                            player.subir_experiencia(mision.getRecompensa());
                            System.out.println("");
                            System.out.println(String.format("Has completado la mision!! Recibes %d de xp.", mision.getRecompensa()));
                            System.out.println("");
                            it.remove();
                        }
                        
                    }
                    
                    break;
                case 3:
                    //Se ejecuta el metodo stats//
                    player.stats();
                    break;
                case 4:
                    //Se recorre la lista de misiones en caso de que no este vacia//
                    if (!player.getListamisiones().isEmpty()){
                        count=1;
                        System.out.println("\n---------------------------------------");

                        for (Mision mision : player.getListamisiones()) {
                            switch (mision.getRequisito()) {
                                case 'm':
                                    System.out.println(String.format("Mision %d: Matar %d enemigos, llevas %d ", count, mision.getValor(),mision.getCantidad()));
                                    break;
                                case 'v':
                                    System.out.println(String.format("Mision %d: Llegar a %d , estas en %d ", count, mision.getValor(),mision.getCantidad()));

                                    break;
                                default:
                                    break;
                                
                            }
                        
                            count+=1;
                        }
                        System.out.println("---------------------------------------\n");
                    //Si esta vacia, imprime que esta vacia//
                    }else{
                        System.out.println("\n---------------------------------------");
                        System.out.println("No tienes misiones activas");
                        System.out.println("---------------------------------------\n");

                    }
                    break;
                    
                case 5:
                    //Se recorre el mundo, y se imprime que tipo de tierra es//
                    count =0;
                    for (Tierra lugar : mundo) {
                        String clase= lugar.getClass().getSimpleName();
                        if (count!=posicion){
                            System.out.println(String.format("%d: %s", count+1, clase));

                        }else{
                            System.out.println(String.format("%d: %s <--- Aca estas tu", count+1, clase));

                        }

                        count+=1;
                    }
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        }
        input.close();


    }
}
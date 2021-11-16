
public class Planicie extends Tierra{
    
    //Constructor//


    //Planicie//

    //Parametros que recibe://
    //float probabilidad//
    //Monstruo monster//
    //Jefe_Final finalboss//
    //NPC npc//

    //Crea una tierra tipo Planicie con los datos entregados como parametros//
    public Planicie(float probabidad, Monstruo monster, Jefe_Final finalboss,NPC npc){
        setJefe_final(finalboss);
        setMonstruo(monster);
        setNpc(npc);
        setProbabilidad_enemigo(probabidad);
        
    }

    //Metodos//


    //Accion//

    //Parametros que recibe://
    //Jugador j//

    //Retorna://
    //Retorna un booleano que indica que si el jugador quedo vivo o no, tras 
    //interactuar con el NPC y combatir (de salir segun la probabilidad)//
    @Override
    public boolean accion(Jugador player) {

        if(this.getNpc()!=null){
            this.getNpc().interaccion(player);
        }
        if (player.getVida()==0){
            return false;
        }
        if (this.getMonstruo()!=null){
            int probability= (int)Math.floor(Math.random()*1000+1);

            if(probability<=(this.getProbabilidad_enemigo()*1000)){
                Monstruo battle = new Monstruo(this.getMonstruo().getVida(),this.getMonstruo().getDano());
                battle.combate(player);
                if (player.getVida()==0){
                    return false;
                }
            }

        }else if (this.getJefe_final()!=null){
            int probability= (int)Math.floor(Math.random()*1000+1);

            if(probability<=(this.getProbabilidad_enemigo()*1000)){
                
                this.getJefe_final().combate(player);
                if (player.getVida()==0){
                    return false;
                }
            }
            if(player.getVida()==0){
                return false;
            }
        }
        if(player.getVida()==0){
            return false;
        }
        

        return true;
    }
    

}

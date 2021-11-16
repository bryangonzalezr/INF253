public class Montana extends Tierra{
    //Constructor//


    //Montana//

    //Parametros que recibe://
    //float probabilidad//
    //Monstruo monster//
    //Jefe_Final finalboss//
    //NPC npc//

    //Crea una tierra tipo Bosque con los datos entregados como parametros//
    public Montana(float probabidad, Monstruo monster, Jefe_Final finalboss,NPC npc){
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
    //Un booleano (true or false) que indica si pudo pasar por el "filtro" de esta//
    //tierra, en este caso Montana, ademas del enemigo y el NPC, debe tener 3 de energia (o mas de//
    //0, pero el sobrante tiene que ser en vida)//
    @Override
    public boolean accion(Jugador player) {
        if(player.getEnergia() == 0){
            return false;
        }else if (player.getEnergia()<3){
            player.setVida(player.getVida()-(3-player.getEnergia()));
            player.setEnergia(0);
            if(player.getVida()<0){
                player.setVida(0);
            }
        }else{
            player.setEnergia(player.getEnergia()-3);
        }
        if(player.getVida()==0){
            return false;
        }

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

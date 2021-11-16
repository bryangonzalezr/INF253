public class Bosque extends Tierra{
    //Constructor//


    //Bosque//

    //Parametros que recibe://
    //float probabilidad//
    //Monstruo m//
    //Jefe_Final fb//
    //NPC npc//

    //Crea una tierra tipo Bosque con los datos entregados como parametros//
    public Bosque(float probabidad, Monstruo monster, Jefe_Final finalboss,NPC npc){
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
    //tierra, en este caso Bosque, ademas del enemigo y el NPC, debe tener 3 de mana (o mas de//
    //0, pero el sobrante tiene que ser en vida)//
    @Override
    public boolean accion(Jugador player) {
        System.out.println(player.getMana());
        System.out.println(player.getVida());
        if(player.getMana() == 0){
            return false;
        }else if (player.getMana()<3){
            player.setVida(player.getVida()-(3-player.getMana()));
            player.setMana(0);
            if(player.getVida()<0){
                player.setVida(0);
            }
        }else{
            player.setMana(player.getMana()-3);
        }
        if(player.getVida()==0){
            return false;
        }

        System.out.println(player.getMana());
        System.out.println(player.getVida());

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

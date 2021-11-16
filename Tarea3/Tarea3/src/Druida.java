import java.util.Scanner;

public class Druida extends Jugador{
    //Construccion//


    //Druida//

    //Parametros que recibe://
    //String nombre//
    //Scanner input//

    //Crea un Jugador tipo Druida, con las estadisticas iniciales propias del//
    //Druida. Ademas, recibe un Scanner, esto para poder hacer los inputs luego//
    //y cerrar satisfactoriamente el System.in //
    public Druida(String nombre, Scanner input){
        this.setNombre(nombre);
        //se setea la vida//
        this.setVida(15);
        this.setVidamax(15);
        //se setea la fuerza//
        this.setFuerza(5);
        //se setea la inteligencia//
        this.setInteligencia(5);
        //se setea la energia//
        this.setEnergia(5);
        this.setEnergiamax(5);
        //se setea el mana//
        this.setMana(5);
        this.setManamax(5);
        //se setea la xp y el lvl//
        this.setXp(0);
        this.setLvlactual(1);
        //Agregamos el scanner para cuando pidamos cosas por pantalla//
        this.setInput(input);
    }

    //Metodos// 

    
    //Ataque//

    //No recibe parametros//

    //Retorna un entero, el cual corresponde al valor que toma el dano fisico//
    //en funcion a la clase, en este caso se calcula con la formula de ataque
    //del Druida. En caso de que no tenga energia, su valor es siempre 0//
    @Override
    public int ataque(){
        //Operacion para obtener el valor del daño//
        int damage;
        if (this.getEnergia()==0){
            damage=0;
        }else{
            if ((getEnergia()/3)>(getMana()/2)) {
                damage= ((getFuerza()+getInteligencia())/3)*((getEnergia()/3));
            }else{
                damage= ((getFuerza()+getInteligencia())/3)*((getMana()/2));
            }
        }

        //Se modifica la energia dependiendo del caso//
        if(getEnergia()>=3){
            this.setEnergia(this.getEnergia()-3);
        }else{
            this.setEnergia(0);
        }
        return damage;
    }
    
    //Hechizo//

    //No recibe parametros//

    //Retorna un entero, el cual corresponde al valor que toma el dano por hechizo//
    //en funcion a la clase, en este caso se calcula con la formula de hechizo
    //del Druida. En caso de que no tenga mana, su valor siempre es 0//
    @Override
    public int hechizo(){
        //Operacion para obtener el valor del daño magico//
        int magicdmg;
        if (this.getMana()==0){
            magicdmg=0;
        }else{
            if ((getEnergia()/2)>(getMana()/3)) {
                magicdmg= ((getFuerza()+getInteligencia())/3)*((getEnergia()/2));
            }else{
                magicdmg= ((getFuerza()+getInteligencia())/3)*((getMana()/3));
            }
        }
        //Se modifica la energia dependiendo del caso//
        if(getMana()>=3){
            this.setMana(this.getMana()-3);
        }else{
            this.setMana(0);
        }
        //Se retorna el daño//
        return magicdmg;
    }

    //subir_experiencia//

    //Parametros que recibe://
    //int xpcant//

    //No retorna nada, pero modifica las estadisticas en funcion de la cantidad de//
    //experiencia que es entregada como parametro. Utiliza el atributo lvl_actual para//
    //saber cuanta experiencia se necesita para subir de nivel, y por cada nivel subido//
    //aumentan los atributos del Druida, ademas de elevar al maximo actual todos los atributos//
    @Override
    public void subir_experiencia(int xpcant){
        //aumentamos la experiencia//
        setXp(getXp()+xpcant);
        int lvldif;
        if (getXp()<10) {
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=1) {
                lvldif =1-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()<25) {
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=2) {
                lvldif =2-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()<50){
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=3) {
                lvldif =3-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()<100){
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=4) {
                lvldif =4-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()<200){
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=5) {
                lvldif =5-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()<350){
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=6) {
                lvldif =6-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()<600){
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=7) {
                lvldif =7-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }else if(getXp()>=600){
            //se establece hacen modificaciones en funcion del cambio en la experiencia y el nivel actual//
            if (getLvlactual()!=8) {
                lvldif =8-getLvlactual();
                for (int i = 0; i < lvldif; i++) {
                    //cambiamos el nivel//
                    setLvlactual(getLvlactual()+1);
                    //aumento de vidamaxima y seteamos la energia en este valor//
                    this.setVidamax(getVidamax()+getLvlactual());
                    this.setVida(getVidamax());
                    //aumento de fuerza//
                    this.setFuerza(getFuerza()+getLvlactual());
                    //aumento de inteligencia
                    this.setInteligencia(getInteligencia()+getLvlactual());
                    //aumento de energia maxima y seteamos la energia en este valor//
                    this.setEnergiamax(getEnergiamax()+getLvlactual());
                    this.setEnergia(getEnergiamax());
                    //aumento en el mana maximo y seteamos el mana en este valor//
                    this.setMana(getManamax()+getLvlactual());
                    this.setManamax(getManamax());
                }
            }
        }
    }
    
}

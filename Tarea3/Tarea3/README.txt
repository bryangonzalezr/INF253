Nombre: Bryan Felipe González Ramírez
Rol: 202073052-0

Instrucciones del archivo:

Gran parte de lo que se pide en la tarea esta bastante especificado en 
el mismo programa, vale decir, que es muy claro todo lo que se debe poner en consola
para el correcto funcionamiento.

Pasos para correcta creacion por parte del DM:
-Ingresar el tamaño del mundo (un numero a partir de 1, con 0 da error)
-Luego comenzará a pedir datos por cada casilla del mundo (estan enumeradas desde el 1 hasta el tamaño)
Lo que pide es:
    -Tipo de mundo
    -Tipo de enemigo (Monstruo o Jefe_Final):
        -Los atributos del enemigo (vida, daño y en el caso del jefe, su nombre)
        -Su probabilidad de aparicion (Para evitar problemas, acepta numeros desde el 0 hasta el 1, escritos con . , ejemplo: 0.546 )
    -Pregunta si desea un NPC, se debe ingresar 1 para si, 2 para no (especificado en el programa)
    En caso de si:
        -Tipo de Npc:
            -Los atributos del NPC en funcion del tipo especificado
A partir de eso, se genera cada casilla a lo largo del mundo, pidiendo lo dicho anteriormente con cada casilla

Creacion del jugador:
    -Una vez creado el mundo, se pide la clase del personaje, son 3 opciones, por consola se debe ingresar el numero que representa
    la clase escrita en consola.
    -Luego se escribe el nombre del jugador.
    -Finalmente se escribe un entero en consola que indica la posicion (se indica una hint, la cual dice entre que numeros es valida la posicion,
    todo numero fuera de ese intervalo va a tirar error al moverse por el mundo). Ademas, se indica el mundo al seleccionar posicion

A partir de aca comienza el juego, donde se puede avanzar hacia la izquierda o derecha, donde se realizaran las interacciones pedidas en la tarea.


Cosas extra que añadí yo (espero que me den puntos por creatividad en los del menu UnU igual me esforce):

    -Jugador: Atributos de maximo para vida, mana, energia; y un atributo lvlactual. Son nombres autoexplicativos, asi que no profundizare en que los use.

            Ademas, se agrego un atributo Scanner, esto debido a que tiraba un warning por no cerrar el Scanner si hacia mas instancias, asi que use una seleccionar
            instanciacion la cual se puede acceder en todas las interacciones a través de su getter (para hacer los inputs).

            Tambien se agrego un nuevo metodo, llamado stats, que imprime todos los stats en ese momento del jugador.

    -Monstruo y Jefe_Final: Se pedia en la tarea que diera la opcion de usar ataque (en mi caso lo llamé tacleada para mas creatividad :D) y hechizo,
    pero además de eso, agregué la opcion de ver los stats del jugador, para poder administrar mejor la energía y mana.

    -En el menu: 
        -Cuando se pregunta que desea hacer, se indica en que posicion se encuentra, y el maximo de casillas del mundo.

        -Agregada opcion para ver el mundo (se señala las posiciones del mundo, con el tipo de tierra que hay en ese lugar,
        para que el jugador pueda analizar si es factible ir a ese lugar con sus estadisticas actuales). Tambien indica
        muy visiblemente cual es la casilla en la que se encuentra en ese momento.

        -Agregada opcion para mostrar la lista de misiones (en caso de que no haya ninguna mision, se imprime que no hay misiones en ese momento)
        Esta ultima opcion indica si la mision consta de llegar a un lugar, o de matar alguna cantidad de enemigos:
            -En el caso de llegar a una casilla, se indica a cual debe llegar, y en cual se encuentra en este momento
            -En el caso de matar enemigos, se indica cuantos debe ejecutar y cuantos lleva en ese momento.
        
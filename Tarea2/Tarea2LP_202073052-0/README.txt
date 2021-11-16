Nombre: Bryan Felipe González Ramírez
Rol: 202073052-0

Instrucciones del archivo:

Al ejecutarse el programa, el menu presenta 5 opciones. Debe ingresar por consola el numero de la opcion que desea ejecutar
Si ejecuta cualquier otra cosa que no sea un numero habrán errores, puesto que recibe solo numeros. Si recibe un numero que no esté
entre 1 y 5, el menú no hará nada.

La opcion crear animal pide la fila y columna en que quiere ser creada, las filas representan el movimiento de arriba abajo, y las columnas
de izquierda a derecha. Pide el tipo de dato ('c','e','f'), luego pide el valor; asi con todas las estadísticas. Luego de pedir las estadísticas,
pide que funcion reproduccion se usa, en mi caso incluí los 2 de la tarea (reproduccionSimple y Cruzada). Posteriormente pide la funcion comerHuir,
y aqui es donde tuve problemas. Puse solamente ComerSiempre y ComerAleatorio como opciones, puesto que la funcion HuirSiempre no la pude implementar
de manera satisfactoria en la iteracion, asi que implemente una seccion en el menu aparte para probar esta funcion. (para que no me bajen tanto :c,
ya que si funciona en realidad, solo que no pude implementarla).

La iteracion funciona con la opcion 2, y es tal cual se pide, simultanea. No considere el caso en el que 3 o 4 animales queden en la misma casilla, asi
que si se da esta situacion es posible que haya algun error, sin embargo esta situacion no esta explicitada en el pdf de la tarea, asi que no espero
un descuento por esto.

Al salir se elimina toda la memoria pedida, por lo que no hay ningun leak de memoria

Finalmente un resumen de lo que modifiqué de la tarea para que quede bien claro:

        -Agregue un struct Tupla, este struct contiene un int* y un Animal*. Este struct fue creado
        especificamente para realizar la iteracion.

        -Agregue una funcion "CopiarAnimal", la cual esta especificada en el comentario dentro del codigo.
        En palabras simples copia la memoria de un animal y la pone en otro, sin que esten referenciados
        uno del otro. Esta funcion la use para la iteracion, puesto que tuve que hacer mas de una vez este
        proceso y desordenaba mucho el codigo (ya que no fue algo corto de hacer).

        -Agregue una opcion nueva en el menu, probar HuirSiempre, ya que no pude implementarlo en la iteracion
        (por favor no me bajen tanto :c, funciona pero me daba muchos errores en la iteracion).


Eso es todo, quizas puede que cuando se ejecute la iteracion de tiempo tarde al ejecutar el programa con valgrind, pero no son mas de 10 seg.
Si se ejecuta sin valgrind es instantaneo.

Gracias por su atencion, disculpen el mucho texto.

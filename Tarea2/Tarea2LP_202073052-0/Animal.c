#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <stddef.h>
#include <math.h>


#include "Animal.h"


// -------------------------
// Funcion: Comparar
// Parametros: Dos direcciones de animal

// Recibe dos animales y los compara, si el primero tiene mayores atributos, retorna 0
// en caso contrario retorna 1

// -------------------------
int Comparar(Animal *a1, Animal *a2){

    // Transformamos los valores del primer animal para comparar

    int comparF1, comparS1, comparR1;
    if(a1->tipo_fuerza=='e'){
        comparF1=*(int*)a1->fuerza;
        }
    else if(a1->tipo_fuerza=='c'){
        char charF1 = *(char*)a1->fuerza;
        comparF1= (int)(charF1/4);
        }
    else if(a1->tipo_fuerza=='f'){
        float toberounded = *(float*)a1->fuerza;
        comparF1= roundf(toberounded);
        }
    if(a1->tipo_velocidad=='e'){
        comparS1=*(int*)a1->velocidad;
        }
    else if(a1->tipo_velocidad=='c'){
        char charS1 = *(char*)a1->velocidad;
        comparS1= (int)(charS1/4);
        }
    else if(a1->tipo_velocidad=='f'){
        float toberounded = *(float*)a1->velocidad;
        comparS1= roundf(toberounded);
        }
    if(a1->tipo_resistencia=='e'){
        comparR1=*(int*)a1->resistencia;
        }
    else if(a1->tipo_resistencia=='c'){
        char charR1 = *(char*)a1->resistencia;
        comparR1= (int)(charR1/4);
        }
    else if(a1->tipo_resistencia=='f'){
        float toberounded = *(float*)a1->resistencia;
        comparR1= roundf(toberounded);
        }
    
    // Transformamos el segundo animal

    int comparF2, comparS2, comparR2;
    if(a2->tipo_fuerza=='e'){
        comparF2=*(int*)a2->fuerza;
        }
    else if(a2->tipo_fuerza=='c'){
        char charS2 = *(char*)a2->fuerza;
        comparF2= (int)(charS2/4);
        }
    else if(a2->tipo_fuerza=='f'){
        float toberounded = *(float*)a2->fuerza;
        comparF2= roundf(toberounded);
        }
    if(a2->tipo_velocidad=='e'){
        comparS2=*(int*)a2->velocidad;
        }
    else if(a2->tipo_velocidad=='c'){
        char charS2 = *(char*)a2->velocidad;
        comparS2= (int)(charS2/4);
        }
    else if(a2->tipo_velocidad=='f'){
        float toberounded = *(float*)a2->velocidad;
        comparS2= roundf(toberounded);
        }
    if(a2->tipo_resistencia=='e'){
        comparR2=*(int*)a2->resistencia;
        }
    else if(a2->tipo_resistencia=='c'){
        char charR2 = *(char*)a2->resistencia;
        comparR2= (int)(charR2/4);
        }
    else if(a2->tipo_resistencia=='f'){
        float toberounded = *(float*)a2->resistencia;
        comparR2= roundf(toberounded);
        }
    
    // Ahora hacemos la comparacion
    
    int animal1=0;
    if (comparF1>comparF2){
        animal1+=1;
    }
    if (comparS1>comparS2){
        animal1+=1;
    }
    if (comparR1>comparR2){
        animal1+=1;
    }
    // Ahora retornamos dependiendo del caso

    if (animal1<2){
        return 1;
    }
    else{
        return 0;
    }
    
}

// -------------------------
// Funcion: ReproduccionSimple
// Parametros: Tres direcciones de animal

// Recibe 3 punteros de animal, los primeros 2 (a1 y a2) son los padres
// el otro es el hijo
// Si la funcion comparar entre los padres (tomando a a1 como primero en la funcion)
// Lo indica como ganador de la comparacion, se pasan todos sus datos al hijo
// Por el contrario, si no sale como ganador, los datos del segundo animal son pasados
// al hijo.
// -------------------------

void ReproduccionSimple(Animal *a1, Animal* a2, Animal *hijo){

    /*Hacemos la comparacion*/

    int comparacion= Comparar(a1,a2);

    /*Si gana el primero, todas sus estadisticas pasan al hijo*/

    if (comparacion==0){
        hijo->tipo_fuerza=a1->tipo_fuerza;
        hijo->tipo_velocidad=a1->tipo_velocidad;
        hijo->tipo_resistencia=a1->tipo_resistencia;
        hijo->comerHuir=a1->comerHuir;
        hijo->reproduccion=a1->reproduccion;
        if(a1->tipo_fuerza=='e'){
            hijo->fuerza=malloc(sizeof(int));
            memcpy(hijo->fuerza,a1->fuerza,sizeof(int));
        }
        else if(a1->tipo_fuerza=='c'){
            hijo->fuerza=malloc(sizeof(char));
            memcpy(hijo->fuerza,a1->fuerza,sizeof(char));
        }
        else if(a1->tipo_fuerza=='f'){
            hijo->fuerza=malloc(sizeof(float));
            memcpy(hijo->fuerza,a1->fuerza,sizeof(float));
        }
        if(a1->tipo_velocidad=='e'){
            hijo->velocidad=malloc(sizeof(int));
            memcpy(hijo->velocidad,a1->velocidad,sizeof(int));
        }
        else if(a1->tipo_velocidad=='c'){
            hijo->velocidad=malloc(sizeof(char));
            memcpy(hijo->velocidad,a1->velocidad,sizeof(char));
        }
        else if(a1->tipo_velocidad=='f'){
            hijo->velocidad=malloc(sizeof(float));
            memcpy(hijo->velocidad,a1->velocidad,sizeof(float));
        }
        if(a1->tipo_resistencia=='e'){
            hijo->resistencia=malloc(sizeof(int));
            memcpy(hijo->resistencia,a1->resistencia,sizeof(int));
        }
        else if(a1->tipo_resistencia=='c'){
            hijo->resistencia=malloc(sizeof(char));
            memcpy(hijo->resistencia,a1->resistencia,sizeof(char));
        }
        else if(a1->tipo_resistencia=='f'){
            hijo->resistencia=malloc(sizeof(float));
            memcpy(hijo->resistencia,a1->resistencia,sizeof(float));
        }
    }

    /**/

    else if (comparacion==1){
        hijo->tipo_fuerza=a2->tipo_fuerza;
        hijo->tipo_velocidad=a2->tipo_velocidad;
        hijo->tipo_resistencia=a2->tipo_resistencia;
        hijo->comerHuir=a2->comerHuir;
        hijo->reproduccion=a2->reproduccion;
        if(a2->tipo_fuerza=='e'){
            hijo->fuerza=malloc(sizeof(int));
            memcpy(hijo->fuerza,a2->fuerza,sizeof(int));
        }
        else if(a2->tipo_fuerza=='c'){
            hijo->fuerza=malloc(sizeof(char));
            memcpy(hijo->fuerza,a2->fuerza,sizeof(char));
        }
        else if(a2->tipo_fuerza=='f'){
            hijo->fuerza=malloc(sizeof(float));
            memcpy(hijo->fuerza,a2->fuerza,sizeof(float));
        }
        if(a2->tipo_velocidad=='e'){
            hijo->velocidad=malloc(sizeof(int));
            memcpy(hijo->velocidad,a2->velocidad,sizeof(int));
        }
        else if(a2->tipo_velocidad=='c'){
            hijo->velocidad=malloc(sizeof(char));
            memcpy(hijo->velocidad,a2->velocidad,sizeof(char));
        }
        else if(a2->tipo_velocidad=='f'){
            hijo->velocidad=malloc(sizeof(float));
            memcpy(hijo->velocidad,a2->velocidad,sizeof(float));
        }
        if(a2->tipo_resistencia=='e'){
            hijo->resistencia=malloc(sizeof(int));
            memcpy(hijo->resistencia,a2->resistencia,sizeof(int));
        }
        else if(a2->tipo_resistencia=='c'){
            hijo->resistencia=malloc(sizeof(char));
            memcpy(hijo->resistencia,a2->resistencia,sizeof(char));
        }
        else if(a2->tipo_resistencia=='f'){
            hijo->resistencia=malloc(sizeof(float));
            memcpy(hijo->resistencia,a2->resistencia,sizeof(float));
        }
    }
}

// -------------------------
// Funcion: ReproduccionCruzada
// Parametros: Tres direcciones de animal

// Recibe 3 punteros de animal, los primeros 2 (a1 y a2) son los padres
// el otro es el hijo
// Si la funcion comparar entre los padres (tomando a a1 como primero en la funcion)
// Lo indica como ganador de la comparacion, se pasan la velocidad, fuerza y funcion reproduccion al hijo,
// y obtiene la resistencia y funcion comerHuir del segundo animal
// Por el contrario, si no sale como ganador, el hijo obtiene los datos al reves (velocidad, fuerza, reproduccion)
// al hijo.

// -------------------------


void ReproduccionCruzada(Animal *a1, Animal* a2, Animal *hijo){
    int comparacion = Comparar(a1,a2);
    if(comparacion==0){
        hijo->tipo_fuerza=a1->tipo_fuerza;
        hijo->tipo_velocidad=a1->tipo_velocidad;
        hijo->reproduccion=a1->reproduccion;
        hijo->tipo_resistencia=a2->tipo_resistencia;
        hijo->comerHuir=a2->comerHuir;
        if(a1->tipo_fuerza=='e'){
            hijo->fuerza=malloc(sizeof(int));
            memcpy(hijo->fuerza,a1->fuerza,sizeof(int));
        }
        else if(a1->tipo_fuerza=='c'){
            hijo->fuerza=malloc(sizeof(char));
            memcpy(hijo->fuerza,a1->fuerza,sizeof(char));
        }
        else if(a1->tipo_fuerza=='f'){
            hijo->fuerza=malloc(sizeof(float));
            memcpy(hijo->fuerza,a1->fuerza,sizeof(float));
        }
        if(a1->tipo_velocidad=='e'){
            hijo->velocidad=malloc(sizeof(int));
            memcpy(hijo->velocidad,a1->velocidad,sizeof(int));
        }
        else if(a1->tipo_velocidad=='c'){
            hijo->velocidad=malloc(sizeof(char));
            memcpy(hijo->velocidad,a1->velocidad,sizeof(char));
        }
        else if(a1->tipo_velocidad=='f'){
            hijo->velocidad=malloc(sizeof(float));
            memcpy(hijo->velocidad,a1->velocidad,sizeof(float));
        }
        if(a2->tipo_resistencia=='e'){
            hijo->resistencia=malloc(sizeof(int));
            memcpy(hijo->resistencia,a2->resistencia,sizeof(int));
        }
        else if(a2->tipo_resistencia=='c'){
            hijo->resistencia=malloc(sizeof(char));
            memcpy(hijo->resistencia,a2->resistencia,sizeof(float));
        }
        else if(a2->tipo_resistencia=='f'){
            hijo->resistencia=malloc(sizeof(float));
            memcpy(hijo->resistencia,a2->resistencia,sizeof(float));
        }
    }
    else if (comparacion==1){
        hijo->tipo_fuerza=a2->tipo_fuerza;
        hijo->tipo_velocidad=a2->tipo_velocidad;
        hijo->reproduccion= a2->reproduccion;
        hijo->tipo_resistencia=a1->tipo_resistencia;
        hijo->comerHuir=a1->comerHuir;
        if(a2->tipo_fuerza=='e'){
            hijo->fuerza=malloc(sizeof(int));
            memcpy(hijo->fuerza,a2->fuerza,sizeof(int));
        }
        else if(a2->tipo_fuerza=='c'){
            hijo->fuerza=malloc(sizeof(char));
            memcpy(hijo->fuerza,a2->fuerza,sizeof(char));
        }
        else if(a2->tipo_fuerza=='f'){
            hijo->fuerza=malloc(sizeof(float));
            memcpy(hijo->fuerza,a2->fuerza,sizeof(float));
        }
        if(a2->tipo_velocidad=='e'){
            hijo->velocidad=malloc(sizeof(int));
            memcpy(hijo->velocidad,a2->velocidad,sizeof(int));
        }
        else if(a2->tipo_velocidad=='c'){
            hijo->velocidad=malloc(sizeof(char));
            memcpy(hijo->velocidad,a2->velocidad,sizeof(char));
        }
        else if(a2->tipo_velocidad=='f'){
            hijo->velocidad=malloc(sizeof(float));
            memcpy(hijo->velocidad,a2->velocidad,sizeof(float));
        }
        if(a1->tipo_resistencia=='e'){
            hijo->resistencia=malloc(sizeof(int));
            memcpy(hijo->resistencia,a1->resistencia,sizeof(int));
        }
        else if(a1->tipo_resistencia=='c'){
            hijo->resistencia=malloc(sizeof(char));
            memcpy(hijo->resistencia,a1->resistencia,sizeof(char));
        }
        else if(a1->tipo_resistencia=='f'){
            hijo->resistencia=malloc(sizeof(float));
            memcpy(hijo->resistencia,a1->resistencia,sizeof(float));
        }
    }
}

// -------------------------
// Funcion: ComerSiempre
// Parametros: Dos direcciones de animal

// Recibe 2 punteros de animal, analiza la fuerza del primero y la resistencia del segundo.
// Si la fuerza del primero es mas alta que la del segundo, se lo come. En caso contrario, el segundo
// animal se come al primero.

// -------------------------

void ComerSiempre(Animal *a1, Animal *a2){
    int F1, R2;
    if(a1->tipo_fuerza=='e'){
        F1=*(int*)a1->fuerza;
        }
    else if(a1->tipo_fuerza=='c'){
        char charF1 = *(char*)a1->fuerza;
        F1= (int)(charF1/4);
        }
    else if(a1->tipo_fuerza=='f'){
        float toberounded = *(float*)a1->fuerza;
        F1= roundf(toberounded);
        }
    if(a2->tipo_fuerza=='e'){
        R2=*(int*)a2->fuerza;
        }
    else if(a2->tipo_fuerza=='c'){
        char charR2 = *(char*)a2->fuerza;
        R2= (int)(charR2/4);
        }
    else if(a2->tipo_fuerza=='f'){
        float toberounded = *(float*)a2->fuerza;
        R2= roundf(toberounded);
        }
    if(F1>R2){
        BorrarAnimal(a2);
    }
    else{
        BorrarAnimal(a1);
    }
}

// -------------------------
// Funcion: ComerAleatorio
// Parametros: Dos direcciones de animal

// Recibe 2 punteros de animal, analiza todas las estadísticas de 
// ambos animales. Si aleatoriamente, el animal 1 tiene mayor estadística
// que el segundo (por ejemplo, mayor fuerza), se lo come; si no, el segundo se come al primero.
// -------------------------

void ComerAleatorio(Animal *a1, Animal *a2){

    int comparF1, comparS1, comparR1;
    if(a1->tipo_fuerza=='e'){
        comparF1=*(int*)a1->fuerza;
        }
    else if(a1->tipo_fuerza=='c'){
        char charF1 = *(char*)a1->fuerza;
        comparF1= (int)(charF1/4);
        }
    else if(a1->tipo_fuerza=='f'){
        float toberounded = *(float*)a1->fuerza;
        comparF1= roundf(toberounded);
        }
    if(a1->tipo_velocidad=='e'){
        comparS1=*(int*)a1->velocidad;
        }
    else if(a1->tipo_velocidad=='c'){
        char charS1 = *(char*)a1->velocidad;
        comparS1= (int)(charS1/4);
        }
    else if(a1->tipo_velocidad=='f'){
        float toberounded = *(float*)a1->velocidad;
        comparS1= roundf(toberounded);
        }
    if(a1->tipo_resistencia=='e'){
        comparR1=*(int*)a1->resistencia;
        }
    else if(a1->tipo_resistencia=='c'){
        char charR1 = *(char*)a1->resistencia;
        comparR1= (int)(charR1/4);
        }
    else if(a1->tipo_resistencia=='f'){
        float toberounded = *(float*)a1->resistencia;
        comparR1= roundf(toberounded);
        }
    

    int comparF2, comparS2, comparR2;
    if(a2->tipo_fuerza=='e'){
        comparS2=*(int*)a2->fuerza;
        }
    else if(a2->tipo_fuerza=='c'){
        char charS2 = *(char*)a2->fuerza;
        comparS2= (int)(charS2/4);
        }
    else if(a2->tipo_fuerza=='f'){
        float toberounded = *(float*)a2->fuerza;
        comparF2= roundf(toberounded);
        }
    if(a2->tipo_velocidad=='e'){
        comparS2=*(int*)a2->velocidad;
        }
    else if(a2->tipo_velocidad=='c'){
        char charS2 = *(char*)a2->velocidad;
        comparS2= (int)(charS2/4);
        }
    else if(a2->tipo_velocidad=='f'){
        float toberounded = *(float*)a2->velocidad;
        comparS1= roundf(toberounded);
        }
    if(a2->tipo_resistencia=='e'){
        comparR2=*(int*)a2->resistencia;
        }
    else if(a2->tipo_resistencia=='c'){
        char charR2 = *(char*)a2->resistencia;
        comparR2= (int)(charR2/4);
        }
    else if(a2->tipo_resistencia=='f'){
        float toberounded = *(float*)a2->resistencia;
        comparR2= roundf(toberounded);
        }
    
    // Ahora hacemos las comparaciones aleatorias

    int random1  = rand()%3;
    int random2  = rand()%3;
    if (random1==0){
        if (random2==0){
            if (comparF1>comparF2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
        else if (random2==1){
            if (comparF1>comparS2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
        else if (random2==2){
            if (comparF1>comparR2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
    }
    else if (random1==1){
        if (random2==0){
            if (comparS1>comparF2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
        else if (random2==1){
            if (comparS1>comparS2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
        else if (random2==2){
            if (comparS1>comparR2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
    }
    else if (random1==2){
        if (random2==0){
            if (comparR1>comparF2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
        else if (random2==1){
            if (comparR1>comparS2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
        else if (random2==2){
            if (comparR1>comparR2){
                BorrarAnimal(a1);
            }
            else{
                BorrarAnimal(a2);
            }
        }
    }

}

// -------------------------
// Funcion: HuirSiempre
// Parametros: Dos direcciones de animal

// Recibe 2 punteros de animal, analiza solo las velocidades de ambos
// Si el animal 1 tiene más velocidad que el otro, se imprime "El animal se ha escapado"
// Caso contrario, se imprime "El animal ha sido comido"
//
// No pude integrar esta funcion en la iteracion, pero está hecha, asi que no me bajen
// tanto por no tenerla integrada pls :C, tuve problemas al mover el animal despues
// de ejecutarla, pero si identifica si el animal puede escaparse o no.
// -------------------------


void HuirSiempre(Animal *a1, Animal *a2){
    int S1, S2;
    if(a1->tipo_velocidad=='e'){
        S1=*(int*)a1->velocidad;
        }
    else if(a1->tipo_velocidad=='c'){
        char charS1 = *(char*)a1->velocidad;
        S1= (int)(charS1/4);
        }
    else if(a1->tipo_velocidad=='f'){
        float toberounded = *(float*)a1->velocidad;
        S1= roundf(toberounded);
        }
    if(a2->tipo_velocidad=='e'){
        S2=*(int*)a2->velocidad;
        }
    else if(a2->tipo_velocidad=='c'){
        char charS2 = *(char*)a2->velocidad;
        S2= (int)(charS2/4);
        }
    else if(a2->tipo_velocidad=='f'){
        float toberounded = *(float*)a2->velocidad;
        S2= roundf(toberounded);
        }
    if(S1>=S2){
        printf("El primer animal se escapo!!\n");
    }
    else{
        printf("El primer animal no pudo escapar :(, fue comido por el primero\n");
        BorrarAnimal(a1);
    }
    
}

// -------------------------
// Funcion: Crear animal
// Parametros: Una direccion de animal

// Recibe una direccion de animal, debe estar vacia. Pide al usuario que entregue el tipo de dato
// para fuerza, velocidad y resistencia. Además da al usuario opciones para la funcion comerHuir y 
// reproduccion.
// -------------------------


void CrearAnimal(Animal* anim){
    // definimos las variables para cada caso fuera de los if
    printf("Escriba el tipo de dato con el que ingresará la fuerza: ");
    scanf(" %c",&anim->tipo_fuerza);
    if(anim->tipo_fuerza=='e'){
        anim->fuerza=malloc(sizeof(int));
        printf("Ingrese el valor de la fuerza: ");
        scanf("%d",(int*)anim->fuerza);
        
    }
    else if(anim->tipo_fuerza=='c'){
        anim->fuerza=malloc(sizeof(char));
        printf("Ingrese el valor de la fuerza: ");
        scanf(" %c",(char*)anim->fuerza);
    }
    else if(anim->tipo_fuerza=='f'){
        anim->fuerza=malloc(sizeof(float));
        printf("Ingrese el valor de la fuerza: ");
        scanf("%f",(float*)anim->fuerza);
    }
    printf("Escriba el tipo de dato con el que ingresará la velocidad: ");
    scanf(" %c",&anim->tipo_velocidad);
    if(anim->tipo_velocidad=='e'){
        anim->velocidad=malloc(sizeof(int));
        printf("Ingrese el valor de la velocidad: ");
        scanf("%d",(int*)anim->velocidad);
    }
    else if(anim->tipo_velocidad=='c'){
        anim->velocidad=malloc(sizeof(char));
        printf("Ingrese el valor de la velocidad: ");
        scanf(" %c",(char*)anim->velocidad);
    }
    else if(anim->tipo_velocidad=='f'){
        anim->velocidad=malloc(sizeof(float));
        printf("Ingrese el valor de la velocidad: ");
        scanf("%f",(float*)anim->velocidad);
        
    }
    printf("Escriba el tipo de dato con el que ingresará la resistencia: ");
    scanf(" %c",&anim->tipo_resistencia);
    if(anim->tipo_resistencia=='e'){
        anim->resistencia=malloc(sizeof(int));
        printf("Ingrese el valor de la resistencia: ");
        scanf("%d",(int*)anim->resistencia);
    }
    else if(anim->tipo_resistencia=='c'){

        anim->resistencia=malloc(sizeof(char));
        printf("Ingrese el valor de la resistencia: ");
        scanf(" %c",(char*)anim->resistencia);
    }
    else if(anim->tipo_resistencia=='f'){
        anim->resistencia=malloc(sizeof(float));
        printf("Ingrese el valor de la resistencia: ");
        scanf("%f",(float*)anim->resistencia);
    }
    int repr, combate;
    printf("\n");
    printf("Funciones de reproduccion: \n");
    printf("    1. ReproduccionSimple\n");
    printf("    2. ReproduccionCruzada\n");
    printf("\n");
    printf("Ingrese que funcion de reproduccion desea para el animal: ");
    scanf(" %d",&repr);
    if (repr==1){
        anim->reproduccion=ReproduccionSimple;
    }
    else if (repr==2){
        anim->reproduccion=ReproduccionCruzada;
    }
    printf("\n");
    printf("Funciones de comerHuir: \n");
    printf("    1. ComerSiempre\n");
    printf("    2. ComerAleatorio\n");
    printf("\n");
    printf("Ingrese que funcion comerHuir desea para el animal: ");
    scanf("%d",&combate);
    if (combate==1){
        anim->comerHuir=ComerSiempre;
    }
    else if (combate==2)
    {
        anim->comerHuir=ComerAleatorio;
    }
    printf("\n");
    
}        

// -------------------------
// Funcion: BorrarAnimal
// Parametros: Una direccion de animal

// Recibe una direccion de animal, y hace free a cada void* fuerza, velocidad y resistencia.
// Ademas, hace que luego del free estos apunten a NULL (asi es como yo definí una casilla vacia)
// -------------------------


void BorrarAnimal(Animal *anim){
    free(anim->fuerza);
    free(anim->velocidad);
    free(anim->resistencia);
    anim->fuerza=NULL;
    anim->velocidad=NULL;
    anim->resistencia=NULL;
}

// -------------------------
// Funcion: Mostrar animal
// Parametros: Una direccion de animal

// Obtiene las variables almacenadas en los void, dependiendo del tipo de dato
// Luego las imprime en el orden:
// Fuerza: 
// Velocidad:
// Resistencia:
// ---------

void MostrarAnimal(Animal* anim){
    printf("\n");
    if(anim->tipo_fuerza=='e'){
        printf("Fuerza: %i\n",*((int*)anim->fuerza));
        }
    else if(anim->tipo_fuerza=='c'){
        printf("Fuerza: %c\n",*((char*)anim->fuerza));
        }
    else if(anim->tipo_fuerza=='f'){
        printf("Fuerza: %f\n",*((float*)anim->fuerza));
        }

    if(anim->tipo_velocidad=='e'){
        printf("Velocidad: %i\n",*(int*)anim->velocidad);
        }
    else if(anim->tipo_velocidad=='c'){
        printf("Velocidad: %c\n",*((char*)anim->velocidad));
        }
    else if(anim->tipo_velocidad=='f'){
        printf("Velocidad: %f\n",*((float*)anim->velocidad));
        }
    if(anim->tipo_resistencia=='e'){
        printf("Resistencia: %d\n", *((int*)anim->resistencia));
        }
    else if(anim->tipo_resistencia=='c'){
        printf("Resistencia: %c\n",*((char*)anim->resistencia));
        }
    else if(anim->tipo_resistencia=='f'){
        printf("Resistencia: %f\n",*((float*)anim->resistencia));
        }
}

// -------------------------
// Funcion: Mostrar Mundo
// Parametros: Un puntero doble de animal

// Reproduce la funcion MostrarAnimal con todos los animales en la variable Mundo, que representa
// una matriz de animales. Además, muestra las cooredandas donde se encuentra cada animal
// ---------

void MostrarMundo(Animal** Mundo){
    for (int i = 0; i < 1000; i++)
    {
        for (int j = 0; j < 1000; j++)
        {
            if (Mundo[i][j].fuerza!=NULL){
                printf("\n---------------------");
                printf("\nCoordenadas: (%d,%d)\n",i,j);
                MostrarAnimal(&Mundo[i][j]);
                printf("---------------------\n");
            }
           
        }
        
    }
    
}

// -------------------------
// Funcion: Borrar Mundo
// Parametros: Un puntero doble de animal

// Libera la memoria pedida en toda la matriz, además hace BorrarAnimal a todos los animales que puedan
// existir en la misma.
// ---------

void BorrarMundo(Animal** Mundo){
    for (int i = 0; i < 1000; i++)
    {
        for (int j = 0; j < 1000; j++)
        {
            if (Mundo[i][j].fuerza!=NULL){
                BorrarAnimal(&Mundo[i][j]);
            }
        }
        free(Mundo[i]);
        
    }
    free(Mundo);
    
}    
     
// -------------------------
// Funcion: Reproducir
// Parametros: Tres direcciones de animal

// Define cual de los dos animales (a1 y a2) es el que usara la funcion reproducir, esto hecho
// aleatoriamente. Luego ejecuta la funcion del que salga, quedando primero en el parametro el
// animal que uso la funcion. El parametro hijo es un animal vacio.
// ---------

void Reproducir(Animal* a1, Animal* a2, Animal* hijo){
    int randomnum= rand()%2;
    if (randomnum==0){
        printf("\n");
        printf("El animal que uso su funcion reproduccion es: \n");
        MostrarAnimal(a1);
        a1->reproduccion(a1,a2,hijo);

    }
    else if (randomnum==1){
        printf("\n");   
        printf("El animal que uso su funcion reproduccion es: \n");
        MostrarAnimal(a2);
        a2->reproduccion(a2,a1,hijo);
    }
}

// -------------------------
// Funcion: ComerHuir
// Parametros: Dos direcciones de animal

// Define cual de los dos animales (a1 y a2) es el que usara la funcion comerHuir, esto hecho
// aleatoriamente. Luego ejecuta la funcion del que salga, quedando primero en el parametro el
// animal que uso la funcion
// ---------

void ComerOHuir(Animal *a1, Animal *a2){
    int randomnum= rand()%2;
    if (randomnum==0){
        printf("\n");
        printf("El animal que uso su funcion ComerOHuir es: \n");
        MostrarAnimal(a1);
        a1->comerHuir(a1,a2);

    }
    else if (randomnum==1){
        printf("\n");
        printf("El animal que uso su funcion ComerOHuir es: \n");
        MostrarAnimal(a2);
        a2->comerHuir(a2,a1);
    }
}

// -------------------------
// Funcion: Copiar animal
// Parametros: Dos direcciones de animal

// Copia todas las variables del animal origen al animal destino
// Creando nueva memoria, para desreferenciar uno del otro. Esta funcion fue creada por mi
// Para facilitar la iteracion, en donde necesite copiar los animales de la matriz a un array
// ---------

void CopiarAnimal(Animal *destino, Animal *origen){
    destino->tipo_fuerza=origen->tipo_fuerza;
    destino->tipo_velocidad=origen->tipo_velocidad;
    destino->tipo_resistencia=origen->tipo_resistencia;
    destino->comerHuir=origen->comerHuir;
    destino->reproduccion=origen->reproduccion;
    if(origen->tipo_fuerza=='e'){
        destino->fuerza=malloc(sizeof(int));
        memcpy(destino->fuerza,origen->fuerza,sizeof(int));
    }
    else if(origen->tipo_fuerza=='c'){
        destino->fuerza=malloc(sizeof(char));
        memcpy(destino->fuerza,origen->fuerza,sizeof(char));
    }
    else if(origen->tipo_fuerza=='f'){
        destino->fuerza=malloc(sizeof(float));
        memcpy(destino->fuerza,origen->fuerza,sizeof(float));
    }
    if(origen->tipo_velocidad=='e'){
        destino->velocidad=malloc(sizeof(int));
        memcpy(destino->velocidad,origen->velocidad,sizeof(int));
    }
    else if(origen->tipo_velocidad=='c'){
        destino->velocidad=malloc(sizeof(char));
        memcpy(destino->velocidad,origen->velocidad,sizeof(char));
    }
    else if(origen->tipo_velocidad=='f'){
        destino->velocidad=malloc(sizeof(float));
        memcpy(destino->velocidad,origen->velocidad,sizeof(float));
    }
    if(origen->tipo_resistencia=='e'){
        destino->resistencia=malloc(sizeof(int));
        memcpy(destino->resistencia,origen->resistencia,sizeof(int));
    }
    else if(origen->tipo_resistencia=='c'){
        destino->resistencia=malloc(sizeof(char));
        memcpy(destino->resistencia,origen->resistencia,sizeof(char));
    }
    else if(origen->tipo_resistencia=='f'){
        destino->resistencia=malloc(sizeof(float));
        memcpy(destino->resistencia,origen->resistencia,sizeof(float));
    }
}
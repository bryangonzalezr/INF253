#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <stddef.h>
#include <math.h>


#include "Animal.h"



int main(){

    // Inicializando matriz, con los punteros fuerza, velocidad y resistencia en NULL
    srand(time(NULL));
    int n=1000;
    Animal** Mundo = (Animal**)malloc(sizeof(Animal*)*n );
    for(int i=0; i<n;i++){
        Mundo[i]= (Animal*)malloc(sizeof(Animal)*n);   
    }
    
    //Así defino una casilla vacia en mi Matriz de Animales,
    // con los void* de cada uno apuntando a NULL

    for(int i=0; i<n;i++){
        for (int j = 0; j < n; j++)
        {
            Mundo[i][j].fuerza=NULL;
            Mundo[i][j].velocidad=NULL;
            Mundo[i][j].resistencia=NULL;

        }
    }

    //Comienza el menú

    int MenuBool= 1;
    printf("Bienvenido a la simulacion: \n");
    int opcion1=0;
    while (MenuBool){

        //opciones del menu

        printf("Escriba el número de la opción que desea aplicar: \n");
        printf("    1. Crear un animal\n");
        printf("    2. Avanzar una iteración temporal\n");
        printf("    3. Mostrar el mundo\n");
        printf("    4. Probar funcion HuirSiempre\n");
        printf("    5. Salir\n");

        //Se obtiene la opcion seleccionada por el usuario

        scanf("%d",&opcion1);
        if (opcion1==1){
            
            //Si se crea un animal, se pregunta donde lo desea crear y se ejecuta
            //la funcion CrearAnimal

            int fil;
            printf("Escriba en que fila desea crear al animal: ");
            scanf("%d", &fil);
            int col;
            printf("Escriba en que columna desea crear al animal: ");
            scanf("%d", &col);
            CrearAnimal(&Mundo[fil][col]);
        }
        else if (opcion1==2){
            
            //Si se desea hacer una iteracion, se pide memoria para un array de Tuplas
            //que representaran la posicion en cada casilla

            Tupla *iteracion = (Tupla*)malloc(sizeof(Tupla)*n*n);

            //Se pide memoria para la Tupla, y se inicializa todo como vacio

            for (int i = 0; i < n*n; i++){
                iteracion[i].posicion=(int*)malloc(sizeof(int)*2);
                iteracion[i].a=(Animal*)malloc(sizeof(Animal));
                iteracion[i].a->fuerza=NULL;
                iteracion[i].a->velocidad=NULL;
                iteracion[i].a->resistencia=NULL;
                iteracion[i].posicion[0]=-1;
                iteracion[i].posicion[1]=-1;
            }

            //Se hace la iteracion dentro de la tupla, es decir, se ingresan los valores
            //con el movimiento aleatorio

            int count=0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){

                    //Si encuentra un animal en la matriz, lo agrega a la Tupla

                    if(Mundo[i][j].fuerza!=NULL){
                        int randomnumber= rand()%4,fil=i,col=j;
                        if(randomnumber==0){
                            fil=(fil-1);
                            if (fil==-1){
                                fil=n-1;
                            }
                        }
                        else if(randomnumber==1){
                            fil=(fil+1)%n;
                            
                        }
                        else if(randomnumber==2){
                            col= (col-1)%n;
                            if (col==-1){
                                col=n-1;
                            }
                        }
                        else if(randomnumber==3){
                            col= (col+1)%n;
                        }
                        iteracion[count].posicion[0]=fil;
                        iteracion[count].posicion[1]=col;
                        CopiarAnimal(iteracion[count].a,&Mundo[i][j]);
                        
                        count+=1;
                    }
                } 
            }

            //Se eliminan los animales del mundo

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (Mundo[i][j].fuerza!=NULL){
                        BorrarAnimal(&Mundo[i][j]);
                    }
                }
              
            }

            //Se itera en el array de tuplas, para ejecutar las funciones
            //reproduccion y comerHuir en caso que sea necesario

            int fil,col;
            for (int i = 0; i < n*n; i++)
            {
                //ingresa solo si la Tupla no es vacía
                if(iteracion[i].posicion[0]!=-1&&iteracion[i].posicion[0]!=-1){
                    fil=iteracion[i].posicion[0];
                    col=iteracion[i].posicion[1];
                    int otherfil,othercol;
                    for (int k = 0; k < n*n; k++)
                    {
                        otherfil=iteracion[k].posicion[0];
                        othercol=iteracion[k].posicion[1];
                        //Entra solo si se repite la posicion
                        if (fil==otherfil&&col==othercol&&i!=k&&fil!=-1){
                            int left=0,up=0,down=0,right=0,index=0,filson,colson;

                            //en este for se comprueba si las casillas adyacentes estan vacias

                            for (int j = 0; j < n*n; j++){

                                filson=(fil-1)%n;
                                colson=(col-1)%n;
                                if (filson==-1){
                                    filson=n-1;
                                }
                                if (colson==-1){
                                    colson=n-1;
                                }
                                if(filson==iteracion[j].posicion[0]&&col==iteracion[j].posicion[1]){
                                    down=1;
                                }
                                else if((fil+1)%n==iteracion[j].posicion[0]&&col==iteracion[j].posicion[1]){
                                    up=1;
                                }
                                else if(fil==iteracion[j].posicion[0]&&(col+1)%n==iteracion[j].posicion[1]){
                                    right=1;
                                }
                                else if(fil==iteracion[j].posicion[0]&&colson==iteracion[j].posicion[1]){
                                    left=1;
                                }
                                if(iteracion[j].a->fuerza==NULL){
                                    index=j;
                                }
                            }

                            //Se ejecuta reproducir solo si existe una casilla
                            //disponible para el hijo
                            printf("Han colisionado dos animales!!\n");
                            
                            MostrarAnimal(iteracion[i].a);
                            printf("\ncon\n");
                            MostrarAnimal(iteracion[k].a);
                            printf("\nIniciando proceso de reproduccion:");
                            printf("\n");
                            if (left==0){
                                iteracion[index].posicion[0]=fil;
                                iteracion[index].posicion[1]=colson;
                                Reproducir(iteracion[i].a,iteracion[k].a,iteracion[index].a);
                            }
                            else if (up==0){
                                iteracion[index].posicion[0]=(fil+1)%n;
                                iteracion[index].posicion[1]=col;
                                Reproducir(iteracion[i].a,iteracion[k].a,iteracion[index].a);
                            }
                            else if (right==0){
                                iteracion[index].posicion[0]=fil;
                                iteracion[index].posicion[1]=(col+1)%n;
                                Reproducir(iteracion[i].a,iteracion[k].a,iteracion[index].a);
                            }
                            else if (down==0){
                                iteracion[index].posicion[0]=filson;
                                iteracion[index].posicion[1]=col;
                                Reproducir(iteracion[i].a,iteracion[k].a,iteracion[index].a);
                            }

                            //ComerOHuir se ejecuta en todos los casos si existe colision
                            printf("\n");
                            printf("Iniciando proceso comerHuir: ");
                            printf("\n");
                            ComerOHuir(iteracion[i].a,iteracion[k].a);
                            
                            //Como uno de los dos va a morir, su posicion se 
                            //setea en -1 dependiendo de que animal este vacio
                            //-1 es lo que determine como casilla vacia en la Tupla

                            if (iteracion[i].a->fuerza==NULL){
                                iteracion[i].posicion[0]=-1;
                                iteracion[i].posicion[1]=-1;
                            }
                            else if(iteracion[k].a->fuerza==NULL){
                                iteracion[k].posicion[0]=-1;
                                iteracion[k].posicion[1]=-1;
                            }
                            
                            
                        }
                    }
                    
                }
            }
            
            //Se pasa cada animal de la iteracion al Mundo
            for (int i = 0; i < n*n; i++)
            {
                if (iteracion[i].a->fuerza!=NULL){
                    CopiarAnimal(&Mundo[iteracion[i].posicion[0]][iteracion[i].posicion[1]],iteracion[i].a);
                }
                
            }

            //Se libera la memoria del array de Tupla

            for (int i = 0; i < n*n; i++){
                free(iteracion[i].posicion);
                if (iteracion[i].a->fuerza!=NULL){
                    BorrarAnimal(iteracion[i].a);
                }
                free(iteracion[i].a);
            }
            free(iteracion);
            
        }
        else if (opcion1==3){
            //Mostrar mundo es super simple XD

            MostrarMundo(Mundo);
        }
        else if (opcion1==4){

            //Cree este ambiente de prueba para la funcion HuirSiempre y que
            //no me bajen todo el puntaje por no tenerla incluida en el menu

            //pide al usuario los datos del animal que va primero en la funcion
            //(el equivalente a que hubiese sido su funcion)
            //Y luego las estadisticas del segundo animal, el que va en el segundo
            //parametro.

            printf("\n");
            printf("Iniciando prueba funcion HuirSiempre");
            printf("\n");
            Animal *anim1=(Animal*)malloc(sizeof(Animal));
            printf("Escriba el tipo de dato con el que ingresará la fuerza del primer animal: ");
            scanf(" %c",&anim1->tipo_fuerza);
            
            //Todo aca es muy similar a crearAnimal, pero no se uso la funcion
            //porque no se requiere la funcion comerHuir ni la funcion Reproduccion
            //de cada uno (por ser un ambiente de prueba).

            if(anim1->tipo_fuerza=='e'){
                anim1->fuerza=malloc(sizeof(int));
                printf("Ingrese el valor de la fuerza del primer animal: ");
                scanf("%d",(int*)anim1->fuerza);
                
            }
            else if(anim1->tipo_fuerza=='c'){
                anim1->fuerza=malloc(sizeof(char));
                printf("Ingrese el valor de la fuerza del primer animal: ");
                scanf(" %c",(char*)anim1->fuerza);
            }
            else if(anim1->tipo_fuerza=='f'){
                anim1->fuerza=malloc(sizeof(float));
                printf("Ingrese el valor de la fuerza del primer animal: ");
                scanf("%f",(float*)anim1->fuerza);
            }
            printf("Escriba el tipo de dato con el que ingresará la velocidad del primer animal: ");
            scanf(" %c",&anim1->tipo_velocidad);
            if(anim1->tipo_velocidad=='e'){
                anim1->velocidad=malloc(sizeof(int));
                printf("Ingrese el valor de la velocidad del primer animal: ");
                scanf("%d",(int*)anim1->velocidad);
            }
            else if(anim1->tipo_velocidad=='c'){
                anim1->velocidad=malloc(sizeof(char));
                printf("Ingrese el valor de la velocidad del primer animal: ");
                scanf(" %c",(char*)anim1->velocidad);
            }
            else if(anim1->tipo_velocidad=='f'){
                anim1->velocidad=malloc(sizeof(float));
                printf("Ingrese el valor de la velocidad del primer animal: ");
                scanf("%f",(float*)anim1->velocidad);
                
            }
            printf("Escriba el tipo de dato con el que ingresará la resistencia del primer animal: ");
            scanf(" %c",&anim1->tipo_resistencia);
            if(anim1->tipo_resistencia=='e'){
                anim1->resistencia=malloc(sizeof(int));
                printf("Ingrese el valor de la resistencia del primer animal: ");
                scanf("%d",(int*)anim1->resistencia);
            }
            else if(anim1->tipo_resistencia=='c'){

                anim1->resistencia=malloc(sizeof(char));
                printf("Ingrese el valor de la resistencia del primer animal: ");
                scanf(" %c",(char*)anim1->resistencia);
            }
            else if(anim1->tipo_resistencia=='f'){
                anim1->resistencia=malloc(sizeof(float));
                printf("Ingrese el valor de la resistencia del primer animal: ");
                scanf("%f",(float*)anim1->resistencia);
            }
            printf("\n");
            Animal *anim2=(Animal*)malloc(sizeof(Animal));
            printf("Escriba el tipo de dato con el que ingresará la fuerza del segundo animal: ");
            scanf(" %c",&anim2->tipo_fuerza);
            if(anim2->tipo_fuerza=='e'){
                anim2->fuerza=malloc(sizeof(int));
                printf("Ingrese el valor de la fuerza del segundo animal: ");
                scanf("%d",(int*)anim2->fuerza);
                
            }
            else if(anim2->tipo_fuerza=='c'){
                anim2->fuerza=malloc(sizeof(char));
                printf("Ingrese el valor de la fuerza del segundo animal: ");
                scanf(" %c",(char*)anim2->fuerza);
            }
            else if(anim2->tipo_fuerza=='f'){
                anim2->fuerza=malloc(sizeof(float));
                printf("Ingrese el valor de la fuerza del segundo animal: ");
                scanf("%f",(float*)anim2->fuerza);
            }
            printf("Escriba el tipo de dato con el que ingresará la velocidad del segundo animal: ");
            scanf(" %c",&anim2->tipo_velocidad);
            if(anim2->tipo_velocidad=='e'){
                anim2->velocidad=malloc(sizeof(int));
                printf("Ingrese el valor de la velocidad del segundo animal: ");
                scanf("%d",(int*)anim2->velocidad);
            }
            else if(anim2->tipo_velocidad=='c'){
                anim2->velocidad=malloc(sizeof(char));
                printf("Ingrese el valor de la velocidad del segundo animal: ");
                scanf(" %c",(char*)anim2->velocidad);
            }
            else if(anim2->tipo_velocidad=='f'){
                anim2->velocidad=malloc(sizeof(float));
                printf("Ingrese el valor de la velocidad del segundo animal: ");
                scanf("%f",(float*)anim2->velocidad);
                
            }
            printf("Escriba el tipo de dato con el que ingresará la resistencia del segundo animal: ");
            scanf(" %c",&anim2->tipo_resistencia);
            if(anim2->tipo_resistencia=='e'){
                anim2->resistencia=malloc(sizeof(int));
                printf("Ingrese el valor de la resistencia del segundo animal: ");
                scanf("%d",(int*)anim2->resistencia);
            }
            else if(anim2->tipo_resistencia=='c'){

                anim2->resistencia=malloc(sizeof(char));
                printf("Ingrese el valor de la resistencia del segundo animal: ");
                scanf(" %c",(char*)anim2->resistencia);
            }
            else if(anim2->tipo_resistencia=='f'){
                anim2->resistencia=malloc(sizeof(float));
                printf("Ingrese el valor de la resistencia del segundo animal: ");
                scanf("%f",(float*)anim2->resistencia);
            }
            printf("\n");
            printf("Estadísticas del primer animal: \n");
            MostrarAnimal(anim1);
            printf("\n");
            printf("Estadísticas del segundo animal: \n");
            MostrarAnimal(anim2);
            printf("\n");

            //Aca se ejecuta la funcion HuirSiempre, que en mi caso como 
            //no la pude incluir en la iteracion, en vez de mover al animal una 
            //casilla si escapa, lo imprime en pantalla "Se escapó"

            //Caso contrario, imprime en pantalla que el animal fue comido porque
            //no pudo escapar

            HuirSiempre(anim1,anim2);


            //Aca se libera la memoria de ambos animales
            //de prueba
            
            BorrarAnimal(anim1);
            BorrarAnimal(anim2);
            free(anim1);
            free(anim2);
        }
        else if (opcion1==5){

            //Con BorrarMundo se libera toda la memoria que queda
            //Pues en general toda la memoria pedida ya esta liberada
            //Tupla libera memoria en la misma iteracion, y la prueba de 
            //HuirSiempre tambien libera la memoria que ocupa ahi mismo.

            BorrarMundo(Mundo);
            MenuBool=0;
        } 
        }
        printf("\n");
    
    
}
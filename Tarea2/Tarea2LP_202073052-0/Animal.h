

//Estructura animal
typedef struct Animal{
    void* fuerza;
    char tipo_fuerza;
    void* velocidad;
    char tipo_velocidad;
    void* resistencia;
    char tipo_resistencia;
    void (*reproduccion)(struct Animal* a1,struct Animal* a2,struct Animal* hijo);
    void (*comerHuir ) (struct Animal* a1,struct Animal* a2);
}Animal;


//Estructura Tupla creada por mi, consta de un puntero int posicion, y el animal correspondiente.

typedef struct Tupla{
    int *posicion;
    Animal *a;
}Tupla;





//Headers

void CrearAnimal(Animal* a);
void BorrarAnimal(Animal* a);
void MostrarAnimal(Animal* a);
void Reproducir(Animal* a1, Animal* a2, Animal* hijo);
void ComerOHuir(Animal* a1, Animal* a2);
int Comparar(Animal* a1, Animal* a2);
void BorrarMundo(Animal** Mundo);
void MostrarMundo(Animal** Mundo);
void ReproduccionSimple(Animal* a1, Animal* a2, Animal* hijo);
void ReproduccionCruzada(Animal* a1, Animal*a2, Animal* hijo);
void ComerSiempre(Animal* a1, Animal* a2);
void HuirSiempre(Animal* a1, Animal* a2);
void ComerAleatorio(Animal* a1, Animal* a2);
void CopiarAnimal(Animal *destino, Animal *origen);

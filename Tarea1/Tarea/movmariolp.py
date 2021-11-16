import re

'''
iniMatrix
--------------
matrix : lista
size: int
--------------
Agrega "size" cantidad de listas en matrix, y ademas, 
agrega "size" cantidad de 0 en cada lista
'''
def iniMatrix(matrix, size):
    i=0
    while (i<size):
        matrix.append([])
        j=0
        while (j<size):
            matrix[i].append(0)
            j+=1
        i+=1

'''
copyMatrix
--------------
matrix : lista de listas
copy_matrix: lista
--------------
Copia la matriz en su totalidad, haciendo nuevas listas para cada valor, evitando
la redireccion que hace python al copiar listas
'''
def copyMatrix(matrix, copy_matrix):
    copy_matrix=list()
    for lista in matrix:
        copy_matrix.append(list(lista))
    return copy_matrix

'''
printMatrix
--------------
matrix : lista de listas
--------------
Imprime los valores de la matriz, saltando de linea y con espacios entre valores.
Esta funcion se uso meramente para pruebas de codigo
'''
def printMatrix(matrix):
    size= len(matrix)
    i=0
    while (i<size):
        j=0
        line=""
        while (j<size):
            line+= str(matrix[i][j])+" "
            j+=1
        print(line)
        i+=1

'''
direccion
--------------
pos : tupla de 2 int
string: string
size: int
--------------
Obtiene la letra y numero de movimientos que se deben hacer hacia la direccion de la letra
separando el string, luego a traves de una formula matematica obtenemos el valor exacto
de posiciones que se debe mover (para cuando se deba dar la vuelta en la matriz)

Retorna una tupla con 2 ints, que equivalen a la posicion final tras aplicar la direccion (fila, columna)
'''
def direccion(pos,string,size):
    identifier= re.compile(r"[UD<>][1-9]\d*")
    x=pos[0]
    y=pos[1]

    directs= identifier.finditer(string)
    for direct in directs:
        letra=direct.group(0)[:1]
        cantidad=int(direct.group(0)[1:])
        if(letra=="U"):
            if((x-cantidad)>=0):
                x-=cantidad
            else:
                x-=cantidad
                x= x+(abs((x//size))*size)
        elif(letra=="D"):
            if(x+cantidad<size):
                x+=cantidad
            else:
                x+=cantidad
                x= x-(abs((x//size))*size)
        elif(letra==">"):
            if(y+cantidad<size):
                y+=cantidad
            else:
                y+=cantidad
                y= y-(abs((y//size))*size)
        elif(letra=="<"):
            if(y-cantidad>=0):
                y-=cantidad
            else:
                y-=cantidad
                y= y+(abs((y//size))*size)
    return (x,y)

'''
getASCII
--------------
matrix : lista de listas
--------------
Recorre la matriz, agregando el valor ASCII (bajo las condiciones dadas)
a un string que sera retornado al final de la funcion
'''
def getASCII(matrix):
    code=""
    i=0
    while i<len(matrix):
        j=0
        while j<len(matrix[i]):
            if 32<=matrix[i][j]<127:
                code+=chr(matrix[i][j])
            if matrix[i][j]==127:
                code+="\n"
            j+=1
        i+=1

    return code

'''
getSe
--------------
matrix : lista de listas
--------------
Recorre la matriz, agregando el valor entero de cada posicion
a un string que sera retornado al final de la funcion
'''
def getSe(matrix):
    Se=""
    i=0
    while i<len(matrix):
        j=0
        while j<len(matrix[i]):
            Se+=str(matrix[i][j])
            j+=1
        i+=1
    return Se

'''
parentesis
--------------
line : string
--------------
Esta es la funcion mas complicada de mi codigo:

Recibe un string line como parametro, el cual espera la linea de codigo a ejecutar:

Primero crea un diccionario de "niveles" de parentesis, este diccionario
representa cuales son los parentesis que estan mas adentro, ordenados desde
izquierda a derecha

Posteriormente, se crea una lista que contiene strings.
Estos son los comandos en el orden que se deben ejecutar, respetando
el orden de los parentesis.

Finalmente, retorna esta lista
'''
def parentesis(line):
    parent= re.compile(r"\(|\)")
    innerpar= re.compile(r"\([^()]+\)")
    dash= re.compile(r"\-")
    if dash.search(line) != None:
        print("invalid")
        return []
    auxline=line
    left=[]
    right=[]
    group={}
    timesanidated=0
    allparent= parent.finditer(line)
    for parents in allparent:
        parStr= parents.group(0)
        parPos=parents.span()
        if parStr=="(":
            left.append(parPos)
            timesanidated+=1
            if timesanidated not in group:
                group[timesanidated]=[]
        if parStr==")":
            right.append(parPos)
            if len(left)!=0:
                group[timesanidated].append(auxline[left[-1][0]:right[-1][1]])
            else:
                return []
            left.pop(-1)
            right.pop(-1)
            timesanidated-=1
    if len(right)!=0 or len(left) !=0:
        return []
    dicsize=len(group)
    order=[]
    while dicsize>0:
        for par in group[dicsize]:
            if dicsize==len(group):
                order.append(par[1:-1])
            else:
                par=par[1:-1]
                while (innerpar.search(par)):
                    par= innerpar.sub(r"-",par)
                par= dash.split(par)
                for strg in par:
                    if strg !="":
                        order.append(strg)
        
        dicsize-=1
    while (innerpar.search(auxline)):
        auxline= innerpar.sub(r"-",auxline)
    auxline= dash.split(auxline)
    for strg in auxline:
        if strg !="":
            order.append(strg)
    
    return order

'''
error
--------------
errorline : string
--------------
Abre un archivo error.txt, y escribe errorline
'''
def error(errorline):
    file=open("error.txt","w")
    if errorline!="":
        file.write(errorline)
    else:
        file.write("No hay errores!")
    file.close()


codigo = open("code.txt","r").read()

#Se separa el codigo por lineas en una lista gracias a re.split()

newLine= re.compile(r"\n")
splitedCode = newLine.split(codigo)

size= int(splitedCode[0])
matrix= list()

#Se inicializa la matriz en 0 con el tamaño dado por el codigo
iniMatrix(matrix,size)
splitedCode.pop(0)
pos=(0,0)

#Expresiones regulares

dire= re.compile(r"([UD<>][1-9]\d*)+")
oper = re.compile(r"[ABRZ]")
condi= re.compile(r"(\?)([UD<>][1-9]\d*)+([ABRZ]|[YX]([UD<>][1-9]\d*)+|\?)")
mult = re.compile(r"[YX]([UD<>][1-9]\d*)+")
showval= re.compile(r"[LS][ce]")

#Lista de las expresiones regulares
comms = []
comms.append(dire)
comms.append(oper)
comms.append(condi)
comms.append(mult)
comms.append(showval)


lineindex=1
errorline=""
showvalstring=""

#Se recorre el codigo linea por linea

for line in splitedCode:

    #Por cada linea crea variables auxiliares, en caso de que la linea sea invalida

    invalid=False
    auxmatrix=list()
    auxmatrix= copyMatrix(matrix,auxmatrix)
    auxpos=pos
    auxstring=""
    condicional=True

    #Separa la linea en orden de parentesis

    order=parentesis(line)
    if order==[]:
        invalid=True
    for auxline in order:
        while (auxline!="") and not invalid:
            for com in comms:    
                code = com.match(auxline)
                if code:
                    sel=com
                    break
            if not code:

                #Si no hace match, invalid es true y se sale de la linea

                invalid=True
                break
            else:
                
                matchPos= code.span()

                #Este if representa un match con direccion

                if (sel==dire):
                    auxpos= direccion(auxpos,code.group(0),size)
                    auxline = auxline[matchPos[1]:]

                #Este if representa un match con operaciones de suma o reseteo

                elif (sel==oper) and condicional:
                    if code.group(0)=="A":
                        auxmatrix[auxpos[0]][auxpos[1]] +=1
                    if code.group(0)=="B":
                        auxmatrix[auxpos[0]][auxpos[1]] -=1
                    if code.group(0)=="R":
                        auxmatrix[auxpos[0]][auxpos[1]]  =0
                    if code.group(0)=="Z":
                        printMatrix(auxmatrix)
                        iniMatrix(auxmatrix,size)
                        printMatrix(auxmatrix)
                    condicional=True
                    auxline = auxline[matchPos[1]:]

                #Este if representa un match con condicionales
                
                elif (sel==condi) and condicional:
                    condipos= direccion(auxpos,code.group(2),size)
                    if auxmatrix[condipos[0]][condipos[1]]>0:
                        condicional=True
                    else:
                        condicional=False
                    auxline=auxline[code.end(2):]

                #Este if representa un match con operaciones de multiplicacion

                elif (sel==mult) and condicional:
                    multpos= direccion(auxpos,code.group(0),size)
                    if (code.group(0)[0:1])=="X":
                        auxmatrix[auxpos[0]][auxpos[1]]=auxmatrix[auxpos[0]][auxpos[1]]*auxmatrix[multpos[0]][multpos[1]]
                    if (code.group(0)[0:1]=="Y")and auxmatrix[multpos[0]][multpos[1]] != 0:
                        auxmatrix[auxpos[0]][auxpos[1]]=auxmatrix[auxpos[0]][auxpos[1]]//auxmatrix[multpos[0]][multpos[1]]
                    condicional=True
                    auxline = auxline[matchPos[1]:]

                #Este if representa un match con operaciones de muestra de valores

                elif (sel==showval) and condicional:
                    auxline = auxline[matchPos[1]:]
                    if code.group(0)[:1]=="L":
                        if code.group(0)[1:]=="e":
                            auxstring+=str(auxmatrix[auxpos[0]][auxpos[1]])
                        if code.group(0)[1:]=="c":
                            if 32<=auxmatrix[auxpos[0]][auxpos[1]]<127:
                                auxstring+=chr(auxmatrix[auxpos[0]][auxpos[1]])
                            if auxmatrix[auxpos[0]][auxpos[1]]==127:
                                auxstring+="\n"
                           
                    if code.group(0)[:1]=="S":
                        if code.group(0)[1:]=="e":
                            auxstring+=getSe(auxmatrix)
                        if code.group(0)[1:]=="c":
                            auxstring+=getASCII(auxmatrix)
                    condicional=True

                #Este if esta hecho para las operaciones luego de un condicional
                #Si el condicional resulta falso y viene otro condicional, se mantiene el falso
                #y se elimina de la linea, dejando solamente la operacion
                #Si el condicional resulta falso y viene una operacion, esta no se realiza
                #y el condicional se vuelve verdadero

                elif condicional==False:
                    if code.group(0)[0]=="?":
                        condicional=False
                        auxline=auxline[code.end(2):]
                    else:
                        condicional=True
                        auxline = auxline[matchPos[1]:]
        
    lineindex+=1

    #Condiciones en caso de que valido o invalido

    if not invalid:
        
        # Si no es invalido, las variables auxiliares se pasan a las variables originales
        # cambiando la matriz y posicion definitivamente

        matrix=auxmatrix
        pos=auxpos
        order==[]
        showvalstring+=auxstring
    elif invalid:

        # Si es invalido, se agrega a la linea de errores

        if errorline=="":
            errorline+=str(lineindex)+" "+line
        else:
            errorline+="\n"+str(lineindex)+" "+line
        auxpos=pos
        auxmatrix=matrix
        auxline=line

#Si showval (string que se crea con los comandos L y S) no es vacio, se imprime.

if showvalstring !="":
    print(showvalstring)


error(errorline)


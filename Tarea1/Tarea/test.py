import re

def valido(linea,comandos):
    for comms in comandos:
        linea=comms.sub(r"",linea)
    if linea!="":
        return False
    else:
        return True
    

direccion= re.compile(r"([UD><][1-9][0-9]*)+")
sumas= re.compile(r"[ABRZ]")
mulpt= re.compile(r"([XY])([UD><][1-9][0-9]*)+")
mostrarval= re.compile(r"[LS][ec]")
condi= re.compile(r"(\?)([UD<>][1-9]\d*)+([ABRZ]|[XY]([UD><][1-9][0-9]*)+|\?)")

##enlistando
comandos=[]
comandos.append(direccion)
comandos.append(sumas)
comandos.append(mulpt)
comandos.append(mostrarval)
comandos.append(condi)

string= "AAA?U23?U24AAAScU234XU23"

comandos_separados= valido(string,comandos)
print(comandos_separados)


matches=direccion.search(string)
nuevostring=matches.group(0)



"# DarkSouls" 

TP 1 

6.2 : isAlive() doit avoir la visibilité à défault car la class Hero est dans le même 
package que le main où isAlive() est appelé. 

7.3 : isAlive() doit avoir la visibilité à public car isAlive() est appelé 
dans un package différent de là où il est créé. 


TP 2 

1.2 : Il faudra passer des membres de 

6 : La durabilité de l'arme est commune au Héro et au Monstre. L'arme est instancié une seule fois. 



TP 3 

4.2 : Error:(11, 8) java: characters.Hero is not abstract and does not override abstract method computeProtection() in characters.Character
L'erreur est présente car on ne déclare pas la fonction abstraite computeProtection() dans la class Hero et Monster. 
Il faut donc @Override computeProtection() dans Hero et Monster


"# DarkSouls" 


TP1

Question 6 Package lsg

La visibilité optimal pour isAlive est friendly. Effectivement,
tant qu'on utilise isAlive dans une classe présente dans le paquet,
c'est la meilleure visibilité

Question 7 Packages characters

La visibilité optimal pour isAlive est public.
On n'a pas d'autre choix, la méthode étant appelé dans une classe
en dehors du paquet, aucune autres visibilité ne pourrais l'atteindre


TP2

Question 1.2 

Il faut changer la visibilité de certain membres car on n'est plus
dans la meme classe, du coup le private nous coupe l'accès à certaine
méthode. On peut passer à protected car elle nous donne la permission
d'appel des méthodes.

Question 6

La durabilité de l'épée baisse également car c'est la même instance de
l'objet. Pour ne plus avoir se problème, il faudrait que chaque
character est une arme équipée différente.

TP3

Question 4.2

erreur:

Class 'Hero' must either be declared abstract or implement abstract method 'computeProtection()' in 'Character'

Cette erreur est présente car la méthode abstraite n'est pas
implémenté dans les classes hero et monster.

TP4

Question 3.3

Returns an iterator over the elements in this set. The elements are returned in no particular order.
L'ordre de l'itération

Question 3.4 

This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order)

Dans le LinkedHashSet, l'iterator est trié dans l'ordre d'insertion


TP6

Question 2.2

Une exception a été remonté (NullPointerException) qui indique qu'un objet
était vide dans la méthode attackWith. Le héro n'avait pas d'arme et à donc créer une erreur lors de l'attaque.



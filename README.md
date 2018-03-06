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
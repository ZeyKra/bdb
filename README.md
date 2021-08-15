# Bûtin des Berchta
> Cahie des Charges
> Crédit: Wolfrost
 
```
Cahier des Charges: Bûtin des Berchta
Nom du Plugin: BDB.jar
Rappel: Tout les messages doivent être configurables

Légende:

* Message envoyé après la commande
! Choses à rajouter (précision.s etc)
<> Argument Obligatoire
[<>] Argument facultatif
= Permission liée à cette commande.

----------------------------------------------------------------------
Explication:

Une zone serait en WarZone, un carré de 5x5 (On peut mettre + ou  -).
Une seule personne peut capturer (et donc gagner les récompenses).

Le joueur reste dans la zone, il doit capturer pendant 30 secondes, pour emporter une pépite d'or nommé "1"


9 pépites d'or = un lingot d'or nommé "2"
9 lingots d'or = un mycellium enchanté nommé "3"
Un mycellium enchanté = revente à 10,000$/unité (je rappel que de base, un mycellium c'est 27$ la revente)

L'évènement sera actif lorsque le nombre de joueurs sera supérieur ou égale à 50 (modifiable).

Commandes:

/bdb set
* Vous devez sélectionner une zone à l'aide de WorldEdit. (message envoyé au joueur)
* L'emplacement de l'évènement Bûtin des Berchta vient d'être définit. (message envoyé au joueur)
= bdb.admin
! Comme vous avez pu le comprendre, il faut sélectionner une zone à l'aide de la hache de WorldEdit.

/bdb stop
* L'évènement Bûtin des Berchta vient d'être stoppé par un Administrateur. (message envoyé à tout le serveur)
* L'évènement est déjà arrêté. (message envoyé au joueur)
= bdb.admin
! Permet d'arrêter l'évènement de manière forcée. L'évènement ne pourra plus reprendre sauf en le ré-activant manuellement.

/bdb start
* L'évènement Bûtin des Berchta vient d'être relancé par un Administrateur. (message envoyé à tout le serveur)
* L'évènement est déjà lancé. (message envoyé au joueur)
= bdb.admin
! Permet de lancé l'évènement de manière forcée. L'évènement pourra être arrêtée de force ou quand la limite de joueurs sera trop faible.

Messages:

L'évènement Bûtin des Berchta vient d'être arrêté car le nombre de joueurs est trop faible. (message envoyé à tout le serveur)
L'évènement Bûtin des Berchta vient de reprendre car le nombre de joueur est suffisant. (message envoyé à tout le serveur)

Tu viens de gagner 1 pépite d'or nommé "X" car tu as capturé pendant 30 secondes le Bûtin des Berchta (message envoyé au joueur)

Autres:

Faites en sorte de la création de 2 crafts:

Le premier serait d'avoir 9 pépites d'ors nommé "1" à mettre dans la table de craft pour créer un lingot d'or nommé "2"
Le second serait d'avoir 9 lingots d'or nommé "2" pour créer un mycellium enchanté nomme "3"

Configuration:

1- Tout les messages doivent être configurables

2- La limite de joueur pour que l'évènement s'arrête/se lance [Par défaut le nombre de connectés est de 50]

3- Le nom d'une pépite d'or nommé "1" (on peut également ajouter un lore) [Par défaut le nom est "1"]

4- Le nom d'un lingot d'or nommé "2" (on peut également ajouter un lore) [Par défaut le nom est "2"]

5- Le nom d'un mycelium enchanté nommé "3" (on peut également ajouter un lore) [Par défaut le nom est "3"]

6- Le temps de capture pour avoir uné pépite d'or nommée "1" [Par défaut 30 secondes] 
```

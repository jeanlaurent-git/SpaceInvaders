# Space Invaders 

**Space Invaders** est un jeu de tir spatial fixe en deux dimensions (**2D**).
Le joueur contrôle un **vaisseau spatial** muni d'un canon laser qu'il peut déplacer *horizontalement*, au *bas de l'écran*.
Dans les airs, des rangées d'aliens (**ennemis**) se déplacent latéralement tout en se rapprochant progressivement du sol et en lançant des **missiles**.
L'objectif est de détruire avec le canon laser les vagues ennemies, *qui se composent de cinq rangées de onze aliens chacune*, avant qu'elles n'atteignent le bas de l'écran.
Le joueur gagne des *points* à chaque fois qu'il détruit un envahisseur.
Le jeu n'autorise qu'**un tir à la fois** et permet d'annuler ceux des ennemis en tirant dessus.
La **vitesse** et la *musique* s'accélèrent au fur et à mesure que le nombre d'aliens diminue.
L'élimination totale de ces derniers amène une *nouvelle vague ennemie plus difficile*, et ce **indéfiniment**.
Le jeu ne se termine que lorsque le joueur perd, ce qui en fait le *premier jeu sans fin*.
Les aliens tentent de détruire le canon en tirant dessus pendant qu'ils s'approchent du bas de l'écran.
S'ils l'atteignent ou arrivent jusqu'au sol, ils ont réussi leur invasion et le jeu est fini.
De temps en temps, un vaisseau spatial apparait tout en haut de l'écran et fait gagner des *points bonus* s'il est détruit. 
Quatre bâtiments destructibles permettent au joueur de se protéger des tirs ennemis.
Ces défenses se désintègrent progressivement sous l'effet des projectiles adverses et de ceux du joueur.
*Le nombre de bâtiments n'est pas le même d'une version à l'autre.*

## Sommaire
- [Semaine n°1 : du 23 au 27 février](#Semaine1)
    * [Fonctionnalité n°1](#Fonctionnalite1)
- [Semaine n°2 : du 30 février au 3 avril](#Semaine2)
    * [Fonctionnalité n°2](#Fonctionnalite2)
    * [Implémentation moteur graphique](#MoteurGraphique)
    * [Fonctionnalité n°3](#Fonctionnalite3)
- [Semaine n°3 : du 6 au 10 avril](#Semaine3)
    * [Fonctionnalité n°4](#Fonctionnalite4)
    * [Fonctionnalité n°5](#Fonctionnalite5)
- [Semaine n°4 : du 13 au 17 avril](#Semaine4)
    * [Fonctionnalité n°6](#Fonctionnalite6)
    * [Fonctionnalité n°7](#Fonctionnalite7)
    * [Fonctionnalité n°8](#Fonctionnalite8)
- [Semaine n°5 : du 20 au 24 avril](#Semaine5)
    * [Fonctionnalité n°9](#Fonctionnalite9)
    * [Fonctionnalité n°10](#Fonctionnalite10)
    * [Fonctionnalité n°11](#Fonctionnalite11)
- [Glossaire](#Glossaire)
- [Annexes](#Annexes)


## Semaine n°1 : du 23 au 27 février<div id="Semaine1"></div>


### Sprints et fonctionnalités réalisées 
<div id="Fonctionnalite1"></div>

#### Fonctionnalité n°1 : Déplacer le vaisseau dans l'espace de jeu (:white_check_mark:)


- **Story n°1.1** : Créer un espace de jeu.  
Un espace de jeu est créé aux dimensions données (2D). 
Cet espace de jeu est vide. 


- **Story n°1.2** : Positionner un nouveau vaisseau dans l’espace de jeu.  
Un nouveau vaisseau est créé. 
Le vaisseau est positionné aux coordonnées transmises. 
Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception devra être levée. 
 Contraintes : 
La position souhaitée est transmise par ses coordonnées x et y. 
Le coin supérieur gauche de l’espace jeu (point en haut à gauche) a pour coordonnées (0,0). 
La taille du vaisseau est réduite pour l'instant à son minimum (1 seul point). 


- **Story n°1.3** : Déplacer le vaisseau vers la droite dans l'espace de jeu.  
Le vaisseau se déplace d'un pas vers la droite.
Si le vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile.


- **Story n°1.4** : Déplacer le vaisseau vers la gauche dans l'espace de jeu.  
Le vaisseau se déplace d'un pas vers la gauche.
Si le vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile.


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalité 1)*

![Diagrammes de classes de la fonctionnalité n°1](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%201.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalité 1)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](ressources/JavaBlacklist.txt) tous les deux fournis par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°1](ressources/Captures/spaceinvaders%20cloud%20capture%201.png)


### Difficultés rencontrées  
Aucune

### Remarques diverses  
Pour pouvoir, mettre en place les tests, il a été nécessaire d’ajouter une fonctionnalité supplémentaire qui permet de représenter l’espace de jeu dans une chaîne ASCII.


-------------


## Semaine n°2 : du 30 février au 3 avril<div id="Semaine2"></div>


### Sprints et fonctionnalités réalisées 
<div id="Fonctionnalite2"></div>

#### Fonctionnalité n°2 : Dimensionner le vaisseau (:white_check_mark:)


- **Story n°2.1** : Positionner un nouveau vaisseau avec une dimension donnée.  
Un nouveau vaisseau est créé aux dimensions données (2D).
Ce vaisseau est positionné aux coordonnées transmises.


- **Story n°2.2** : Faire en sorte qu'il soit impossible de positionner un nouveau vaisseau qui déborde de l'espace de jeu.  
Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception est levée.
Si une partie du vaisseau créé est en dehors des limites de l'espace de jeu, alors une exception est levée.
 Contraintes :
La position souhaitée est transmise par ses coordonnées x et y.
Le coin inférieur gauche du vaisseau correspond a l'origine du vaisseau.


- **Story n°2.3** : Déplacer un vaisseau vers la droite en tenant compte de sa dimension.  
Le vaisseau se déplace d'un pas vers la droite. 
Refactoring de la Story 1.3 en prenant en compte la largeur du vaisseau. 
Si le bord droit du vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile.


- **Story n°2.4** : Déplacer un vaisseau vers la droite en tenant compte de sa dimension.  
Le vaisseau se déplace d'un pas vers la gauche. 
Refactoring de la Story 1.4 en prenant en compte la largeur du vaisseau. 
Si le bord gauche du vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile.


- **Story n°2.5** : Refactoring.  
Création des classes `Position` et `Dimension`.
Implémentation de ces classes dans les classes `SpaceInvaders` et `Vaisseau`.

<div id="MoteurGraphique"></div>

#### Implémentation du moteur graphique Zeldiablo
<div id="Fonctionnalite3"></div>

#### Fonctionnalité n°3 : Choisir la vitesse du vaisseau (:white_check_mark:)


- **Story n°3.1** : Comprendre ce qu'est la vitesse dans notre application et faire un choix de conception.  
Ajout de la définition de la vitesse au [glossaire](#Glossaire). 


- **Story n°3.2** : Ajouter la `vitesse` au `Vaisseau` sans régression de comportement.  
Implémentation d'un attribut `vitesse` dans la classe `Vaisseau`. 
Refactoring des méthodes de la classe pour implémenter la vitesse. 


- **Story n°3.3** : Régler la vitesse du vaisseau.  
Création d'un nouveau constructeur en surcharge de la classe `Vaisseau` qui a la signature : `Vaisseau(Dimension, Position, int)`. 


- **Story n°3.4** : Faire en sorte que le déplacement se fasse *correctement* pour une vitesse quelconque.  
Refactoring de la méthode `positionnerUnNouveauVaisseau` de la classe `SpaceInvaders` pour ajouter la vitesse à sa signature.
refactoring de la classe `SpaceInvadersTest` pour inclure la vitesse dans tous les tests.


- **Story n°3.5** : Refactoring.  
Refactoring de la méthode `initialiserJeu` de la classe `SpaceInvaders`. 
Implémentation de la constante `VAISSEAU_VITESSE` dans la classe `Constante`


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalités 2 et 3)*

![Diagrammes de classes de la fonctionnalité n°2](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%202.PNG)

![Diagrammes de classes de la fonctionnalité n°3](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%203.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 2 et 3)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](ressources/JavaBlacklist.txt) tous les deux fournis par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°2](ressources/Captures/spaceinvaders%20cloud%20capture%202.png)

![Nuage de mots de la fonctionnalité n°3](ressources/Captures/spaceinvaders%20cloud%20capture%203.png)


### Difficultés rencontrées 
Aucune

### Remarques diverses
Pour pouvoir mettre en place le moteur graphique, il a été nécessaire d'implémenter une API dans notre code. Le moteur graphique se trouve dans le package ``fr.unilim.iut.spaceinvaders.moteurjeu``. On considère ce code comme élaboré en **TDD**.


-------------


## Semaine n°3 : du 6 au 10 avril<div id="Semaine3"></div>


### Sprints et fonctionnalités réalisées 
<div id="Fonctionnalite4"></div>

#### Fonctionnalité n°4 : Tirer un missile depuis le vaisseau (:white_check_mark:)


- **Story n°4.1** : Comprendre ce qu'est un missile et refactorer.  
Création d'une superclasse `Sprite`. 
Ajout des termes en lien avec le sprite au [glossaire](#Glossaire). 
Refactoring des classes `Vaisseau` et `Sprite`.


- **Story n°4.2** : Comprendre ce que signifie *tirer un missile depuis le vaisseau*.  
Analyse de la fonctionnalité grâce au diagramme de séquence disponible [ici](https://github.com/iblasquez/tdd_spaceInvaders/blob/master/enonces/images/DiagSeq_S4_TirerUnMissile.png)


- **Story n°4.3** : Tirer un missile.  
Un nouveau missile est créé.  
Il se positionne au-dessus et centré par rapport au vaisseau.  
Le joueur ne peut créer qu'un missile à la fois. Tant qu'il y en a un dans l'espace de jeu, il ne peut s'en créer de nouveau.  
Le missile créé ne peut dépasser la largeur du vaisseau (simple logique) et il ne peut pas non plus dépasser la hauteur de l'espace de jeu, sinon une exception est levée.  
Création d'une classe de tests `VaisseauTest`. 


- **Story n°4.4** : Faire déplacer le missile à la verticale de manière autonome.  
Création d'une énumération `Direction` permettant de réorganiser la disposition de l'espace de jeu.  
Refactoring de la classe Sprite.  
Refactoring de la méthode `deplacerMissile` afin qu'elle lève une exception si le missile touche le haut de l'espace de jeu.
<div id="Fonctionnalite5"></div>

#### Fonctionnalité n°5 : Ajouter un envahisseur dans le jeu (:white_check_mark:)


- **Story n°5.1** : Créer un envahisseur.  
Création de la classe `Envahisseur` qui hérite de la classe `Sprite`.  
Ajout d'un attribut envahisseur à la classe `SpaceInvaders`.  


- **Story n°5.2** : Positionner un nouvel envahisseur sur l'espace de jeu.  
Un nouvel envahisseur est créé aux dimensions et a la position donnée.  
S'il est positionné, *complètement ou partiellement* a l'exterieur de l'espace de jeu, une exception est levée.  
Le coin inférieur gauche correspond a l'origine de l'envahisseur car c'est un sprite.  


- **Story n°5.3** : Déplacer le nouvel envahisseur sur l'espace de jeu (*à droite et a gauche*).  
Comme pour le vaisseau, le vaisseau reste immobile s'il est au bord de l'espace de jeu (à droite et a gauche).  


- **Story n°5.4** : Faire en sorte que l'envahisseur fasse des aller-retours entre la droite et la gauche.  
Implémentation d'une nouvelle méthode `void deplacerEnvahisseur()` qui vérifie si l'envahisseur se trouve sur un bord ou pas et qui change sa direction si besoin.  


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalités 4 et 5)*

![Diagrammes de classes de la fonctionnalité n°4](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%204.PNG)

![Diagrammes de classes de la fonctionnalité n°5](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%205.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 4 et 5)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](ressources/JavaBlacklist.txt) tous les deux fournis  par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°4](ressources/Captures/spaceinvaders%20cloud%20capture%204.png)

![Nuage de mots de la fonctionnalité n°5](ressources/Captures/spaceinvaders%20cloud%20capture%205.png)


### Difficultés rencontrées 
Détection du missile en haut de l'espace de jeu à cause des axes inversés.

### Remarques diverses
Refactoring de la classe `DessinSpaceInvaders` pour ajouter le missile et ajout des constantes `MISSILE_LONGUEUR`, `MISSILE_HAUTEUR` et `MISSILE_VITESSE` à la classe `Constantes`.  
Refactoring de la classe `DessinSpaceInvaders` pour ajouter l'envahisseur et ajout des constantes `ENVAHISSEUR_LONGUEUR`, `ENVAHISSEUR_HAUTEUR` et `ENVAHISSEUR_VITESSE` à la classe `Constantes`.  


-------------


## Semaine n°4 : du 13 au 17 avril<div id="Semaine4"></div>


### Sprints et fonctionnalités réalisées 
<div id="Fonctionnalite6"></div>

#### Fonctionnalité n°6 : Détecter une collision entre deux sprites (:white_check_mark:)


- **Story n°6.1** : Comprendre ce qu'est une collision.  
Création d'une classe `Collision` avec une méthode `detecterCollision`.  
Ajout du terme 'Collision' au [glossaire](#Glossaire).   
Refactoring de la classe `SpaceInvaders`. 


- **Story n°6.2** : Imaginer des situations à tester.  
La collision peut s'effectuer par les 4 cotés car on considère les sprites comme des rectangles.


- **Story n°6.3** : Comprendre ce que l'on considère comme une collision.  
Création des différents tests dans la classe de test `CollisionTest` à partir des exemples de la **story 6.2**:
    - collision par le bas
    - collision par le haut
    - collision par la droite
    - collision par la gauche


- **Story n°6.4** : Implémentation des nouveautés au moteur graphique.  
Ajout dans la méthode `evoluer()` d'une nouvelle condition pour vérifier les collisions.
<div id="Fonctionnalite7"></div>

#### Fonctionnalité n°7 : Terminer la partie (:white_check_mark:)


- **Story n°7.1** : Réfléchir à ce l'on considère comme la fin de partie.  
On considère ici que la partie est terminée lorsqu'un missile percute l'envahisseur.  
Ajout du terme 'Fin de partie' au [glossaire](#Glossaire).  


- **Story n°7.2** : Tests
Implémentations de tests pour vérifier la fin de la partie.


- **Story n°7.2** : Implémenter la fin de partie.
Refactoring de la fin de partie dans la méthode `evoluer()`.
<div id="Fonctionnalite8"></div>

#### Fonctionnalité n°8 : Plusieurs missiles (:white_check_mark:)


- **Story n°8.1** : Refactoring de la classe SpaceInvaders.  
L'attribut `missile` de la classe `SpaceInvaders` devient donc une liste d'objets de la classe `Missile`.  
La classe `DessinSpaceInvaders` implémente maintenant les changements du type.  
Une méthode `void supprimerMissilesHorsDeEspaceDeJeu()` est créée pour supprimer LES missiles hors de l'espace de jeu.  
 
 
- **Story n°8.2** : Tests.  
Mise en place de tests pour vérifier que deux missiles ne se chevauchent pas.


- **Story n°8.2** : Éviter que deux missiles se chevauchent.  
Création d'une constante `TEMPS_ENTRE_DEUX_MISSILES` qui instaure un cooldown entre deux tirs.  
Implémentation du cooldown dans la méthode `void tirerUnMissileDepuisLeVaisseau(Dimension, int)` avec l'instruction
`System.currentTimeMillis()` qui mesure le cooldown.


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalités 6, 7 et 8)*

![Diagrammes de classes de la fonctionnalité n°6](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%206.PNG)

![Diagrammes de classes de la fonctionnalité n°7](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%207.PNG)

![Diagrammes de classes de la fonctionnalité n°7](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%208.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 6, 7 et 8)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](ressources/JavaBlacklist.txt) tous les deux fournis  par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°6](ressources/Captures/spaceinvaders%20cloud%20capture%206.png)

![Nuage de mots de la fonctionnalité n°7](ressources/Captures/spaceinvaders%20cloud%20capture%207.png)

![Nuage de mots de la fonctionnalité n°7](ressources/Captures/spaceinvaders%20cloud%20capture%208.png)


### Difficultés rencontrées 
Detection de la collision entre deux sprites par manque d'indications.  
Implémentation de la Liste de missiles.  


### Remarques diverses
aucune.


-------------


## Semaine n°5 : du 20 au 24 avril<div id="Semaine5"></div>


### Sprints et fonctionnalités réalisées 
<div id="Fonctionnalite9"></div>

#### Fonctionnalité n°9 : Envoyer une ligne d'envahisseurs (:white_check_mark:)


- **Story n°9.1** : Déterminer ce qu'est une ligne d'envahisseurs.  
Une ligne d'envahisseurs correspond a l'ajout sur l'axe horizontal d'envahisseurs identiques tous séparés par une 
distance correspondant à la moitié de la longueur de l'envahisseur original.  


- **Story n°9.2** : Tests.  
Mise en place de tests qui prennent en compte la taille de la ligne d'envahisseurs.  
Tests aux limites (gauche et droite).  
Tests de demi-tour appliqué à la ligne et non a chaque envahisseur.  
Test de collision pour la suppression que de l'envahisseur touché.  


- **Story n°9.3** : Ajout de contenu.  
Transformation de l'attribut `envahisseur` en `envahisseurs` de type `Liste<Envahisseurs>`.  
Ajout de la méthode `positionnerUneNouvelleLigneEnvahisseurs(Position, Envahisseur, int)` qui ajoute une ligne 
d'envahisseurs séparés par la moitié de la longueur d'un envahisseur.  
Refactoring des méthodes des classes `SpaceInvaders` et `DessinSpaceInvaders` pour implémenter la liste d'envahisseurs.  


- **Story n°9.4** : Constantes
Ajout des constantes `ENVAHISSEUR_POSITION_X`, `ENVAHISSEUR_POSITION_Y` et `ENVHISSEUR_PARLIGNE`  
<div id="Fonctionnalite10"></div>

#### Fonctionnalité n°10 : Ajouter le score (:white_check_mark:)


- **Story n°10.1** : Reflexion.  
Le score est augmenté de 20 a chaque fois qu'un envahisseur est tué.  
La valeur de 20 a été choisie pour avoir une marge plus grande pour choisir les points à attribuer au joueur quand il tirera sur les missiles ennemis ou autres.


- **Story n°10.2** : Tests.  
Ajout d'un test qui vérifie que le sore augmente bien de 20 quand un missile percute un ennemi.  


- **Story n°10.3** : Ajouts.  
Ajout d'un attribut `score` à la classe `SpaceInvaders` qui est mis a 0 lors de la création du jeu.  


- **Story n°10.4** : Refactoring.  
Révision de la classe `DessinSpaceInvaders` pour ajouter l'affichage du score en haut à gauche.  
<div id="Fonctionnalite11"></div>

#### Fonctionnalité n°11 : Les ennemis tirent des missiles aléatoirement (:white_check_mark:)


- **Story n°11.1** : Reflexion.  
Les missiles tirent aléatoirement donc il faut implémenter une valeur aléatoire.  
Si un missile touche le vaisseau, la partie se termine.  
Il faut donc penser que si on tue tous les envahisseurs, il ne faut pas gagner le jeu, mais rajouter des envahisseurs 
au jeu pour le rendre infini.


- **Story n°11.2** : Tests.  
Ajout de tests pour vérifier la position des missiles à leur création.  
Ajout de tests pour vérifier le positionnement de la ligne d'envahisseurs à sa création car non fait à la fonctionnalité précédente.  


- **Story n°11.3** : Ajouts.  
Ajout de 2 classes : `MissileEnvahisseur` et `MissileVaisseau` qui héritent toutes les deux de la classe `Missile`.
Ces 2 nouvelles classes sont indispensables à mon sens pour différencier les missiles afin que dans le futur quand on 
implémentera plusieurs lignes d'envahisseurs les envahisseurs ne se tirent pas les uns sur les autres.  
On ajoute les méthodes nécessaires au tir de missiles depuis un ennemi dans la classe `SpaceInvaders`.  
On ajoute aussi à la classe `DessinSpaceInvaders` une méthode pour dessiner les missiles ennemis d'une couleur différente des missiles alliés.  
On modifie aussi les méthodes de la classe `Personnage` pour introduire le tir des ennemis.  


- **Story n°11.4** : Refactoring.  
Refactoring de la classe `SpaceInvaders` pour simplifier les méthodes notamment la méthode `evoluer` dont on a extrait des méthodes.  
Refactoring des classes de test pour être à jour avec les dernières modifications de refactoring pour ne plus utiliser la méthode `evoluer`.  
Refactoring du glossaire pour correspondre aux fonctionnalités actuelles.  


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalités 9, 10 et 11)*

![Diagrammes de classes de la fonctionnalité n°9](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%209.PNG)

![Diagrammes de classes de la fonctionnalité n°10](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%2010.PNG)

![Diagrammes de classes de la fonctionnalité n°11](ressources/Captures/spaceinvaders%20diagramme%20de%20classe%20capture%2011.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 9, 10 et 11)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](ressources/JavaBlacklist.txt) tous les deux fournis par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°9](ressources/Captures/spaceinvaders%20cloud%20capture%209.png)

![Nuage de mots de la fonctionnalité n°10](ressources/Captures/spaceinvaders%20cloud%20capture%2010.png)

![Nuage de mots de la fonctionnalité n°11](ressources/Captures/spaceinvaders%20cloud%20capture%2011.png)

### Difficultés rencontrées  
Aucune

### Remarques diverses  
Aucune


-------------


## Glossaire<div id="Glossaire"></div>

* **Vaisseau** : Véhicule commandé par le joueur, pouvant se déplacer de droite à gauche et ayant la possibilité de lancer des missiles destinés à détruire le(s) envahisseurs.

* **Envahisseur** : Ennemi qui apparaît à l'écran, se déplace automatiquement de droite à gauche et qui doit être détruit par un missile lancé depuis le vaisseau du joueur. Il tire des missiles aléatoirement.

* **Missile** : Projectile envoyé à la verticale par le vaisseau vers l'envahisseur dans le but de le détruire. Mais aussi depuis un envahisseur verticalement vers le bas de l'ecran dans le but de détruire le vaisseau.  

* **Immobile** : Aucun déplacement, aucune exception levée : le sprite reste juste à sa position actuelle.

* **Vitesse** : Grandeur physique associée aux différents sprites. Elle correspond à la distance parcourue au cours d'un déplacement.

* **Personnage** : Être fictif et virtuel, contrôlé ou non par le joueur, qui apparaît dans un jeu vidéo.

* **Sprite** : Élément graphique qui peut se déplacer sur l'ecran. Identifie les personnages et les objets qui se superposent au fond d'ecran et qui se déplacent.

* **Collision** : Une collision est détectée lorsqu'un sprite est placé à la meme place su'un autre sprite.

* **Fin de partie** : La fin de partie correspond à la collision entre un missile de l'envahisseur et le vaisseau.

* **Cooldown** : Terme correspondant au temps minimal entre deux actions.

* :x: : Fonctionnalité non ou partiellement implémentée.

* :white_check_mark: : Fonctionnalité implémentée complètement.  


------------- 


## Annexes<div id="Annexes"></div>

- [JavaBlacklist.txt](ressources/JavaBlacklist.txt)  
- [Ressources graphiques](ressources/Captures)
- [Consignes](https://github.com/iblasquez/tdd_SpaceInvaders)


-------------


> Créé par [**Jean Laurent**](https://github.com/jeanlrnt) en première année de DUT Informatique à Limoges *pendant l'année universitaire 2019-2020*. Projet proposé par [Isabelle Blasquez](https://github.com/iblasquez).  

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
- [Glossaire](#Glossaire)


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

![Diagrammes de classes de la fonctionnalité n°1](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%201.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalité 1)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/JavaBlacklist.txt) tous les deux fournis par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°1](Captures/spaceinvaders%20cloud%20capture%201.png)


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
Le coin inferieur gauche du vaisseau correspond a l'origine du vaisseau.


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

#### Implémentation du moteur graphique Spique
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

![Diagrammes de classes de la fonctionnalité n°2](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%202.PNG)

![Diagrammes de classes de la fonctionnalité n°3](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%203.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 2 et 3)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/JavaBlacklist.txt) tous les deux fournis par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°2](Captures/spaceinvaders%20cloud%20capture%202.png)

![Nuage de mots de la fonctionnalité n°3](Captures/spaceinvaders%20cloud%20capture%203.png)


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
Il se positionne au dessus et centré par rapport au vaisseau.  
Le joueur ne peut créer qu'un missile à la fois. Tant qu'il y en a un dans l'espace de jeu, il ne peut s'en créer de nouveau.  
Le missile créé ne peut dépasser la largeur du vaisseau (simple logique) et il ne peut pas non plus dépasser la hauteur de l'espace de jeu, sinon une exception est levée.  
Création d'une classe de tests `VaisseauTest`. 


- **Story n°4.4** : Faire déplacer le missile à la verticale de manière autonome.  
Création d'une énumération `Direction` permettant de réorganiser la disposition de l'espace de jeu.  
Refactoring de la classe Sprite.  
Refactoring de la méthode `deplacerMissile` afin qu'elle lève une exception si le missile touche le haut de l'espace de jeu.
<div id="Fonctionnalite5"></div>

#### Fonctionnalité n°5 : Ajouter un envahisseur dans le jeu (:white_check_mark:)


- **Story n°5.1** : Créer un envhisseur.  
Création de la classe `Envahisseur` qui hérite de la classe `Sprite`.  
Ajout d'un attribut envahisseur à la classe `SpaceInvaders`.  


- **Story n°5.2** : Positionner un nouvel envahisseur sur l'espace de jeu.  
Un nouvel envahisseur est créé aux dimensions et a la position donnée.  
S'il est positionné, *complètement ou partiellement* a l'exterieur de l'espace de jeu, une exception est levée.  
Le coin inferieur gauche correspond a l'origine de l'envahisseur car c'est un sprite.  


- **Story n°5.3** : Déplacer le nouvel envahisseur sur l'espace de jeu (*à droite et a gauche*).  
Comme pour le vaisseau, le vaisseau reste immobile si il est au bord de l'espace de jeu (à droite et a gauche).  


- **Story n°5.4** : Faire en sorte que l'envahisseur fasse des aller-retours entre la droite et la gauche.  
Implémentation d'une nouvelle méthode `void deplacerEnvahisseur()` qui vérifie si l'envahisseur se trouve sur un bord ou pas et qui change sa direction si besoin.  


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalités 4 et 5)*

![Diagrammes de classes de la fonctionnalité n°4](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%204.PNG)

![Diagrammes de classes de la fonctionnalité n°5](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%205.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 4 et 5)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/JavaBlacklist.txt) tous les deux fournis  par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°4](Captures/spaceinvaders%20cloud%20capture%204.png)

![Nuage de mots de la fonctionnalité n°5](Captures/spaceinvaders%20cloud%20capture%205.png)


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


- **Story n°6.2** : Imaginer des situations a tester.  
La collision peut s'effectuer par les 4 cotés car on considère les sprites comme des rectangles.


- **Story n°6.3** : Comprendre ce que l'on considère comme une collision.  
Création des différents tests dans la classe de test `CollisionTest` a partir des exemples de la **story 6.2**:
    - collision par le bas;
    - collision par le haut;
    - collision par la droite;
    - collision par la gauche;


- **Story n°6.4** : Implémentation des nouveautés au moteur graphique.  
Ajout dans la méthode `evoluer()` d'une nouvelle condition pour vérifier les collisions.
<div id="Fonctionnalite7"></div>

#### Fonctionnalité n°7 : Terminer la partie (:x:)


- **Story n°7.1** : Reflechir à ce l'on considere comme la fin de partie.  
On considère ici que la partie est terminée lorsqu'un missile percute l'envahisseur.  
Ajout du terme 'Fin de partie' au [glossaire](#Glossaire).  


- **Story n°7.2** : Implémenter la fin de partie.
Refactorer la fin de partie dans la méthode `evoluer()`.


### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes *(Fonctionnalités 6 et 7)*

![Diagrammes de classes de la fonctionnalité n°6](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%206.PNG)

![Diagrammes de classes de la fonctionnalité n°7](Captures/spaceinvaders%20diagramme%20de%20classe%20capture%207.PNG)

### Nuage de mots du projet spaceinvaders *(Fonctionnalités 6 et 7)*
(généré à l’aide de [Source Code Word Cloud Generator](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/Word%20Cloud%20Generator.zip) avec la liste [JavaBlacklist.txt](https://github.com/iblasquez/enseignement-iut-m2104-conception/blob/master/ressources/JavaBlacklist.txt) tous les deux fournis  par [Isabelle Blasquez](https://github.com/iblasquez))
 
![Nuage de mots de la fonctionnalité n°6](Captures/spaceinvaders%20cloud%20capture%206.png)

![Nuage de mots de la fonctionnalité n°7](Captures/spaceinvaders%20cloud%20capture%207.png)


### Difficultés rencontrées 
Detection de la collision entre deux sprites par manque d'indications.


### Remarques diverses
aucune.

-------------


## Glossaire<div id="Glossaire"></div>

* **Vaisseau** : Véhicule commandé par le joueur, pouvant se déplacer de droite à gauche et ayant la possibilité de lancer des missiles destinés à détruire le(s) envahisseurs.

* **Envahisseur** : Ennemi qui apparaît à l'écran, se déplace automatiquement de droite à gauche et qui doit être détruit par un missile lancé depuis le vaisseau du joueur.

* **Missile** : Projectile envoyé à la verticale par le vaisseau vers l'envahisseur dans le but de le détruire.

* **Immobile** : Aucun déplacement, aucune exception levée : le sprite reste juste à sa position actuelle.

* **Vitesse** : Grandeur physique associée aux différents sprites. Elle correspond à la vitesse de déplacement des sprites sur l'ecran et peut varier. Elle est représentée par un entier qui correspond au nombre de pixels parcourus par le sprite à chaque demande de déplacement.

* **Personnage** : Etre fictif et virtuel, contrôlé ou non par le joueur, qui apparaît dans un jeu vidéo.

* **Sprite** : Elément graphique qui peut se deplacer sur l'ecran. Identifie les personnages et les objets qui se superposent au fond d'ecran et qui se deplassent.

* **Collision** : Une collision est détectée lorsqu'un sprite se retrouve 'à cheval' sur un autre sprite.

* **Fin de partie** : La fin de partie correspond à la collision entre deux sprites.

------------- 

> Créé par [**Jean Laurent**](https://github.com/jeanlrnt) en première année de DUT Informatique à Limoges. Projet proposé par [Isabelle Blasquez](https://github.com/iblasquez).

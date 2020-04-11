package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvaders implements Jeu {

    int longueur;
    int hauteur;
    Vaisseau vaisseau;
    List<Missile> missiles;
    long timerMissile;
    List<Envahisseur> envahisseurs;
    boolean partieFinie;

    public SpaceInvaders(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.missiles = new ArrayList<>();
        this.envahisseurs = new ArrayList<>();
    }


    public void initialiserJeu() {
        this.partieFinie = false;

        Position positionVaisseau = new Position(Constante.ESPACE_JEU_LONGUEUR / 2, Constante.ESPACE_JEU_HAUTEUR - 1);
        Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
        Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
        Position positioEnvahisseur = new Position(Constante.ENVAHISSEUR_POSITION_X, Constante.ENVAHISSEUR_POSITION_Y);

        Envahisseur envahisseur = new Envahisseur(dimensionEnvahisseur, positioEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
        positionnerUnNouveauPersonnage(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE, true);
        positionnerUneNouvelleLigneEnvahisseurs(positioEnvahisseur, envahisseur, Constante.ENVAHISSEUR_PARLIGNE);
    }

    public String recupererEspaceJeuDansChaineASCII() {
        StringBuilder espaceDeJeu = new StringBuilder();

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < longueur; x++) {
                espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
            }
            espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
    }

    private char recupererMarqueDeLaPosition(int x, int y) {
        char marque;

        if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_VAISSEAU;
        else if (this.aUnMissileQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_MISSILE;
        else if (this.aUnEnvahisseurQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_ENVAHISSEUR;
        else marque = Constante.MARQUE_VIDE;
        return marque;
    }

    public boolean aUnVaisseau() {
        return vaisseau != null;
    }

    public boolean aDesEnvahisseurs() {
        return !this.envahisseurs.isEmpty();
    }

    public boolean aDesMissiles() {
        return !this.missiles.isEmpty();
    }

    public void positionnerUnNouveauPersonnage(Dimension dimension, Position position, int vitesse, boolean estUnVaisseau) {
        int x = position.abscisse();
        int y = position.ordonnee();

        if (estHorsEspaceJeu(x, y))
            throw new HorsEspaceJeuException("La position du personnage est en dehors de l'espace jeu");

        int longueurPersonnage = dimension.longueur();
        int hauteurPersonnage = dimension.hauteur();

        if (estHorsEspaceJeu(x + longueurPersonnage - 1, y))
            throw new DebordementEspaceJeuException(
                    "Le personnage déborde de l'espace jeu vers la droite à cause de sa longueur");
        if (estHorsEspaceJeu(x, y - hauteurPersonnage + 1))
            throw new DebordementEspaceJeuException(
                    "Le personnage déborde de l'espace jeu vers le bas à cause de sa hauteur");

        if (!estUnVaisseau) this.envahisseurs.add(new Envahisseur(dimension, position, vitesse));
        else this.vaisseau = new Vaisseau(dimension, position, vitesse);
    }

    public void positionnerUneNouvelleLigneEnvahisseurs(Position position, Envahisseur envahisseur, int nombreEnvahisseurs) {
        int x = position.abscisse();
        int y = position.ordonnee();

        int longueurEnvahisseur = envahisseur.dimension.longueur();
        int hauteurEnvahisseur = envahisseur.dimension.hauteur();
        int espaceInterEnvahisseur = longueurEnvahisseur / 2;
        int longueurLigneEnvahisseurs;
        if (nombreEnvahisseurs > 1) {
            longueurLigneEnvahisseurs = nombreEnvahisseurs * longueurEnvahisseur + (nombreEnvahisseurs - 1) * espaceInterEnvahisseur;
        } else {
            longueurLigneEnvahisseurs = longueurEnvahisseur;
        }

        if (estHorsEspaceJeu(x, y))
            throw new HorsEspaceJeuException("La position de la ligne d'envahisseurs est en dehors de l'espace jeu");

        if (estHorsEspaceJeu(x + longueurLigneEnvahisseurs - 1, y))
            throw new DebordementEspaceJeuException(
                    "La ligne d'envahisseurs déborde de l'espace jeu vers la droite à cause de sa longueur");
        if (estHorsEspaceJeu(x, y - hauteurEnvahisseur + 1))
            throw new DebordementEspaceJeuException(
                    "La ligne d'envahisseurs déborde de l'espace jeu vers le bas à cause de sa hauteur");

        int vitesse = envahisseur.vitesse;
        int positionX = x;
        this.envahisseurs.add(new Envahisseur(envahisseur.dimension, new Position(positionX, y), vitesse));
        for (int i = 0; i < nombreEnvahisseurs - 1; i++) {
            positionX += espaceInterEnvahisseur + longueurEnvahisseur;
            this.envahisseurs.add(new Envahisseur(envahisseur.dimension, new Position(positionX, y), vitesse));
        }

    }

    private boolean estHorsEspaceJeu(int x, int y) {
        return ((x < 0) || (x >= longueur)) || ((y < 0) || (y >= hauteur));
    }

    public void deplacerVaisseauVersLaDroite() {
        if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
            vaisseau.deplacerHorizontalementVers(Direction.DROITE);
            if (estHorsEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
                vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
            }
        }
    }

    public void deplacerVaisseauVersLaGauche() {
        if (0 < vaisseau.abscisseLaPlusAGauche()) {
            vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
            if (estHorsEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
                vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
            }
        }
    }

    public void deplacerMissile(Direction direction) {

        for (Missile missile : this.missiles) {
            missile.deplacerVerticalementVers(direction);
        }

        supprimerMissilesHorsDeEspaceDeJeu();
    }

    public void deplacerEnvahisseurs() {
        if (Direction.DROITE.equals(envahisseurs.get(0).getDirection()) && envahisseurs.get(envahisseurs.size() - 1).abscisseLaPlusADroite() >= longueur - 1)
            envahisseurs.get(0).setDirection(Direction.GAUCHE);
        if (Direction.GAUCHE.equals(envahisseurs.get(0).getDirection()) && envahisseurs.get(0).abscisseLaPlusAGauche() <= 0)
            envahisseurs.get(0).setDirection(Direction.DROITE);
        for (Envahisseur envahisseur : this.envahisseurs) {
            envahisseur.deplacerHorizontalementVers(envahisseurs.get(0).getDirection());
        }
    }

    public void supprimerMissilesHorsDeEspaceDeJeu() {
        boolean continuerLaRecherche;

        do {
            continuerLaRecherche = false;
            for (Missile missile : this.missiles) {
                if (missile.ordonneeLaPlusHaute() <= 0) {
                    this.missiles.remove(missile);
                    continuerLaRecherche = true;
                    break;
                }
            }
        } while (continuerLaRecherche);
    }

    private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
        if (this.aDesEnvahisseurs()) {
            for (Envahisseur envahisseur : this.envahisseurs) {
                if (envahisseur.occupeLaPosition(x, y))
                    return true;
            }
        }
        return false;
    }


    private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
        if (this.aDesMissiles()) {
            for (Missile missile : this.missiles) {
                if (missile.occupeLaPosition(x, y))
                    return true;
            }
        }
        return false;
    }

    private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
        return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
    }

    @Override
    public void evoluer(Commande commandeUtilisateur) {
        if (null != commandeUtilisateur) {
            if (commandeUtilisateur.gauche) {
                this.deplacerVaisseauVersLaGauche();
            }

            if (commandeUtilisateur.droite) {
                this.deplacerVaisseauVersLaDroite();
            }

            if (commandeUtilisateur.tir) {
                this.tirerUnMissileDepuisLeVaisseau(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR),
                        Constante.MISSILE_VITESSE);
            }
        }

        if (this.aDesMissiles())
            this.deplacerMissile(Direction.HAUT_ECRAN);
        if (this.aDesEnvahisseurs())
            this.deplacerEnvahisseurs();


        for (int i = 0; i < this.envahisseurs.size(); i++) {
            if (this.aDesEnvahisseurs() && this.aDesMissiles() && (new Collision()).detecterCollision(envahisseurs.get(i), missiles.get(0))) {
                envahisseurs.remove(i);
                this.missiles.remove(0);
            }
        }

        if (!this.aDesEnvahisseurs()) {
            this.missiles.clear();
            this.partieFinie = true;
        }
    }

    @Override
    public boolean etreFini() {
        return this.partieFinie;
    }

    public Vaisseau recupererVaisseau() {
        return this.vaisseau;
    }

    public List<Missile> recupererMissiles() {
        return this.missiles;
    }

    public List<Envahisseur> recupererEnvahisseurs() {
        return this.envahisseurs;
    }

    public void tirerUnMissileDepuisLeVaisseau(Dimension dimensionMissile, int vitesseMissile) {

        if ((vaisseau.hauteur() + dimensionMissile.hauteur()) > this.hauteur)
            throw new MissileException(
                    "Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");

        if (System.currentTimeMillis() > this.timerMissile + Constante.TEMPS_ENTRE_DEUX_MISSILES) {
            missiles.add(this.vaisseau.tirerUnMissile(dimensionMissile, vitesseMissile, Direction.HAUT_ECRAN));
            this.timerMissile = System.currentTimeMillis();
        }
    }

}

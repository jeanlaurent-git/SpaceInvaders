package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class SpaceInvaders implements Jeu {

    int longueur;
    int hauteur;
    Vaisseau vaisseau;
    Missile missile;
    Envahisseur envahisseur;
    boolean partieFinie;

    public SpaceInvaders(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
    }


    public void initialiserJeu() {
        this.partieFinie = false;
        Position positionVaisseau = new Position(Constante.ESPACEJEU_LONGUEUR / 2, Constante.ESPACEJEU_HAUTEUR - 1);
        Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
        Position positionEnvahisseur = new Position(Constante.ESPACEJEU_LONGUEUR / 2,
                Constante.ENVAHISSEUR_HAUTEUR + this.hauteur / 100);
        Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
        positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
        positionnerUnNouveauEnvahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
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

    public boolean aUnEnvahisseur() {
        return envahisseur != null;
    }

    public boolean aUnMissile() {
        return missile != null;
    }

    public void positionnerUnNouveauEnvahisseur(Dimension dimension, Position position, int vitesse) {
        this.positionnerUnNouveauEnvahisseur(dimension, position, vitesse, Direction.DROITE);
    }

    public void positionnerUnNouveauEnvahisseur(Dimension dimension, Position position, int vitesse, Direction direction) {

        int x = position.abscisse();
        int y = position.ordonnee();

        if (estHorsEspaceJeu(x, y))
            throw new HorsEspaceJeuException("La position de l'envahisseur est en dehors de l'espace jeu");

        int longueurEnvahisseur = dimension.longueur();
        int hauteurEnvahisseur = dimension.hauteur();

        if (estHorsEspaceJeu(x + longueurEnvahisseur - 1, y))
            throw new DebordementEspaceJeuException(
                    "L'envahisseur déborde de l'espace jeu vers la droite à cause de sa longueur");
        if (estHorsEspaceJeu(x, y - hauteurEnvahisseur + 1))
            throw new DebordementEspaceJeuException(
                    "L'envahisseur déborde de l'espace jeu vers le bas à cause de sa hauteur");

        envahisseur = new Envahisseur(dimension, position, vitesse, direction);
    }


    public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {

        int x = position.abscisse();
        int y = position.ordonnee();

        if (estHorsEspaceJeu(x, y))
            throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

        int longueurVaisseau = dimension.longueur();
        int hauteurVaisseau = dimension.hauteur();

        if (estHorsEspaceJeu(x + longueurVaisseau - 1, y))
            throw new DebordementEspaceJeuException(
                    "Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
        if (estHorsEspaceJeu(x, y - hauteurVaisseau + 1))
            throw new DebordementEspaceJeuException(
                    "Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

        vaisseau = new Vaisseau(dimension, position, vitesse);
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

    public void deplacerMissile() {

        this.missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);

        if (this.missile.ordonneeLaPlusHaute() <= 0)
            this.missile = null;
    }

    public void deplacerEnvahisseur() {
        if(Direction.DROITE.equals(envahisseur.getDirection()) && envahisseur.abscisseLaPlusADroite() >= longueur - 1)
            envahisseur.setDirection(Direction.GAUCHE);
        if(Direction.GAUCHE.equals(envahisseur.getDirection()) && envahisseur.abscisseLaPlusAGauche() <= 0)
            envahisseur.setDirection(Direction.DROITE);
        envahisseur.deplacerHorizontalementVers(envahisseur.getDirection());
    }

    private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
        return this.aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
    }


    private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
        return this.aUnMissile() && missile.occupeLaPosition(x, y);
    }

    private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
        return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
    }

    @Override
    public void evoluer(Commande commandeUtilisateur) {
        if(null != commandeUtilisateur) {
            if (commandeUtilisateur.gauche) {
                this.deplacerVaisseauVersLaGauche();
            }

            if (commandeUtilisateur.droite) {
                this.deplacerVaisseauVersLaDroite();
            }

            if (commandeUtilisateur.tir && !this.aUnMissile()) {
                this.tirerUnMissileDepuisLeVaisseau(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR),
                        Constante.MISSILE_VITESSE);
            }
        }

        if (this.aUnMissile())
            this.deplacerMissile();
        if (this.aUnEnvahisseur())
            this.deplacerEnvahisseur();

        if (this.aUnEnvahisseur() && this.aUnMissile() && (new Collision()).detecterCollision(envahisseur, missile)) {
            this.envahisseur = null;
            this.missile = null;
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

    public Missile recupererMissile() {
        return this.missile;
    }

    public Envahisseur recupererEnvahisseur() {
        return this.envahisseur;
    }

    public void tirerUnMissileDepuisLeVaisseau(Dimension dimensionMissile, int vitesseMissile) {

        if ((vaisseau.hauteur() + dimensionMissile.hauteur()) > this.hauteur)
            throw new MissileException(
                    "Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");

        this.missile = this.vaisseau.tirerUnMissile(dimensionMissile, vitesseMissile, Direction.HAUT);
    }

}

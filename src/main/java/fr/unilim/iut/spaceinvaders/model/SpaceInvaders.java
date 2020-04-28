package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceInvaders implements Jeu {

    int longueur;
    int hauteur;
    Vaisseau vaisseau;
    List<MissileVaisseau> missilesVaisseau;
    long timerMissileAllie;
    long timerMissileEnnemi;
    List<Envahisseur> envahisseurs;
    List<MissileEnvahisseur> missilesEnvahisseurs;
    boolean partieFinie;
    int score;
    int distanceParcourue;

    public SpaceInvaders(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.missilesVaisseau = new ArrayList<>();
        this.envahisseurs = new ArrayList<>();
        this.missilesEnvahisseurs = new ArrayList<>();
        this.score = 0;
        this.distanceParcourue = 1;
    }


    public void initialiserJeu() {
        this.partieFinie = false;

        Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
        Position positionVaisseau = new Position(Constante.ESPACE_JEU_LONGUEUR / 2, Constante.ESPACE_JEU_HAUTEUR - 1);

        positionnerUnNouveauPersonnage(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE, true);
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
        else if (this.aUnMissileAllieQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_MISSILE_VAISSEAU;
        else if (this.aUnEnvahisseurQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_ENVAHISSEUR;
        else if (this.aUnMissileEnnemiQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_MISSILE_ENVAHISSEUR;
        else marque = Constante.MARQUE_VIDE;
        return marque;
    }

    public boolean aUnVaisseau() {
        return vaisseau != null;
    }

    public boolean aDesEnvahisseurs() {
        return !this.envahisseurs.isEmpty();
    }

    public boolean aDesMissilesAllie() {
        return !this.missilesVaisseau.isEmpty();
    }

    public boolean aDesMissilesEnnemi() {
        return !this.missilesEnvahisseurs.isEmpty();
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
        int longueurLigneEnvahisseurs = nombreEnvahisseurs * longueurEnvahisseur + (nombreEnvahisseurs - 1) * espaceInterEnvahisseur;

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

    private void positionnerUneNouvelleLigneEnvahisseurs() {
        Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
        Position positionEnvahisseur = new Position(Constante.ENVAHISSEUR_POSITION_X, Constante.ENVAHISSEUR_POSITION_Y);

        Envahisseur envahisseur = new Envahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
        positionnerUneNouvelleLigneEnvahisseurs(positionEnvahisseur, envahisseur, Constante.ENVAHISSEUR_PARLIGNE);
    }

    private boolean estHorsEspaceJeu(int x, int y) {
        return ((x < 0) || (x >= longueur)) || ((y < 0) || (y >= hauteur));
    }

    public void deplacerVaisseauVersLaDroite() {
        if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
            vaisseau.deplacerHorizontalementVers(Direction.DROITE);
            if (estHorsEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute()))
                vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
        }
    }

    public void deplacerVaisseauVersLaGauche() {
        if (0 < vaisseau.abscisseLaPlusAGauche()) {
            vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
            if (estHorsEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute()))
                vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
        }
    }

    public void deplacerMissile() {

        for (MissileVaisseau missile : this.missilesVaisseau)
            missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
        for (MissileEnvahisseur missile : this.missilesEnvahisseurs)
            missile.deplacerVerticalementVers(Direction.BAS_ECRAN);
        supprimerMissilesHorsDeEspaceDeJeu();
    }

    public void deplacerEnvahisseurs() {
        changerDirectionEnvahisseurADroite();
        changerDirectionEnvahisseurAGauche();

        deplacerEnvahisseursApresAllerRetour();

        for (Envahisseur envahisseur : this.envahisseurs) {
            envahisseur.deplacerHorizontalementVers(envahisseurs.get(0).getDirection());
        }
    }

    private void changerDirectionEnvahisseurAGauche () {
        for (int i = 0; i < envahisseurs.size(); i++) {
            if (Direction.GAUCHE.equals(envahisseurs.get(i).getDirection()) && envahisseurs.get(i).abscisseLaPlusAGauche() <= 0) {
                for (Envahisseur envahisseur : envahisseurs) {
                    envahisseur.setDirection(Direction.DROITE);
                }
                distanceParcourue += 1;
                break;
            }
        }
    }

    private void changerDirectionEnvahisseurADroite () {
        if (Direction.DROITE.equals(envahisseurs.get(0).getDirection()) && envahisseurs.get(envahisseurs.size() - 1).abscisseLaPlusADroite() >= longueur - 1) {
            for (Envahisseur envahisseur : envahisseurs) {
                envahisseur.setDirection(Direction.GAUCHE);
            }
            distanceParcourue += 1;
        }
    }

    private void deplacerEnvahisseursApresAllerRetour () {
        if (distanceParcourue % 3 == 0 && distanceParcourue != 0) {
            distanceParcourue += 1;
            for (int i = 0; i < envahisseurs.get(0).hauteur(); i++) {
                for (Envahisseur envahisseur : this.envahisseurs)
                    envahisseur.deplacerVerticalementVers(Direction.BAS_ECRAN);
            }
        }
    }

    public void supprimerMissilesHorsDeEspaceDeJeu() {
        supprimerMissilesVaisseauHorsEspaceDeJeu();
        supprimerMissilesEnvahisseurHorsEspaceDeJeu();
    }

    private void supprimerMissilesEnvahisseurHorsEspaceDeJeu() {
        this.missilesEnvahisseurs.removeIf(missile -> missile.ordonneeLaPlusBasse() >= this.hauteur);
    }

    private void supprimerMissilesVaisseauHorsEspaceDeJeu() {
        this.missilesVaisseau.removeIf(missile -> missile.ordonneeLaPlusHaute() <= 0);
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


    private boolean aUnMissileAllieQuiOccupeLaPosition(int x, int y) {
        if (this.aDesMissilesAllie()) {
            for (MissileVaisseau missile : this.missilesVaisseau) {
                if (missile.occupeLaPosition(x, y))
                    return true;
            }
        }
        return false;
    }

    private boolean aUnMissileEnnemiQuiOccupeLaPosition(int x, int y) {
        if (this.aDesMissilesEnnemi()) {
            for (MissileEnvahisseur missile : this.missilesEnvahisseurs) {
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

        if (!this.aDesEnvahisseurs()) {
            positionnerUneNouvelleLigneEnvahisseurs();
        }

        if (envahisseurs.get(0).origine.y >= (Constante.ENVAHISSEUR_POSITION_Y + (2 * Constante.ENVAHISSEUR_HAUTEUR))) {
            Position positionRef = new Position(Constante.ENVAHISSEUR_POSITION_X, Constante.ENVAHISSEUR_POSITION_Y);
            Position position = envahisseurs.get(0).origine;
            Dimension dimension = envahisseurs.get(0).dimension;

            if (position.x == positionRef.x && !this.aUnEnvahisseurQuiOccupeLaPosition(positionRef.x, positionRef.y)) {
                positionnerUneNouvelleLigneEnvahisseurs(positionRef, new Envahisseur(dimension, positionRef, Constante.ENVAHISSEUR_VITESSE), Constante.ENVAHISSEUR_PARLIGNE);
            }
        }

        if (commandeUtilisateur != null) {
            commandeGauche(commandeUtilisateur);
            commandeDroite(commandeUtilisateur);
            commandeTir(commandeUtilisateur);
        }

        detecterCollisionEnvahisseurMissile();
        detecterCollisionVaisseauMissile();
        detecterCollisionMissileMissile();


        if (this.aDesMissilesAllie() || this.aDesMissilesEnnemi())
            this.deplacerMissile();
        if (this.aDesEnvahisseurs()) {
            this.deplacerEnvahisseurs();
            faireTirerAleatoirementLesEnvahisseurs();
        }

    }

    private void commandeTir(Commande commandeUtilisateur) {
        if (commandeUtilisateur.tir) {
            this.tirerUnMissileDepuisLeVaisseau(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR),
                    Constante.MISSILE_VITESSE);
        }
    }

    private void commandeDroite(Commande commandeUtilisateur) {
        if (commandeUtilisateur.droite) {
            this.deplacerVaisseauVersLaDroite();
        }
    }

    private void commandeGauche(Commande commandeUtilisateur) {
        if (commandeUtilisateur.gauche) {
            this.deplacerVaisseauVersLaGauche();
        }
    }

    private void faireTirerAleatoirementLesEnvahisseurs() {
        Random random = new Random();
        this.tirerUnMissileDepuisUnEnvahisseur(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR),
                Constante.MISSILE_VITESSE, envahisseurs.get(random.nextInt(envahisseurs.size())));
    }

    public void detecterCollisionVaisseauMissile() {
        for (int i = 0; i < this.missilesEnvahisseurs.size(); i++) {
            if (this.aUnVaisseau() && this.aDesMissilesEnnemi() && (new Collision()).detecterCollision(vaisseau, missilesEnvahisseurs.get(i))) {
                vaisseau = null;
                this.partieFinie = true;
                this.missilesEnvahisseurs.remove(i);
                break;
            }
        }
    }

    public void detecterCollisionEnvahisseurMissile() {
        if (this.aDesEnvahisseurs())
        for (int i = 0; i < this.envahisseurs.size(); i++) {
            if (this.aDesMissilesAllie())
            for (int j = 0; j < this.missilesVaisseau.size(); j++) {
                if (this.aDesMissilesAllie() && this.aDesEnvahisseurs() && (new Collision()).detecterCollision(envahisseurs.get(i), missilesVaisseau.get(j))) {
                    this.augmenterScore(Constante.SCORE_DETRUIRE_ENVAHISSEUR);
                    this.missilesVaisseau.remove(j);
                    this.envahisseurs.remove(i);
                    break;
                }
            }
        }
    }

    public void detecterCollisionMissileMissile() {
        if (this.aDesMissilesAllie())
            for (int i = 0; i < this.missilesVaisseau.size(); i++) {
                if (this.aDesMissilesEnnemi())
                    for (int j = 0; j < this.missilesEnvahisseurs.size(); j++) {
                        if (this.aDesMissilesAllie() && this.aDesMissilesEnnemi() && (new Collision()).detecterCollision(missilesEnvahisseurs.get(j), missilesVaisseau.get(i))) {
                            this.augmenterScore(Constante.SCORE_DETRUIRE_MISSILE);
                            this.missilesVaisseau.remove(i);
                            this.missilesEnvahisseurs.remove(j);
                            break;
                        }
                    }
            }
    }

    @Override
    public boolean etreFini() {
        return this.partieFinie;
    }

    public void augmenterScore(int difference) {
        this.score += difference;
    }

    public int recupererScore() {
        return this.score;
    }

    public Vaisseau recupererVaisseau() {
        return this.vaisseau;
    }

    public List<MissileVaisseau> recupererMissilesVaisseau() {
        return this.missilesVaisseau;
    }

    public List<MissileEnvahisseur> recupererMissilesEnvahisseur() {
        return this.missilesEnvahisseurs;
    }

    public List<Envahisseur> recupererEnvahisseurs() {
        return this.envahisseurs;
    }

    public int recupererDistanceParcourue () {
        return distanceParcourue;
    }

    public void mettreDistanceParcourue (int valeur) {
        distanceParcourue = valeur;
    }

    public void tirerUnMissileDepuisLeVaisseau (Dimension dimensionMissile, int vitesseMissile) {

        if ((vaisseau.hauteur() + dimensionMissile.hauteur()) > this.hauteur)
            throw new MissileException(
                    "Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");

        if (System.currentTimeMillis() > this.timerMissileAllie + Constante.TEMPS_ENTRE_DEUX_MISSILES_ALLIE) {
            missilesVaisseau.add((MissileVaisseau) this.vaisseau.tirerUnMissile(dimensionMissile, vitesseMissile));
            this.timerMissileAllie = System.currentTimeMillis();
        }
    }

    public void tirerUnMissileDepuisUnEnvahisseur(Dimension dimensionMissile, int vitesseMissile, Envahisseur envahisseur) {

        if ((envahisseur.ordonneeLaPlusHaute() + dimensionMissile.hauteur()) > this.hauteur)
            throw new MissileException(
                    "Pas assez de hauteur libre entre l'envahisseur et le bas de l'espace jeu pour tirer le missile");
        else
            if (System.currentTimeMillis() > this.timerMissileEnnemi + Constante.TEMPS_ENTRE_DEUX_MISSILES_ENNEMI) {
                missilesEnvahisseurs.add((MissileEnvahisseur) envahisseur.tirerUnMissile(dimensionMissile, vitesseMissile));
                this.timerMissileEnnemi = System.currentTimeMillis();
            }
    }

}

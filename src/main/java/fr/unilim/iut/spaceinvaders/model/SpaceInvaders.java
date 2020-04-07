package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.*;

public class SpaceInvaders implements Jeu {

    int longueur;
    int hauteur;
    Vaisseau vaisseau;
    Missile missile;
    Envahisseur envahisseur;

    public SpaceInvaders(int longueur, int hauteur) {
	this.longueur = longueur;
	this.hauteur = hauteur;
    }


    public void positionnerUnNouveauEnvahisseur(Dimension dimension, Position position, int vitesse) {

	int x = position.abscisse();
	int y = position.ordonnee();

	if (!estDansEspaceJeu(x, y))
	    throw new HorsEspaceJeuException("La position de l'envahisseur est en dehors de l'espace jeu");

	int longueurEnvahisseur = dimension.longueur();
	int hauteurEnvahisseur = dimension.hauteur();

	if (!estDansEspaceJeu(x + longueurEnvahisseur - 1, y))
	    throw new DebordementEspaceJeuException("L'envahisseur déborde de l'espace jeu vers la droite à cause de sa longueur");
	if (!estDansEspaceJeu(x, y - hauteurEnvahisseur + 1))
	    throw new DebordementEspaceJeuException("L'envahisseur déborde de l'espace jeu vers le bas à cause de sa hauteur");

	envahisseur = new Envahisseur(dimension,position,vitesse,Direction.DROITE);
    }


    public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {

	int x = position.abscisse();
	int y = position.ordonnee();

	if (!estDansEspaceJeu(x, y))
	    throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

	int longueurVaisseau = dimension.longueur();
	int hauteurVaisseau = dimension.hauteur();

	if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
	    throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
	if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
	    throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

	vaisseau = new Vaisseau(dimension,position,vitesse);
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

    public void deplacerVaisseauVersLaDroite() {
	if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
	    vaisseau.deplacerHorizontalementVers(Direction.DROITE);
	    if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
		vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
	    }
	}
    }

    public void deplacerVaisseauVersLaGauche() {
	if (0 < vaisseau.abscisseLaPlusAGauche()) {
	    vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
	    if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
		vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
	    }
	}
    }

    public void deplacerEnvahisseurVersLaDroite() {
	if (envahisseur.abscisseLaPlusADroite() < (longueur - 1)) {
	    envahisseur.deplacerHorizontalementVers(Direction.DROITE);
	    this.envahisseur.direction = Direction.DROITE;
	    if (!estDansEspaceJeu(envahisseur.abscisseLaPlusADroite(), envahisseur.ordonneeLaPlusHaute())) {
		envahisseur.positionner(longueur - envahisseur.longueur(), envahisseur.ordonneeLaPlusHaute());
	    }
	}
    }

    public void deplacerEnvahisseurVersLaGauche() {
	if (0 < envahisseur.abscisseLaPlusAGauche()) {
	    envahisseur.deplacerHorizontalementVers(Direction.GAUCHE);
	    this.envahisseur.direction = Direction.GAUCHE;
	    if (!estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusHaute())) {
		envahisseur.positionner(0, envahisseur.ordonneeLaPlusHaute());
	    }
	}
    }

    public void deplacerEnvahisseur() {
	if (envahisseur.abscisseLaPlusADroite() < (longueur - 1) && 0 < envahisseur.abscisseLaPlusAGauche()) {
	    if (envahisseur.direction == Direction.DROITE) {
		this.deplacerEnvahisseurVersLaDroite();
	    }
	    if (envahisseur.direction == Direction.GAUCHE) {
		this.deplacerEnvahisseurVersLaGauche();
	    }
	} else if (envahisseur.abscisseLaPlusADroite() == longueur - 1) {
	    this.envahisseur.deplacerHorizontalementVers(Direction.GAUCHE);
	    this.envahisseur.direction = Direction.GAUCHE;
	} else if (envahisseur.abscisseLaPlusAGauche() == 0) {
	    this.envahisseur.deplacerHorizontalementVers(Direction.DROITE);
	    this.envahisseur.direction = Direction.DROITE;
	}
    }

    private boolean estDansEspaceJeu(int x, int y) {
	return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
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

    private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
	return this.aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
    }

    public boolean aUnEnvahisseur() {
	return envahisseur != null;
    }


    private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
	return this.aUnMissile() && missile.occupeLaPosition(x, y);
    }

    public boolean aUnMissile() {
	return missile != null;
    }

    private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
	return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
    }

    public boolean aUnVaisseau() {
	return vaisseau != null;
    }

    @Override
    public void evoluer(Commande commandeUser) {

	if (commandeUser.gauche) {
	    deplacerVaisseauVersLaGauche();
	}

	if (commandeUser.droite) {
	    deplacerVaisseauVersLaDroite();
	}

	if (commandeUser.tir && !this.aUnMissile()) {
	    tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR),
		    Constante.MISSILE_VITESSE);
	}

	if (this.aUnMissile()) {
	    this.deplacerMissile();
	}
	
	if (this.aUnEnvahisseur()) {
	    this.deplacerEnvahisseur();
	}

    }

    public void initialiserJeu() {
	Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
	Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
	Position positionEnvahisseur = new Position(this.longueur/2,Constante.ENVAHISSEUR_HAUTEUR+this.hauteur/100);
	Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
	positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
	positionnerUnNouveauEnvahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
    }

    public Vaisseau recupererVaisseau() {
	return this.vaisseau;
    }

    @Override
    public boolean etreFini() {
	return false;
    }

    public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {

	if ((vaisseau.hauteur()+ dimensionMissile.hauteur()) > this.hauteur )
	    throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");

	this.missile = this.vaisseau.tirerUnMissile(dimensionMissile,vitesseMissile);
    }

    public Missile recupererMissile() {
	return this.missile;
    }

    public void deplacerMissile() {

	if (this.aUnMissileQuiOccupeLaPosition(missile.abscisseLaPlusAGauche(), 0)) {
	    this.missile = null;
	} else {
	    this.missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
	}
    }


    public Envahisseur recupererEnvahisseur() {
	return this.envahisseur;
    }

}

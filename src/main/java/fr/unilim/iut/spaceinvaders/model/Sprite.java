package fr.unilim.iut.spaceinvaders.model;

public abstract class Sprite {

    protected Position origine;
    protected Dimension dimension;
    protected int vitesse;


    public Sprite(Dimension dimension, Position origine, int vitesse) {
	this.dimension = dimension;
	this.origine = origine;
	this.vitesse = vitesse;
    }

    public boolean occupeLaPosition(int x, int y) {
	return (estAbsiceCouverte(x) && estOrdonneeCouverte(y));
    }

    public boolean estOrdonneeCouverte(int y) {
	return (ordonneeLaPlusBasse()<=y) && (y<=ordonneeLaPlusHaute());
    }

    public boolean estAbsiceCouverte(int x) {
	return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
    }

    public int ordonneeLaPlusBasse() {
	return ordonneeLaPlusHaute()-this.dimension.hauteur()+1;
    }

    public int ordonneeLaPlusHaute() {
	return this.origine.ordonnee();
    }

    public int abscisseLaPlusADroite() {
	return abscisseLaPlusAGauche()+this.dimension.longueur()-1;
    }

    public int abscisseLaPlusAGauche() {
	return this.origine.abscisse();
    }

    public void deplacerHorizontalementVers(Direction direction) {
	this.origine.changerAbscisse(this.origine.abscisse() + direction.valeur()*vitesse);
    }

    public void deplacerVerticalementVers(Direction direction) {
	this.origine.changerOrdonnee(this.origine.ordonnee() + direction.valeur()*vitesse);
    }

    public void positionner(int x, int y) {
	this.origine.changerAbscisse(x);
	this.origine.changerOrdonnee(y);
    }

    public int hauteur() {
	return this.dimension.hauteur();
    }

    public int longueur() {
	return this.dimension.longueur();
    }

}
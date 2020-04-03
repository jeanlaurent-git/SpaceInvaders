package fr.unilim.iut.spaceinvaders;

public class Vaisseau {
    Position origine;
    Dimension dimension;

    public Vaisseau(int longueur, int hauteur) {
	this(longueur, hauteur, 0, 0);
    }

    public Vaisseau(int longueur, int hauteur, int x, int y) {
	this(new Dimension(longueur, hauteur), new Position(x, y));
    }

    public Vaisseau(Dimension dimension, Position positionOrigine) {
	this.dimension = dimension;
	this.origine = positionOrigine;
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

    public void seDeplacerVersLaDroite() {
	this.origine.changerAbscisse(this.origine.abscisse()+1);
    }


    public void seDeplacerVersLaGauche() {
	this.origine.changerAbscisse(this.origine.abscisse()-1);
    }


    public void positionner(int x, int y) {
	this.origine.changerAbscisse(x);
	this.origine.changerOrdonnee(y);
    }
}

package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Personnage {
    Direction direction;

    public Envahisseur(Dimension dimension, Position origine, int vitesse) {
        super(dimension, origine, vitesse);
        this.direction = Direction.DROITE;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
 
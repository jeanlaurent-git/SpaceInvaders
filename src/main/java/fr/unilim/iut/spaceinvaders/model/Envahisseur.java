package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Personnage {
    Direction direction;

    public Envahisseur(Dimension dimension, Position origine, int vitesse, Direction direction) {
        super(dimension, origine, vitesse);
        this.direction = direction;
    }

    public Envahisseur(Dimension dimension, Position position, int vitesse) {
        this(dimension, position, vitesse, Direction.DROITE);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
 
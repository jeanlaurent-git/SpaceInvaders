package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class Vaisseau extends Sprite {

    public Vaisseau(Dimension dimension, Position origine, int vitesse) {
        super(dimension, origine, vitesse);
    }

    public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile, Direction direction) {

        if (this.dimension.longueur() < dimensionMissile.longueur())
            throw new MissileException("La longueur du missile est supérieure à celle du vaisseau");

        Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile, direction);
        return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
    }

    public Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile, Direction direction) {
        int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
        int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

        int ordonneeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
        if (Direction.BAS_ECRAN.equals(direction))
            ordonneeOrigineMissile = this.ordonneeLaPlusHaute() + 1;
        return new Position(abscisseOrigineMissile, ordonneeOrigineMissile);
    }
}

package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class Personnage extends Sprite {

    public Personnage(Dimension dimension, Position origine, int vitesse) {
        super(dimension, origine, vitesse);
    }

    public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {

        if (this.dimension.longueur() < dimensionMissile.longueur())
            throw new MissileException("La longueur du missile est supérieure à celle du personnage");

        Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);
        if (this instanceof Envahisseur) {
            return new MissileEnvahisseur(dimensionMissile, new Position(positionOrigineMissile.x, positionOrigineMissile.y + dimensionMissile.hauteur), vitesseMissile);
        } else if (this instanceof Vaisseau){
            return new MissileVaisseau(dimensionMissile, positionOrigineMissile, vitesseMissile);
        }
        return null;
    }

    public Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
        int abscisseMilieuPersonnage = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
        int abscisseOrigineMissile = abscisseMilieuPersonnage - (dimensionMissile.longueur() / 2);

        if (this instanceof Envahisseur)
            return new Position(abscisseOrigineMissile, this.ordonneeLaPlusHaute());
        else
            return new Position(abscisseOrigineMissile, this.ordonneeLaPlusBasse() - 1);
    }

}

package fr.unilim.iut.spaceinvaders.model;

public class Collision {

    public boolean detecterCollision(Sprite spriteStatique, Sprite spriteMobile) {
        return this.spriteToucheParSprite(spriteStatique, spriteMobile);
    }

    private boolean spriteToucheParSprite(Sprite spriteStatique, Sprite spriteMobile) {
        return ((this.spriteToucheEnBasParSprite(spriteStatique, spriteMobile) &&
                spriteToucheHorizontalementParSprite(spriteStatique, spriteMobile))
                || (this.spriteToucheEnHautParSprite(spriteStatique, spriteMobile) &&
                spriteToucheHorizontalementParSprite(spriteStatique, spriteMobile)));
    }

    private boolean spriteToucheHorizontalementParSprite(Sprite spriteStatique, Sprite spriteMobile) {
        return this.spriteToucheAGaucheParSprite(spriteStatique, spriteMobile) ||
                this.spriteToucheADroiteParSprite(spriteStatique, spriteMobile);
    }

    public boolean spriteToucheADroiteParSprite(Sprite spriteStatique, Sprite spriteMobile) {
        return spriteStatique.abscisseLaPlusADroite() >= spriteMobile.abscisseLaPlusAGauche() &&
                spriteMobile.abscisseLaPlusADroite() >= spriteStatique.abscisseLaPlusAGauche();
    }

    public boolean spriteToucheAGaucheParSprite(Sprite spriteStatique, Sprite spriteMobile) {
        return spriteStatique.abscisseLaPlusAGauche() <= spriteMobile.abscisseLaPlusADroite() &&
                spriteMobile.abscisseLaPlusAGauche() <= spriteStatique.abscisseLaPlusADroite();
    }

    public boolean spriteToucheEnBasParSprite(Sprite spriteStatique, Sprite spriteMobile) {
        return spriteStatique.ordonneeLaPlusHaute() >= spriteMobile.ordonneeLaPlusBasse() &&
                spriteMobile.ordonneeLaPlusHaute() >= spriteStatique.ordonneeLaPlusBasse();
    }

    public boolean spriteToucheEnHautParSprite(Sprite spriteStatique, Sprite spriteMobile) {
        return spriteStatique.ordonneeLaPlusBasse() <= spriteMobile.ordonneeLaPlusHaute() &&
                spriteMobile.ordonneeLaPlusBasse() <= spriteStatique.ordonneeLaPlusHaute();
    }
}
package fr.unilim.iut.spaceinvaders.model;

public class Collision {

    public boolean detecterCollision(Sprite spriteTouche, Sprite spriteToucheur) {
        return this.spriteToucheParSprite(spriteTouche, spriteToucheur);
    }

    private boolean spriteToucheParSprite(Sprite spriteTouche, Sprite spriteToucheur) {
        return ((this.spriteToucheEnBasParSprite(spriteTouche, spriteToucheur) &&
                spriteToucheHorizontalementParSprite(spriteTouche, spriteToucheur))
                || (this.spriteToucheEnHautParSprite(spriteTouche, spriteToucheur) &&
                spriteToucheHorizontalementParSprite(spriteTouche, spriteToucheur)));
    }

    private boolean spriteToucheHorizontalementParSprite(Sprite spriteTouche, Sprite spriteToucheur) {
        return this.spriteToucheAGaucheParSprite(spriteTouche, spriteToucheur) ||
                this.spriteToucheADroiteParSprite(spriteTouche, spriteToucheur);
    }

    public boolean spriteToucheADroiteParSprite(Sprite spriteTouche, Sprite spriteToucheur) {
        return spriteTouche.abscisseLaPlusADroite() >= spriteToucheur.abscisseLaPlusAGauche() &&
                spriteToucheur.abscisseLaPlusADroite() >= spriteTouche.abscisseLaPlusAGauche();
    }

    public boolean spriteToucheAGaucheParSprite(Sprite spriteTouche, Sprite spriteToucheur) {
        return spriteTouche.abscisseLaPlusAGauche() <= spriteToucheur.abscisseLaPlusADroite() &&
                spriteToucheur.abscisseLaPlusAGauche() <= spriteTouche.abscisseLaPlusADroite();
    }

    public boolean spriteToucheEnBasParSprite(Sprite spriteTouche, Sprite spriteToucheur) {
        return spriteTouche.ordonneeLaPlusHaute() >= spriteToucheur.ordonneeLaPlusBasse() &&
                spriteToucheur.ordonneeLaPlusHaute() >= spriteTouche.ordonneeLaPlusBasse();
    }

    public boolean spriteToucheEnHautParSprite(Sprite spriteTouche, Sprite spriteToucheur) {
        return spriteTouche.ordonneeLaPlusBasse() <= spriteToucheur.ordonneeLaPlusHaute() &&
                spriteToucheur.ordonneeLaPlusBasse() <= spriteTouche.ordonneeLaPlusHaute();
    }
}
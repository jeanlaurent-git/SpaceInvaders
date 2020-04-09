package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisionTest {
    Collision collision;

    @Before
    public void initialisation() {
        collision = new Collision();
    }

    @Test
    public void test_spriteToucheParSprite_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile = new Missile(new Dimension(1, 1), new Position(5, 2), 3);

        assertTrue(collision.detecterCollision(envahisseur, missile));

    }

    @Test
    public void test_spriteNonToucheParSprite_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile = new Missile(new Dimension(1, 1), new Position(11, 9), 3);

        assertFalse(collision.detecterCollision(envahisseur, missile));
    }

    @Test
    public void test_spriteToucheParSpriteAGauche_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new Missile(new Dimension(1, 2), new Position(5, 1), 3);

        assertTrue(collision.spriteToucheAGaucheParSprite(envahisseur, missile));

    }

    @Test
    public void test_spriteToucheParSpriteADroite_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new Missile(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheADroiteParSprite(envahisseur, missile));

    }

    @Test
    public void test_spriteToucheParSpriteEnHaut_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new Missile(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnHautParSprite(envahisseur, missile));

    }

    @Test
    public void test_spriteToucheParSpriteEnBas_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new Missile(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnBasParSprite(envahisseur, missile));

    }
}

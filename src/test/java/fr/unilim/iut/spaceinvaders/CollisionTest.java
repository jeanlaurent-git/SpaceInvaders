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
    public void test_envahisseurToucheParMissile_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile = new MissileVaisseau(new Dimension(1, 1), new Position(5, 2), 3);

        assertTrue(collision.detecterCollision(envahisseur, missile));

    }

    @Test
    public void test_envahisseurNonToucheParMissile_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile = new MissileVaisseau(new Dimension(1, 1), new Position(11, 9), 3);

        assertFalse(collision.detecterCollision(envahisseur, missile));
    }

    @Test
    public void test_envahisseurToucheParMissileAGauche_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileVaisseau(new Dimension(1, 2), new Position(5, 1), 3);

        assertTrue(collision.spriteToucheAGaucheParSprite(envahisseur, missile));

    }

    @Test
    public void test_envahisseurToucheParMissileADroite_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileVaisseau(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheADroiteParSprite(envahisseur, missile));

    }

    @Test
    public void test_envahisseurToucheParMissileEnHaut_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileVaisseau(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnHautParSprite(envahisseur, missile));

    }

    @Test
    public void test_envahisseurToucheParMissileEnBas_DetecterCollision() {

        Envahisseur envahisseur = new Envahisseur(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileVaisseau(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnBasParSprite(envahisseur, missile));

    }

    @Test
    public void test_vaisseauToucheParMissile_DetecterCollision() {

        Vaisseau vaisseau = new Vaisseau(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile = new MissileEnvahisseur(new Dimension(1, 1), new Position(5, 2), 3);

        assertTrue(collision.detecterCollision(vaisseau, missile));

    }

    @Test
    public void test_vaisseauNonToucheParMissile_DetecterCollision() {

        Vaisseau vaisseau = new Vaisseau(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile = new MissileEnvahisseur(new Dimension(1, 1), new Position(7, 2), 3);

        assertFalse(collision.detecterCollision(vaisseau, missile));
    }

    @Test
    public void test_vaisseauToucheParMissileAGauche_DetecterCollision() {

        Vaisseau vaisseau = new Vaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 1), 3);

        assertTrue(collision.spriteToucheAGaucheParSprite(vaisseau, missile));

    }

    @Test
    public void test_vaisseauToucheParMissileADroite_DetecterCollision() {

        Vaisseau vaisseau = new Vaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheADroiteParSprite(vaisseau, missile));

    }

    @Test
    public void test_vaisseauToucheParMissileEnHaut_DetecterCollision() {

        Vaisseau vaisseau = new Vaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnHautParSprite(vaisseau, missile));

    }

    @Test
    public void test_vaisseauToucheParMissileEnBas_DetecterCollision() {

        Vaisseau vaisseau = new Vaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnBasParSprite(vaisseau, missile));

    }

    @Test
    public void test_missileToucheParMissile_DetecterCollision() {

        Missile missile1 = new MissileVaisseau(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile2 = new MissileEnvahisseur(new Dimension(1, 1), new Position(5, 2), 3);

        assertTrue(collision.detecterCollision(missile1, missile2));

    }

    @Test
    public void test_missileNonToucheParMissile_DetecterCollision() {

        Missile missile1 = new MissileVaisseau(new Dimension(1, 1), new Position(5, 2), 3);
        Missile missile2 = new MissileEnvahisseur(new Dimension(1, 1), new Position(7, 2), 3);

        assertFalse(collision.detecterCollision(missile1, missile2));
    }

    @Test
    public void test_missileToucheParMissileAGauche_DetecterCollision() {

        Missile missile1 = new MissileVaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile2 = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 1), 3);

        assertTrue(collision.spriteToucheAGaucheParSprite(missile1, missile2));

    }

    @Test
    public void test_missileToucheParMissileADroite_DetecterCollision() {

        Missile missile1 = new MissileVaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile2 = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheADroiteParSprite(missile1, missile2));

    }

    @Test
    public void test_missileToucheParMissileEnHaut_DetecterCollision() {

        Missile missile1 = new MissileVaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile2 = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnHautParSprite(missile1, missile2));

    }

    @Test
    public void test_missileToucheParMissileEnBas_DetecterCollision() {

        Missile missile1 = new MissileVaisseau(new Dimension(2, 2), new Position(5, 2), 3);
        Missile missile2 = new MissileEnvahisseur(new Dimension(1, 2), new Position(5, 2), 3);

        assertTrue(collision.spriteToucheEnBasParSprite(missile1, missile2));

    }
}

package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.*;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceInvadersTest {
    private SpaceInvaders spaceinvaders;

    @Before
    public void initialisation() {
        spaceinvaders = new SpaceInvaders(15, 10);
    }

    @Test
    public void test_AuDebut_JeuSpaceInvaderEstVide() {
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {

        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(15, 9), 1, true);
            fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(-1, 9), 1, true);
            fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(14, 10), 1, true);
            fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(14, -1), 1, true);
            fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }

    }

    @Test
    public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(7, 9), 1, true);
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                ".......VVV.....\n" +
                ".......VVV.....\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {

        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(9, 2), new Position(7, 9), 1, true);
            fail("Dépassement du vaisseau à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
        } catch (final DebordementEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 4), new Position(7, 1), 1, true);
            fail("Dépassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
        } catch (final DebordementEspaceJeuException e) {
        }
    }

    @Test
    public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(7, 9), 3, true);
        spaceinvaders.deplacerVaisseauVersLaGauche();

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "....VVV........\n" +
                "....VVV........\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(0, 9), 3, true);
        spaceinvaders.deplacerVaisseauVersLaGauche();

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "VVV............\n" +
                "VVV............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaGauche() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(1, 9), 3, true);
        spaceinvaders.deplacerVaisseauVersLaGauche();

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "VVV............\n" +
                "VVV............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(7, 9), 3, true);
        spaceinvaders.deplacerVaisseauVersLaDroite();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "..........VVV..\n" +
                "..........VVV..\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(12, 9), 3, true);
        spaceinvaders.deplacerVaisseauVersLaDroite();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "............VVV\n" +
                "............VVV\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaDroite() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(10, 9), 3, true);
        spaceinvaders.deplacerVaisseauVersLaDroite();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "............VVV\n" +
                "............VVV\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_MissileBienTireDepuisVaisseau_VaisseauLongueurImpaireMissileLongueurImpaire() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(7, 2), new Position(5, 9), 2, true);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3, 2), 2);

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                ".......MMM.....\n" +
                ".......MMM.....\n" +
                ".....VVVVVVV...\n" +
                ".....VVVVVVV...\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test(expected = MissileException.class)
    public void test_PasAssezDePlacePourTirerUnMissile_UneExceptionEstLevee() {
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(7, 2), new Position(5, 9), 1, true);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(7, 9), 1);
    }

    @Test
    public void test_MissileAvanceAutomatiquement_ApresTirDepuisLeVaisseau() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(7, 2), new Position(5, 9), 2, true);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3, 2), 2);

        spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                ".......MMM.....\n" +
                ".......MMM.....\n" +
                "...............\n" +
                "...............\n" +
                ".....VVVVVVV...\n" +
                ".....VVVVVVV...\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_MissileDisparait_QuandIlCommenceASortirDeEspaceJeu() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(7, 2), new Position(5, 9), 1, true);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3, 2), 1);
        for (int i = 1; i <= 6; i++) {
            spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);
        }

        spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                ".....VVVVVVV...\n" +
                ".....VVVVVVV...\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_UnNouveauEnvahisseurPositionneHorsEspaceJeu_DoitLeverUneException() {

        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(15, 9), 1, false);
            fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(-1, 9), 1, false);
            fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(14, 10), 1, false);
            fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }


        try {
            spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(1, 1), new Position(14, -1), 1, false);
            fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
        } catch (final HorsEspaceJeuException e) {
        }

    }

    @Test
    public void test_unNouveauEnvahisseurAvecUneDimensionEstCorrectementPositionneDansEspaceJeu() {
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(2, 2), new Position(7, 3), 1, false);
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                ".......EE......\n" +
                ".......EE......\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_LeJeuSeTermineEnCasDeCollisionEntreLeMissileEtLEnvahisseur() {
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(4, 2), new Position(7, 9), 1, true);
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(5, 2), new Position(7, 2), 1, false);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3, 2), 1);

        for (int i = 0; i < 4; i++) {
            spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);
        }
        spaceinvaders.evoluer(null);
        spaceinvaders.evoluer(null);
        assertTrue(spaceinvaders.etreFini());
    }

    @Test
    public void test_LeJeuNeSeTerminePasSiNonCollision() {
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(3, 2), new Position(4, 9), 1, true);
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(2, 2), new Position(5, 1), 1, false);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(1, 2), 1);

        for (int i = 0; i < 4; i++) {
            spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);
        }
        spaceinvaders.evoluer(null);
        assertFalse(spaceinvaders.etreFini());
    }

    @Test
    public void test_MissilesBienTiresDepuisVaisseau() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(5,2),new Position(5,9), 2, true);

        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3,2), 2);
        Vaisseau vaisseau = spaceinvaders.recupererVaisseau();
        for (int i = 0; i < 2; i++) {
            spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);
        }
        spaceinvaders.recupererMissiles().add(vaisseau.tirerUnMissile(new Dimension(3,2), 2, Direction.HAUT_ECRAN));

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "......MMM......\n" +
                "......MMM......\n" +
                "...............\n" +
                "...............\n" +
                "......MMM......\n" +
                "......MMM......\n" +
                ".....VVVVV.....\n" +
                ".....VVVVV.....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_MissileNonTireDepuisVaisseau_PresenceDeMissilesEnBasEcran() {

        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(5,2),new Position(5,9), 2, true);

        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3,2), 2);
        Vaisseau vaisseau = spaceinvaders.recupererVaisseau();
        for (int i = 0; i < 2; i++) {
            spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);
        }
        vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(3,2), 2);

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "......MMM......\n" +
                "......MMM......\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...VVVVV.......\n" +
                "...VVVVV.......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_uneNouvelleLigneEnvahisseurAvecUneDimensionEstCorrectementPositionneDansEspaceJeu() {
        Envahisseur envahisseur = new Envahisseur(new Dimension(2,2), new Position(4,3), 1);
        spaceinvaders.positionnerUneNouvelleLigneEnvahisseurs(new Position(4, 3), envahisseur, 3);
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "....EE.EE.EE...\n" +
                "....EE.EE.EE...\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_uneNouvelleLigneEnvahisseurseDeplace_versLaGauche() {
        Envahisseur envahisseur = new Envahisseur(new Dimension(2,2), new Position(4,3), 1);
        spaceinvaders.positionnerUneNouvelleLigneEnvahisseurs(new Position(4, 3), envahisseur, 3);
        spaceinvaders.recupererEnvahisseurs().get(0).setDirection(Direction.GAUCHE);
        spaceinvaders.deplacerEnvahisseurs();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "...EE.EE.EE....\n" +
                "...EE.EE.EE....\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_uneNouvelleLigneEnvahisseurseDeplace_versLaDroite() {
        Envahisseur envahisseur = new Envahisseur(new Dimension(2,2), new Position(4,3), 1);
        spaceinvaders.positionnerUneNouvelleLigneEnvahisseurs(new Position(4, 3), envahisseur, 3);
        spaceinvaders.recupererEnvahisseurs().get(0).setDirection(Direction.DROITE);
        spaceinvaders.deplacerEnvahisseurs();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                ".....EE.EE.EE..\n" +
                ".....EE.EE.EE..\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_uneNouvelleLigneEnvahisseurseDeplace_versLaDroite_quandElleToucheLeBordGauche() {
        Envahisseur envahisseur = new Envahisseur(new Dimension(2,2), new Position(4,3), 1);
        spaceinvaders.positionnerUneNouvelleLigneEnvahisseurs(new Position(0, 3), envahisseur, 3);
        spaceinvaders.deplacerEnvahisseurs();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                ".EE.EE.EE......\n" +
                ".EE.EE.EE......\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_uneNouvelleLigneEnvahisseurseDeplace_versLaGauche_quandElleToucheLeBordDroit() {
        Envahisseur envahisseur = new Envahisseur(new Dimension(2,2), new Position(4,3), 1);
        spaceinvaders.positionnerUneNouvelleLigneEnvahisseurs(new Position(7, 3), envahisseur, 3);
        spaceinvaders.deplacerEnvahisseurs();
        assertEquals("" +
                "...............\n" +
                "...............\n" +
                "......EE.EE.EE.\n" +
                "......EE.EE.EE.\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
    public void test_uneCollisionEntreUnMissileEtUnEnvahisseurSupprimeLeMissileEtLEnvahisseur() {
        Envahisseur envahisseur = new Envahisseur(new Dimension(2,2), new Position(4,3), 1);
        spaceinvaders.positionnerUneNouvelleLigneEnvahisseurs(new Position(4, 3), envahisseur, 3);
        spaceinvaders.positionnerUnNouveauPersonnage(new Dimension(4,2), new Position(6,9), 1, true);
        spaceinvaders.tirerUnMissileDepuisLeVaisseau(new Dimension(2,2), 1);
        for (int i = 0; i < 3; i++) {
            spaceinvaders.deplacerMissile(Direction.HAUT_ECRAN);
        }
        spaceinvaders.evoluer(null);

        assertEquals("" +
                "...............\n" +
                "...............\n" +
                ".....EE....EE..\n" +
                ".....EE....EE..\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "...............\n" +
                "......VVVV.....\n" +
                "......VVVV.....\n", spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

}

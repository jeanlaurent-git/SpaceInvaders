package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Direction;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.Vaisseau;
import fr.unilim.iut.spaceinvaders.utils.MissileException;
import org.junit.Test;

public class VaisseauTest extends SpaceInvadersTest {

    @Test(expected = MissileException.class)
    public void test_LongueurMissileSuperieureALongueurVaisseau_UneExceptionEstLevee() {
        Vaisseau vaisseau = new Vaisseau(new Dimension(5, 2), new Position(5, 9), 1);
        vaisseau.tirerUnMissile(new Dimension(7, 2), 1, Direction.HAUT_ECRAN);
    }

}

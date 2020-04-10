package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.Constante;
import fr.unilim.iut.spaceinvaders.model.DessinSpaceInvaders;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.moteurjeu.MoteurGraphique;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SpaceInvaders jeu = new SpaceInvaders(Constante.ESPACE_JEU_LONGUEUR, Constante.ESPACE_JEU_HAUTEUR);
        jeu.initialiserJeu();
        DessinSpaceInvaders afficheur = new DessinSpaceInvaders(jeu);

        MoteurGraphique moteur = new MoteurGraphique(jeu, afficheur);
        moteur.lancerJeu(Constante.ESPACE_JEU_LONGUEUR, Constante.ESPACE_JEU_HAUTEUR);
    }

}

package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.DessinJeu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.List;


public class DessinSpaceInvaders extends JPanel implements DessinJeu {

    private final SpaceInvaders jeu;

    public DessinSpaceInvaders (SpaceInvaders spaceInvaders) {
        this.jeu = spaceInvaders;
    }

    @Override
    public void dessiner (BufferedImage image) {

        dessinerLeFond(image);
        if (! this.jeu.etreFini()) {
            if (this.jeu.aUnVaisseau()) {
                Vaisseau vaisseau = this.jeu.recupererVaisseau();
                this.dessinerUnVaisseau(vaisseau, image);
            }

            if (this.jeu.aDesMissilesAllie()) {
                List<MissileVaisseau> missiles = this.jeu.recupererMissilesVaisseau();
                this.dessinerUnMissileAllie(missiles, image);
            }

            if (this.jeu.aDesEnvahisseurs()) {
                List<Envahisseur> envahisseurs = this.jeu.recupererEnvahisseurs();
                this.dessinerUnEnvahisseur(envahisseurs, image);
            }

            if (this.jeu.aDesMissilesEnnemi()) {
                List<MissileEnvahisseur> missiles = this.jeu.recupererMissilesEnvahisseur();
                this.dessinerUnMissileEnnemi(missiles, image);
            }

        }

        if (this.jeu.etreFini()) {
            this.dessinerMessageDeFin(image);
        }

        this.dessinerLeScore(image);

    }

    private void dessinerUnEnvahisseur (List<Envahisseur> envahisseurs, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        double pixel = Constante.ENVAHISSEUR_LONGUEUR / 10.0;

        for (Envahisseur envahisseur : envahisseurs) {
            //Dessin du corps de l'envahisseur
            crayon.setColor(Color.white);
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (2 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (2 * pixel), (int) (6 * pixel),
                            (int) (6 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (1 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (4 * pixel), (int) (8 * pixel),
                            (int) (3 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche(),
                            envahisseur.ordonneeLaPlusBasse() + (int) (6 * pixel), (int) (1 * pixel),
                            (int) (3 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (9 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (6 * pixel), (int) (1 * pixel),
                            (int) (3 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (1 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (9 * pixel), (int) (2 * pixel),
                            (int) (1 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (7 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (9 * pixel), (int) (2 * pixel),
                            (int) (1 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (2 * pixel),
                            envahisseur.ordonneeLaPlusBasse(), (int) (1 * pixel),
                            (int) (1 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (3 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (1 * pixel), (int) (1 * pixel),
                            (int) (1 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (7 * pixel),
                            envahisseur.ordonneeLaPlusBasse(), (int) (1 * pixel),
                            (int) (1 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (6 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (1 * pixel), (int) (1 * pixel),
                            (int) (1 * pixel));

            //Dessin des yeux de l'envahisseur
            crayon.setColor(Color.BLACK);
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (3 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (4 * pixel), (int) (1 * pixel),
                            (int) (3 * pixel));
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche() + (int) (6 * pixel),
                            envahisseur.ordonneeLaPlusBasse() + (int) (4 * pixel), (int) (1 * pixel),
                            (int) (3 * pixel));
        }

    }

    private void dessinerUnVaisseau (Vaisseau vaisseau, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        double pixel = Constante.VAISSEAU_HAUTEUR / 10.0;

        crayon.setColor(Color.white);
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (5 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (4 * pixel), (int) (10 * pixel),
                        (int) (5 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (7 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (9 * pixel), (int) (6 * pixel),
                        (int) (pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (8 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (3 * pixel), (int) (4 * pixel),
                        (int) (pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (9 * pixel),
                        vaisseau.ordonneeLaPlusBasse(), (int) (2 * pixel),
                        (int) (3 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (3 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (4 * pixel), (int) (2 * pixel),
                        (int) (4 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (15 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (4 * pixel), (int) (2 * pixel),
                        (int) (4 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (2 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (3 * pixel), (int) (2 * pixel),
                        (int) (4 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (16 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (3 * pixel), (int) (2 * pixel),
                        (int) (4 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (1 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (2 * pixel), (int) (2 * pixel),
                        (int) (4 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (17 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (2 * pixel), (int) (2 * pixel),
                        (int) (4 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche(),
                        vaisseau.ordonneeLaPlusBasse() + (int) (pixel), (int) (2 * pixel),
                        (int) (3 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (18 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (pixel), (int) (2 * pixel),
                        (int) (3 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche(),
                        vaisseau.ordonneeLaPlusBasse(), (int) (pixel),
                        (int) (pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (19 * pixel),
                        vaisseau.ordonneeLaPlusBasse(), (int) (pixel),
                        (int) (pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (5 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (2 * pixel), (int) (pixel),
                        (int) (2 * pixel));
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche() + (int) (14 * pixel),
                        vaisseau.ordonneeLaPlusBasse() + (int) (2 * pixel), (int) (pixel),
                        (int) (2 * pixel));

    }

    private void dessinerUnMissileAllie (List<MissileVaisseau> missiles, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        double pixel = Constante.VAISSEAU_HAUTEUR / 10.0;

        crayon.setColor(Color.blue);
        for (MissileVaisseau missile : missiles) {
            crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse() + (int) (pixel),
                            (int) (2 * pixel), (int) (4 * pixel));
            crayon.fillOval(missile.abscisseLaPlusAGauche(),
                            missile.ordonneeLaPlusBasse(), (int) (2 * pixel), (int) (2 * pixel));
        }

    }

    private void dessinerUnMissileEnnemi (List<MissileEnvahisseur> missiles, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.red);
        for (MissileEnvahisseur missile : missiles) {
            crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse(), missile.longueur(),
                            missile.hauteur());
        }

    }

    private void dessinerMessageDeFin (BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.WHITE);
        crayon.setFont(new Font(Constante.MESSAGE_VICTOIRE_FONT, Font.PLAIN, Constante.MESSAGE_VICTOIRE_TAILLE));
        crayon.drawString(Constante.MESSAGE_VICTOIRE_TEXT, Constante.ESPACE_JEU_LONGUEUR / 5,
                          Constante.ESPACE_JEU_HAUTEUR / 2);
    }

    private void dessinerLeScore (BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.WHITE);
        crayon.setFont(new Font(Constante.SCORE_FONT, Font.PLAIN, Constante.SCORE_TAILLE));
        crayon.drawString("Score : " + this.jeu.recupererScore(), Constante.SCORE_POSITION_X,
                          Constante.SCORE_POSITION_Y);
    }

    private void dessinerLeFond (BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.black);
        crayon.fillRect(0, 0, jeu.longueur, jeu.hauteur);
    }
}

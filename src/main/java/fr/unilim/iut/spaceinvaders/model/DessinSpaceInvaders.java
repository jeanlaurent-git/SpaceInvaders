package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;


public class DessinSpaceInvaders implements DessinJeu {

    private final SpaceInvaders jeu;

    public DessinSpaceInvaders(SpaceInvaders spaceInvaders) {
        this.jeu = spaceInvaders;
    }

    @Override
    public void dessiner(BufferedImage image) {

        if (!this.jeu.etreFini()) {
            if (this.jeu.aUnVaisseau()) {
                Vaisseau vaisseau = this.jeu.recupererVaisseau();
                this.dessinerUnVaisseau(vaisseau, image);
            }

            if (this.jeu.aDesMissiles()) {
                List<Missile> missiles = this.jeu.recupererMissiles();
                this.dessinerUnMissile(missiles, image);
            }

            if (this.jeu.aDesEnvahisseurs()) {
                List<Envahisseur> envahisseurs = this.jeu.recupererEnvahisseurs();
                this.dessinerUnEnvahisseur(envahisseurs, image);
            }

        }

        if (this.jeu.etreFini()) {
            this.dessinerMessageDeFin(image);
        }

        this.dessinerLeScore(image);

    }

    private void dessinerUnEnvahisseur(List<Envahisseur> envahisseurs, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.red);
        for (Envahisseur envahisseur : envahisseurs) {
            crayon.fillRect(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusBasse(), envahisseur.longueur(),
                    envahisseur.hauteur());
        }

    }

    private void dessinerUnVaisseau(Vaisseau vaisseau, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.gray);
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusBasse(), vaisseau.longueur(),
                vaisseau.hauteur());

    }

    private void dessinerUnMissile(List<Missile> missiles, BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.blue);
        for (Missile missile : missiles) {
            crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse(), missile.longueur(),
                    missile.hauteur());
        }

    }

    private void dessinerMessageDeFin(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.BLACK);
        crayon.setFont(new Font(Constante.MESSAGE_FIN_FONT, Font.PLAIN, Constante.MESSAGE_FIN_TAILLE));
        crayon.drawString(Constante.MESSAGE_FIN_TEXT, Constante.ESPACE_JEU_LONGUEUR / 5, Constante.ESPACE_JEU_HAUTEUR / 2);
    }

    private void dessinerLeScore(BufferedImage image) {
        Graphics2D crayon = (Graphics2D) image.getGraphics();

        crayon.setColor(Color.BLACK);
        crayon.setFont(new Font(Constante.SCORE_FONT, Font.PLAIN, Constante.SCORE_TAILLE));
        crayon.drawString("Score : " + this.jeu.recupererScore(), Constante.SCORE_POSITION_X, Constante.SCORE_POSITION_Y);
    }

}

package fr.unilim.iut.spaceinvaders.model;

public class Constante {
    public static final int ESPACE_JEU_LONGUEUR = 800;
    public static final int ESPACE_JEU_HAUTEUR = 600;

    //longueur = 2 * hateur pour les graphismes
    public static final int VAISSEAU_LONGUEUR = 100;
    public static final int VAISSEAU_HAUTEUR = 50;
    public static final int VAISSEAU_VITESSE = 10;

    public static final int MISSILE_LONGUEUR = 10;
    public static final int MISSILE_HAUTEUR = 30;
    public static final int MISSILE_VITESSE = 7;
    public static final long TEMPS_ENTRE_DEUX_MISSILES_ALLIE = 250;
    public static final long TEMPS_ENTRE_DEUX_MISSILES_ENNEMI = 750;

    //longueur = hauteur pour les graphismes
    public static final int ENVAHISSEUR_LONGUEUR = 40;
    public static final int ENVAHISSEUR_HAUTEUR = 40;
    public static final int ENVAHISSEUR_POSITION_X = 50;
    public static final int ENVAHISSEUR_POSITION_Y = 100;
    public static final int ENVAHISSEUR_VITESSE = 1;
    public static final int ENVAHISSEUR_PARLIGNE = 11;

    public static final char MARQUE_FIN_LIGNE = '\n';
    public static final char MARQUE_VIDE = '.';
    public static final char MARQUE_VAISSEAU = 'V';
    public static final char MARQUE_MISSILE_VAISSEAU = 'M';
    public static final char MARQUE_MISSILE_ENVAHISSEUR = 'S';
    public static final char MARQUE_ENVAHISSEUR = 'E';

    public static final int SCORE_DETRUIRE_ENVAHISSEUR = 20;
    public static final int SCORE_DETRUIRE_MISSILE = 5;

    public static final String SCORE_FONT = "Arial";
    public static final int SCORE_TAILLE = 20;
    public static final int SCORE_POSITION_X = 20;
    public static final int SCORE_POSITION_Y = 30;

    public static final String MESSAGE_FIN_FONT = "Arial";
    public static final String MESSAGE_FIN_TEXT = "VOUS AVEZ PERDU !";
    public static final int MESSAGE_FIN_TAILLE = 50;
}

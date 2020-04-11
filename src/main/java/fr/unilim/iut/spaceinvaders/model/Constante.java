package fr.unilim.iut.spaceinvaders.model;

public class Constante {
    public static final int ESPACE_JEU_LONGUEUR = 800;
    public static final int ESPACE_JEU_HAUTEUR = 800;

    public static final int VAISSEAU_LONGUEUR = 100;
    public static final int VAISSEAU_HAUTEUR = 50;
    public static final int VAISSEAU_VITESSE = 10;

    public static final int MISSILE_LONGUEUR = 10;
    public static final int MISSILE_HAUTEUR = 30;
    public static final int MISSILE_VITESSE = 10;
    public static final long TEMPS_ENTRE_DEUX_MISSILES = 250;

    public static final int ENVAHISSEUR_LONGUEUR = 50;
    public static final int ENVAHISSEUR_HAUTEUR = 50;
    public static final int ENVAHISSEUR_POSITION_X = 50;
    public static final int ENVAHISSEUR_POSITION_Y = 100;
    public static final int ENVAHISSEUR_VITESSE = 2;
    public static final int ENVAHISSEUR_PARLIGNE = 10;

    public static final char MARQUE_FIN_LIGNE = '\n';
    public static final char MARQUE_VIDE = '.';
    public static final char MARQUE_VAISSEAU = 'V';
    public static final char MARQUE_MISSILE = 'M';
    public static final char MARQUE_ENVAHISSEUR = 'E';

    public static final String MESSAGE_FIN_FONT = "Arial";
    public static final String MESSAGE_FIN_TEXT = "VOUS AVEZ GAGNE !";
    public static final int MESSAGE_FIN_TAILLE = 50;
}

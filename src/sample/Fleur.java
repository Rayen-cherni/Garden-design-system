package sample;

public class Fleur extends Plante {

    private String couleur;

    public Fleur(Code code, int taille_max, String couleur) {
        super(code, taille_max);
        this.couleur = couleur;
    }

    /**
     * Getters && Setters
     **/

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}

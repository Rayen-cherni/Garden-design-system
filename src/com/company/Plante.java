package com.company;

public class Plante {

    private Code code;
    private int taille_max;

    public Plante(Code code, int taille_max) {
        this.code = code;
        this.taille_max = taille_max;
    }

    // Return true si la plante support l'ombre
    // Dans l'enoncé suelement les laitues && les clématites supportent l'ombre
    public boolean isSupportOmbre() {
        return this.code == Code.L || this.code == Code.C;
    }

    public boolean isNeedsWater() {
        return this.code == Code.L;
    }

    /**
     * Getters && Setters
     **/
    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public int getTaille_max() {
        return taille_max;
    }

    public void setTaille_max(int taille_max) {
        this.taille_max = taille_max;
    }
}

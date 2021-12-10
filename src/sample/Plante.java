package sample;

public class Plante {

    private Code code;
    private int taille_max;

    public Plante() {

    }

    public Plante(Code code, int taille_max) {
        this.code = code;
        this.taille_max = taille_max;
    }

    /**
     * Return true si la plante support l'ombre
     * Dans l'enoncé suelement les laitues && les clématites supportent l'ombre
     **/
    public boolean isSupportOmbre() {
        return this.code == Code.L || this.code == Code.C;
    }

    public boolean isNeedsWater() {
        return this.code == Code.L;
    }

    /**
     * Test : Si une case donnes est correctement amenagees
     **/
    public boolean isProperlyEquipped(Plante[][] matrix, Jardin jardin, int indiceLigne, int indiceColonne) {
        boolean test1SuccessfullyPassed;
        boolean test2SuccessfullyPassed;
        boolean test3SuccessfullyPassed;

        test1SuccessfullyPassed = !jardin.isIncompatible(indiceLigne, indiceColonne, matrix); // False

        if (jardin.isOmbre(indiceLigne + 1)) {
            test2SuccessfullyPassed = this.isSupportOmbre();
        } else {
            test2SuccessfullyPassed = true;
        } //True

        test3SuccessfullyPassed = !jardin.isConfusedWithThePipe(indiceColonne); // True
        return test1SuccessfullyPassed & test2SuccessfullyPassed & test3SuccessfullyPassed;
    }


    /**
     * Getters && Setters
     **/
    public Code getCode() {
        return code;
    }

    public int getTaille_max() {
        return taille_max;
    }

}

package com.company;

import java.util.logging.Logger;

public class Jardin {

    private int nombreLigne;
    private int nombreColonne;
    private int numeroColonneToyeu;
    private int indiceDebartZoneOmbre;
    private int indiceFinZoneOmbre;

    private static final Logger logger = Logger.getLogger(Jardin.class.getName());

    public Jardin(int nombre_ligne, int nombre_colonnes, int numeroColonneToyeu,
                  int indiceDebartZoneOmbre, int indiceFinZoneOmbre) {
        this.nombreLigne = nombre_ligne;
        this.nombreColonne = nombre_colonnes;
        this.numeroColonneToyeu = numeroColonneToyeu;
        this.indiceDebartZoneOmbre = indiceDebartZoneOmbre;
        this.indiceFinZoneOmbre = indiceFinZoneOmbre;
    }

    /**
     * Create a matrix to present our park
     **/
    public Plante[][] create() {
        return new Plante[this.nombreLigne][this.nombreColonne];
    }

    /**
     * Remplissage de jardin par une plante
     **/
    public void fillingByOnePlante(int rowIndex, int columnIndex, Plante plante, Plante[][] matrix) throws Exception {
        if (columnIndex == this.numeroColonneToyeu - 1) {
            logger.warning(String.format("La plante d'indice [%d][%d] confused with the pipe ", rowIndex, columnIndex));
            throw new Exception();
        } else {
            if (matrix[rowIndex][columnIndex] != null) {
                logger.warning(String.format("La position [%d][%d] n'est pas vide ", rowIndex, columnIndex));
                throw new Exception();
            } else {
                matrix[rowIndex][columnIndex] = plante;
            }
        }
    }

    /**
     * Affichage
     **/
    public void display(Plante[][] matrix) {
        System.out.println("-------------------------------");
        System.out.print(String.format("Remind: Pipe position is %d ", this.numeroColonneToyeu));
        String[][] auxMatrix = this.convertPlanteMatrixToStringMatrix(matrix);

        for (String[] strings : auxMatrix) {
            for (int j = 0; j < auxMatrix[0].length; j++) {
                System.out.print(strings[j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Convert the matrix of Plante to String matrix using the code name as input to the converted matrix
     **/
    private String[][] convertPlanteMatrixToStringMatrix(Plante[][] matrix) {
        String[][] auxMatrix = new String[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == this.numeroColonneToyeu - 1) {
                    auxMatrix[i][j] = "*";
                } else {
                    auxMatrix[i][j] = matrix[i][j].getCode().name();
                }
            }
            System.out.println();
        }
        return auxMatrix;
    }

    public Plante getPlanteByIndexes(int i, int j, Plante[][] matrix) {
        return matrix[i][j];
    }

    public void displayInfoOfParticularPlante(Plante plante) {
        System.out.println("-------------------------------");

        System.out.println("Code de la plante : " + plante.getCode());
        System.out.println("Taille maximale de la plante : " + plante.getTaille_max());
        System.out.println("Besion d'eau : " + plante.isNeedsWater());
        System.out.println("Support l'ombre : " + plante.isSupportOmbre());
        if (plante instanceof Fleur) {
            System.out.println("Couleur de la plante : " + ((Fleur) plante).getCouleur());
        }
        System.out.println("-------------------------------");

    }

    /**
     * Tester si n'importe quelle case est incompatible avec ses voisines.
     **/
    public boolean isIncompatible(int i, int j, Plante[][] matrix) {
        boolean isIncompatible = false;
        try {
            int diffNext = matrix[i][j].getTaille_max() - matrix[i][j + 1].getTaille_max();
            int diffPrevious = matrix[i][j].getTaille_max() - matrix[i][j - 1].getTaille_max();
            int diffTop = matrix[i][j].getTaille_max() - matrix[i + 1][j].getTaille_max();
            int diffButton = matrix[i][j].getTaille_max() - matrix[i - 1][j].getTaille_max();

            if (diffNext > 30 || diffPrevious > 30 || diffButton > 30 || diffTop > 30) {
                isIncompatible = true;
            }
        } catch (Exception e) {
            return isIncompatible;
        }
        return isIncompatible;
    }


    /**
     * Tester si deux cases données sont incompatible
     **/
    public boolean isIncompatibleBetweenTwoPlante(int i, int j, int x, int y, Plante[][] matrix) {
        boolean isIncompatible = false;
        try {
            int diff = matrix[i][j].getTaille_max() - matrix[x][y].getTaille_max();

            if (diff > 30) {
                isIncompatible = true;
            }
        } catch (Exception e) {
            return false;
        }
        return isIncompatible;
    }

    /**
     * Tester si une case donnée est loin du tuyau d’irrigation
     **/
    public boolean isConfusedWithThePipe(int j) {
        return j == this.numeroColonneToyeu - 1;
    }

    /**
     * Tester si une case donnée est à l’ombre
     **/
    public boolean isOmbre(int LigneDonne) {
        return LigneDonne - 1 >= indiceDebartZoneOmbre && LigneDonne - 1 <= indiceFinZoneOmbre - 1;
    }


    /**
     * Si le jardin est correctement amenagees
     **/
    public boolean jardinIsProperlyEquipped(Plante[][] matrix, Jardin jardin) {

        Plante plante = new Plante();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!plante.isProperlyEquipped(matrix, jardin)) {
                    return false;
                }
            }
        }
        return true;
    }


}

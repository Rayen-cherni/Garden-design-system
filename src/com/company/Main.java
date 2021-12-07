package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        //TODO :
        // - Mettre les indices dynamiques
        // - tester si la case est rempli ou pas !
        // - Zone d'ombrage !


        System.out.print("Saisir le nombre de lignes dans la matrice: ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        System.out.print("Saisir le nombre de colonnes dans la matrice: ");
        int n = sc.nextInt();

        System.out.print("Saisir le numéro de colonne de toyeu: ");
        int t = sc.nextInt();

        /** Create Jardin **/
        Jardin jardin = new Jardin(m, n, t);
        Plante[][] matrix = jardin.create();

        /** Creation des legumes **/
        Plante l1 = new Plante(Code.L, 30);
        Plante l2 = new Plante(Code.L, 30);
        Plante l3 = new Plante(Code.L, 30);

        /** Creation des feleurs **/
        Plante f1 = new Fleur(Code.R, 255, "Rose");
        Plante f2 = new Fleur(Code.C, 55, "Red");
        Plante f3 = new Fleur(Code.R, 55, "Rose");

        /** Remplisssage de la jardin par des legumes **/
        jardin.fillingByOnePlante(0, 0, l1, matrix);
        Plante aux = jardin.getPlanteByIndexes(0, 0, matrix);

        jardin.fillingByOnePlante(0, 1, l2, matrix);
        Plante aux11 = jardin.getPlanteByIndexes(0, 1, matrix);

        jardin.fillingByOnePlante(1, 0, l3, matrix);
        Plante aux111 = jardin.getPlanteByIndexes(1, 0, matrix);

        /** Affichage des legumes **/
        jardin.displayInfoOfParticularPlante(aux);
        jardin.displayInfoOfParticularPlante(aux11);
        jardin.displayInfoOfParticularPlante(aux111);

        /** Remplissage de la jardin par des fleures **/
        jardin.fillingByOnePlante(1, 1, f1, matrix);
        Plante aux2 = jardin.getPlanteByIndexes(1, 1, matrix);

        jardin.fillingByOnePlante(2, 0, f2, matrix);
        Plante aux22 = jardin.getPlanteByIndexes(2, 0, matrix);

        jardin.fillingByOnePlante(2, 1, f3, matrix);
        Plante aux222 = jardin.getPlanteByIndexes(2, 1, matrix);

        /** Affichage des fleures **/
        jardin.displayInfoOfParticularPlante(aux2);
        jardin.displayInfoOfParticularPlante(aux22);
        jardin.displayInfoOfParticularPlante(aux222);

        /** Dummy Data pour tester la methode de qst 6 **/
        jardin.fillingByOnePlante(0, 2, f1, matrix);
        jardin.fillingByOnePlante(1, 2, f1, matrix);
        jardin.fillingByOnePlante(2, 2, f1, matrix);
        jardin.fillingByOnePlante(3, 0, f1, matrix);
        jardin.fillingByOnePlante(3, 1, f1, matrix);
        jardin.fillingByOnePlante(3, 2, f1, matrix);

        /** Affichage de jardin sous la forme demandés dans qst 4 **/
        jardin.display(matrix);

        /** Test : si le donnees de deux cases voisines sont incompatibles **/
        System.out.println(String.format("Incompatibilité entre [%d][%d] et [%d][%d] est : " +
                jardin.isIncompatibleBetweenTwoPlante(0, 0, 0, 1, matrix), 0, 0, 0, 1));

        /** Test : si une case donnée a au moins un voisin au contenu incompatible **/
        System.out.println(String.format("Incompatibilité entre [%d][%d] et ses voisine est : "
                + jardin.isIncompatible(1, 1, matrix), 1, 1));

        /** Test : si une case donnée est loin du tuyau d’irrigation **/
        System.out.println(String.format("La fleur d'indice de colonne est [%d] confused avec le tuyau : "
                + jardin.isConfusedWithThePipe(3), 3));
    }
}

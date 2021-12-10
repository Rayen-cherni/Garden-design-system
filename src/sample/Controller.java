package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {

    //TODO :
    // - test unitaire Test case :
    // if input will be 4 4 4 3 4 => result will be : "confused with the pipe"
    // successfully Test : 5 5 5 3 4


    @FXML
    private TextField colonneMatrix;

    @FXML
    private TextField colonneToyeu;

    @FXML
    private TextField debartZoneOmbre;

    @FXML
    private TextField finZoneOmbre;

    @FXML
    private TextField ligneMatrix;

    @FXML
    private Button button;


    @FXML
    void getColonneMatrixSize(KeyEvent event) {
        System.out.println(colonneMatrix.getText());
        // Integer.parseInt(colonneMatrix.getText());
    }

    @FXML
    void getLigneDebartZoneOmbre(KeyEvent event) {
        System.out.println(debartZoneOmbre.getText());
    }

    @FXML
    void getLigneFinZoneOmbre(KeyEvent event) {
        System.out.println(finZoneOmbre.getText());
    }

    @FXML
    void getLigneMatrixSize(KeyEvent event) {
        System.out.println(ligneMatrix.getText());

    }

    @FXML
    void getPipePosition(KeyEvent event) {
        System.out.println(colonneToyeu.getText());

    }

    @FXML
    void runCode(KeyEvent event) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    fakeMain();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }


    void fakeMain() throws Exception {
        /** Casting **/
        String m = ligneMatrix.getText();
        String n = colonneMatrix.getText();
        String t = colonneToyeu.getText();
        String lzo = debartZoneOmbre.getText();
        String czo = finZoneOmbre.getText();

        int m1 = Integer.parseInt(m);
        int n1 = Integer.parseInt(n);
        int t1 = Integer.parseInt(t);
        int lzo1 = Integer.parseInt(lzo);
        int czo1 = Integer.parseInt(czo);

        /** Create Jardin **/
        Jardin jardin = new Jardin(m1, n1, t1, lzo1, czo1);
        Plante[][] matrix = jardin.create();

        /** Creation des legumes **/
        Plante l1 = new Plante(Code.L, 30);
        Plante l2 = new Plante(Code.T, 40);
        Plante l3 = new Plante(Code.L, 50);
        Plante l4 = new Plante(Code.T, 50);

        /** Creation des feleurs **/
        Plante f1 = new Fleur(Code.R, 255, "Rose");
        Plante f2 = new Fleur(Code.C, 55, "Red");
        Plante f3 = new Fleur(Code.R, 55, "Pink");
        Plante f4 = new Fleur(Code.C, 55, "Rose");


        /** Remplisssage de le jardin par des legumes **/
        jardin.fillingByOnePlante(0, 0, l1, matrix);
        Plante aux = jardin.getPlanteByIndexes(0, 0, matrix);

        jardin.fillingByOnePlante(0, 1, l2, matrix);
        Plante aux11 = jardin.getPlanteByIndexes(0, 1, matrix);

        jardin.fillingByOnePlante(0, 2, l3, matrix);
        Plante aux111 = jardin.getPlanteByIndexes(0, 2, matrix);

        jardin.fillingByOnePlante(0, 3, l4, matrix);
        Plante aux1111 = jardin.getPlanteByIndexes(0, 3, matrix);

        /** Affichage des legumes **/
        jardin.displayInfoOfParticularPlante(aux);
        jardin.displayInfoOfParticularPlante(aux11);
        jardin.displayInfoOfParticularPlante(aux111);
        jardin.displayInfoOfParticularPlante(aux1111);


        /** Remplissage de le jardin par des fleures **/
        jardin.fillingByOnePlante(1, 0, f1, matrix);
        Plante aux2 = jardin.getPlanteByIndexes(1, 0, matrix);

        jardin.fillingByOnePlante(1, 1, f2, matrix);
        Plante aux22 = jardin.getPlanteByIndexes(1, 1, matrix);

        jardin.fillingByOnePlante(1, 2, f3, matrix);
        Plante aux222 = jardin.getPlanteByIndexes(1, 2, matrix);

        jardin.fillingByOnePlante(1, 3, f3, matrix);
        Plante aux2222 = jardin.getPlanteByIndexes(1, 3, matrix);

        /** Affichage des fleures **/
        jardin.displayInfoOfParticularPlante(aux2);
        jardin.displayInfoOfParticularPlante(aux22);
        jardin.displayInfoOfParticularPlante(aux222);
        jardin.displayInfoOfParticularPlante(aux2222);

        /** Dummy Data pour tester la methode de qst 6 **/
        jardin.fillingByOnePlante(2, 0, l1, matrix);
        jardin.fillingByOnePlante(2, 1, l2, matrix);
        jardin.fillingByOnePlante(2, 2, l3, matrix);
        jardin.fillingByOnePlante(2, 3, l4, matrix);

        jardin.fillingByOnePlante(3, 0, f1, matrix);
        jardin.fillingByOnePlante(3, 1, f2, matrix);
        jardin.fillingByOnePlante(3, 2, f3, matrix);
        jardin.fillingByOnePlante(3, 3, f4, matrix);

        /** Dummy Data pour tester le successfully test **/
        jardin.fillingByOnePlante(4, 0, l1, matrix);
        jardin.fillingByOnePlante(4, 1, f2, matrix);
        jardin.fillingByOnePlante(4, 2, f3, matrix);
        jardin.fillingByOnePlante(4, 3, l4, matrix);


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

        /** Test : Si une case donnée est à l'ombre **/
        System.out.println("La case donnees est appartient a la zone ombre : " + jardin.isOmbre(4));


        /** Test : Si une case donnes est correctement amenagees **/
        // System.out.println("La case donnee est correctement aménagée : " + f1.isProperlyEquipped(matrix, jardin, 3, 0)); => Result false :
        // puisque f1 est de code C de coup ne support pas l'ombre mais elle est placee dans une zone ombree


         System.out.println("La case donnee est correctement aménagée : " + f1.isProperlyEquipped(matrix, jardin, 1, 0));
        //Result : True, => Ne support pas l'ombre mais placee dans une zone n'est pas ombree

        /** Test : Si une le jardin est correctement amenagees **/
        System.out.println("Le jardin est correctement aménagée : " + jardin.jardinIsProperlyEquipped(matrix, jardin));
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.BressanJoaquinSudarioRichard.vista;

import edu.ub.prog2.BressanJoaquinSudarioRichard.model.CarpetaFitxers;
import java.util.Scanner;
import edu.ub.prog2.utils.Menu;
import java.io.File;
/**
 *
 * @author Joaquin Bressan & rsudarbe117.alumnes
 * The IniciadorAplicacioUB class contains the imported menu and the main class
 * where the program will be executed
 */
public class IniciadorAplicacioUB {

        /**Set of predefined constants
         * 
         */
    static private enum OptionsMainMenu {
        MAIN_MENU_OPTION1, MAIN_MENU_OPTION2, MAIN_MENU_OPTION3, MAIN_MENU_EXIT
    };
        /**String list with the different
         * options that the user will have
         */
    static private String[] descMainMenu = {"Afegir fitxer multimedia", "Eliminar fitxer multimedia", "Mostrar carpeta", "Sortir"};

	/**main() method where menu is implemented
	 *
	 * @param args
	 */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        IniciadorAplicacioUB aplicacio = new IniciadorAplicacioUB();

        aplicacio.gestioAplicacioUB(sc);
    }

	/**Method where the imported menu
         * is called and managed
	 *
	 * @param sc
	 */
    public void gestioAplicacioUB(Scanner sc) {
        
        //creating an object from Menu's class
        Menu<OptionsMainMenu> mainMenu = new Menu<OptionsMainMenu>("Main Menu", OptionsMainMenu.values());

        String p;
        File f;
        CarpetaFitxers cf = new CarpetaFitxers();
        
        mainMenu.setDescripcions(descMainMenu);//method in imported menu

        OptionsMainMenu option = null;
        do {
            mainMenu.mostrarMenu();//method in imported menu
            option = mainMenu.getOpcio(sc);

            switch (option) {
                case MAIN_MENU_OPTION1:
                    System.out.print("Path? ");
                    p = sc.next();
                    if (checkFile(p)) {
                        f = new File(p);
                        //try...catch methods for thrown Java exceptions
                        try { //statement executed while there are no errors
                            cf.addFitxer(f);
                        } catch(Exception e) { // statement executed if an error occurs in the try block
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid path.");
                    }
                    break;
                case MAIN_MENU_OPTION2:
                    if(cf.getSize()==0){
                        System.out.println("The folder is empty");
                    } else {
                        System.out.print("Path? ");
                        p = sc.next();
                        if (checkFile(p)) {
                            f = new File(p);
                            try {
                                cf.removeFitxer(f);
                            } catch(Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Invalid path.");
                        }
                    }
                    break;
                case MAIN_MENU_OPTION3:
                    System.out.println(cf);
                    break;
                case MAIN_MENU_EXIT:
                    System.out.println("Good Bye");
                    break;
                //default choice already implemented in the jar imported
            }

        } while (option != OptionsMainMenu.MAIN_MENU_EXIT);

    }

	/**Method to check the existence of a file
         * through a given path
	 *
	 * @param p
	 * @return boolean
	 */
    public static boolean checkFile(String p) {
        File file = new File(p);        
        return file.exists();
    }
}

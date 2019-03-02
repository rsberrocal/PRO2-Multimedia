/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class IniciadorAplicacioUB {

    /**
     * @param args the command line arguments
     */
    static private enum OptionsMainMenu {
        MAIN_MENU_OPTION1, MAIN_MENU_OPTION2, MAIN_MENU_OPTION3, MAIN_MENU_EXIT
    };

    static private String[] descMainMenu = {"Afegir fitxer multimedia", "Eliminar fitxer multimedia", "Mostrar carpeta", "Sortir"};

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        IniciadorAplicacioUB aplicacio = new IniciadorAplicacioUB();

        aplicacio.gestioAplicacioUB(sc);
    }

    public void gestioAplicacioUB(Scanner sc) {

        Menu<OptionsMainMenu> mainMenu = new Menu<OptionsMainMenu>("Main Menu", OptionsMainMenu.values());

        String p, ext, description, name, d = null;
        CarpetaFitxers cf = new CarpetaFitxers();
        File f;

        mainMenu.setDescripcions(descMainMenu);

        OptionsMainMenu option = null;
        do {
            mainMenu.mostrarMenu();
            option = mainMenu.getOpcio(sc);

            switch (option) {
                case MAIN_MENU_OPTION1:
                    System.out.print("Path? ");
                    p = sc.next();
                    if (checkFile(p) == true) {
                        f = new File(p);
                        try {
                            cf.addFitxer(f);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    } else {
                        System.out.println("Invalid path.");
                    }
                    break;
                case MAIN_MENU_OPTION2:
                    System.out.print("Path? ");
                    p = sc.next();
                    if (checkFile(p) == true) {
                        f = new File(p);
                        try {
                            cf.removeFitxer(f);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    } else {
                        System.out.println("Invalid path.");
                    }
                    break;
                case MAIN_MENU_OPTION3:
                    System.out.println(cf);
                    break;
                case MAIN_MENU_EXIT:
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Error");
                    break;

            }

        } while (option != OptionsMainMenu.MAIN_MENU_EXIT);

    }

    public static boolean checkFile(String p) {
        File file = new File(p);
        System.err.println("ABOSULTE PATH "+file.getAbsolutePath());
        System.out.println("REL "+file.getPath());
        System.out.println("COSO "+file.exists());
        return file.exists();
    }
}

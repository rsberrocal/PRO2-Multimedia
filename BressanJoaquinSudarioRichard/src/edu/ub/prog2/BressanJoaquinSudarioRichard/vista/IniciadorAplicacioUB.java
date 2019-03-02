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

import edu.ub.prog2.BressanJoaquinSudarioRichard.model.CarpetaFitxer;
import edu.ub.prog2.BressanJoaquinSudarioRichard.model.FitxerMultimedia;
import java.util.Scanner;
import edu.ub.prog2.utils.Menu;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
/**
 *
 * @author rsudarbe117.alumnes
 */
public class IniciadorAplicacioUB {

    /**
     * @param args the command line arguments
     */
    static private enum OptionsMainMenu {
        MAIN_MENU_OPTION1, MAIN_MENU_OPTION2, MAIN_MENU_EXIT
    };

    static private String[] descMainMenu = {"Afegir fitxer multimèdia", "Eliminar fitxer multimèdia", "Mostrar carpeta", "Sortir"};

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        IniciadorAplicacioUB aplicacio = new IniciadorAplicacioUB();

        aplicacio.gestioAplicacioUB(sc);
    }

    public void gestioAplicacioUB(Scanner sc) {

        Menu<OptionsMainMenu> mainMenu = new Menu<OptionsMainMenu>("Main Menu", OptionsMainMenu.values());
        
        String p, ext, description, name, d = null;
        CarpetaFitxer cf = new CarpetaFitxer();
        File f;
        
        mainMenu.setDescripcions(descMainMenu);

        OptionsMainMenu option = null;
        do {
            mainMenu.mostrarMenu();
            option = mainMenu.getOpcio(sc);
            
            switch(option){
                case MAIN_MENU_OPTION1:
                    System.out.print("Path? ");
                    p = sc.next();
                    if (checkFile(p)==true){
                        File fi = new File(p);
                        cf.addFitxer(fi);
                    }else{
                        System.out.println("File does not exist.");
                    }
                    break;
                case MAIN_MENU_OPTION2:
                    System.out.print("Path? ");
                    p = sc.next();
                    if (checkFile(p)== true){
                    f = new File(p);
                    cf.removeFitxer(f);
                    }
                    System.out.println("Option 2");
                    break;
                case MAIN_MENU_EXIT:
                    System.out.println("Good Bye");
                    break;
            }
            
        } while (option != OptionsMainMenu.MAIN_MENU_EXIT);

    }
    
    public static boolean checkFile(String p){
        Path path = Paths.get(p);
        return Files.exists(path);
    }
}
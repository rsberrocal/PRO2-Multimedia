/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.BressanJoaquinSudarioRichard.vista;

import java.util.Scanner;
import edu.ub.prog2.utils.Menu;

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

    static private String[] descMainMenu = {"Option 1", "Option 2", "Option 3", "Exit"};

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        IniciadorAplicacioUB aplicacio = new IniciadorAplicacioUB();

        aplicacio.gestioAplicacioUB(sc);
    }

    public void gestioAplicacioUB(Scanner sc) {

        Menu<OptionsMainMenu> mainMenu = new Menu<OptionsMainMenu>("Main Menu", OptionsMainMenu.values());

        mainMenu.setDescripcions(descMainMenu);

        OptionsMainMenu option = null;
        do {
            mainMenu.mostrarMenu();
            option = mainMenu.getOpcio(sc);
            
            switch(option){
                case MAIN_MENU_OPTION1:
                    System.out.println("Option 1");
                    break;
                case MAIN_MENU_OPTION2:
                    System.out.println("Option 2");
                    break;
                    case MAIN_MENU_EXIT:
                        System.out.println("Good Bye");
                        break;
            }
            
        } while (option != OptionsMainMenu.MAIN_MENU_EXIT);

    }
}

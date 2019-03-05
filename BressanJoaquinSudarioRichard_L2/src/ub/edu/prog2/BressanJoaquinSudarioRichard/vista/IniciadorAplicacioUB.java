/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;
import ub.edu.prog2.BressanJoaquinSudarioRichard.vista.AplicacioUB2;
import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class IniciadorAplicacioUB {
    static private enum OpcionsMainMenu{
        MAIN_MENU_OPTION1, MAIN_MENU_OPTION2, MAIN_MENU_OPTION3, MAIN_MENU_EXIT
    };
    static private enum OpcionsSubMenu{
        SUB_MENU_OPTION1, SUB_MENU_OPTION2, SUB_MENU_OPTION3, SUB_MENU_EXIT
    };
    static private enum OpcionsSubMenu1{
        SUB_MENU1_OPTION1, SUB_MENU1_OPTION2, SUB_MENU1_OPTION3, SUB_MENU1_EXIT
    }
    
    static private String[] descMainMenu = {"Gestio biblioteca", "Guardar dades", "Recuperar dades", "Sortir"};
    static private String[] descSubMenu = {"Afegir fitxer multimedia", "Mostrar carpeta", "Eliminar fitxer multimedia", "Menu anterior"};
    static private String[] descSubMenu1 = {"Afegir video", "Afegir audio", "Menu anterior"};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AplicacioUB2 app = new AplicacioUB2();
        
        app.gestioAplicacioUB(sc);
    }
    
    public void gestioAplicacioUB(Scanner sc){
        Menu<OpcionsMainMenu> mainMenu = new Menu("Menu", {OpcionsMainMenu,OpcionsSubMenu,OpcionsSubMenu1});
    }
}

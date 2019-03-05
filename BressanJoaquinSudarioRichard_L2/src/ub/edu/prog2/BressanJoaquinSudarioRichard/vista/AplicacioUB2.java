/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;

/**
 *
 * @author joaqu
 */
public class AplicacioUB2 {
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
    
}

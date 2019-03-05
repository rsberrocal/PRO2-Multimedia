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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AplicacioUB2 app = new AplicacioUB2();
        
        app.gestioAplicacioUB(sc);
    }
    
    public void gestioAplicacioUB(Scanner sc){
        Menu<OpcionsMainMenu,OpcionsSubMenu,OpcionsSubMenu1> mainMenu = new Menu("Menu", {OpcionsMainMenu,OpcionsSubMenu,OpcionsSubMenu1)
    }
}

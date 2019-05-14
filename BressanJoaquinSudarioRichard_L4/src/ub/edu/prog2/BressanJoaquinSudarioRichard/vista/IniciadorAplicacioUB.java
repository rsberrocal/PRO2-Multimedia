/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;

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
        
        AplicacioUB3 aplicacio = new AplicacioUB3();
        
        aplicacio.gestioAplicacioUB(sc);
    }
    
}

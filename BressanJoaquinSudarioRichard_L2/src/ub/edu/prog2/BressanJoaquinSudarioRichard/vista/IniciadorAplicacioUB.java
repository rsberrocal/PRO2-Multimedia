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
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AplicacioUB2 aplicacio = new AplicacioUB2();
        
        aplicacio.gestioAplicacioUB(sc);
    }
}

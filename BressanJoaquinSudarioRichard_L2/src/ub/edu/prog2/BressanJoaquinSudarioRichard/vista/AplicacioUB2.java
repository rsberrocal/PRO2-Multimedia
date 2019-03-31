/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;

import edu.ub.prog2.utils.AplicacioException;
import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.Controlador;
import edu.ub.prog2.utils.Menu;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class AplicacioUB2 {
    static private enum OptionsMainMenu{
        MAIN_MENU_OPTION1, MAIN_MENU_OPTION2, MAIN_MENU_OPTION3, MAIN_MENU_EXIT
    };
    static private enum OptionsSubMenu1{
        SUB_MENU1_OPTION1, SUB_MENU1_OPTION2, SUB_MENU1_OPTION3, SUB_MENU1_EXIT
    };
    static private enum OptionsSubMenu2{
        SUB_MENU2_OPTION1, SUB_MENU2_OPTION2, SUB_MENU2_EXIT
    }
    
    static private String[] descMainMenu = {"Gestio biblioteca", "Guardar dades","Recuperar dades", "Sortir"};
    static private String[] descSubMenu1 = {"Afegir fitxer multimedia", "Mostrar carpeta", "Eliminar fitxer multimedia", "Menu anterior"};
    static private String[] descSubMenu2 = {"Afegir video", "Afegir audio", "Menu anterior"};
    Controlador c = new Controlador(); 
    String path, nom, codec;
    float durada, fps;
    int alcada, amplada, kbps;
    File camiImatge;
    
    public void gestioAplicacioUB(Scanner sc){
        
        Menu<OptionsMainMenu> mainMenu = new Menu<>("Main menu", OptionsMainMenu.values());
        
        mainMenu.setDescripcions(descMainMenu);
        
        
        String p;
        
        OptionsMainMenu opt = null;
        do{
            mainMenu.mostrarMenu();
            opt = mainMenu.getOpcio(sc);
            
            switch(opt){
                case MAIN_MENU_OPTION1:
                    gestioSubMenu1(sc);
                    break;
                case MAIN_MENU_OPTION2:
                    System.out.println("Insert destination path: ");
                    p = sc.next();
                    try{
                        c.guardarDadesDisc(p);
                    } catch(AplicacioException a){
                        System.err.println(a);
                    } catch(IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case MAIN_MENU_OPTION3:
                    System.out.println("Insert origin path: ");
                    p = sc.next();
                    try{
                        c.carregarDadesDisc(p);
                    } catch(AplicacioException a){
                        System.err.println(a);
                    } catch(IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;  
                case MAIN_MENU_EXIT:
                    System.out.println("Good bye");
                    break;
                
            }
                            
        } while (opt != OptionsMainMenu.MAIN_MENU_EXIT);
    }
    
    public void gestioSubMenu1(Scanner sc){
        Menu<OptionsSubMenu1> subMenu1 = new Menu<>("Submenu 1", OptionsSubMenu1.values());
        
        subMenu1.setDescripcions(descSubMenu1);
        
        OptionsSubMenu1 opt = null;
        do{
            subMenu1.mostrarMenu();
            opt = subMenu1.getOpcio(sc);
            
            switch(opt){
                case SUB_MENU1_OPTION1:
                    gestioSubMenu2(sc);
                    break;
                case SUB_MENU1_OPTION2:
                    System.out.println(c.mostrarBiblioteca());
                    break;
                case SUB_MENU1_OPTION3:
                    int id;
                    c.mostrarBiblioteca();
                    System.out.println("File id?");
                    id = sc.nextInt();
                    try{
                        c.esborrarFitxer(id);
                    }catch(AplicacioException e){
                        System.out.println(e.getMessage());
                    }        
                    break;
                case SUB_MENU1_EXIT:
                    break;
            }
            
        } while(opt != OptionsSubMenu1.SUB_MENU1_EXIT);
    }
    
    public void gestioSubMenu2 (Scanner sc) throws AplicacioException{
        Menu<OptionsSubMenu2> subMenu2 = new Menu<>("Submenu 2", OptionsSubMenu2.values());
        
        subMenu2.setDescripcions(descSubMenu2);
        
        OptionsSubMenu2 opt = null;
        do{
            subMenu2.mostrarMenu();
            opt = subMenu2.getOpcio(sc);
            switch(opt){
                case SUB_MENU2_OPTION1:
                    System.out.print("Video's path? ");
                    path = sc.next();
                    System.out.print("Video's name? ");
                    nom = sc.next();
                    System.out.print("Video's codec? ");
                    codec = sc.next();
                    System.out.print("Video's duration? ");
                    durada = sc.nextFloat();
                    System.out.print("Video's height? ");
                    alcada = sc.nextInt();
                    System.out.print("Video's width( ");
                    amplada = sc.nextInt();
                    System.out.print("Video's fps? ");
                    fps = sc.nextFloat();
                    try{
                        c.afegirVideo(path, nom, codec, durada, alcada, amplada, fps);
                    }catch(AplicacioException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case SUB_MENU2_OPTION2:
                    System.out.print("Audio's path? ");
                    path = sc.next();
                    System.out.print("Audio's name? ");
                    nom = sc.next();
                    System.out.print("Audio's codec? ");
                    codec = sc.next();
                    System.out.print("Audio's duration? ");
                    durada = sc.nextFloat();
                    System.out.print("Audio's height? ");
                    alcada = sc.nextInt();
                    System.out.print("Audio's width? ");
                    amplada = sc.nextInt();
                    System.out.print("Audio's kbps? ");
                    kbps = sc.nextInt();
                    try{
                        c.afegirVideo(path, nom, codec, durada, alcada, amplada, kbps);
                    }catch(AplicacioException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case SUB_MENU2_EXIT:
                    break;
            } 
        } while (opt != OptionsSubMenu2.SUB_MENU2_EXIT);
    }
}

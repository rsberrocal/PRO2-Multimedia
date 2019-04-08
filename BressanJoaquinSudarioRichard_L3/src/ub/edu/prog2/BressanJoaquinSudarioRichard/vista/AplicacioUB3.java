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
public class AplicacioUB3 {
    static private enum OptionsMainMenu{
        MAIN_MENU_OPTION1, MAIN_MENU_OPTION2, MAIN_MENU_OPTION3, MAIN_MENU_OPTION4, MAIN_MENU_OPTION5, MAIN_MENU_EXIT
    };
    static private enum OptionsSubMenu1{
        SUB_MENU1_OPTION1, SUB_MENU1_OPTION2, SUB_MENU1_OPTION3, SUB_MENU1_EXIT
    };
    static private enum OptionsSubMenu11{
        SUB_MENU11_OPTION1, SUB_MENU11_OPTION2, SUB_MENU11_EXIT
    };
    static private enum OptionsSubMenu2{
        SUB_MENU2_OPTION1, SUB_MENU2_OPTION2, SUB_MENU2_OPTION3, SUB_MENU2_OPTION4, SUB_MENU2_EXIT
    };
    static private enum OptionsSubMenu24{
        SUB_MENU24_OPTION1, SUB_MENU24_OPTION2, SUB_MENU24_OPTION3, SUB_MENU24_EXIT
    };
    static private enum OptionsSubMenu3{
        SUB_MENU3_OPTION1, SUB_MENU3_OPTION2, SUB_MENU3_OPTION3, SUB_MENU3_OPTION4, SUB_MENU3_OPTION5, SUB_MENU3_OPTION6, SUB_MENU3_EXIT
    };
    static private enum OptionsSubMenu36{
        SUB_MENU36_OPTION1, SUB_MENU36_OPTION2, SUB_MENU36_OPTION3, SUB_MENU36_OPTION4, SUB_MENU36_EXIT
    };
    
    static private String[] descMainMenu = {"Gestio biblioteca", "Gestio Albums", "Control Reproduccio/Visio", "Guardar dades","Recuperar dades", "Sortir"};
    static private String[] descSubMenu1 = {"Afegir fitxer multimedia", "Mostrar carpeta", "Eliminar fitxer multimedia", "Menu anterior"};
    static private String[] descSubMenu11 = {"Afegir video", "Afegir audio", "Menu anterior"};
    static private String[] descSubMenu2 = {"Afegir album", "Mostrar albums", "Eliminar album", "Gestionar album", "Menu anterior"};
    static private String[] descSubMenu24 = {"Afegir fitxer multimedia", "Mostrar album", "Eliminar fitxer multimedia", "Menu anterior"};
    static private String[] descSubMenu3 = {"Reproduir un fitxer reproduible", "Reproduir tota la biblioteca", "Reproduir un album", "Activar/desactivar reproduccio continua", "Activar/desactivar reproduccio aleatoria", "Gestio reproduccio en curso", "Menu anterior"};
    static private String[] descSubMenu36 = {"Re-empren", "Pausa", "Atura", "Salta", "Menu anteriro"};
                                            
    Controlador c = new Controlador(); 
    String path, nom, codec, pathFile;
    float durada, fps;
    int alcada, amplada, kbps;
    File camiImatge;
    
    /**
     *
     * @param sc
     */
    public void gestioAplicacioUB(Scanner sc){
        
        Menu<OptionsMainMenu> mainMenu = new Menu<>("Main menu", OptionsMainMenu.values());
        
        mainMenu.setDescripcions(descMainMenu);
        
        
        String p;
        
        OptionsMainMenu opt;
        do{
            mainMenu.mostrarMenu();
            opt = mainMenu.getOpcio(sc);
            
            switch(opt){
                case MAIN_MENU_OPTION1:
                    gestioSubMenu1(sc);
                    break;
                case MAIN_MENU_OPTION2:
                    gestioSubMenu2(sc);
                    break;
                case MAIN_MENU_OPTION3:
                    gestioSubMenu3(sc);
                    break;
                case MAIN_MENU_OPTION4:
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
                case MAIN_MENU_OPTION5:
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
    
    /**
     *
     * @param sc
     */
    public void gestioSubMenu1(Scanner sc){
        Menu<OptionsSubMenu1> subMenu1 = new Menu<>("Submenu 1", OptionsSubMenu1.values());
        
        subMenu1.setDescripcions(descSubMenu1);
        
        OptionsSubMenu1 opt;
        do{
            subMenu1.mostrarMenu();
            opt = subMenu1.getOpcio(sc);
            
            switch(opt){
                case SUB_MENU1_OPTION1:
                    gestioSubMenu11(sc);
                    break;
                case SUB_MENU1_OPTION2:
                    if (c.isEmpty()){
                        System.out.println("Biblioteca vacía.");
                    }else{
                        System.out.println(c.mostrarBiblioteca());
                    }
                    break;
                case SUB_MENU1_OPTION3:
                    if (c.isEmpty()){
                        System.out.println("Biblioteca vacía.");
                    }else{
                        int id;
                        System.out.println(c.mostrarBiblioteca());
                        System.out.println("File id?");
                        id = sc.nextInt();
                        try{
                            c.esborrarFitxer(id);
                        }catch(AplicacioException e){
                            System.out.println(e);
                        }
                    }
                    break;
                case SUB_MENU1_EXIT:
                    break;
            }
            
        } while(opt != OptionsSubMenu1.SUB_MENU1_EXIT);
    }
    
    /**
     *
     * @param sc
     */
    public void gestioSubMenu11 (Scanner sc){
        Menu<OptionsSubMenu11> subMenu11 = new Menu<>("Submenu 1.1", OptionsSubMenu11.values());
        
        subMenu11.setDescripcions(descSubMenu11);
        
        OptionsSubMenu11 opt;
        do{
            subMenu11.mostrarMenu();
            opt = subMenu11.getOpcio(sc);
            switch(opt){
                case SUB_MENU11_OPTION1:
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
                    System.out.print("Video's width? ");
                    amplada = sc.nextInt();
                    System.out.print("Video's fps? ");
                    fps = sc.nextFloat();
                    try{
                        c.afegirVideo(path, nom, codec, durada, alcada, amplada, fps);
                    }catch(AplicacioException e){
                        System.out.println(e);
                    }
                    break;
                case SUB_MENU11_OPTION2:
                    System.out.print("Audio's path? ");
                    path = sc.next();
                    System.out.print("Audio's name? ");
                    nom = sc.next();
                    System.out.print("Audio's image path? ");
                    pathFile = sc.next();
                    camiImatge = new File(pathFile);
                    System.out.print("Audio's codec? ");
                    codec = sc.next();
                    System.out.print("Audio's duration? ");
                    durada = sc.nextFloat();
                    System.out.print("Audio's kbps? ");
                    kbps = sc.nextInt();
                    try{
                        c.afegirAudio(path, camiImatge, nom, codec, durada, kbps);
                    }catch(AplicacioException e){
                        System.out.println(e);
                    }
                    break;
                case SUB_MENU11_EXIT:
                    break;
                
            } 
        } while (opt != OptionsSubMenu11.SUB_MENU11_EXIT);
    }
    
    public void gestioSubMenu2(Scanner sc){
        Menu<OptionsSubMenu2> subMenu2 = new Menu<>("Submenu 2", OptionsSubMenu2.values());
        
        subMenu2.setDescripcions(descSubMenu2);
        
        OptionsSubMenu2 opt;
        do{
            subMenu2.mostrarMenu();
            opt = subMenu2.getOpcio(sc);
            switch(opt){
                case SUB_MENU2_OPTION1:
                    
                    break;
                case SUB_MENU2_OPTION2:
                    break;
                case SUB_MENU2_OPTION3:
                    break;
                case SUB_MENU2_OPTION4:
                    gestioSubMenu24(sc);
                    break;
                case SUB_MENU2_EXIT:
                    break;
                
            } 
        } while (opt != OptionsSubMenu2.SUB_MENU2_EXIT);
    }
    public void gestioSubMenu24(Scanner sc){
        Menu<OptionsSubMenu24> subMenu24 = new Menu<>("Submenu 2.4", OptionsSubMenu24.values());
        
        subMenu24.setDescripcions(descSubMenu24);
        
        OptionsSubMenu24 opt;
        do{
            subMenu24.mostrarMenu();
            opt = subMenu24.getOpcio(sc);
            switch(opt){
                case SUB_MENU24_OPTION1:
                    
                    break;
                case SUB_MENU24_OPTION2:
                    break;
                case SUB_MENU24_OPTION3:
                    break;
                case SUB_MENU24_EXIT:
                    break;
                
            } 
        } while (opt != OptionsSubMenu24.SUB_MENU24_EXIT);
    }
    public void gestioSubMenu3(Scanner sc){
        Menu<OptionsSubMenu3> subMenu3 = new Menu<>("Submenu 3", OptionsSubMenu3.values());
        
        subMenu3.setDescripcions(descSubMenu3);
        
        OptionsSubMenu3 opt;
        do{
            subMenu3.mostrarMenu();
            opt = subMenu3.getOpcio(sc);
            switch(opt){
                case SUB_MENU3_OPTION1:
                    break;
                case SUB_MENU3_OPTION2:
                    break;
                case SUB_MENU3_OPTION3:
                    break;
                case SUB_MENU3_OPTION4:
                    break;
                case SUB_MENU3_OPTION5:
                    break;
                case SUB_MENU3_OPTION6:
                    gestioSubMenu36(sc);
                    break;
                case SUB_MENU3_EXIT:
                    break;
                
            } 
        } while (opt != OptionsSubMenu3.SUB_MENU3_EXIT);
    }
    public void gestioSubMenu36(Scanner sc){
        Menu<OptionsSubMenu36> subMenu36 = new Menu<>("Submenu 3.6", OptionsSubMenu36.values());
        
        subMenu36.setDescripcions(descSubMenu36);
        
        OptionsSubMenu36 opt;
        do{
            subMenu36.mostrarMenu();
            opt = subMenu36.getOpcio(sc);
            switch(opt){
                case SUB_MENU36_OPTION1:
                    
                    break;
                case SUB_MENU36_OPTION2:
                    break;
                case SUB_MENU36_OPTION3:
                    break;
                case SUB_MENU36_OPTION4:
                    break;
                case SUB_MENU36_EXIT:
                    break;
                
            } 
        } while (opt != OptionsSubMenu36.SUB_MENU36_EXIT);
    }
}
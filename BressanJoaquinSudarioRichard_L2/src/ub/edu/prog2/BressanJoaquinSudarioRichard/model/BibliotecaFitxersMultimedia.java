/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers{
    public BibliotecaFitxersMultimedia(){
        
    }
    
    public void addFitxer(File fitxer, boolean isAudio){
        if(isAudio){
            Audio aud = new Audio();
        }else{
            
        }
    }    
    
}

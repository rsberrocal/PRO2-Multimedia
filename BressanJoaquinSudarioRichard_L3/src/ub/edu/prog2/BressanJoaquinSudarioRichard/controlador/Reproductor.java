/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import edu.ub.prog2.utils.ReproductorBasic;
import java.io.File;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Audio;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.FitxerReproduible;

/**
 *
 * @author Rocho
 */
public class Reproductor extends ReproductorBasic {
    public Reproductor(EscoltadorReproduccioBasic controlador) {
        super(controlador);
    }
   
    public void reprodueix(FitxerReproduible fr) throws AplicacioException{
        this.play(fr);
        
        
    }
    public void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException{
        this.play(audio, fitxerImatge);
    }
    
}

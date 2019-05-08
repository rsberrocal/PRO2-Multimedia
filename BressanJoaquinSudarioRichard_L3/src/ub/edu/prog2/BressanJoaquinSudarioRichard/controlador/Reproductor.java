/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
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

    /**
     *
     * @param vlcPath
     * @param controlador
     */
    public Reproductor(EscoltadorReproduccioBasic controlador) {
        super("C:\\Program Files\\VideoLAN\\VLC",controlador);
    }
   
    /**
     *
     * @param fr
     * @throws AplicacioException
     */
    public void reprodueix(FitxerReproduible fr) throws AplicacioException{
        this.play(fr);
        
        
    }

    /**
     *
     * @param audio
     * @param fitxerImatge
     * @throws AplicacioException
     */
    public void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException{
            this.play(audio, fitxerImatge);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class AlbumFitxersMultimedia extends CarpetaFitxers {

    private int maxFiles;

    public AlbumFitxersMultimedia() {
        super(10);
        this.maxFiles = 10;
    }

    public AlbumFitxersMultimedia(int max){
        super(max);
        this.maxFiles = max;
    }
    
    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

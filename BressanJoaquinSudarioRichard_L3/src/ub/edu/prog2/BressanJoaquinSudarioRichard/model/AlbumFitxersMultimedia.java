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

    private int maxFiles = 100;
    private String title;

    /**
     * Creates a new album with max size and title
     *
     * @param max
     * @param titulo
     */
    public AlbumFitxersMultimedia(int max, String titulo) {
        this.maxFiles = max;
    }

    //addFitxer if the album is full, throw an error, else add the file
    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        if (this.getSize() < this.maxFiles) {
            super.addFitxer(fitxer);
        } else {
            throw new AplicacioException("Album Full");
        }
    }

    @Override
    public String toString() {
        String message = "Album " + this.title + "\n";
        message += "==================\n";
        message += super.toString();
        return message;
    }
    
    /**
     *
     * @param title set a new title album
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return title from the album
     */
    public String getTitle() {
        return this.title;
    }
}

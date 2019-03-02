/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;
import java.util.Date;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class FitxerMultimedia extends File{  
    
    private String path;
    private String nameFile;
    private String ext;
    private Date lastUpdate;
    private String description;
    
    public FitxerMultimedia(String path) {
        super(path);
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean equals(FitxerMultimedia fitxerMultimedia){
        if(this.path == fitxerMultimedia.getPath() && this.nameFile == fitxerMultimedia.getNameFile()
                && this.ext == fitxerMultimedia.getExt() && this.description == fitxerMultimedia.getDescription()
                && this.lastUpdate == fitxerMultimedia.getLastUpdate()){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return("Description: " + this.getDescription() + ", date: " +  this.getLastUpdate()
                + ", file name: " + this.getNameFile() + ", extension: " + this.getExt() + ", path: " + this.path);
    }
}

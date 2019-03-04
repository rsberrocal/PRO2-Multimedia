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
    
	/**
	 *
	 * @param path
	 */
	public FitxerMultimedia(String path) {
        super(path);
        this.path = path;
    }
    
    //getters
    public String getPath() {
        return path;
    }

	/**
	 *
	 * @return
	 */
	public String getNameFile() {
        return nameFile;
    }

	/**
	 *
	 * @return
	 */
	public String getExt() {
        return ext;
    }

	/**
	 *
	 * @return
	 */
	public Date getLastUpdate() {
        return lastUpdate;
    }

	/**
	 *
	 * @return
	 */
	public String getDescription() {
        return description;
    }

    //setters

	/**
	 *
	 * @param path
	 */
    public void setPath(String path) {
        this.path = path;
    }
    
	/**
	 *
	 * @param description
	 */
	public void setDescription(String description) {
        this.description = description;
    }
    
	/**
	 *
	 * @param nameFile
	 */
	public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

	/**
	 *
	 * @param ext
	 */
	public void setExt(String ext) {
        this.ext = ext;
    }

	/**
	 *
	 * @param lastUpdate
	 */
	public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
     
	/**
	 *
	 * @param fitxerMultimedia
	 * @return
	 */
	public boolean equals(FitxerMultimedia fitxerMultimedia){
        if(this.path == fitxerMultimedia.getPath() && this.nameFile == fitxerMultimedia.getNameFile()
                && this.ext == fitxerMultimedia.getExt() && this.description == fitxerMultimedia.getDescription()
                && this.lastUpdate == fitxerMultimedia.getLastUpdate()){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return("Descripció = " + this.getDescription() + ", data = " + this.getLastUpdate() + ", nom fitxer = " + this.getNameFile() + ", ext = " + this.getExt() + ", cami complet = " + this.getAbsolutePath());
    }
}

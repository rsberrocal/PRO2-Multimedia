/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;
import java.util.Date;

/**
 *
 * @author rsudarbe117.alumnes & jbressna9.alumnes
 * The FitxerMultimedia class defines the attributes
 * of a multimedia file
 */
public class FitxerMultimedia extends File{ 
    
        /**Path, name, extension, date, description of
         * the multimedia file
         */
    private String path;
    private String nameFile;
    private String ext;
    private Date lastUpdate;
    private String description;
    

        /**Constructor for FitxerMultimedia
         * 
         * @param path
         */
    public FitxerMultimedia(String path) {
        super(path);
        this.path = path;
    }
    
        /**Gets file's path
         * 
         * @return String
         */
    public String getPath() {
            return path;
    }

	/**Gets file's name
	 *
	 * @return String
	 */
    public String getNameFile() {
        return nameFile;
    }

	/**Gets file's extension
	 *
	 * @return String
	 */
    public String getExt() {
        return ext;
    }

	/**Gets file's last update
	 *
	 * @return Date
	 */
    public Date getLastUpdate() {
        return lastUpdate;
    }

	/**Gets file's description
	 *
	 * @return String
	 */
    public String getDescription() {
        return description;
    }

        /**Sets file's path by the inserted string
         * 
         * @param path 
         */
    public void setPath(String path) {
        this.path = path;
    }
    
	/**Sets file's description by the inserted string
	 *
	 * @param description
	 */
    public void setDescription(String description) {
        this.description = description;
    }
    
	/**Sets file's name by the inserted string
	 *
	 * @param nameFile
	 */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

	/**sets file's extension by the inserted string
	 *
	 * @param ext
	 */
    public void setExt(String ext) {
        this.ext = ext;
    }

	/**Sets file's last update by the inserted date
	 *
	 * @param lastUpdate
	 */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
     
	/**Method that compares two files by comparing all
	 *their attributes
         * 
	 * @param fitxerMultimedia
	 * @return boolean
	 */
    public boolean equals(FitxerMultimedia fitxerMultimedia){
        if(this.path == fitxerMultimedia.getPath() && this.nameFile == fitxerMultimedia.getNameFile()
                && this.ext == fitxerMultimedia.getExt() && this.description == fitxerMultimedia.getDescription()
                && this.lastUpdate == fitxerMultimedia.getLastUpdate()){
            return true;
        }
        return false;
    }
        /**Method that returns the string representation
         * of the file
         * 
         * @return String
         */
    public String toString(){
        return("Descripció = " + this.getDescription() + ", data = " + this.getLastUpdate() + ", nom fitxer = " + this.getNameFile() + ", ext = " + this.getExt() + ", cami complet = " + this.getAbsolutePath());
    }
}

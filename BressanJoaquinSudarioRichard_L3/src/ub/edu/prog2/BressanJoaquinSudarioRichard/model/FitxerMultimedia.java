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
 * @author rsudarbe117.alumnes and jbressna9.alumnes The FitxerMultimedia class
 * defines the attributes of a multimedia file
 */
public class FitxerMultimedia extends File {

    /**
     * Path, name, extension, date, description of the multimedia file
     */
    /*private String path;
    private String nameFile;    
    private Date lastUpdate;*/
    private String ext;
    private String description;

    /**
     * Constructor for FitxerMultimedia with only path
     *
     * @param path local path from file
     */
    public FitxerMultimedia(String path) {
        super(path);
    }

    /**
     *  Constructor for FitxerMultimedia with path and description
     * @param path local path from file
     * @param desc description's file
     */
    public FitxerMultimedia(String path, String desc) {
        super(path);
        this.description = desc;
    }

    /**
     * Gets file's path
     *
     * @return String
     */
    public String getPath() {
        return super.getPath();
    }

    /**
     * Gets file's name
     *
     * @return String
     */
    public String getNameFile() {
        return super.getName();
    }

    /**
     * Gets file's extension
     *
     * @return String
     */
    public String getExt() {
        /*int indexName = super.getName().lastIndexOf('.');
        return super.getName().substring(indexName);*/
        return this.ext;
    }

    /**
     * Gets file's last update
     *
     * @return Date
     */
    public Date getLastUpdate() {
        return new Date(super.lastModified());
    }

    /**
     * Gets file's description
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets file's path by the inserted string
     *
     * @param path
     */
    /*public void setPath(String path) {
        ;
    }*/
    /**
     * 
     *
     * @param description Sets file's description by the inserted string
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     *
     * @param ext sets file's extension by the inserted string
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     *
     *
     * @param fitxerMultimedia file to compare
     *  Method that compares two files by comparing all their attributes
     * @return boolean
     */
    public boolean equals(FitxerMultimedia fitxerMultimedia) {
        return super.equals(fitxerMultimedia);
        /*if(super.getPath() == fitxerMultimedia.getPath() && .nameFile == fitxerMultimedia.getNameFile()
                && this.ext == fitxerMultimedia.getExt() && this.description == fitxerMultimedia.getDescription()
                && this.lastUpdate == fitxerMultimedia.getLastUpdate()){
            return true;
        }*/
    }

    /**
     * Method that returns the string representation of the file
     *
     * @return String
     */
    public String toString() {
        return ("Descripció = " + this.getDescription() + ", data = " + this.getLastUpdate() + ", nom fitxer = " + this.getNameFile() + ", ext = " + this.getExt() + ", cami complet = " + this.getAbsolutePath());
    }
}

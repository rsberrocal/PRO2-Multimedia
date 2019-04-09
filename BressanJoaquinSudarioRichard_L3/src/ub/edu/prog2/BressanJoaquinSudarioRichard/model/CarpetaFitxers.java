/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import edu.ub.prog2.utils.InFileFolder;

/**
 * @author Richard Sudario This CarpetaFitxers class contains and control all
 * the FitxerMultimedia
 */
public class CarpetaFitxers implements Serializable, InFileFolder {

    private int MAX_SIZE = 100;

    /**
     *
     */
    protected ArrayList<FitxerMultimedia> folder;

    /**
     * Creates a empty folder
     */
    public CarpetaFitxers() {
        //By default create a empty list
        this.folder = new ArrayList<>();
    }

    public CarpetaFitxers(int max) {
        this.MAX_SIZE = max;
        this.folder = new ArrayList();
    }

    /**
     * @return returns the size folder
     */
    public int getSize() {
        return this.folder.size();
    }

    /**
     * method to add a file in a folder, if is full throw a exception
     *
     * @param fitxer this fitxer is used to create a new FitxerMultimedia and
     * added to the folder
     * @throws edu.ub.prog2.utils.AplicacioException
     *
     */
    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        if (!this.isFull()) {
            this.folder.add((FitxerMultimedia) fitxer);
        } else {
            throw new AplicacioException("ERROR: Folder Full");
        }
    }

    /*public void addFitxer(File fitxer, boolean checkSize) throws AplicacioException {
        //call the method createFitxerMultimedia to create a FitxerMultimedia object
        //this.folder.add(createFitxerMultimedia(fitxer, true));
        //Method is full is useless 
        if (checkSize) {
            if (this.MAX_SIZE == this.getSize()) {
                throw new AplicacioException("Error: folder full");
            } else {
                this.folder.add((FitxerMultimedia) fitxer);
            }
        } else {
            this.folder.add((FitxerMultimedia) fitxer);
        }

    }*/
    /**
     * method to remove a file in a folder, if not exist in the folder throw a
     * exception
     *
     * @param fitxer this fitxer is used to create a new FitxerMultimedia, later
     * search this object and if is found its removed
     */
    @Override
    public void removeFitxer(File fitxer) {
        this.folder.remove(fitxer);
    }

    /*public void removeFitxer(File fitxer) throws Exception {
        FitxerMultimedia fileMulti = createFitxerMultimedia(fitxer, false);
        //Get the index of the file if not exist fileIndex is -1
        int fileIndex = this.folder.indexOf(fileMulti);
        if (fileIndex != -1) {
            this.folder.remove(fileIndex);
        } else {
            throw new Exception("ERROR: File not found");
        }
    }*/
    /**
     *
     *
     * @param position postion of file
     * @return returns file in folder by a position
     */
    public File getAt(int position) {
        return this.folder.get(position);
    }

    /**
     * clear the whole folder
     */
    public void clear() {
        this.folder.clear();
    }

    /**
     *
     * @return true if size is equal to MAX_SIZE
     */
    /*
    public boolean isFull() {
        return this.folder.size() == this.MAX_SIZE;
    }*/
    @Override
    public String toString() {
        String message = "Carpeta Fitxers:\n";
        message += "==============\n";
        for (int i = 0; i < this.folder.size(); i++) {
            FitxerMultimedia file = this.folder.get(i);
            message += "[" + (i + 1) + "]" + file;
            message += "\n";
        }
        return message;
    }

    protected boolean hasFile(File f) {
        Iterator it = this.folder.iterator();
        while (it.hasNext()) {
            FitxerMultimedia file = (FitxerMultimedia) it.next();
            if (file.equals(f)) {
                return true;
            }
        }
        return false;
    }   

    @Override
    public boolean isFull() {
        return this.folder.size()==this.MAX_SIZE;
    }

}

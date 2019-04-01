/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Richard Sudario This CarpetaFitxers class contains and control all
 * the FitxerMultimedia
 */
public class CarpetaFitxers implements Serializable {

    //private int MAX_SIZE = 100; no limit

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

    /**
     * returns the size folder
     *
     * @return
     */
    public int getSize() {
        return this.folder.size();
    }

    /**
     * method to add a file in a folder, if is full throw a exception
     *
     * @param fitxer this fitxer is used to create a new FitxerMultimedia and
     * added to the folder
     * @throws Exception if the folder is full
     */
    public void addFitxer(File fitxer) {
        //call the method createFitxerMultimedia to create a FitxerMultimedia object
        //this.folder.add(createFitxerMultimedia(fitxer, true));
        //Method is full is useless 
        this.folder.add((FitxerMultimedia) fitxer);

    }

    /**
     * method to remove a file in a folder, if not exist in the folder throw a
     * exception
     *
     * @param fitxer this fitxer is used to create a new FitxerMultimedia, later
     * search this object and if is found its removed
     * @throws Exception if file doesnt exist
     */
    public void removeFitxer(File fitxer) throws Exception {
        FitxerMultimedia fileMulti = createFitxerMultimedia(fitxer, false);
        //Get the index of the file if not exist fileIndex is -1
        int fileIndex = this.folder.indexOf(fileMulti);
        if (fileIndex != -1) {
            this.folder.remove(fileIndex);
        } else {
            throw new Exception("ERROR: File not found");
        }
    }

    /**
     * returns file in folder by a position
     *
     * @param position
     * @return
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

    //Function to create a FitxerMultimedia object, parameters: file to create, bool to select if is a file to add or not
    private FitxerMultimedia createFitxerMultimedia(File fitxer, boolean isNew) {
        FitxerMultimedia fileToAdd = new FitxerMultimedia(fitxer.getPath());
        Scanner sc = new Scanner(System.in);

        //get index to split between the name and the extension
        int indexName = fitxer.getName().lastIndexOf('.');
        //String name = fitxer.getName().substring(0, indexName);
        String ext = fitxer.getName().substring(indexName);
        //fileToAdd.setNameFile(name);        
        fileToAdd.setExt(ext);
        //lastUpdate is now
        //fileToAdd.setLastUpdate(new Date());

        //if is a file to add, set a description
        if (isNew) {
            System.out.println("Afegeix una descripcion al fitxer " + fileToAdd.getNameFile());
            fileToAdd.setDescription(sc.next());
        }
        return fileToAdd;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class CarpetaFitxer {

    //private int size;
    private int MAX_SIZE = 100;
    private ArrayList<FitxerMultimedia> folder;

    public CarpetaFitxer() {
        this.folder = new ArrayList<>();
    }

    public int getSize() {
        return this.folder.size();
    }

    public void addFitxer(File fitxer) {
        this.folder.add(createFitxerMultimedia(fitxer));        
    }

    public void removeFitxer(File fitxer) throws Exception {        
        FitxerMultimedia fileMulti = createFitxerMultimedia(fitxer);
        int fileIndex = this.folder.indexOf(fileMulti);
        if (fileIndex != -1) {
            this.folder.remove(fileIndex);
        } else {
            throw new Exception("ERROR:File not found");
        }
    }

    public File getAt(int position) {
        return this.folder.get(position);
    }

    public void clear() {
        this.folder.clear();
    }

    public boolean isFull() {
        return this.folder.size() == this.MAX_SIZE;
    }

    @Override
    public String toString() {
        String message = "Carpeta Fitxers:\n";
        message += "==============\n";
        for (int i = 0; i < this.folder.size(); i++) {
            /*[1] Descripció= Nadal, data=Thu Jan 08 12:34:02 CET 2015, nom
                fitxer=carmen, ext=mp4, cami complet=F:\carmen.mp4 */
            FitxerMultimedia file = this.folder.get(i);
            message += "[" + (i + 1) + "]  Descripció = " + file.getDescription() + ", data = " + file.getLastUpdate() + ", nom fitxer = " + file.getNameFile() + ", ext = " + file.getExt() + ", cami complet = " + file.getAbsolutePath();
            message += "\n";
        }
        return message;
    }
    //Function to create a FitxerMultimedia object
    private FitxerMultimedia createFitxerMultimedia(File fitxer) {
        FitxerMultimedia fileToAdd = new FitxerMultimedia(fitxer.getPath());
        Scanner sc = new Scanner(System.in);
        //Get index to split the nameFile
        int indexName = fitxer.getName().lastIndexOf('.');
        String name = fitxer.getName().substring(0, indexName);
        String ext = fitxer.getName().substring(indexName, 0);
        fileToAdd.setNameFile(name);
        //To get the extension, search the last dot
        fileToAdd.setExt(ext);
        fileToAdd.setLastUpdate(new Date());

        System.out.println("Afegeix una descripcion al fitxer " + name);
        fileToAdd.setDescription(sc.nextLine());
        return fileToAdd;
    }
}

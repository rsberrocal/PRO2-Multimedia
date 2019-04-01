/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class Audio extends FitxerReproduible {

    private int kbps;
    private File img;

    /**
     *
     * @param cami path to file
     * @param fitxerImatge path to image
     * @param nom name 
     * @param codec codec from file
     * @param durada duration in minutes
     * @param kbps quality
     * @param r vlc
     */
    public Audio(String cami, File fitxerImatge, String nom, String codec, float durada, int kbps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.kbps = kbps;
        this.img = fitxerImatge;
    }

    /**
     *
     * @return returns the quality
     */
    public int getQuality() {
        return kbps;
    }

    /**
     *
     * @param kbps set the quality
     */
    public void setQuality(int kbps) {
        this.kbps = kbps;
    }

    /**
     *
     */
    @Override
    protected void reproduir() {
        //TODO
    }

    @Override
    public String toString() {
        return (super.toString() + " , qualitat = " + this.getQuality() + " , imatge = " + this.img.getAbsolutePath());
    }

}

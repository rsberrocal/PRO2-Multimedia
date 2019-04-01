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
     * @param cami
     * @param fitxerImatge
     * @param nom
     * @param codec
     * @param durada
     * @param kbps
     * @param r
     */
    public Audio(String cami, File fitxerImatge, String nom, String codec, float durada, int kbps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.kbps = kbps;
        this.img = fitxerImatge;
    }

    /**
     *
     * @return
     */
    public int getQuality() {
        return kbps;
    }

    /**
     *
     * @param kbps
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

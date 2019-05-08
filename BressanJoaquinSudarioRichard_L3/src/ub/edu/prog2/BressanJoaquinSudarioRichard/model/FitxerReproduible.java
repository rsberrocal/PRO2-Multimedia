/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.Reproductor;

/**
 *
 * @author rsudarbe117.alumnes
 */
public abstract class FitxerReproduible extends FitxerMultimedia {

    private float duration;
    private String codec;

    /**
     *
     */
    protected transient Reproductor player;
    /**
     *
     * @param cami path's file
     * @param nom name's file
     * @param codec codec from file
     * @param durada duration in seconds
     * @param r player
     */
    protected FitxerReproduible(String cami, String nom, String codec, float durada, Reproductor r) {
        super(cami, nom);
        this.duration = durada;
        this.codec = codec;
        this.player = r;
    }

    /**
     *
     */
    public abstract void reproduir();

    /**
     * Method that returns the string representation of the file
     *
     * @return String
     */
    public String toString() {
        return (super.toString() + ", duració = " + this.duration + " , codec = " + this.codec);
    }
    
    public void setReproductor(Reproductor r){
        this.player = r;
                
    }
}

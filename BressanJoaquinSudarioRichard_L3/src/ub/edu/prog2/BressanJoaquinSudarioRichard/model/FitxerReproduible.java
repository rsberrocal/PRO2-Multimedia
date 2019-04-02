/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

/**
 *
 * @author rsudarbe117.alumnes
 */
public abstract class FitxerReproduible extends FitxerMultimedia {

    private float duration;
    private String codec;

    /**
     *
     * @param cami
     * @param nom
     * @param codec
     * @param durada
     * @param r
     */
    protected FitxerReproduible(String cami, String nom, String codec, float durada, Reproductor r) {
        super(cami, nom);
        this.duration = durada;
        this.codec = codec;
    }

    /**
     *
     */
    protected abstract void reproduir();

    /**
     * Method that returns the string representation of the file
     *
     * @return String
     */
    public String toString() {
        return (super.toString() + ", duració = " + this.duration + " , codec = " + this.codec);
    }
}

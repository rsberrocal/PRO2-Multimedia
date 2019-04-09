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
public class Video extends FitxerReproduible {

    private int widthPx;
    private int heightPx;
    private float fps;

    /**
     *
     * @param cami
     * @param nom
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @param r
     */
    public Video(String cami, String nom, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.widthPx = alcada;
        this.heightPx = amplada;
        this.fps = fps;
    }

    /**
     *
     * @return
     */
    public int getWidthPx() {
        return widthPx;
    }

    /**
     *
     * @param widthPx
     */
    public void setWidthPx(int widthPx) {
        this.widthPx = widthPx;
    }

    /**
     *
     * @return
     */
    public int getHeightPx() {
        return heightPx;
    }

    /**
     *
     * @param heightPx
     */
    public void setHeightPx(int heightPx) {
        this.heightPx = heightPx;
    }

    /**
     *
     * @return
     */
    public float getFps() {
        return fps;
    }

    /**
     *
     * @param fps
     */
    public void setFps(float fps) {
        this.fps = fps;
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
        return (super.toString() + ", amplada = " + this.getWidthPx() + ", alçada = " + this.getHeightPx() + " , fps = " + this.getFps());
    }

}

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
     * @param cami path's video
     * @param nom name's video
     * @param codec codec from video
     * @param durada duration in seconds
     * @param alcada height in pixels
     * @param amplada width in pixels
     * @param fps frames per second
     * @param r player
     */
    public Video(String cami, String nom, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.widthPx = alcada;
        this.heightPx = amplada;
        this.fps = fps;
    }

    /**
     *
     * @return width in pixels
     */
    public int getWidthPx() {
        return widthPx;
    }

    /**
     *
     * @param widthPx set a new width
     */
    public void setWidthPx(int widthPx) {
        this.widthPx = widthPx;
    }

    /**
     *
     * @return height in pixels
     */
    public int getHeightPx() {
        return heightPx;
    }

    /**
     *
     * @param heightPx set a new height
     */
    public void setHeightPx(int heightPx) {
        this.heightPx = heightPx;
    }

    /**
     *
     * @return frames per seconds
     */
    public float getFps() {
        return fps;
    }

    /**
     *
     * @param fps set a new value to frames per second
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

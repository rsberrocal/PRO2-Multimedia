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
public class Video extends FitxerReproduible {

    private int widthPx;
    private int heightPx;
    private float fps;

    public Video(String cami, String nom, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) {
        super(cami, nom, codec, durada, r);
        this.widthPx = alcada;
        this.heightPx = amplada;
        this.fps = fps;
    }

    public int getWidthPx() {
        return widthPx;
    }

    public void setWidthPx(int widthPx) {
        this.widthPx = widthPx;
    }

    public int getHeightPx() {
        return heightPx;
    }

    public void setHeightPx(int heightPx) {
        this.heightPx = heightPx;
    }

    public float getFps() {
        return fps;
    }

    public void setFps(float fps) {
        this.fps = fps;
    }

    @Override
    protected void reproduir() {
        //TODO
    }

}

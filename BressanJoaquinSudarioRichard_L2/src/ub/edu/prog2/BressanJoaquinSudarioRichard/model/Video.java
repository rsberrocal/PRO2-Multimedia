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
public class Video extends FitxerReproduible{
    float widthPx;
    float heightPx;
    int fps;

    public Video() {
    }

    public float getWidthPx() {
        return widthPx;
    }

    public void setWidthPx(float widthPx) {
        this.widthPx = widthPx;
    }

    public float getHeightPx() {
        return heightPx;
    }

    public void setHeightPx(float heightPx) {
        this.heightPx = heightPx;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }
    
}

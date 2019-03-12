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
public abstract class FitxerReproduible extends FitxerMultimedia{
    private double duration;
    private String codec;

    public FitxerReproduible(String path) {
        super(path);
    }
    
    protected abstract void reproduir();    
    
        
    
}

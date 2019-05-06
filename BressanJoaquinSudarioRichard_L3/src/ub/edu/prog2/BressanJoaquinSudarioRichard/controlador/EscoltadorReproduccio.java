/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import java.io.File;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.BibliotecaFitxersMultimedia;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.CarpetaFitxers;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.FitxerReproduible;
/**
 *
 * @author joaqu
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic{
    private CarpetaFitxers llistaReproduint;
    private boolean[] llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;
    int pos;
    FitxerReproduible fR;
    
    /**
     *
     * @param llistaReproduint
     * @param reproduccioCiclica
     */
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica){
        this.llistaReproduint = llistaReproduint;
        this.reproduccioCiclica = reproduccioCiclica;
        llistaCtrl =  new boolean[llistaReproduint.getSize()];
        if(this.reproduccioAleatoria){
                this.pos=(int)Math.round(Math.random()*(this.llistaReproduint.getSize()-1));
        }else{
            this.pos=0;
        }
        fR = (FitxerReproduible) this.llistaReproduint.getAt(pos);
        fR.reproduir();
    }
    
    /**
     *
     * @param f
     * @param reproduccioCiclica
     * @throws AplicacioException
     */
    public void iniciarReproduccio(File f, boolean reproduccioCiclica) throws AplicacioException{
        BibliotecaFitxersMultimedia lib = new BibliotecaFitxersMultimedia();
        lib.addFitxer(f);
        this.iniciarReproduccio(lib, reproduccioCiclica);
    }
    
    protected void setContinue(boolean isContinue){
        this.reproduccioCiclica = isContinue;
    }
    protected boolean getContinue(){
        return this.reproduccioCiclica;
    }
    
    protected void setRandom(boolean isRandom){
        this.reproduccioAleatoria = isRandom;
    }
    
    protected boolean getRandom(){
        return this.reproduccioAleatoria;
    }
    /**
     */
    @Override
    protected void onEndFile() {
        System.out.println("S'ha acabat de reproduir el fitxer \n");
        this.next();
    }

    

    /**
     *
     */
    @Override
    protected void next() {
        if (this.reproduccioCiclica){
            if(this.reproduccioAleatoria){
                pos=(int)Math.round(Math.random()*(llistaCtrl.length-1));
                pos++;
                pos = pos%llistaReproduint.getSize();
                
            }else{
                pos++;
                pos = pos%llistaReproduint.getSize();
                llistaCtrl[pos] = true;
            }
        }else if(hasNext()){
            if(this.reproduccioAleatoria){
                pos=(int)Math.round(Math.random()*(llistaCtrl.length-1));
                while(llistaCtrl[pos]){
                    pos++;
                    pos = pos%llistaReproduint.getSize();
                }
            }else{
                pos++;
                pos = pos%llistaReproduint.getSize();
                llistaCtrl[pos] = true;
            }
        }else{
            System.out.println("No more files found");
        }
        fR = (FitxerReproduible)this.llistaReproduint.getAt(pos);
        fR.reproduir();
    }

    /**
     *
     * @return
     */
    @Override
    protected boolean hasNext() {
        for(int i = 0; i<llistaCtrl.length; i++){
            if(llistaCtrl[i]==false){
                return true;
            }
        }
        return false;
    }
}

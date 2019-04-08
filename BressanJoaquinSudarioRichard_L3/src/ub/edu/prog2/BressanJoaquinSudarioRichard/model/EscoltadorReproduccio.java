/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
/**
 *
 * @author joaqu
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic{
    private CarpetaFitxers llistaReproduint;
    private boolean[] llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;
    int pos;
    
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica){
        this.llistaReproduint = llistaReproduint;
        this.reproduccioCiclica = reproduccioCiclica;
        llistaCtrl =  new boolean[llistaReproduint.getSize()];
    }
    
    @Override
    protected void onEndFile() {
        System.out.println("S'ha acabat de reproduir el fitxer \n");// example to try when all other classes are done to understand this method
    }

    @Override
    protected void next() {
        if (this.reproduccioCiclica==true){
            if(reproduccioAleatoria == true){
                pos=(int)Math.round(Math.random()*(llistaCtrl.length-1));
                pos++;
                pos = pos%llistaReproduint.getSize();
                System.out.println(llistaReproduint.getAt(pos));
            }else{
                pos++;
                pos = pos%llistaReproduint.getSize();
                System.out.println(llistaReproduint.getAt(pos));
                llistaCtrl[pos] = true;
            }
        }else if(hasNext()){
            if(reproduccioAleatoria == true){
                pos=(int)Math.round(Math.random()*(llistaCtrl.length-1));
                while(llistaCtrl[pos]==true){
                    pos++;
                    pos = pos%llistaReproduint.getSize();
                }
                System.out.println(llistaReproduint.getAt(pos));
            }else{
                pos++;
                pos = pos%llistaReproduint.getSize();
                System.out.println(llistaReproduint.getAt(pos));
                llistaCtrl[pos] = true;
            }
        }else{
            System.out.println("ERROR: No more files found");
        }
    }

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

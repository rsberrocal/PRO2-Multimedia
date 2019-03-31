/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaqu
 */
public class Dades implements Serializable {
    BibliotecaFitxersMultimedia bfm;
    Reproductor r;
    
    Dades (BibliotecaFitxersMultimedia b){
        this.bfm = b;
    }
    
    public void addVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws Exception{
        Video v = new Video(path, nomVideo, codec, durada, alcada, amplada, fps, r);
        this.bfm.addFitxer(v);
    }
    
    public void addAudio(String cami, File camiImatge, String nomAudio, String codec, float durada, int kbps) throws Exception{
        Audio a = new Audio(cami, camiImatge, nomAudio, codec, durada, kbps, r);
        this.bfm.addFitxer(a);
    }
    
    public List<String> print(){
        List<String> l = new ArrayList<>(); // sino me sale un error y no puedo commit
        return l;
    }
    
    public void delete(int id) throws AplicacioException{
        this.bfm.removeFitxer(id);
    }
    //serialización
    public void carregarDades(String camiOrigen) throws AplicacioException, IOException{
        File f = new File(camiOrigen);
        FileInputStream in = null;
        ObjectInputStream objIn = null;
        
        try{
            in = new FileInputStream(f);
            objIn = new ObjectInputStream(in);
            objIn.read();
        }catch(Exception e){
            throw new AplicacioException(e.getMessage());
        } finally {
            if (in != null){
                in.close();
            }
            if (objIn != null){
                objIn.close();
            }
        }
    }
    
    //deserialización
    public void guardarDades(String camiDesti) throws AplicacioException, IOException{ 
        File f = new File (camiDesti);
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;
        
        try{
            out = new FileOutputStream(f);
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(this.bfm);
        }catch(Exception e){
            throw new AplicacioException(e.getMessage());
        } finally {
            if (out != null){
                out.close();
            }
            if (objOut != null){
                objOut.close();
            }
        }
        
        
    }
    
    /*public String toString(){
        for (int i = 0; i < bfm.getSize() ; i++){
            System.out.println(bfm[i]);
        }
        return (".");
    } BibliotecaFitxerMultimedia is not array*/
}

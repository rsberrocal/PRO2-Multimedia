/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author joaqu
 */
public class Dades implements Serializable {
    BibliotecaFitxersMultimedia bfm = new BibliotecaFitxersMultimedia();
    Reproductor r ;
    
    /**
     *
     * @param b
     */
    public Dades (BibliotecaFitxersMultimedia b){
        this.bfm = b;
    }
    
    /**
     *
     * @param path
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException
     */
    public void addVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException{
        Video v = new Video(path, nomVideo, codec, durada, alcada, amplada, fps, r);
        this.bfm.addFitxer(v);
        
    }
    
    /**
     *
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    public void addAudio(String cami, File camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException{
        Audio a = new Audio(cami, camiImatge, nomAudio, codec, durada, kbps, r);
        this.bfm.addFitxer(a);
    }
    
    /**
     *
     * @return
     */
    public List<String> print(){
        return bfm.listBiblioteca();
    }
    
    /**
     *
     * @param id
     * @throws AplicacioException
     */
    public void delete(int id) throws AplicacioException{
        this.bfm.removeFitxer(id);
    }
    //serialización

    /**
     *
     * @param camiOrigen
     * @throws AplicacioException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void carregarDades(String camiOrigen) throws AplicacioException, IOException, ClassNotFoundException{
        File f = new File(camiOrigen);
        FileInputStream in = null;
        ObjectInputStream objIn = null;
        
        try{
            in = new FileInputStream(f);
            objIn = new ObjectInputStream(in);
            Object stream = objIn.readObject();
            while(stream != null){
                this.bfm.addFitxer((File) stream);
                stream = objIn.readObject();
            }
        }catch(EOFException e){
            in.close();
        }catch(IOException e){
            throw new AplicacioException(e.getMessage());
        }catch(ClassNotFoundException ex){
            throw new AplicacioException(ex.getMessage());
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

    /**
     *
     * @param camiDesti
     * @throws AplicacioException
     * @throws IOException
     */
    public void guardarDades(String camiDesti) throws AplicacioException, IOException{ 
        File f = new File (camiDesti);
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;
        
        try{
            out = new FileOutputStream(f);
            objOut = new ObjectOutputStream(out);
            for(int i = 0; i<bfm.getSize(); i++){
                objOut.writeObject(bfm.getAt(i));
            }
        }catch(IOException e){
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

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        if(bfm.getSize() == 0){
            return true;
        }
        return false;
    }
}

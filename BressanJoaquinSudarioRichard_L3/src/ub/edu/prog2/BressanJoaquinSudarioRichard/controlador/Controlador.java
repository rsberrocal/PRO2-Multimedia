/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.util.List;
import edu.ub.prog2.utils.InControlador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.AlbumFitxersMultimedia;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.BibliotecaFitxersMultimedia;

/**
 *
 * @author joaqu
 */
public class Controlador implements InControlador {

    BibliotecaFitxersMultimedia library = new BibliotecaFitxersMultimedia();
    Dades data; 
    Reproductor reproductor;    

    public Controlador() {
        data = new Dades(library);
    }

    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {
        data.addVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }

    public void afegirAudio(String cami, File camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
        data.addAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
    }

    public List<String> mostrarBiblioteca() { // lista de las salidas de toString() de los ficheros
        return data.print();
    }

    public void esborrarFitxer(int id) throws AplicacioException {
        data.delete(id);
    }

    public boolean isEmpty() {
        if (data.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void afegirAudio(String string, String string1, String string2, String string3, float f, int i) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reproduirFitxer(int i) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afegirAlbum(String title) throws AplicacioException {
        data.addAlbum(title);
    }

    @Override
    public List<String> mostrarLlistatAlbums(){       
        return data.mostrarAlbums();
    }

    @Override
    public void esborrarAlbum(String title) throws AplicacioException {
        data.deleteAlbum(title);
    }

    @Override
    public boolean existeixAlbum(String string) {
        
    }

    @Override
    public void afegirFitxer(String string, int i) throws AplicacioException {
        
    }

    @Override
    public List<String> mostrarAlbum(String string) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void esborrarFitxer(String string, int i) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obrirFinestraReproductor() {
        this.reproductor.open();
    }

    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        this.reproductor.close();
    }

    @Override
    public void reproduirCarpeta() throws AplicacioException {
        
    }

    @Override
    public void reproduirCarpeta(String string) throws AplicacioException {
        
    }

    @Override
    public void reemprenReproduccio() throws AplicacioException {
        reproductor.resume();
    }

    @Override
    public void pausaReproduccio() throws AplicacioException {
        reproductor.pause();
    }

    @Override
    public void aturaReproduccio() throws AplicacioException {
        reproductor.stop();
    }

    @Override
    public void saltaReproduccio() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        try {
            data.guardarDades(camiDesti);
        } catch (IOException ex) {
            throw new AplicacioException(ex.getMessage());
        }
    }

    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        try {
            data.carregarDades(camiOrigen);
        } catch (IOException ex) {
            throw new AplicacioException(ex.getMessage());
        }        
    }
}

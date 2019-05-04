/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Audio;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.util.List;
import edu.ub.prog2.utils.InControlador;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.BibliotecaFitxersMultimedia;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.FitxerReproduible;

/**
 *
 * @author joaqu
 */
public class Controlador implements InControlador {

    BibliotecaFitxersMultimedia library = new BibliotecaFitxersMultimedia();
    Dades data;
    private transient Reproductor reproductor;

    public Controlador() {
        data = new Dades(library);
    }

    //BIBLIOTECA
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {
        data.addVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }

    public void afegirAudio(String cami, File camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
        data.addAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
    }

    @Override
    public List<String> mostrarBiblioteca() { // lista de las salidas de toString() de los ficheros
        return data.print();
    }

    @Override
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

    //CONTROL ALBUM ARRAY 
    @Override
    public void afegirAlbum(String title) throws AplicacioException {
        data.addAlbum(title);
    }

    @Override
    public List<String> mostrarLlistatAlbums() {
        try {
            return data.mostrarAlbums();
        } catch (AplicacioException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void esborrarAlbum(String title) throws AplicacioException {
        data.deleteAlbum(title);
    }

    @Override
    public boolean existeixAlbum(String string) {
        return data.albumExist(string);
    }

    //CONTROL ALBUM add/delete/show
    @Override
    public void afegirFitxer(String title, int id) throws AplicacioException {
        this.data.addFileToAlbum(title, id);
    }

    @Override
    public List<String> mostrarAlbum(String title) throws AplicacioException {
        return this.data.mostrarAlbum(title);
    }

    @Override
    public void esborrarFitxer(String title, int id) throws AplicacioException {
        this.data.deleteFileInAlbum(title, id);
    }

    //REPRODUCTOR
    @Override
    public void obrirFinestraReproductor() {
        this.reproductor.open();
    }

    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        this.reproductor.close();
    }

    @Override
    public void reproduirFitxer(int i) throws AplicacioException {
        this.reproductor.show(this.library.getAt(i));
    }

    @Override
    public void reproduirCarpeta() throws AplicacioException {
        Iterator it = this.library.folder.iterator();
        while (it.hasNext()) {
            File f = (File) it.next();
            if ("Audio".equals(f.getClass().getName())) {
                Audio aud = (Audio) f;
                aud.getImatge();
                this.reproductor.reprodueix(aud, aud.getImatge());
            } else if ("Video".equals(f.getClass().getName())) {
                FitxerReproduible fr = (FitxerReproduible) f;
                this.reproductor.reprodueix(fr);
            } else {
                this.reproductor.show(f); //other file than audio/video
            }
        }
    }

    @Override
    public void reproduirCarpeta(String string) throws AplicacioException {
        Iterator it = data.findAlbum(string).folder.iterator();
        while (it.hasNext()) {
            File a = (File) it.next();
            if ("Audio".equals(a.getClass().getName())) {
                Audio aud = (Audio) a;
                aud.getImatge();
                this.reproductor.reprodueix(aud, aud.getImatge());
            } else if ("Video".equals(a.getClass().getName())) {
                FitxerReproduible fr = (FitxerReproduible) a;
                this.reproductor.reprodueix(fr);
            } else {
                this.reproductor.show(a); //other file than audio/video
            }
        }
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

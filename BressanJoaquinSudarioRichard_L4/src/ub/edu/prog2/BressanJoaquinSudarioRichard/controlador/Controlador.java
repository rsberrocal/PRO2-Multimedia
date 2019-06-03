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
import java.util.Scanner;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.AlbumFitxersMultimedia;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.BibliotecaFitxersMultimedia;

/**
 *
 * @author joaqu
 */
public class Controlador implements InControlador {

    BibliotecaFitxersMultimedia library = new BibliotecaFitxersMultimedia();
    public Dades data;
    EscoltadorReproduccio escoltador;
    private transient Reproductor reproductor;
    Scanner sc = new Scanner(System.in);

    /**
     *
     * @param vlcPath
     */
    public Controlador() {

        this.escoltador = new EscoltadorReproduccio();
        this.reproductor = new Reproductor(escoltador);
        data = new Dades(library, reproductor);
    }

    //BIBLIOTECA
    /**
     * Add a Video to library
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
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {
        data.addVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }

    /**
     * Add an Audio to library
     *
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
        File f = new File(camiImatge);
        data.addAudio(cami, f, nomAudio, codec, durada, kbps);
    }

    /**
     * Show the whole library
     *
     * @return a list with all the info
     */
    @Override
    public List<String> mostrarBiblioteca() { // lista de las salidas de toString() de los ficheros
        return data.print();
    }

    public List<String> mostrarBibliotecaNames() {
        return data.listBiblioteca();
    }

    /**
     * delete a file
     *
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void esborrarFitxer(int id) throws AplicacioException {
        data.delete(id);
    }

    /**
     * check if the library is empty or not
     *
     * @return a boolean
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //CONTROL ALBUM ARRAY 
    /**
     * Add an album with a title
     *
     * @param title
     * @throws AplicacioException
     */
    @Override
    public void afegirAlbum(String title) throws AplicacioException {
        this.data.addAlbum(title);
    }

    public void afegirAlbum(String title, int size) throws AplicacioException {
        this.data.addAlbum(title, size);
    }

    public boolean isEmptyAlbums() {
        return this.data.isEmptyAlbums();
    }

    public AlbumFitxersMultimedia getActualAlbum(String title) {
        return this.data.findAlbum(title);
    }

    public boolean isEmptyAlbum(String title) {
        return this.data.isEmptyAlbum(title);
    }

    /**
     * Show all the albums
     *
     * @return
     */
    @Override
    public List<String> mostrarLlistatAlbums() {
        try {
            return this.data.mostrarAlbums();
        } catch (AplicacioException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Delete an album by title
     *
     * @param title
     * @throws AplicacioException
     */
    @Override
    public void esborrarAlbum(String title) throws AplicacioException {
        this.data.deleteAlbum(title);
    }

    /**
     * Check if the album already exists
     *
     * @param string
     * @return
     */
    @Override
    public boolean existeixAlbum(String string) {
        return data.albumExist(string);
    }

    //CONTROL ALBUM add/delete/show
    /**
     * Add a file to album by id
     *
     * @param title
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void afegirFitxer(String title, int id) throws AplicacioException {
        this.data.addFileToAlbum(title, id);
    }

    /**
     * Show an album
     *
     * @param title
     * @return
     * @throws AplicacioException
     */
    @Override
    public List<String> mostrarAlbum(String title) throws AplicacioException {
        return this.data.mostrarAlbum(title);
    }

    /**
     * Delete a file in album
     *
     * @param title
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void esborrarFitxer(String title, int id) throws AplicacioException {
        this.data.deleteFileInAlbum(title, id);
    }

    //REPRODUCTOR
    /**
     *
     */
    @Override
    public void obrirFinestraReproductor() {
        this.reproductor.open();
    }

    /**
     *
     * @throws AplicacioException
     */
    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        try {
            this.reproductor.close();
        } catch (AplicacioException e) {
            throw new AplicacioException(e.getMessage());
        }
    }

    /**
     *
     * @param i
     * @throws AplicacioException
     */
    @Override
    public void reproduirFitxer(int i) throws AplicacioException {
        File f = this.library.getAt(i);
        this.escoltador.iniciarReproduccio(f, this.escoltador.getContinue());
    }

    /**
     *
     * @throws AplicacioException
     */
    @Override
    public void reproduirCarpeta() throws AplicacioException {
        this.escoltador.iniciarReproduccio(this.library, this.escoltador.getContinue());
    }

    /**
     *
     * @param string
     * @throws AplicacioException
     */
    @Override
    public void reproduirCarpeta(String string) throws AplicacioException {
        AlbumFitxersMultimedia album = data.findAlbum(string);
        this.escoltador.iniciarReproduccio(album, this.escoltador.getContinue());
    }

    /**
     *
     * @throws AplicacioException
     */
    @Override
    public void reemprenReproduccio() throws AplicacioException {
        this.reproductor.resume();
    }

    /**
     *
     * @throws AplicacioException
     */
    @Override
    public void pausaReproduccio() throws AplicacioException {
        this.reproductor.pause();
    }

    /**
     *
     * @throws AplicacioException
     */
    @Override
    public void aturaReproduccio() throws AplicacioException {
        this.reproductor.stop();
    }

    /**
     *
     * @throws AplicacioException
     */
    @Override
    public void saltaReproduccio() throws AplicacioException {
        this.escoltador.next();
    }

    //CONTINUE OR RANDOM
    /**
     *
     * @param isRandom
     */
    public void setRandom(boolean isRandom) {
        this.escoltador.setRandom(isRandom);
    }

    /**
     *
     * @return
     */
    public boolean getRandom() {
        return this.escoltador.getRandom();
    }

    /**
     *
     * @param isContinu
     */
    public void setContinu(boolean isContinu) {
        this.escoltador.setContinue(isContinu);
    }

    /**
     *
     * @return
     */
    public boolean getContinu() {
        return this.escoltador.getContinue();
    }

    //DATA
    /**
     *
     * @param camiDesti
     * @throws AplicacioException
     */
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        try {
            this.data.guardarDades(camiDesti);
        } catch (IOException ex) {
            throw new AplicacioException(ex.getMessage());
        }
    }

    /**
     *
     * @param camiOrigen
     * @throws AplicacioException
     */
    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        try {
            this.data.carregarDades(camiOrigen);
            this.data.setReproductor();
        } catch (IOException ex) {
            throw new AplicacioException(ex.getMessage());
        }
    }

    public int getNumAlbums() {
        return this.data.getNumAlbums();
    }

    public int getSizeLib() {
        return this.library.getSize();
    }
}

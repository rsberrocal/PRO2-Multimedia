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
    Dades data;
    EscoltadorReproduccio escoltador;
    private transient Reproductor reproductor;  
    Scanner sc = new Scanner(System.in);

    public Controlador() {
        data = new Dades(library);
    }

    //BIBLIOTECA
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {
        data.addVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }
    
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
        File f = new File(camiImatge);
        data.addAudio(cami, f, nomAudio, codec, durada, kbps);
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

    //CONTROL ALBUM ARRAY 
    @Override
    public void afegirAlbum(String title) throws AplicacioException {
        this.data.addAlbum(title);
    }

    @Override
    public List<String> mostrarLlistatAlbums() {
        try {
            return this.data.mostrarAlbums();
        } catch (AplicacioException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void esborrarAlbum(String title) throws AplicacioException {
        this.data.deleteAlbum(title);
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
        try{
            this.reproductor.close();
        }catch(AplicacioException e){
            throw new AplicacioException(e.getMessage());
        }
    }

    @Override
    public void reproduirFitxer(int i) throws AplicacioException {
        File f = this.library.getAt(i);
        System.out.println("Reproducción continua?");
        this.escoltador.setContinue(sc.nextBoolean());
        this.escoltador.setRandom(false);
        this.escoltador.iniciarReproduccio(f, this.escoltador.getContinue());
    }

    @Override
    public void reproduirCarpeta() throws AplicacioException {
        System.out.println("Reproducción continua?");
        this.escoltador.setContinue(sc.nextBoolean());
        System.out.println("Reproducción aleatoria?");
        this.escoltador.setRandom(sc.nextBoolean());
        this.escoltador.iniciarReproduccio(this.library, this.escoltador.getContinue());
    }

    @Override
    public void reproduirCarpeta(String string) throws AplicacioException {
        AlbumFitxersMultimedia album = data.findAlbum(string);
        System.out.println("Reproducción continua?");
        this.escoltador.setContinue(sc.nextBoolean());
        System.out.println("Reproducción aleatoria?");
        this.escoltador.setRandom(sc.nextBoolean());
        this.escoltador.iniciarReproduccio(album, this.escoltador.getContinue());
    }

    @Override
    public void reemprenReproduccio() throws AplicacioException {
        this.reproductor.resume();
    }

    @Override
    public void pausaReproduccio() throws AplicacioException {
        this.reproductor.pause();
    }

    @Override
    public void aturaReproduccio() throws AplicacioException {
        this.reproductor.stop();
    }

    @Override
    public void saltaReproduccio() throws AplicacioException {
        this.escoltador.next();
    }

    //CONTINUE OR RANDOM
    public void setRandom(boolean isRandom){
        this.escoltador.setRandom(isRandom);
    }
    
    public boolean getRandom(){
        return this.escoltador.getRandom();
    }
    
    public void setContinu(boolean isContinu){
        this.escoltador.setContinue(isContinu);
    }
    
    public boolean getContinu(){
        return this.escoltador.getContinue();
    }
    
    
    //DATA
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        try {
            this.data.guardarDades(camiDesti);
        } catch (IOException ex) {
            throw new AplicacioException(ex.getMessage());
        }
    }

    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        try {
            this.data.carregarDades(camiOrigen);
        } catch (IOException ex) {
            throw new AplicacioException(ex.getMessage());
        }
    }

    
}

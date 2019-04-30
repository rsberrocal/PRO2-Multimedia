/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class Dades implements Serializable {

    BibliotecaFitxersMultimedia library = new BibliotecaFitxersMultimedia();
    Reproductor player;
    ArrayList<AlbumFitxersMultimedia> albums;

    /**
     *
     * @param b
     */
    public Dades(BibliotecaFitxersMultimedia lib) {
        this.library = lib;
        this.albums = new ArrayList<>();
    }

    /**
     *
     * @param path file path
     * @param nomVideo video name
     * @param codec codec file
     * @param durada duration in minutes
     * @param alcada pixels file
     * @param amplada pixels file
     * @param fps frames per seconds
     * @throws AplicacioException error
     */
    public void addVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {
        Video v = new Video(path, nomVideo, codec, durada, alcada, amplada, fps, player);
        this.library.addFitxer(v);

    }

    /**
     *
     * @param cami file path
     * @param camiImatge file image
     * @param nomAudio audio name
     * @param codec codec file
     * @param durada duration in minutes
     * @param kbps quality
     * @throws AplicacioException error
     */
    public void addAudio(String cami, File camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
        Audio a = new Audio(cami, camiImatge, nomAudio, codec, durada, kbps, player);
        this.library.addFitxer(a);
    }

    /**
     *
     * @return
     */
    public List<String> print() {
        return library.listBiblioteca();
    }

    /**
     *
     * @param id
     * @throws AplicacioException
     */
    public void delete(int id) throws AplicacioException {
        this.library.removeFitxer(id);
    }

    //Menu's option 2: Albums
    public void addAlbum(String title) throws AplicacioException {
        int albumSize;
        Scanner sc = new Scanner(System.in);
        System.out.println("Album size?");
        albumSize = sc.nextInt();
        if (!albumExist(title)) {
            this.albums.add(new AlbumFitxersMultimedia(albumSize, title));
        } else {
            throw new AplicacioException("Error: Album exists");
        }
    }

    public boolean albumExist(String title) {
        Iterator it = this.albums.iterator();
        while (it.hasNext()) {
            AlbumFitxersMultimedia a = (AlbumFitxersMultimedia) it.next();
            if (a.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public List<String> mostrarAlbums() throws AplicacioException {
        if (albums.isEmpty()) {
            throw new AplicacioException("No album found.");
        } else {
            List<String> list = new ArrayList<>();
            Iterator it = this.albums.iterator();
            int i = 1;
            while (it.hasNext()) {
                AlbumFitxersMultimedia album = (AlbumFitxersMultimedia) it.next();
                list.add("\n[" + i + "] " + album.getTitle());
                i++;
            }
            return list;
        }
    }

    public void deleteAlbum(String title) throws AplicacioException {
        albums.remove(findAlbum(title));

    }

    public AlbumFitxersMultimedia findAlbum(String title) {
        for (int i = 0; i < albums.size(); i++) {
            AlbumFitxersMultimedia album = albums.get(i);
            if (album.getTitle().equals(title)) {
                return albums.get(i);
            }
        }
        return null;
    }

    //Options of 2.4 are already taken into account by CarpetaFitxers class (album extends carpeta)
    public void addFileToAlbum(String title, int id) throws AplicacioException {
        findAlbum(title).addFitxer(this.library.getAt(id));
    }

    public List<String> mostrarAlbum(String title) throws AplicacioException {
        AlbumFitxersMultimedia actualAlbum = findAlbum(title);
        if (actualAlbum != null) {
           return actualAlbum.showAlbum();
        } else {
            throw new AplicacioException("Error: album not exists");
        }
    }
    
    public void deleteFileInAlbum(String title,int id){
        AlbumFitxersMultimedia actualAlbum = findAlbum(title);
        if (actualAlbum != null) {
           this.albums.remove(id);
        } else {
            throw new AplicacioException("Error: album not exists");
        }
    }

    //serialización
    /**
     *
     * @param camiOrigen
     * @throws AplicacioException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void carregarDades(String camiOrigen) throws AplicacioException, IOException {
        File f = new File(camiOrigen);
        FileInputStream in = null;
        ObjectInputStream objIn = null;

        try {
            in = new FileInputStream(f);
            objIn = new ObjectInputStream(in);
            Object stream = objIn.readObject();
            while (stream != null) {
                this.library.addFitxer((File) stream);
                stream = objIn.readObject();
            }
        } catch (EOFException e) {
            in.close();
        } catch (IOException e) {
            throw new AplicacioException(e.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new AplicacioException(ex.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            if (objIn != null) {
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
    public void guardarDades(String camiDesti) throws AplicacioException, IOException {
        File f = new File(camiDesti);
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;

        try {
            out = new FileOutputStream(f);
            objOut = new ObjectOutputStream(out);
            for (int i = 0; i < library.getSize(); i++) {
                objOut.writeObject(library.getAt(i));
            }
        } catch (IOException e) {
            throw new AplicacioException(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
            if (objOut != null) {
                objOut.close();
            }
        }
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        if (library.getSize() == 0) {
            return true;
        }
        return false;
    }
}

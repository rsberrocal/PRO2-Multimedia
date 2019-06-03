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
import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.EscoltadorReproduccio;

/**
 *
 * @author joaqu
 */
public class Dades implements Serializable {

    BibliotecaFitxersMultimedia library = new BibliotecaFitxersMultimedia();
    private transient Reproductor player;
    ArrayList<AlbumFitxersMultimedia> albums;
    private transient int howMuchFiles;
    EscoltadorReproduccio escoltador;

    /**
     * Creates a new Dades object
     *
     * @param lib library from controller
     */
    public Dades(BibliotecaFitxersMultimedia lib, Reproductor player) {
        this.library = lib;
        this.albums = new ArrayList<>();
        this.player = player;
    }

    /**
     * Add a video to library
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
     * Add an audio to library
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
        boolean exists = camiImatge.exists();
        this.library.addFitxer(a);
    }

    /**
     *
     * @return a string with all the files in library
     */
    public List<String> print() {
        return library.listBiblioteca();
    }

    public List<String> listBiblioteca() {
        return library.listBibliotecaNames();
    }

    /**
     * Delete a file from the library
     *
     * @param id of the file to delete
     * @throws AplicacioException
     */
    public void delete(int id) throws AplicacioException {
        this.deleteIfExist(id);
        this.library.removeFitxer(id);
    }

    private void deleteIfExist(int id) throws AplicacioException {
        if (id < 0 || id > this.library.getSize()) {
            throw new AplicacioException("Error: file does not exist");
        } else {
            Iterator it = this.albums.iterator();
            FitxerMultimedia fileToDelete = (FitxerMultimedia) this.library.getAt(id);
            while (it.hasNext()) {
                AlbumFitxersMultimedia album = (AlbumFitxersMultimedia) it.next();
                ArrayList tmp = (ArrayList) album.folder.clone();
                Iterator itFile = tmp.iterator();
                while (itFile.hasNext()) {
                    FitxerMultimedia f = (FitxerMultimedia) itFile.next();
                    if (fileToDelete.equals(f)) {
                        album.removeFitxer(f);
                    }
                }
            }
        }
    }

    //Menu's option 2: Albums
    /**
     * Creates a new album with a title
     *
     * @param title of the new album
     * @throws AplicacioException
     */
    public void addAlbum(String title) throws AplicacioException {
        int albumSize;
        Scanner sc = new Scanner(System.in);
        System.out.println("Album size?");
        albumSize = sc.nextInt();
        //Check if album exists
        if (!albumExist(title)) {
            this.albums.add(new AlbumFitxersMultimedia(albumSize, title));
        } else {
            throw new AplicacioException("Error: Album exists");
        }
    }

    public void addAlbum(String title, int albumSize) throws AplicacioException {
        //Check if album exists
        if (!albumExist(title)) {
            this.albums.add(new AlbumFitxersMultimedia(albumSize, title));
        } else {
            throw new AplicacioException("Error: Album exists");
        }
    }

    /**
     * Check if the album eists
     *
     * @param title of the album to check
     * @return true if exists, else false
     */
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

    /**
     * List all the albums
     *
     * @return list with albums
     * @throws AplicacioException
     */
    public List<String> mostrarAlbums() throws AplicacioException {
        List<String> list = new ArrayList<>();
        if (albums.isEmpty()) {
            list.add("No albums found");
            return list;
        } else {
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

    /**
     * Delete an album from the array
     *
     * @param title of the album
     * @throws AplicacioException error if not exists
     */
    public void deleteAlbum(String title) throws AplicacioException {
        if (albumExist(title)) {
            albums.remove(findAlbum(title));
        } else {
            throw new AplicacioException("Error: Album not exists");
        }
    }

    /**
     * Check if the album exists in the array or not
     *
     * @param title of the album
     * @return album if exists, else null
     */
    public AlbumFitxersMultimedia findAlbum(String title) {
        Iterator it = this.albums.iterator();
        while (it.hasNext()) {
            AlbumFitxersMultimedia album = (AlbumFitxersMultimedia) it.next();
            if (album.getTitle().equals(title)) {
                return album;
            }
        }
        return null;
    }

    //Options of 2.4 are already taken into account by CarpetaFitxers class (album extends carpeta)
    /**
     * Add file to album only if the album exists and if the file exists
     *
     * @param title of the album
     * @param id of the library
     * @throws AplicacioException
     */
    public void addFileToAlbum(String title, int id) throws AplicacioException {
        AlbumFitxersMultimedia album = findAlbum(title);
        if (album == null || id < 0 || id > this.library.getSize()) {
            throw new AplicacioException("Error: id not exists");
        } else {
            album.addFitxer(this.library.getAt(id));
        }
    }

    /**
     *
     * @param title
     * @return
     * @throws AplicacioException
     */
    public List<String> mostrarAlbum(String title) throws AplicacioException {
        AlbumFitxersMultimedia actualAlbum = findAlbum(title);
        if (actualAlbum != null) {
            return actualAlbum.showAlbum();
        } else {
            throw new AplicacioException("Error: album not exists");
        }
    }

    /**
     *
     * @param title
     * @param id
     * @throws AplicacioException
     */
    public void deleteFileInAlbum(String title, int id) throws AplicacioException {
        AlbumFitxersMultimedia actualAlbum = findAlbum(title);
        if (actualAlbum == null || id < 0 || id > actualAlbum.getSize()) {
            throw new AplicacioException("Error: id not exists");
        } else {
            actualAlbum.removeFitxer(actualAlbum.getAt(id));
        }
    }

    //serialización
    /**
     *
     * @param camiOrigen
     * @throws AplicacioException
     * @throws IOException
     */
    public void carregarDades(String camiOrigen) throws AplicacioException, IOException {
        File f = new File(camiOrigen);
        FileInputStream in = null;
        ObjectInputStream objIn = null;

        try {
            in = new FileInputStream(f);
            objIn = new ObjectInputStream(in);
            Object stream = objIn.readObject();
            try {
                while (stream != null) {
                    this.library.addFitxer((File) stream);
                    stream = objIn.readObject();
                }
            } catch (ClassCastException e) {
                while (stream != null) {
                    this.albums.add((AlbumFitxersMultimedia) stream);
                    stream = objIn.readObject();
                }
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
            for (int j = 0; j < albums.size(); j++) {
                objOut.writeObject(albums.get(j));
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
     * @return boolean
     */
    public boolean isEmpty() {
        if (library.getSize() == 0) {
            return true;
        }
        return false;
    }

    public boolean isEmptyAlbums() {
        return this.albums.isEmpty();
    }

    public boolean isEmptyAlbum(String title) {
        return this.findAlbum(title).folder.isEmpty();
    }

    public void setReproductor() {
        Iterator it = this.library.folder.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().getName().equals("FitxerReproduible")) {
                FitxerReproduible fR = (FitxerReproduible) it.next();
                fR.setReproductor(this.player);
                if (this.albums.size() > 0) {
                    Iterator itA = this.albums.iterator();
                    while (itA.hasNext()) {
                        AlbumFitxersMultimedia album = (AlbumFitxersMultimedia) itA.next();
                        Iterator itFiles = album.folder.iterator();
                        while (itFiles.hasNext()) {
                            FitxerReproduible file = (FitxerReproduible) itFiles.next();
                            if (file.equals(fR)) {
                                file.setReproductor(this.player);
                            }
                        }
                    }
                }
            }
        }
    }

    public int getNumAlbums() {
        return this.albums.size();
    }

}

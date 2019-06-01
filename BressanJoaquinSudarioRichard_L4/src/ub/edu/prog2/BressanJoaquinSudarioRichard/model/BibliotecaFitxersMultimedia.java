/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;
import edu.ub.prog2.utils.AplicacioException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers {

    /**
     *
     */
    public BibliotecaFitxersMultimedia() {
        super();
    }

    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        //If its not duplicated and file exists
        if (!fitxer.exists()) {
            throw new AplicacioException("Error: File does not exist");
        }
        if (!super.hasFile(fitxer)) {
            //Add file to folder
            super.folder.add((FitxerMultimedia) fitxer);
        } else {
            throw new AplicacioException("Error: File duplicated");
        }
    }

    /*@Override
    public void addFitxer(File fitxer) throws AplicacioException {  
        if (!super.hasFile(fitxer)) {
            super.addFitxer(fitxer);
        } else {
            throw new AplicacioException("Error: File duplicated");
        }
    }*/
    /**
     *
     * @param index position in the array
     * @throws AplicacioException with error message
     */
    public void removeFitxer(int index) throws AplicacioException {
        if (this.getSize() == 0) {
            throw new AplicacioException("Error; Biblioteca buida");
        } else {
            if (index > this.getSize()) {
                throw new AplicacioException("Error: posició incorrecta");
            } else {
                try {
                    super.folder.remove(super.getAt(index));
                } catch (Exception ex) {
                    throw new AplicacioException(ex.getMessage());
                }
            }
        }
    }

    /**
     *
     * @return returns a list with all elements
     */
    public List<String> listBiblioteca() {
        List<String> list = new ArrayList<>();
        Iterator it = super.folder.iterator();
        int i = 1;
        while (it.hasNext()) {
            list.add("\n[" + i + "] " + it.next().toString());
            i++;
        }
        return list;
    }

    /**
     *
     * @return
     */
    public Iterator getIterator() {
        return super.folder.iterator();
    }

}

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
        try {
            if(super.hasFile(fitxer)){
                super.addFitxer(fitxer);
            }else{
                throw new AplicacioException("Error: File duplicated");
            }
        } catch (Exception e) {
            throw new AplicacioException(e.getMessage());
        }
    }

    /**
     *
     * @param index
     * @throws AplicacioException
     */
    public void removeFitxer(int index) throws AplicacioException {
        if (this.getSize() == 0) {
            throw new AplicacioException("Error; Biblioteca buida");
        } else {
            if (index > this.getSize()) {
                throw new AplicacioException("Error: posició incorrecta");
            } else {
                try {
                    super.removeFitxer(super.getAt(index));
                } catch (Exception ex) {
                    throw new AplicacioException(ex.getMessage());
                }
            }
        }
     }

    /**
     *
     * @return
     */
    public List<String> listBiblioteca() {
        List<String> list = new ArrayList<>();
        Iterator it = super.folder.iterator();
        while (it.hasNext()) {
            list.add(it.next().toString());
        }
        return list;
    }

}

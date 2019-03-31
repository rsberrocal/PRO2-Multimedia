/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Reproductor;
/**
 *
 * @author joaqu
 */
public class Controlador {
    
    Dades d;
    Reproductor r;
    
    public void afegirVideo (String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException, Exception{
        d.addVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }
    
    public void afegirAudio(String cami, File camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException, Exception{
        d.addAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
    }
    
    public List<String> mostrarBiblioteca(){ // lista de las salidas de toString() de los ficheros
        return d.print();
            
    }
    
    public void esborrarFitxer(int id) throws AplicacioException{
        d.delete(id);
    }
    
    public void guardarDadesDisc(String camiDesti) throws AplicacioException, IOException{
        d.guardarDades(camiDesti);
    }
    
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException, IOException{
        d.carregarDades(camiOrigen);
    }
}

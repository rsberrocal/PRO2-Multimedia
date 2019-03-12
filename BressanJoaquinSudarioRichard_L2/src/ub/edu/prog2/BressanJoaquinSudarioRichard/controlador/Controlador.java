/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.controlador;

import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.util.List;
import ub.edu.prog2.BressanJoaquinSudarioRichard.model.Video;

/**
 *
 * @author joaqu
 */
public class Controlador {
    public void afegirVideo (String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException{
        
    }
    
    public void afegirAudio(String cami, String camilmatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException{
        
    }
    
    public List<String> mostrarBiblioteca(){ // lista de las salidas de toString() de los ficheros
        List<String> d = null; //Sino aparecía como error
        return d;
    }
    
    public void esborrarFitxer(int id) throws AplicacioException{
        // id es la posición en la lista de getBiblioteca()

        
    }
    
    public void guardarDadesDisc(String camiDesti) throws AplicacioException{
        
    }
    
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException{

    }
}

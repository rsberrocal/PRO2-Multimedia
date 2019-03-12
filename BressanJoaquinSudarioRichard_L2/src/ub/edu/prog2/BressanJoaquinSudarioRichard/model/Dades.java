/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

/**
 *
 * @author joaqu
 */
public class Dades implements Serializable {
    
    public void guardarDades(String camiDesti) throws AplicacioException{
        File f = new File(camiDesti);
        FileInputStream in = null;
        
        try{
            in = new FileInputStream(f);
            
        }catch(Exception e){
            
        } finally {
            if (in != null){
                in.close();
            }
        }
    }
    
    public void carregarDades(String camiOrigen) throws AplicacioException{
        File f = new File (camiOrigen);
        FileOutputStream out = null;
        
        try{
            out = new FileOutputStream(f);
        
        }catch(Exception e){
            
        } finally {
            if (out != null){
                out.close();
            }
        }
        
        
    }
}

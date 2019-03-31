/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.model;

import java.io.File;
import java.util.Scanner;
import edu.ub.prog2.utils.AplicacioException;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers {

    public BibliotecaFitxersMultimedia() {
        super();
    }

    public void addFitxer(File fitxer, boolean isAudio) throws AplicacioException {
        if (this.isFull()) {
            throw new AplicacioException("Error: biblioteca plena");
        } else {
            String desc;
            float durat;
            String codec;
            char optionFile;
            Scanner sc = new Scanner(System.in);
            System.out.println("Afegeix una descripcion al fitxer " + fitxer.getName());
            desc = sc.next();
            System.out.println("Afegeix una durada al fitxer " + fitxer.getName());
            durat = sc.nextFloat();
            System.out.println("Afegeix un codec al fitxer " + fitxer.getName());
            codec = sc.next();
            System.out.println("Sera un audio o video? A/V");
            optionFile = sc.next().charAt(0);
            if (isAudio) {
                int kbs;
                String imgFile;
                System.out.println("Afeigeix una qualitat d'audio(kbs)");
                kbs = sc.nextInt();
                System.out.println("Afegeix la ruta de la imatge al audio");
                imgFile = sc.next();
                File f = new File(imgFile);
                try {
                    super.addFitxer(new Audio(fitxer.getAbsolutePath(), f, desc, codec, durat, kbs, new Reproductor()));
                } catch (Exception e) {
                    throw new AplicacioException(e.getMessage());
                }
            } else {
                int width;
                int height;
                float fps;
                System.out.println("Dimensions del video");
                System.out.println("Amplada:");
                width = sc.nextInt();
                System.out.println("Alçada:");
                height = sc.nextInt();
                System.out.println("Afeigeix els frames per segon del video");
                fps = sc.nextFloat();
                try {
                    super.addFitxer(new Video(fitxer.getAbsolutePath(), desc, codec, durat, height, width, fps, new Reproductor()));
                } catch (Exception e) {
                    throw new AplicacioException(e.getMessage());
                }
            }
        }
    }

}

package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author joni_
 */
public class ExportarPostFijas {
    
    public void exportar(String resultado, String evaluacion){
        try {
            FileOutputStream text = new FileOutputStream("exp_postfijas.txt");
            PrintStream newTxt = new PrintStream(text);
            String[] salida = resultado.split("\n"); 
            String[] salida2 = evaluacion.split("\n");
            for (int i=0; i<salida.length;i++){
                newTxt.println(salida[i] + "Resultado: " + salida2[i]);
            }
            } catch (FileNotFoundException fne) {
                System.out.println(fne.getMessage());
            }
    }
}

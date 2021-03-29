/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author joni_
 */
public class LeerInfijas {
    private Scanner scan;
    private ArrayList<String> expresiones;
    
    public LeerInfijas(){
        expresiones = new ArrayList();
    }
    
    public void leerExpresiones(){
         try {
            File file = new File("exp_infijas.txt");
            this.scan = new Scanner(file);
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
    }
    
    public ArrayList<String> obtenerExpresiones(){
        leerExpresiones();
        while(this.scan.hasNextLine()){
            String expresion = scan.nextLine();
            expresiones.add(expresion);
        }
        return expresiones;
    }
    
}

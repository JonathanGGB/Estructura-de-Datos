/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author joni_
 */
public class ConvertirExpresion {
    private Stack pilaParentesis;
    private String salida;
    private Stack pilaOperadores;
    
    public ConvertirExpresion(){
        this.pilaParentesis = new Stack();
        this.salida = "";
        this.pilaOperadores = new Stack();
    }
    
    public String validarExpresion() {
        List expresiones = new LeerInfijas().obtenerExpresiones();
        
        for(int k=0;k<expresiones.size();k++){
            
            String cadena = (String) expresiones.get(k);
        
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == '(') {
                    pilaParentesis.push(cadena.charAt(i));
                } else {

                    if (cadena.charAt(i) == ')' ) {
                        if(!pilaParentesis.isEmpty()){
                            pilaParentesis.pop();
                            for (int j=0; j<pilaOperadores.size();j++){
                                salida = salida + " " + pilaOperadores.pop();
                            }
                        } else{
                            return "Error de parentesis en expresion " + (k+1);
                        }

                    } else {

                        if (cadena.charAt(i)>='0' & cadena.charAt(i)<='9'){
                            if(i>0){
                                if(cadena.charAt(i-1)>='0' & cadena.charAt(i-1)<='9' & cadena.charAt(i)>='0' & cadena.charAt(i)<='9'){
                                        salida= salida + cadena.charAt(i);
                                    } else {
                                        salida= salida + " " + cadena.charAt(i);
                                    }
                            } else{
                                salida= salida + " " + cadena.charAt(i);
                            }
                            
                        } else {
                            if (cadena.charAt(i)=='+' | cadena.charAt(i)=='-' |  cadena.charAt(i)=='*' |  cadena.charAt(i)=='/'){
                                if(i>0){
                                    if(cadena.charAt(i-1) == '*' & cadena.charAt(i)== '*'){
                                        pilaOperadores.push("**");
                                    } else {
                                        pilaOperadores.push(cadena.charAt(i));
                                    }
                                } 
                            
                            } else {
                                if (cadena.charAt(i) == ';'){
                                    for (int j=0; j<pilaOperadores.size();j++){
                                        if(!pilaOperadores.isEmpty()){
                                            salida = salida + " " + pilaOperadores.pop();
                                        }
                                        salida = salida + ";\n";
                                    }
                                }
                            }
                        }

                    }

                }
            }

        }
        
        return salida;
    }
    
}

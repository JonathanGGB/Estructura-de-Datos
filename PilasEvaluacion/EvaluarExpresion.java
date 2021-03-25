package Clases;

import java.util.List;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author Irving Poot
 */

public class EvaluarExpresion{
    String salida;
    public String Evaluar() throws ScriptException{
        List expresiones = new LeerInfijas().obtenerExpresiones();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        for(int k=0;k<expresiones.size();k++){
            String cadena = (String) expresiones.get(k);
            salida = salida + engine.eval(cadena) + ";\n";
            
        }
        return salida;
    }

}


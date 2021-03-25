import javax.script.ScriptException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joni_
 */
public class InfijoAPostFijo {
    
    public static void main(String[] args) throws ScriptException {
       new ExportarPostFijas().exportar(new ConvertirExpresion().validarExpresion(), new EvaluarExpresion().Evaluar());
       

    }
}

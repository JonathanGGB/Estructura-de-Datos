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

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;
    
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
    
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
    
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
    
    
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
    
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
    
            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
    
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
    
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
    
                return x;
            }
        }.parse();
    }
    public String Evaluar() throws ScriptException{
        List expresiones = new LeerInfijas().obtenerExpresiones();

        for(int k=0;k<expresiones.size();k++){
            String cadena = (String) expresiones.get(k);
            cadena = cadena.replace("**", "^");
            cadena = cadena.replace(";", "");
            
            if (salida == null){
                salida = engine.eval(cadena) + ";\n";
            }else{
                salida = salida + engine.eval(cadena) + ";\n";
            }
            
            
        }
        return salida;
    }

}


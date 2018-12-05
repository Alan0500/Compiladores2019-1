package ast.patron.compuesto;
import ast.patron.visitante.*;
/* Tipos:
 * 1 - Boolean
 * 2 - Integer
 * 3 - Double
 * 4 - String
*/
public class Hoja extends Nodo
{
    public void accept(Visitor v){
     	v.visit(this);
    }

}

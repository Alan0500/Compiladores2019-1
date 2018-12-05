package ast.patron.compuesto;
import ast.patron.visitante.*;

public class PIzquierdoHoja extends Hoja
{
    public PIzquierdoHoja(Object i){
	valor = new Variable(i);
	tipo = 1;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}

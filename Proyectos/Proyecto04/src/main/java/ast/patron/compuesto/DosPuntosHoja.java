package ast.patron.compuesto;
import ast.patron.visitante.*;

public class DosPuntosHoja extends Hoja
{
    public DosPuntosHoja(Object i){
	valor = new Variable(i);
	tipo = 1;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}

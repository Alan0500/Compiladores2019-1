package ast.patron.compuesto;
import ast.patron.visitante.*;

public class PDerechoHoja extends Hoja
{
    public PDerechoHoja(Object i){
	valor = new Variable(i);
	tipo = 1;
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
}

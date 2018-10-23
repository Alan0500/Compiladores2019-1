package ast.patron.compuesto;

import ast.patron.visitante.*;

public class DoubleHoja extends Hoja {
    public DoubleHoja(double i) {
        valor = new Variable(i);
        tipo = 1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

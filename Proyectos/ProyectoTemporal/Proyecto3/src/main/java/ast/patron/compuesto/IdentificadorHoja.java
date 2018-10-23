package ast.patron.compuesto;

import ast.patron.visitante.*;

public class IdentificadorHoja extends Hoja {

    public IdentificadorHoja(String nombre, Object o) {
        valor = new Variable(o);  
        name = nombre ; 
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
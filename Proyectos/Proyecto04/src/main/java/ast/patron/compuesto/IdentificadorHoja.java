package ast.patron.compuesto;

import ast.patron.visitante.*;

public class IdentificadorHoja extends Hoja {

    public IdentificadorHoja(String nombre) {
        name = nombre ; 
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
package ast.patron.compuesto;

import ast.patron.visitante.*;

public class DivEnteraNodo extends NodoBinario {

    public DivEnteraNodo(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho); 
        tipo = 4;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}

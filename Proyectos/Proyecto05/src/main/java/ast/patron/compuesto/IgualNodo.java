package ast.patron.compuesto;

import ast.patron.visitante.*;

public class IgualNodo extends NodoBinario {

    public IgualNodo(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho); 
        tipo = 4;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}

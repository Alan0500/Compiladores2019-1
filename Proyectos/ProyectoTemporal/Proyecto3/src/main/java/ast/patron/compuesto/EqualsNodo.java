package ast.patron.compuesto;

import ast.patron.visitante.*;

public class EqualsNodo extends NodoBinario {

    public EqualsNodo(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho); 
        tipo = 4;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
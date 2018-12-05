package ast.patron.compuesto;

import ast.patron.visitante.*;

public class AddNodo extends NodoBinario {

    public AddNodo(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho); 
    }
    public void accept(Visitor v) {
         
        v.visit(this);
    }
}

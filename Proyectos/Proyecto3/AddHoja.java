package ast.patron.compuesto;

import ast.patron.visitante.*;

public class AddHojas extends NodoBinario {

    public AddHojas(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho); 
        tipo = 4;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
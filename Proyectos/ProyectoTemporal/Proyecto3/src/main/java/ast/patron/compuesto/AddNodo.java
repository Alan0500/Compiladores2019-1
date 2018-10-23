package ast.patron.compuesto;

import ast.patron.visitante.*;

public class AddNodo extends NodoBinario {

    public AddNodo(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho); 
        System.out.println(super.getPrimerHijo());
        System.out.println(super.getUltimoHijo());
        tipo = 4;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}

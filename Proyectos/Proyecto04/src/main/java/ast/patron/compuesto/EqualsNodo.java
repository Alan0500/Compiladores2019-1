package ast.patron.compuesto;

import ast.patron.visitante.*;

public class EqualsNodo extends NodoBinario {

    public EqualsNodo(Nodo izquierdo, Nodo derecho) {
        super(izquierdo, derecho);
        izquierdo.setTipo(identificarTipo(derecho));
    }

    private int identificarTipo(Nodo derecho) {
        if (derecho instanceof BooleanHoja)
        {
            return 1;
        }
        if (derecho instanceof IntHoja) 
        {
            return 2;
        }
        if (derecho instanceof DoubleHoja) 
        {
            return 3;
        }
        if (derecho instanceof StringHoja) 
        {
            return 4;
        }
        return 0;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
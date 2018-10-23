package ast.patron.compuesto;

import ast.patron.visitante.*;

public class WhileNodo extends Compuesto {

    public WhileNodo(Nodo Condicion, Nodo Then) {
        super(Condicion);
        super.hijos.getAll().add(1, Then);

    }

    public void agregarCondicion(Nodo r) {
        super.hijos.getAll().add(0, r);
    }

    public void agregarThen(Nodo r) {
        super.hijos.getAll().add(1, r);
    }

    public Nodo obtenerCondicion() {
        return super.hijos.getAll().get(0);
    }

    public Nodo obtenerThen() {
        return super.hijos.getAll().get(1);
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
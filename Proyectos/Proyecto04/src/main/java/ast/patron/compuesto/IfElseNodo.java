package ast.patron.compuesto;

import ast.patron.visitante.*;

public class IfElseNodo extends Compuesto {

    public IfElseNodo(Nodo Condicion, Nodo Then, Nodo Else) {
        // super(izquierdo, derecho);
        // tipo = 4;
        super(Condicion);
        super.hijos.getAll().add(1, Then);
        super.hijos.getAll().add(2, Else);

    }

    public void agregarCondicion(Nodo r) {
        super.hijos.getAll().add(0, r);
    }

    public void agregarThen(Nodo r) {
        super.hijos.getAll().add(1, r);
    }

    public void agregarElse(Nodo r) {
        super.hijos.getAll().add(2, r);
    }

    public Nodo obtenerCondicion() {
        return super.hijos.getAll().get(0);
    }

    public Nodo obtenerThen() {
        return super.hijos.getAll().get(1);
    }

    public Nodo obtenerElse() {
        return super.hijos.getAll().get(2);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
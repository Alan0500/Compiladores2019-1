package ast.patron.compuesto;
import ast.patron.visitante.*;

public class NodoNegativo extends Compuesto{
    public NodoNegativo(Nodo valor) {
        super(valor);
    }

    public void agregarValor(Nodo r) {
        super.hijos.getAll().add(0, r);
    }

    public Nodo obtenerValor() {
        return super.hijos.getAll().get(0);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
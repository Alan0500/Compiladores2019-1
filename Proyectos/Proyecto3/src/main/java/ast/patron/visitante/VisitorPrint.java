package ast.patron.visitante;

import ast.patron.compuesto.*;
// import java.util.LinkedList;
// import java.util.Iterator;

public class VisitorPrint implements Visitor {

    public void visit(IntHoja n) {
        System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
    }

    public void visit(Nodo n) {

    }

    public void visit(AddNodo n) {
        System.out.print("[Hoja Suma] valor Izquierdo: "+n.getPrimerHijo().getValor().ival);

    }

    public void visit(RestNodo n) {

    }

    public void visit(MultNodo n) {

    }

    public void visit(DivNodo n) {

    }

    public void visit(NodoBinario n) {

    }

    public void visit(DivEnteraNodo n) {

    }

    public void visit(MayorNodo n) {

    }

    public void visit(MenorNodo n) {

    }

    public void visit(IgualNodo n) {

    }

    public void visit(ModuloNodo n) {

    }

    public void visit(StringHoja n) {

    }

    public void visit(IfElseNodo n) {

    }


    public void visit(BooleanHoja n) {

    }

    public void visit(AndNodo n) {

    }

    public void visit(OrNodo n) {

    }

    public void visit(MayorIgualNodo n) {

    }

    public void visit(MenorIgualNodo n) {

    }

    public void visit(DiffNodo n) {

    }

    public void visit(EqualsNodo n) {

    }

    public void visit(PDerechoHoja n) {

    }

    public void visit(PIzquierdoHoja n) {

    }

    public void visit(DosPuntosHoja n) {

    }

}

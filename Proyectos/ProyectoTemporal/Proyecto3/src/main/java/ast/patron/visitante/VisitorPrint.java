package ast.patron.visitante;

import java.util.Iterator;

import ast.patron.compuesto.*;
// import java.util.LinkedList;
// import java.util.Iterator;

public class VisitorPrint implements Visitor {

    public void visit(IntHoja n) {
        System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
    }
    public void visit(DoubleHoja n) {
        System.out.print("[Hoja Real] valor: " + n.getValor().dval);
    }

    public void visit(AddNodo n) {
        System.out.print("[Nodo Suma] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());
        }
        System.out.println("}");
    }

    public void visit(RestNodo n) {
        System.out.print("[Nodo Resta] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");
    }

    public void visit(MultNodo n) {
        System.out.print("[Nodo Multiplicacion] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");

    }

    public void visit(DivNodo n) {
        System.out.print("[Nodo Divicion] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");

    }

    public void visit(DivEnteraNodo n) {
        System.out.print("[Nodo DivicionEntera] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");

    }

    public void visit(MayorNodo n) {
        System.out.print("[Nodo Mayor] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");
    }

    public void visit(MenorNodo n) {
        System.out.print("[Nodo Menor] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");

    }

    public void visit(IgualNodo n) {
        System.out.print("[Nodo Igualdad] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");
    }

    public void visit(ModuloNodo n) {
        System.out.print("[Nodo Modulo] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());

        }
        System.out.println("}");
    }

    public void visit(StringHoja n) {
        System.out.print("[Hoja String] valor: " + n.getValor().sval);
    }

    public void visit(IfElseNodo n) {

    }

    public void visit(BooleanHoja n) {
        System.out.print("[Hoja Boolean] valor: " + n.getValor().bval);

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
        System.out.print("[Hoja ParentesisDer]");
    }

    public void visit(PIzquierdoHoja n) {
        System.out.print("[Hoja ParentesisIzq]");
    }

    public void visit(DosPuntosHoja n) {
        System.out.print("[Hoja DosPuntos]" );
    }

    public void visit(Nodo n) {
        if (n instanceof IntHoja) {
            visit((IntHoja) n);
        }
        if (n instanceof DoubleHoja) {
            visit((DoubleHoja) n);
        }
        if (n instanceof StringHoja) {
            visit((StringHoja) n);
        }
        if (n instanceof AddNodo) {
            visit((AddNodo) n);
        }
        if (n instanceof AndNodo) {
            visit((AndNodo) n);
        }
        if (n instanceof BooleanHoja) {
            visit((BooleanHoja) n);
        }
        if (n instanceof DiffNodo) {
            visit((DiffNodo) n);
        }
        if (n instanceof DivEnteraNodo) {
            visit((DivEnteraNodo) n);
        }
        if (n instanceof DosPuntosHoja) {
            visit((DosPuntosHoja) n);
        }
        if (n instanceof DivNodo) {
            visit((DivNodo) n);
        }
        if (n instanceof EqualsNodo) {
            visit((EqualsNodo) n);
        }
        if (n instanceof IfElseNodo) {
            visit((IfElseNodo) n);
        }
        if (n instanceof IgualNodo) {
            visit((IgualNodo) n);
        }
        if (n instanceof MayorIgualNodo) {
            visit((MayorIgualNodo) n);
        }
        if (n instanceof MenorIgualNodo) {
            visit((MenorIgualNodo) n);
        }
        if (n instanceof MenorNodo) {
            visit((MenorNodo) n);
        }
        if (n instanceof MayorNodo) {
            visit((MayorNodo) n);
        }
        if (n instanceof ModuloNodo) {
            visit((ModuloNodo) n);
        }
        if (n instanceof MultNodo) {
            visit((MultNodo) n);
        }
        if (n instanceof OrNodo) {
            visit((OrNodo) n);
        }
        if (n instanceof PDerechoHoja) {
            visit((PDerechoHoja) n);
        }
        if (n instanceof PIzquierdoHoja) {
            visit((PIzquierdoHoja) n);
        }
        if (n instanceof RestNodo) {
            visit((RestNodo) n);
        }

    }

}

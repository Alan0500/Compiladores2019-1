package ast.patron.visitante;

import java.util.Iterator;
import java.util.LinkedList;

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
        System.out.print("[Nodo SUMA] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
    }

    public void visit(RestNodo n) {
        System.out.print("[Nodo RESTA] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
    }

    public void visit(MultNodo n) {
        System.out.print("[Nodo MULTIPLICACION] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
    }

    public void visit(DivNodo n) {
        System.out.print("[Nodo DIVICION] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(DivEnteraNodo n) {
        System.out.print("[Nodo DIVICION ENTERA] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(MayorNodo n) {
        System.out.print("[Nodo MAYOR] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
    }

    public void visit(MenorNodo n) {
        System.out.print("[Nodo MENOR] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(IgualNodo n) {
        System.out.print("[Nodo IGUALDAD] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
    }

    public void visit(ModuloNodo n) {
        System.out.print("[Nodo MODULO] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
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
        System.out.print("[Nodo AND] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(OrNodo n) {
        System.out.print("[Nodo OR] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(MayorIgualNodo n) {
        System.out.print("[Nodo MAYOR IGUAL] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");
        

    }

    public void visit(MenorIgualNodo n) {
        System.out.print("[Nodo MENOR IGUAL] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(DiffNodo n) {
        System.out.print("[Nodo DIFF] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

    }

    public void visit(EqualsNodo n) {
        System.out.print("[Nodo EQUALS] {");
        Iterator<Nodo> hijos = n.getHijos().iterator();
        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.print(",");
            }
            visit(hijos.next());
             
        }
        System.out.print("}");

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
    public void visit(IfNodo n) {        
        System.out.print("[Nodo IF] condicion: {");
        visit(n.obtenerCondicion());
        System.out.print("} then:{");
        visit(n.obtenerThen());
        System.out.print("}");
    }

    public void visit(WhileNodo n) {               
        System.out.print("[Nodo WHILE] condicion: {");
        visit(n.obtenerCondicion());
        System.out.print("} then:{");
        visit(n.obtenerThen());
        System.out.print("}");
    }
    public void visit(IdentificadorHoja n) {
        System.out.print("[Hoja Identificador] nombre: {"+ n.getNombre()); 
        System.out.print("}");
    }

    public void visit(PrintNodo n) {
        System.out.print("[Nodo PRINT] valor:");
        visit(n.obtenerValor());
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
        if (n instanceof IfNodo) {
            visit((IfNodo) n);
        }
        if (n instanceof IfElseNodo) {
            visit((IfElseNodo) n);
        }
        if (n instanceof WhileNodo) {
            visit((WhileNodo) n);
        }
        if (n instanceof IdentificadorHoja) {
            visit((IdentificadorHoja) n);
        }
        if (n instanceof PrintNodo) {
            visit((PrintNodo) n);
        }
        if (n instanceof NodoCompuesto) {
            visit((NodoCompuesto) n);
        }
        if (n instanceof NodoPositivo) {
            visit((NodoPositivo) n);
        }
        if (n instanceof NodoNegativo) {
            visit((NodoNegativo) n);
        }
        if (n instanceof NotNodo) {
            visit((NotNodo) n);
        }
    }

    public void visit(NodoCompuesto n) {
        System.out.print("\n");
        Iterator<Nodo> hijos = n.getHijos().iterator();

        boolean primerNodo = true; 
        while (hijos.hasNext()) {
            if(primerNodo ==true){
                primerNodo = false; 
            }else {
                System.out.println(";");
            }
            visit(hijos.next());  
        }
    }

    public void visit(NotNodo n) {
        System.out.print("[Nodo NOT] valor: {");
        visit(n.obtenerValor());     
        System.out.print("}");   

    }

    public void visit(NodoPositivo n) {
        System.out.print("[Nodo POSITIVO] valor: {");
        visit(n.obtenerValor());     
        System.out.print("}");

    }

    public void visit(NodoNegativo n) {
        System.out.print("[Nodo NEGATIVO] valor: {");
        visit(n.obtenerValor());     
        System.out.print("}");

    }

    public void visit(PowNodo n) {
        System.out.print("[Nodo Potencia] base: {");
        visit(n.getPrimerHijo());
        System.out.print("} exponente: {");
        visit(n.getUltimoHijo());
        System.out.print("}");
    }

}

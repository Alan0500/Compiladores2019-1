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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
            hijos.next().accept(this);
             
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
        n.obtenerCondicion().accept(this);
        System.out.print("} then:{");
        n.obtenerThen().accept(this);
        System.out.print("}");
    }

    public void visit(WhileNodo n) {               
        System.out.print("[Nodo WHILE] condicion: {");
        n.obtenerCondicion().accept(this);
        System.out.print("} then:{");
        n.obtenerThen().accept(this);
        System.out.print("}");
    }
    public void visit(IdentificadorHoja n) {
        System.out.print("[Hoja Identificador] nombre: {"+ n.getNombre()); 
        System.out.print("}");
    }

    public void visit(PrintNodo n) {
        System.out.print("[Nodo PRINT] valor:");
        n.obtenerValor().accept(this);
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
            hijos.next().accept(this);  
        }
    }

    public void visit(NotNodo n) {
        System.out.print("[Nodo NOT] valor: {");
        n.obtenerValor().accept(this);     
        System.out.print("}");   

    }

    public void visit(NodoPositivo n) {
        System.out.print("[Nodo POSITIVO] valor: {");
        n.obtenerValor().accept(this);       
        System.out.print("}");

    }

    public void visit(NodoNegativo n) {
        System.out.print("[Nodo NEGATIVO] valor: {");
        n.obtenerValor().accept(this);      
        System.out.print("}");

    }

    public void visit(PowNodo n) {
        System.out.print("[Nodo Potencia] base: {");
        n.getPrimerHijo().accept(this);
        System.out.print("} exponente: {");
        n.getUltimoHijo().accept(this);
        System.out.print("}");
    }

    public void visit(Nodo n ){} 
    public void visit(Hoja n){}
    public void visit(NodoBinario n ){}
}

package ast.patron.compuesto;

import ast.patron.visitante.*;

public class NodoBinario extends Nodo {

    public NodoBinario(Nodo primer, Nodo ultimo) {
        super(); 
        agregaHijoPrincipio(primer);
        if(primer != null){
            agregaHijoPrincipio(primer);
        }
        if(ultimo != null){
            agregaHijoFinal(ultimo);
        }
        tipo = 4;
    }
    @Override
    public void agregaHijoPrincipio(Nodo r) {
        if(r != null){
            super.agregaHijoPrincipio(r);
        }        
    }
    @Override
    public void agregaHijoFinal(Nodo r) {
        if (r != null){
            super.agregaHijoFinal(r);
        }
    }
    @Override
    public Nodo getPrimerHijo() {
        return super.getPrimerHijo();
    }
    @Override
    public Nodo getUltimoHijo() {
        return super.getUltimoHijo();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

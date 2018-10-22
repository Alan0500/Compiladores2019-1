package ast.patron.compuesto;

import ast.patron.visitante.*;

public class NodoBinario extends Nodo {

    public NodoBinario(Nodo primer, Nodo ultimo) {
        super(); 
        agregaHijoPrincipio(primer);
        agregaHijoFinal(ultimo);
        tipo = 4;
    }
    @Override
    public void agregaHijoPrincipio(Nodo r) {
        super.agregaHijoPrincipio(r);
    }
    @Override
    public void agregaHijoFinal(Nodo r) {
        super.agregaHijoFinal(r);
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

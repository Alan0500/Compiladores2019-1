/** Componente. La clase genéria Nodo.
 * @author Diana Montes
 */
package ast.patron.compuesto;

import ast.patron.visitante.*;

public class Nodo {
    Hijos hijos;
    Variable valor;
    int tipo;
    String name;

    public Nodo(){
        hijos = new Hijos(); 
        tipo = 0;
        
    }

    public Hijos getHijos() {
        return hijos;
    }

    public Nodo getHijo() {
        return null;
    }

    public void setHijo(Nodo c) {
        hijos.getAll().add(c); 
    }

    public Nodo getUltimoHijo() {
        return hijos.getUltimoHijo();
    }

    public Nodo getPrimerHijo() {
        return hijos.getPrimerHijo();
    }

    public void agregaHijoFinal(Nodo r) {
        this.hijos.agregaHijoFinal(r);
    }

    public void agregaHijoPrincipio(Nodo r) {
        this.hijos.agregaHijoPrincipio(r);
    }

    public Variable getValor() {
        return valor;
    }

    public int getType() {
        return tipo;
    }

    public String getNombre() {
        return name;
    }

    public void setValor(Variable nuevo) {
        valor = nuevo;
    }

    public void setTipo(int nuevo) {
        tipo = nuevo;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}

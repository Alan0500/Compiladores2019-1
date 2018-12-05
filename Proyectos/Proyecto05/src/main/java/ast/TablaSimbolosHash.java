package ast;

import java.io.*;
import java.util.Hashtable;
import ast.TablaSimbolos;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;
public class TablaSimbolosHash implements TablaSimbolos
{
    private Hashtable<String,Integer> tablaSimbolos; 
    public TablaSimbolosHash()
    {
        tablaSimbolos = new Hashtable(); 
    }
    public Integer LookUp(String name)
    {
        return tablaSimbolos.get(name); 
    } 
    public void Insert(String name, Integer info)
    {
        tablaSimbolos.put(name, info); 
    } 
    /**
     * @return the tablaSimbolos
     */
    public Hashtable getTablaSimbolos() {
        return tablaSimbolos;
    }
    /**
     * @param tablaSimbolos the tablaSimbolos to set
     */
    public void setTablaSimbolos(Hashtable tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

}
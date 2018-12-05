package ast;

import java.io.*;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;
public interface TablaSimbolos
{
    public Integer LookUp(String name) ; 
    public void Insert(String name, Integer info); 
}
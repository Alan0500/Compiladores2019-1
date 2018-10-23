package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    public void visit(IntHoja n);
    public void visit(Nodo n);
    public void visit(AddNodo n);    
    public void visit(RestNodo n);
    public void visit(MultNodo n);
    public void visit(DivNodo n);
    public void visit(DivEnteraNodo n);
    public void visit(MayorNodo n);
    public void visit(MenorNodo n);
    public void visit(DoubleHoja n);
    public void visit(IgualNodo n);
    public void visit(ModuloNodo n);
    public void visit(StringHoja n);
    public void visit(IfElseNodo n);
    public void visit(BooleanHoja n);
    public void visit(AndNodo n);
    public void visit(OrNodo n);
    public void visit(IfNodo n);
    public void visit(WhileNodo n);
    public void visit(IdentificadorHoja n);
    //public void visit(NotNodo n);
    
    public void visit(PrintNodo n);
    public void visit(MayorIgualNodo n);
    public void visit(MenorIgualNodo n);
    public void visit(DiffNodo n);
    public void visit(EqualsNodo n);
    public void visit(PDerechoHoja n);
    public void visit(PIzquierdoHoja n);
    public void visit(DosPuntosHoja n);


}

package ast.patron.visitante;

import ast.TablaSimbolos;
import ast.patron.compuesto.*;
import java.util.Iterator;

public class VisitanteGenerador implements Visitor {
    Registros reg = new Registros();
    TablaSimbolos simbolos;
    public static String archivo ; 
    public VisitanteGenerador(TablaSimbolos simbolos ) {
        this.simbolos = simbolos;
        this.archivo = ".data\n"+
                        "True : .word 1\n "+
                        "false : .word 0\n"+
                        ".text\n"+
                        "main: \n";        
    }

    public void visit(DiffNodo n) {

    }

    public void visit(IntHoja n) {
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(1);
        int i = n.getValor().ival;
        System.out.println("li " + siguientes[0] + "," + i);
        archivo = archivo + "li " + siguientes[0] + "," + i+"\n";
    }

    public void visit(AddNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        boolean enteros = true;
        boolean primerDouble = false;
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode = "add";
        System.out.println(opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]);
        
        archivo = archivo + opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]+"\n";
    }

    public void visit(RestNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        boolean enteros = true;
        boolean primerDouble = false;
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode = "sub";
        System.out.println(opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]);
        archivo = archivo + opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]+"\n";
    }

    public void visit(MultNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        boolean enteros = true;
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode = "mul";
        System.out.println(opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]);
        archivo = archivo + opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]+"\n";
    }


    public void visit(DivNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        boolean enteros = true;
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode = "div";
        System.out.println(opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]);
        archivo = archivo + opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]+"\n";
    }

    public void visit(DivEnteraNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        boolean enteros = true;
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode = "div";
        System.out.println(opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]);
        archivo = archivo + opcode + " " + objetivo + ", " + siguientes[0] + ", " + siguientes[1]+"\n";
    }

    public void visit(MayorNodo n) {
    }

    public void visit(MenorNodo n) {
    }

    public void visit(DoubleHoja n) {
        String objetivo = reg.getObjetivoREGISTRODouble();
        String[] siguientes = reg.getNsiguientesD(1);
        double i = n.getValor().dval;
        System.out.println("li.d " + siguientes[0] + "," + i);
        archivo = archivo + "li.d " + siguientes[0] + "," + i+"\n";
    }

    public void visit(IgualNodo n) {
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();
        boolean enteros = true;
        boolean primerDouble = false;

        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(2);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1]);
        hd.accept(this);
        String opcode = String.format(
                "%s: \n" + "beq %s, %s, %s\n" + "b %s\n" + "%s:\n" + "li $v0, 1 \n" + "b %s\n" + "%s:\n"
                        + "li $v0, 0 \n" + "b %s\n" + "%s:\n",
                reg.siguienteEtiquetaIguales(), siguientes[0], siguientes[1], reg.siguienteEtiquetaIgualesTRUE(),
                reg.siguienteEtiquetaIgualesFALSE(), reg.siguienteEtiquetaIgualesTRUE(),
                reg.siguienteEtiquetaIgualesFIN(), reg.siguienteEtiquetaIgualesFALSE(),
                reg.siguienteEtiquetaIgualesFIN(), reg.siguienteEtiquetaIgualesFIN());
        System.out.println(opcode);
        archivo += opcode+"\n";
        reg.igualesTemporal++;
    }

    public void visit(ModuloNodo n) {
    }

    public void visit(StringHoja n) {
        System.out.printf(".data\n %s .asciiz \"%s\" \n.text\n", reg.siguienteCadenaTemporal(), n.getValor().sval);
        archivo += String.format(".data\n %s .asciiz \"%s\" \n.text\n", reg.siguienteCadenaTemporal(), n.getValor().sval);
    }

    public void visit(IfElseNodo n) {
    }

    public void visit(BooleanHoja n) {
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(1);
        int i = n.getValor().ival;
        System.out.println("li " + siguientes[0] + "," + i);
        String valor = n.getValor().bval ? "True" : "False";
        System.out.printf("lw %s , %s", siguientes[0], valor);
        archivo = archivo +  String.format("lw %s , %s \n", siguientes[0], valor);
    }

    public void visit(AndNodo n) {

    }

    public void visit(OrNodo n) {
    }

    public void visit(IfNodo n) {

    }

    public void visit(WhileNodo n) {
    }

    public void visit(IdentificadorHoja n) {
    }

    public void visit(NotNodo n) {
    }

    public void visit(NodoCompuesto n) {
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            hijos.next().accept(this);
        }
    }

    public void visit(PrintNodo n) {
        Nodo hi = n.getPrimerHijo();
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(1);
        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0]);
        hi.accept(this);
        String code = String.format("move $a0,%s\nli $v0, 1 \nsyscall\n ", siguientes[0]);
        archivo = archivo + code ; 
    }

    public void visit(MayorIgualNodo n) {
    }

    public void visit(MenorIgualNodo n) {
    }

    public void visit(EqualsNodo n) {
    }

    public void visit(PDerechoHoja n) {
    }

    public void visit(PIzquierdoHoja n) {
    }

    public void visit(DosPuntosHoja n) {
    }

    public void visit(NodoPositivo n) {
    }

    public void visit(NodoNegativo n) {
        String objetivo = reg.getObjetivoREGISTRO();
        String[] siguientes = reg.getNsiguientes(1);
        // n.getPrimerHijo().accept(this);
        niega(n);
        int i = n.getPrimerHijo().getValor().ival;
        System.out.println("li " + siguientes[0] + "," + i);
        archivo += "li " + siguientes[0] + "," + i+"\n";
    }
    /**
     * Metodo que niega un entero al encontrarse un nodo negativo 
     * Caso -4 genera un arbol NodoNegativo (IntHoja 4)
     * El metodo sirve para eliminar el nodo negativo y no perder el contexto
     * @param n
     */
    private void niega(Nodo n) {
        if (n instanceof Hoja) {
            if (n instanceof IntHoja) {
                Variable as = n.getValor();
                int entero = as.ival;
                as.ival = entero * -1;
            }
            if (n instanceof DoubleHoja) {
                Variable as = n.getValor();
                double dou = as.dval;
                as.dval = dou * -1;
            }
        } else {
            Hijos hijos = n.getHijos();
            if (hijos != null || hijos.getAll().size() > 0) {
                niega(n.getPrimerHijo());
            }
        }
    }

    public void visit(PowNodo n) {
    }

    public void visit(Nodo n) {
    }

    public void visit(Hoja n) {
    }

    public void visit(NodoBinario n) {
    }

    public String archivoCadena(){
        archivo = archivo + "end: jr $ra";
        return archivo;
    }
}
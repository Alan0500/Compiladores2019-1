package ast.patron.visitante;

import ast.TablaSimbolos;
import ast.patron.compuesto.*;
import java.util.Iterator;
import java.util.LinkedList;

public class VisitorSemantico implements Visitor {
    private TablaSimbolos tablaSimbolos;
    private Nodo arbol;
    private final String MSGERROROPERACIONUNARIA = "[ERROR] OPERADOR \"%s\" NO DEFINIDO para el tipo: %s. \n";
    private final String MSGERROROPERACION = "[ERROR] OPERADOR \"%s\" NO DEFINIDO para los tipos: %s,%s. \n";
    // eSTE ES OPCIONAL Y SOLO SIRVE PARA TENER MEJOR CONTROL SOBRE LO QUE ESTOY RECONOCIENDO DEGUG
    private final VisitorPrint print = new VisitorPrint();
    private final String MSGERRORDEF = "[ERROR] VARIABLE \"%s\" no inicializada\n";

    public VisitorSemantico(TablaSimbolos tabla, Nodo arbol) {
        this.tablaSimbolos = tabla;
        this.arbol = arbol;
    }
    public VisitorSemantico(TablaSimbolos tabla) {
        this.tablaSimbolos = tabla;
        this.arbol = null;
    }
    public void setArbol(Nodo arbol){
        this.arbol = arbol;
    }

    public void visit(IntHoja n) {
        n.setTipo(2);
    }   

    public void visit(AddNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 4 }, // Boolean
                                    { 0, 0, 2, 3, 4 }, // Enteros
                                    { 0, 0, 3, 3, 4 }, // Reales
                                    { 0, 4, 4, 4, 4 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"+",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());

    }
    /**
     * Metodo que unicamente sirve para poder visualizar de mejor forma los errores de tipos
     * @param n
     * @return
     */
    private String obtenerTipoS(int n) {
        switch (n) {
        case 1:
            return "BOOLEAN";
        case 2:
            return "INTEGER";
        case 3:
            return "REAL";
        case 4:
            return "STRING";
        default:
            return "ERROR";
        }
    }

    private int obtenerTipo(Nodo n) {

        if (n!= null){
            if (n instanceof Hoja && !(n instanceof IdentificadorHoja )) {
                return n.getType();
            } else {
                if (n instanceof IdentificadorHoja){
                    if (!n.getNombre().equals("")) {
                        Integer valor = tablaSimbolos.LookUp(n.getNombre());
                        if (valor != null) {
                            return valor;
                        }
                    }
                }
                else{
                    // Este es el caso de que es un nodo operador y ya fue visitado con anterioridad
                    // por lo tanto ya fue calculado su tipo
                    return n.getType(); 
                }
                
            }
        }
        System.out.printf(MSGERRORDEF,n.getNombre().toUpperCase());
        return 0;

    }

    public void visit(RestNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 2, 3, 0 }, // Enteros
                                    { 0, 0, 3, 3, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"-",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(MultNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 2, 3, 0 }, // Enteros
                                    { 0, 0, 3, 3, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"*",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(DivNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 2, 3, 0 }, // Enteros
                                    { 0, 0, 3, 3, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"/",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(DivEnteraNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 2, 2, 0 }, // Enteros
                                    { 0, 0, 2, 2, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"//",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(MayorNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 1, 1, 0 }, // Enteros
                                    { 0, 0, 1, 1, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,">",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(MenorNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
         //n.accept(print);
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 1, 1, 0 }, // Enteros
                                    { 0, 0, 1, 1, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"<",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(DoubleHoja n) {
        n.setTipo(3);
    }

    public void visit(IgualNodo n) {
       // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 1, 0, 0, 0 }, // Boolean
                                    { 0, 0, 1, 1, 0 }, // Enteros
                                    { 0, 0, 1, 1, 0 }, // Reales
                                    { 0, 0, 0, 0, 1 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"==",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(ModuloNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 2, 3, 0 }, // Enteros
                                    { 0, 0, 3, 3, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"%",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(StringHoja n) {
        n.setTipo(4);
    }

    public void visit(IfElseNodo n) {
        visit(n.obtenerCondicion());
        visit(n.obtenerThen());
        visit(n.obtenerElse());
    }

    public void visit(BooleanHoja n) {
        n.setTipo(1);
    }

    public void visit(AndNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 1, 0, 0, 0 }, // Boolean
                                    { 0, 0, 0, 0, 0 }, // Enteros
                                    { 0, 0, 0, 0, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"and",S1,S3);
            System.exit(1);
        }
        ////System.out.println(n.getType());
    }

    public void visit(OrNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 1, 0, 0, 0 }, // Boolean
                                    { 0, 0, 0, 0, 0 }, // Enteros
                                    { 0, 0, 0, 0, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"or",S1,S3);
            System.exit(1);
        }
//        //System.out.println(n.getType());
    }

    public void visit(IfNodo n) {
        visit(n.obtenerCondicion());
        visit(n.obtenerThen());
    }

    public void visit(WhileNodo n) {
        visit(n.obtenerCondicion());
        visit(n.obtenerThen());
    }

    public void visit(IdentificadorHoja n) {
        // El valor ya fue asignado al momento de la aignacion del valor
        if (!n.getNombre().equals("")){
            Integer valor = tablaSimbolos.LookUp(n.getNombre());
            if(valor != null){
                n.setTipo(valor);
            }else{
                System.out.printf(MSGERRORDEF,n.getNombre());
                // Mensaje de error que sale en el primer error Semantico [SE PUEDE OMITIR]
                System.exit(1);
            }
        }
    }

    public void visit(NotNodo n) {
// ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int[] matrizOperador =  { 0, 1, 2, 3, 0 }; 
        n.setTipo(matrizOperador[s1]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            System.out.printf(MSGERROROPERACIONUNARIA,"-",S1);
            System.exit(1);
        }
    }

    public void visit(NodoCompuesto n) {
        Iterator<Nodo> hijos = n.getHijos().iterator();
        while (hijos.hasNext()) {
            visit(hijos.next());  
        } 
    }

    public void visit(PrintNodo n) {
    }

    public void visit(MayorIgualNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 1, 1, 0 }, // Enteros
                                    { 0, 0, 1, 1, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,">=",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(MenorIgualNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 1, 1, 0 }, // Enteros
                                    { 0, 0, 1, 1, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"<=",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
    }

    public void visit(DiffNodo n) {
           // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 1, 0, 0, 0 }, // Boolean
                                    { 0, 0, 1, 1, 0 }, // Enteros
                                    { 0, 0, 1, 1, 0 }, // Reales
                                    { 0, 0, 0, 0, 1 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"!=",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());    
    }

    public void visit(EqualsNodo n) {
        
        visit(n.getUltimoHijo());
        //System.out.println(n.getUltimoHijo());
        int tipo = n.getUltimoHijo().getType(); 
        //System.err.println("[ERROR AL LEER EL ENTERO]"+ tipo);
        //n.accept(print);
        tablaSimbolos.Insert(n.getPrimerHijo().getNombre(), tipo);
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
    }

    public void visit(PowNodo n) {
        // ----------------------Puedes Comentar despues esta Linea--------------
        // No es importante pero sirve de mucho al debugear 
        // //n.accept(print);
        // System.out.println();
        
        visit(n.getPrimerHijo());
        visit(n.getUltimoHijo());
        int s1 = obtenerTipo(n.getPrimerHijo());
        int s3 = obtenerTipo(n.getUltimoHijo());
        int[][] matrizOperador = {  { 0, 0, 0, 0, 0 }, // Error
                                    { 0, 0, 0, 0, 0 }, // Boolean
                                    { 0, 0, 2, 3, 0 }, // Enteros
                                    { 0, 0, 3, 3, 0 }, // Reales
                                    { 0, 0, 0, 0, 0 } }; // String
        n.setTipo(matrizOperador[s1][s3]);
        if (n.getType() == 0) {
            String S1 = obtenerTipoS(s1);
            String S3 = obtenerTipoS(s3);
            System.out.printf(MSGERROROPERACION,"**",S1,S3);
            System.exit(1);
        }
        //System.out.println(n.getType());
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
}
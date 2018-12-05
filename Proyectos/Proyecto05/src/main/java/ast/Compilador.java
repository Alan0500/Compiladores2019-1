//import Parser;
package ast;
import java.io.*;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;



public class Compilador{

    FileWriter fichero = null;
    PrintWriter pw = null;
    Parser parser;
    Nodo raízAST;
    VisitorPrint v_print;
    VisitorSemantico v_contreto ;
    VisitanteGenerador v_generador ; 

    Compilador(Reader fuente){
        parser = new Parser(fuente);
        v_print = new VisitorPrint();
        v_contreto = new VisitorSemantico(parser.tablaSimbolos); 
        v_generador = new VisitanteGenerador(parser.tablaSimbolos);
    }

    public void ConstruyeAST(boolean debug){
        parser.yydebug = debug;
        parser.yyparse(); // análisis léxico, sintáctio y constucción del AST
        raízAST = parser.raíz;
    }
    
    public void imprimeAST(){
        
        parser.raíz.accept(v_print);
    }
    public void aceptaAST(){
        parser.raíz.accept(v_contreto);
	System.out.println("\n\n\n[OK] Reconocimiento Exitoso"); 
    }
    public void generaCodigo(){
        raízAST.accept(v_generador);
    }
    public static void main(String[] args){
            //String archivo = "src/main/resources/fizzbuzz.p";
            String archivo = "src/main/resources/ejemplo.p";
        try{
            Reader a = new FileReader(archivo);
            Compilador c  = new Compilador(a);
            c.ConstruyeAST(false);
            c.imprimeAST();
            c.aceptaAST();
            c.generaCodigo();
            String generaArchivo = c.v_generador.archivoCadena() ; 
            int index = archivo.lastIndexOf('/');
            String token = archivo.substring(index+1,archivo.indexOf(".")+1)+"asm";
            File folder = new File("out/");
            if (!folder.exists()) { 
                folder.mkdir();
            }
            FileWriter fichero = new FileWriter("out/"+token);
            
            //PrintWriter pw = new PrintWriter(fichero);
            fichero.write(generaArchivo);
            fichero.close();
                         

        }catch(FileNotFoundException e){
            System.err.println("El archivo " + archivo +" no fue encontrado. ");
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Uso: java Compilador [archivo.p]: ");
        }catch(Exception e ){
            System.err.println(e);
        }
    }
}

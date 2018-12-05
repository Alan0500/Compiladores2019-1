//parser.y
%{
  import java.lang.Math;
  import java.io.*;
%}

 // %token NL          /* newline  */
%token <dval> NUMERO  /* a number */

%type <dval> exp fact term MENOS

%right '-' '+'
%right  '*' '/'

      
%%

input:   /* empty string */
       | input line
       ;
      
line:   exp  { System.out.println("[OK] " + $1);  }
       ;
      
exp:  term              {$$ = $1 ;}
     | term '+' exp        { $$ = $1 + $3; }
     | term '-' exp            {$$ = $1 - $3 ; } 
    
    ;  
term : fact                     {$$ = $1 ;}
    | fact '*' term                { $$ = $1 * $3; }
    |  fact '/' term                 { $$ = $1 / $3; }
     
  ;
fact  : NUMERO                      {$$ = $1 ; }                         
    | MENOS NUMERO                    {$$ = -1 * $2 ; }
    ;
    
%%
/* Referencia a analizador léxico */
private Nodos lexer;
/* Constructor */
public Parser(Reader r) {
    lexer = new Nodos(r, this);
}
public int yylex(){
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
}
/* Función para reportar error */
public void yyerror (String error) {
    System.err.println ("[ERROR]  " + error);
    System.exit(1);
}
/* Creación del parser e inicialización del reconocimiento */
public static void main(String args[])  {
    // Parser parser = new Parser(new FileReader(args[0]));
    // parser.yyparse();
    try{
		Parser yyparser = new Parser(new FileReader(args[0]));
		yyparser.yyparse();	
	}catch(FileNotFoundException e){
		System.err.println("El archivo "+args[0]+ "no existe"); 
	}
}

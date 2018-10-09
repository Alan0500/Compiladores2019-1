%{
  import java.lang.Math;
  import java.io.*;
%}

%token NUMERO TRUE FALSE SALTO AND FROM ENTERO REAL INDENTA DEINDENTA 
%token ELIF OR IF PRINT RETURN MAS MENOS MULT DIV EXP MOD MAYOR MENOR NOT WHILE FOR ELSE CADENA
%token MAYORIG MENOSIG IGUAL DIST MASIG MENORIG IGUALIG PARIZQ PARDER DOSPUNTOS PUNTOCOMA IDENTIFICADOR
/* Gramática con recursión izquierda */

%%

/* file_input: (SALTO | stmt)* ENDMARKER */

file_input : 
    | SALTO file_input {dump_stacks(stateptr);}
    | stmt file_input   {dump_stacks(stateptr);}
    ;

/* stmt: simple_stmt | compound_stmt */
stmt:  compound_stmt  {dump_stacks(stateptr);}
    | simple_stmt {dump_stacks(stateptr);}
    ; 

/* compound_stmt: if_stmt
             | while_stmt */
compound_stmt: if_stmt {dump_stacks(stateptr);}
     |while_stmt {dump_stacks(stateptr);}
    ;

/* simple_stmt: small_stmt SALTO */
simple_stmt : small_stmt SALTO {dump_stacks(stateptr);}
    ;

/* small_stmt: expr_stmt | print_stmt */
small_stmt : expr_stmt {dump_stacks(stateptr);}
    | print_stmt {dump_stacks(stateptr);}
    ;

/* expr_stmt: test '=' test */
expr_stmt : test  {dump_stacks(stateptr);}
    |test IGUAL test {dump_stacks(stateptr);}
    ;

/* print_stmt: 'print' test */
print_stmt : PRINT test {dump_stacks(stateptr);}
    ;


/* if_stmt: 'if' test ':' suite ['else' ':' suite] */
if_stmt : IF test DOSPUNTOS suite {dump_stacks(stateptr);}
    /*| IF test DOSPUNTOS suite ELSE DOSPUNTOS suite {dump_stacks(stateptr);} */
    ;
/* while_stmt: 'while' test ':' suite */ 
while_stmt : WHILE test DOSPUNTOS suite {dump_stacks(stateptr);}
    ;
/* suite: simple_stmt | SALTO INDENTA stmt+ DEINDENTA */

suite : simple_stmt {dump_stacks(stateptr);} 
    | SALTO INDENTA stmt DEINDENTA {dump_stacks(stateptr);}
    | SALTO INDENTA suite DEINDENTA {dump_stacks(stateptr);}
    
    ; 

/* test: or_test */
test : or_test {dump_stacks(stateptr);}
    ;

/* or_test: and_test ('or' and_test)* */
or_test : and_test {dump_stacks(stateptr);}
    | and_test OR or_test
    ;

/* and_test: not_test ('and' not_test)* */
and_test : not_test
    | not_test AND and_test {dump_stacks(stateptr);}
    ;
/* not_test: 'not' not_test | comparison */
not_test: NOT not_test  {dump_stacks(stateptr);}
    | comparison {dump_stacks(stateptr);}
    ;
/* comparison: expr (comp_op expr)* */
comparison: expr  {dump_stacks(stateptr);}
    | expr comp_op expr  {dump_stacks(stateptr);}
    ;
/* comp_op: '<'|'>'|'=='|'>='|'<='|'!=' */
comp_op: MENOR {dump_stacks(stateptr);}
    |MAYOR {dump_stacks(stateptr);}
    |IGUALIG {dump_stacks(stateptr);}
    |MAYORIG {dump_stacks(stateptr);}
    |MENORIG {dump_stacks(stateptr);}
    |DIST {dump_stacks(stateptr);}
    ;
/* expr: term (('+'|'-') term)* */
expr: term {dump_stacks(stateptr);} 
    | term MAS expr {dump_stacks(stateptr);}
    | term MENOS expr {dump_stacks(stateptr);}
    ;
/* term: factor (('*'|'/'|'%'|'//') factor)* */
term: factor  {dump_stacks(stateptr);}
    |factor MULT term {dump_stacks(stateptr);}
    |factor DIV term {dump_stacks(stateptr);}
    |factor MOD term {dump_stacks(stateptr);}
    ;

/* factor: ('+'|'-') factor | power */
factor:  power {dump_stacks(stateptr);}
    |MAS factor {dump_stacks(stateptr);}
    | MENOS factor {dump_stacks(stateptr);}
    ;
/* power: atom ['**' factor] */
power: atom  {dump_stacks(stateptr);}
    | atom EXP factor {dump_stacks(stateptr);}
    ;
/* atom: IDENTIFICADOR | ENTERO | CADENA
    | REAL | BOOLEANO | '(' test ')' */

atom: IDENTIFICADOR 	{dump_stacks(stateptr);}
    | ENTERO {dump_stacks(stateptr);}
    | CADENA {dump_stacks(stateptr);}
    | REAL {dump_stacks(stateptr);}
    | TRUE {dump_stacks(stateptr);}
    | FALSE {dump_stacks(stateptr);}
    | PARIZQ test PARDER {dump_stacks(stateptr);} 
    ;






%%
/* Referencia a analizador léxico */
private Flexer lexer;

/* Constructor */
public Parser(Reader r) {
    lexer = new Flexer(r, this);
}

private int yylex () {
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
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader("src/main/resources/test.txt"));

    parser.yydebug = true;
    parser.yyparse();
}

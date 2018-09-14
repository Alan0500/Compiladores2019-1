package testmaven;
%%
%{
  boolean paso =false;
  /* %line Sirve para crear un identificador en que linea se encuentra el token que esta siendo reconocido*/
  ControladorAnalisisLexico controlador  = new ControladorAnalisisLexico();
%}
%class Flexer
%public
%unicode
%line
%type String
PUNTO   = \.
BOOLEAN = True | False
ENTERO  = [1-9][0-9]* | 0+
FLOAT = {ENTERO} {PUNTO} {ENTERO} | {PUNTO} {ENTERO} | {ENTERO} {PUNTO}
RESERVED_WORD = and|or|not|for|while|if|else|elif|print
STRING = \" (.[^\\\"])* \"
SEPARADOR = :
OPERADOR = \+|\-|\*|\**|\/|\/\/|\%|\<|\>|\>=|\<=|\=|\!|\==
COMMENT = #.*
ID_PYTHON = ([:jletter:]|_) ([:jletter:]|[:jletterdigit:]|_)*
%state ESPACIOS
%%
\n     {  yybegin(ESPACIOS);  }
{FLOAT} { return "FLOAT ("+yytext()+")"; }
{RESERVED_WORD} { return "RESERVADA("+yytext()+")"; }
{BOOLEAN}     { return "BOOLEAN("+yytext()+")"; }
{SEPARADOR}   { return "SEPARADOR("+yytext()+")"; }
{ENTERO}      { return "ENTERO("+yytext()+")"; }
{STRING}      { return "CADENA("+yytext() + ")"; }
{ID_PYTHON}    { return "ID_PYTHON("+yytext() + ")"; }
{COMMENT}     { return "COMMENT( "+yytext() + ")"; }
{OPERADOR}    { return "OPERADOR("+yytext()+")"; }
" "           {}
("("|")")       {}
<ESPACIOS> {
(" ")*     {
              int espacios = yylength() ;
              yybegin(YYINITIAL);
              String resultado = controlador.representa(espacios,yyline);
              if(resultado==""){
                  return "SALTO\n";
              }

              return "SALTO\n"+(resultado+"("+espacios+")");
              }
(\t|" ")+     {
                int espacios = yytext().length();
                yybegin(YYINITIAL);
                String resultado = controlador.representa(espacios,yyline);
                if(resultado==""){
                  return "\n";
                }
                return "SALTO\n"+(resultado+"("+espacios+")");
                }


} 
.             { throw new RuntimeException("Error en la linea: " + yyline); }
<<EOF>>       {
                if(!paso){
                  paso = true;
                    return "\n"+controlador.terminaIdentacion();
                  }
                  throw new Final("Final de la linea");
        
}               
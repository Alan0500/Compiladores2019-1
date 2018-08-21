// Codigo en java 
%%
%public
%class AL
%unicode
%standalone

ENTEROS = [0-9]+
COMENTARIOS = \/\/.*  | \/\* .* \*\/
IDENTIFICADOR = [:jletter:][:jletterdigit:]*

%%
{ENTEROS} {System.out.println("ENTERO");}
{COMENTARIOS} {System.out.println("COMENTARIOS");}
{IDENTIFICADOR} {System.out.println("IDENTIFICADOR"); }
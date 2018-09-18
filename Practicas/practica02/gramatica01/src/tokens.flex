%%
//Declaraciones en java (variables, constructores, métodos)
%{
    private Parser parser;

    public Nodos (java.io.Reader r, Parser p){
    	   this(r);
    	   parser = p;
    }
%}
//Directivas declaradas:

%class Nodos //La clase que se genera a partir de este archivo con JFlex es llamada así.
%standalone //Crea un método main.
%public //La clase generada es pública.
%unicode //Para que lea carácteres unicode.
//%byaccj //Para compatibilidad con byacc

//Atomos definidos:

NUMERO = [1-9]+[0-9]* | [0-9]+

%%
//{Token} {Accion}
//Acciones a ejecutar encontrando el token:

//Si encontramos un número asignamos yylval con el valor 'parseado' de yytext y devolvemos un token de tipo NUMERO (declarado dentro de ari.y).
{NUMERO} {parser.yylval = new ParserVal(Double.parseDouble(yytext())); return parser.NUMERO;}

//Hacemos lo mismo para los operadores.
"+"|"-"|"*"|"/" { System.out.print("");return (int) yycharat(0); }

//Si nos encontramos cualquier cosa que no sea un número o token lanzamos un error.
. {System.out.println("[ERROR] La expresión aritmética no está bien formada");System.exit(1);}
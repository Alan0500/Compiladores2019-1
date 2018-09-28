/********************************************************************************
**  @author Diana Montes                                                       **
**  @about Proyecto 1: Analizador léxico para p, subconjunto de Python.        **
*********************************************************************************/
package asintactico;
import java.util.Stack;

%%
%public
%class Flexer
%standalone
%line
%state INDENTA CADENA CODIGO
%unicode
%{
    private Parser parser;

    public Flexer (java.io.Reader r, Parser p){
    	   this(r);
    	   parser = p;
    }
    
    /* Acumula todos los átomos de DEINDENTA que deben ser devueltos  */
    static String dedents = "";
    /* Estructura auxiliar para almacenar los bloques de indentación */
    static Stack<Integer> pila = new Stack<Integer>();
    /* Guarda el nivel actual de indentación */
    static Integer actual = 0;
    /** Función que maneja los niveles de indetación e imprime
    * átomos INDENTA y DEINDENTA.
    * @param int espacios - nivel de indetación actual.
    * @return boolean - true en caso que no haya errores léxicos,
    * 	      	      	 false en otro caso.
    */
    public static boolean indentacion(int espacios){
        if(pila.empty()){ //ponerle un cero a la pila si esta vacia
             pila.push(new Integer(0));
        }

        Integer tope = pila.peek();

        if(tope != espacios){
	    //Se debe emitir un DEDENT por cada nivel mayor al actual
            if(tope > espacios){
                while(pila.peek() > espacios &&  pila.peek()!=0 ){
                    dedents += "DEINDENTA("+pila.pop()+")\n";
                }
                if(pila.peek() == espacios){
                    System.out.print(dedents);
                    dedents = "";
                    return true;
                }
                return false;
            }
   	    //El nivel actual de indentación es mayor a los anteriores.
            pila.push(espacios);
            System.out.println("INDENTA("+actual+")");
            return true;
        }
	//El nivel actual es igual al anterior.
        return true;
    }
%}
PUNTO			=	\.
DIGIT           	=       [0-9]
CERO             	=        0+
ENTERO			= 	{CERO} | {DIGIT}+
REAL			= 	{ENTERO}? {PUNTO} {ENTERO} | {ENTERO} {PUNTO} {ENTERO}?
AND             = "and"
FROM            = "from"
NOT             = "not"
WHILE           = "while"
FOR             = "for"
ELSE            = "else"
ELIF            = "elif"
OR              = "or"
IF              = "if"
PRINT           = "print"
RETURN          = "return"
MAS                         = "+"
MENOS               = "-"
MULT                = "*"
DIV             = "/"
EXP             = "**"
MOD             = "%"
MAYOR               = ">"
MENOR               = "<"
MAYORIG             = ">="
MENORIG             = "<="
IGUAL               = "="
DIST                = "!="
MASIG               = "+="
MENOSIG             = "-="
IGUALIG             = "=="
PARIZQ              ="("
PARDER              =")"
DOSPUNTOS               =":"
PUNTOCOMA               =";"
CADENA                  = \" (.)* \"
/* OPERADOR  		=       ("+" | "-" | "*" | "**" | "/" | "//" | "%" |
			         "<" | ">" | "<=" | "+=" | "-=" | ">=" | "==" | "!=" | "<>" | "=" )
SEPARADOR  		=       ("(" | ")" | ":" | ";" ) */
SALTO          	        =        "\n"
IDENTIFICADOR       	= 	([:letter:] | "_" )([:letter:] | "_" | [0-9])*
ESC              	= 	(\\)
CHAR_LITERAL   	        = 	([:letter:] | [:digit:] | "_" | "$" | " " | "#" ) | "\\"
COMENTARIO 		=     	"#".*{SALTO}
/* BOOLEANO		=	("True" | "False") */
TRUE                = "True"
FALSE               = "False"
%%
{COMENTARIO}      			{}
 // " "+                        		{ System.exit(1);}
  //.                               	{ yybegin(CODIGO);}
//}
//<CODIGO>{
  //\"					{  yybegin(CADENA); }
  {ENTERO}				                    {System.out.println(yytext()+ "\n"); return Parser.ENTERO; }
  {REAL}                              {System.out.println(yytext()+ "\n"); return Parser.REAL; }
  {TRUE}                 		          {System.out.println(yytext()+ "\n"); return Parser.TRUE ;}  
  {FALSE}             			          {System.out.println(yytext()+ "\n"); return Parser.FALSE ; }
  {AND }                              {System.out.println(yytext()+ "\n");return Parser.AND;}                  
  {FROM}                              {System.out.println(yytext()+ "\n");return Parser.FROM;}
  {NOT }                              {System.out.println(yytext()+ "\n");return Parser.NOT ;}
  {WHILE }                            {System.out.println(yytext()+ "\n");return Parser.WHILE ;}
  {FOR }                              {System.out.println(yytext()+ "\n");return Parser.FOR ;}
  {ELSE}                              {System.out.println(yytext()+ "\n");return Parser.ELSE ;}
  {ELIF}                              {System.out.println(yytext()+ "\n");return Parser.ELIF ;}
  {OR    }                            {System.out.println(yytext()+ "\n");return Parser.OR ;}
  {IF}                                {System.out.println(yytext()+ "\n");return Parser.IF;}
  {PRINT }                            {System.out.println(yytext()+ "\n");return Parser.PRINT;}
  {RETURN}                            {System.out.println(yytext()+ "\n");return Parser.RETURN ;}
  {MAS  }                             {System.out.println(yytext()+ "\n");return Parser.MAS ;}
  {MENOS}                             {System.out.println(yytext()+ "\n");return Parser.MENOS ;}
  {MULT }                             {System.out.println(yytext()+ "\n");return Parser.MULT ;}
  {DIV  }                             {System.out.println(yytext()+ "\n");return Parser.DIV ;}
  {EXP  }                             {System.out.println(yytext()+ "\n");return Parser.EXP ;}
  {MOD  }                             {System.out.println(yytext()+ "\n");return Parser.MOD ;}
  {MAYOR}                             {System.out.println(yytext()+ "\n");return Parser.MAYOR ;}
  {MENOR}                             {System.out.println(yytext()+ "\n");return Parser.MENOR ;}
  {MAYORIG   }                        {System.out.println(yytext()+ "\n");return Parser.MAYORIG ;}
  {MENOSIG   }                        {System.out.println(yytext()+ "\n");return Parser.MENOSIG ;}
  {IGUAL     }                        {System.out.println(yytext()+ "\n");return Parser.IGUAL ;}
  {DIST      }                        {System.out.println(yytext()+ "\n");return Parser.DIST ;}
  {MASIG     }                        {System.out.println(yytext()+ "\n");return Parser.MASIG ;}
  {MENOSIG   }                        {System.out.println(yytext()+ "\n");return Parser.MENOSIG ;}
  {IGUALIG   }                        {System.out.println(yytext()+ "\n");return Parser.IGUALIG ;}
  {PARIZQ    }                        {System.out.println(yytext()+ "\n");return Parser.PARIZQ ;}
  {PARDER    }                        {System.out.println(yytext()+ "\n");return Parser.PARDER ;}
  {DOSPUNTOS}                         {System.out.println(yytext()+ "\n");return Parser.DOSPUNTOS ;}
  {PUNTOCOMA}                         {System.out.println(yytext()+ "\n");return Parser.PUNTOCOMA ;}
  {IDENTIFICADOR}           		{System.out.println(yytext()); return Parser.IDENTIFICADOR; }
  {SALTO}                 		        {System.out.println("\n SALTO"+ "\n"); yybegin(INDENTA); actual=0; return Parser.SALTO; }
  " "                        		{   }
  {CADENA}                            {System.out.println(yytext()+ "\n"); return Parser.CADENA; }
// <CADENA>{
//   {CHAR_LITERAL}			{ yybegin(CODIGO); return Parser.CADENA;}
//   {SALTO}				{ System.exit(1);}
// }
<INDENTA>{
  {SALTO}				{ actual = 0; return Parser.SALTO;}
  " "                            	{ actual++; return Parser.INDENTA;}
  \t                             	{ actual += 4;return Parser.INDENTA;}
  .                               	{ yypushback(1);
                                          /* if(!indentacion(actual)){
                                                System.out.println("Error de indentacion, linea "+(yyline+1));
                                                System.exit(1);
                                          } */
					  yybegin(CODIGO);
					}
}
<<EOF>>                                 {indentacion(0); System.out.println("Simulacion Exitosa"); System.exit(0);}
[^]					{ }

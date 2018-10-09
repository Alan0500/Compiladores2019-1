//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package asintactico;



//#line 2 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
  import java.lang.Math;
  import java.io.*;
//#line 20 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short NUMERO=257;
public final static short TRUE=258;
public final static short FALSE=259;
public final static short SALTO=260;
public final static short AND=261;
public final static short FROM=262;
public final static short ENTERO=263;
public final static short REAL=264;
public final static short INDENTA=265;
public final static short DEINDENTA=266;
public final static short ELIF=267;
public final static short OR=268;
public final static short IF=269;
public final static short PRINT=270;
public final static short RETURN=271;
public final static short MAS=272;
public final static short MENOS=273;
public final static short MULT=274;
public final static short DIV=275;
public final static short EXP=276;
public final static short MOD=277;
public final static short MAYOR=278;
public final static short MENOR=279;
public final static short NOT=280;
public final static short WHILE=281;
public final static short FOR=282;
public final static short ELSE=283;
public final static short CADENA=284;
public final static short MAYORIG=285;
public final static short MENOSIG=286;
public final static short IGUAL=287;
public final static short DIST=288;
public final static short MASIG=289;
public final static short MENORIG=290;
public final static short IGUALIG=291;
public final static short PARIZQ=292;
public final static short PARDER=293;
public final static short DOSPUNTOS=294;
public final static short PUNTOCOMA=295;
public final static short IDENTIFICADOR=296;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    1,    1,    2,    2,    3,    6,    6,
    7,    7,    8,    4,    5,   10,   10,   10,    9,   11,
   11,   12,   12,   13,   13,   14,   14,   16,   16,   16,
   16,   16,   16,   15,   15,   15,   17,   17,   17,   17,
   18,   18,   18,   19,   19,   20,   20,   20,   20,   20,
   20,   20,
};
final static short yylen[] = {                            2,
    0,    2,    2,    1,    1,    1,    1,    2,    1,    1,
    1,    3,    2,    4,    4,    1,    4,    4,    1,    1,
    3,    1,    3,    2,    1,    1,    3,    1,    1,    1,
    1,    1,    1,    1,    3,    3,    1,    3,    3,    3,
    1,    2,    2,    1,    3,    1,    1,    1,    1,    1,
    1,    3,
};
final static short yydefred[] = {                         0,
   50,   51,    0,   47,   49,    0,    0,    0,    0,    0,
    0,   48,    0,   46,    0,    0,    4,    5,    6,    7,
    0,    9,   10,    0,   19,    0,    0,   25,    0,    0,
    0,   41,    0,    2,    0,   13,   42,   43,   24,    0,
    0,    3,    8,    0,    0,    0,   29,   28,   31,   33,
   32,   30,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   52,   12,   21,   23,   27,   35,   36,   38,   39,
   40,   45,    0,   16,   14,   15,    0,    0,    5,    0,
   17,   18,
};
final static short yydgoto[] = {                         15,
   16,   17,   18,   19,   20,   21,   22,   23,   24,   75,
   25,   26,   27,   28,   29,   53,   30,   31,   32,   33,
};
final static short yysindex[] = {                      -256,
    0,    0, -256,    0,    0, -196, -196, -169, -169, -196,
 -196,    0, -196,    0,    0, -256,    0,    0,    0,    0,
 -251,    0,    0, -260,    0, -239, -231,    0, -123, -261,
 -156,    0, -241,    0, -255,    0,    0,    0,    0, -253,
 -248,    0,    0, -196, -196, -196,    0,    0,    0,    0,
    0,    0, -169, -169, -169, -169, -169, -169, -169, -199,
 -199,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -215,    0,    0,    0, -226, -214,    0, -213,
    0,    0,
};
final static short yyrindex[] = {                        56,
    0,    0,   56,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   56,    0,    0,    0,    0,
    0,    0,    0, -203,    0, -180, -245,    0, -182,  -88,
 -109,    0, -144,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,
};
final static short yygindex[] = {                        15,
   -5,    0,  -55,    0,    0,    0,    0,    0,   95,  -51,
   24,   29,   72,    0,  -34,    0,   80,   -8,    0,    0,
};
final static int YYTABLESIZE=206;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         37,
   38,    1,    2,    3,   74,   74,    4,    5,   43,   76,
   54,   55,    6,    7,   22,    8,    9,   34,   66,   67,
   68,   79,   22,   10,   11,   80,   44,   12,   45,   46,
   42,    1,    2,   73,   59,   13,    4,    5,   60,   14,
   61,   22,    6,    7,   62,    8,    9,   22,   22,   77,
   72,   81,   82,   10,   11,    1,   11,   12,    1,    2,
   73,    1,    2,    4,    5,   13,    4,    5,   64,   14,
    7,   78,    8,    9,   65,    8,    9,   26,   26,   20,
   10,   39,    0,   10,   12,   26,    0,   12,    1,    2,
    0,    0,   13,    4,    5,   13,   14,    0,    0,   14,
   35,   36,    8,    9,   26,   40,   20,   41,    0,    0,
   26,   26,   20,   20,   12,   44,   44,   56,   57,    0,
   58,    0,   13,   44,    0,    0,   14,   44,   44,   44,
   44,    0,   44,   44,   44,   69,   70,   71,   63,    0,
   44,    0,   44,   44,    0,   44,   44,    0,   44,   44,
   37,   37,    0,    0,   47,   48,    0,    0,   37,    0,
    0,   49,   37,   37,   50,    0,   51,   52,   37,   37,
    0,   34,   34,    0,    0,   37,    0,   37,   37,   34,
   37,   37,    0,   37,   37,    0,    0,    0,    0,   34,
   34,    0,    0,    0,    0,    0,   34,    0,   34,   34,
    0,   34,   34,    0,   34,   34,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          8,
    9,  258,  259,  260,   60,   61,  263,  264,  260,   61,
  272,  273,  269,  270,  260,  272,  273,    3,   53,   54,
   55,   77,  268,  280,  281,   77,  287,  284,  268,  261,
   16,  258,  259,  260,  276,  292,  263,  264,  294,  296,
  294,  287,  269,  270,  293,  272,  273,  293,  294,  265,
   59,  266,  266,  280,  281,    0,  260,  284,  258,  259,
  260,  258,  259,  263,  264,  292,  263,  264,   45,  296,
  270,   77,  272,  273,   46,  272,  273,  260,  261,  260,
  280,   10,   -1,  280,  284,  268,   -1,  284,  258,  259,
   -1,   -1,  292,  263,  264,  292,  296,   -1,   -1,  296,
    6,    7,  272,  273,  287,   11,  287,   13,   -1,   -1,
  293,  294,  293,  294,  284,  260,  261,  274,  275,   -1,
  277,   -1,  292,  268,   -1,   -1,  296,  272,  273,  274,
  275,   -1,  277,  278,  279,   56,   57,   58,   44,   -1,
  285,   -1,  287,  288,   -1,  290,  291,   -1,  293,  294,
  260,  261,   -1,   -1,  278,  279,   -1,   -1,  268,   -1,
   -1,  285,  272,  273,  288,   -1,  290,  291,  278,  279,
   -1,  260,  261,   -1,   -1,  285,   -1,  287,  288,  268,
  290,  291,   -1,  293,  294,   -1,   -1,   -1,   -1,  278,
  279,   -1,   -1,   -1,   -1,   -1,  285,   -1,  287,  288,
   -1,  290,  291,   -1,  293,  294,
};
}
final static short YYFINAL=15;
final static short YYMAXTOKEN=296;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"NUMERO","TRUE","FALSE","SALTO","AND","FROM","ENTERO","REAL",
"INDENTA","DEINDENTA","ELIF","OR","IF","PRINT","RETURN","MAS","MENOS","MULT",
"DIV","EXP","MOD","MAYOR","MENOR","NOT","WHILE","FOR","ELSE","CADENA","MAYORIG",
"MENOSIG","IGUAL","DIST","MASIG","MENORIG","IGUALIG","PARIZQ","PARDER",
"DOSPUNTOS","PUNTOCOMA","IDENTIFICADOR",
};
final static String yyrule[] = {
"$accept : file_input",
"file_input :",
"file_input : SALTO file_input",
"file_input : stmt file_input",
"stmt : compound_stmt",
"stmt : simple_stmt",
"compound_stmt : if_stmt",
"compound_stmt : while_stmt",
"simple_stmt : small_stmt SALTO",
"small_stmt : expr_stmt",
"small_stmt : print_stmt",
"expr_stmt : test",
"expr_stmt : test IGUAL test",
"print_stmt : PRINT test",
"if_stmt : IF test DOSPUNTOS suite",
"while_stmt : WHILE test DOSPUNTOS suite",
"suite : simple_stmt",
"suite : SALTO INDENTA stmt DEINDENTA",
"suite : SALTO INDENTA suite DEINDENTA",
"test : or_test",
"or_test : and_test",
"or_test : and_test OR or_test",
"and_test : not_test",
"and_test : not_test AND and_test",
"not_test : NOT not_test",
"not_test : comparison",
"comparison : expr",
"comparison : expr comp_op expr",
"comp_op : MENOR",
"comp_op : MAYOR",
"comp_op : IGUALIG",
"comp_op : MAYORIG",
"comp_op : MENORIG",
"comp_op : DIST",
"expr : term",
"expr : term MAS expr",
"expr : term MENOS expr",
"term : factor",
"term : factor MULT term",
"term : factor DIV term",
"term : factor MOD term",
"factor : power",
"factor : MAS factor",
"factor : MENOS factor",
"power : atom",
"power : atom EXP factor",
"atom : IDENTIFICADOR",
"atom : ENTERO",
"atom : CADENA",
"atom : REAL",
"atom : TRUE",
"atom : FALSE",
"atom : PARIZQ test PARDER",
};

//#line 133 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
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
//#line 356 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 2:
//#line 16 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 3:
//#line 17 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 4:
//#line 21 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 5:
//#line 22 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 6:
//#line 27 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 7:
//#line 28 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 8:
//#line 32 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 9:
//#line 36 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 10:
//#line 37 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 11:
//#line 41 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 12:
//#line 42 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 13:
//#line 46 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 14:
//#line 51 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 15:
//#line 55 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 16:
//#line 59 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 17:
//#line 60 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 18:
//#line 61 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 19:
//#line 66 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 20:
//#line 70 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 23:
//#line 76 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 24:
//#line 79 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 25:
//#line 80 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 26:
//#line 83 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 27:
//#line 84 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 28:
//#line 87 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 29:
//#line 88 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 30:
//#line 89 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 31:
//#line 90 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 32:
//#line 91 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 33:
//#line 92 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 34:
//#line 95 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 35:
//#line 96 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 36:
//#line 97 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 37:
//#line 100 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 38:
//#line 101 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 39:
//#line 102 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 40:
//#line 103 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 41:
//#line 107 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 42:
//#line 108 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 43:
//#line 109 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 44:
//#line 112 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 45:
//#line 113 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 46:
//#line 118 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 47:
//#line 119 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 48:
//#line 120 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 49:
//#line 121 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 50:
//#line 122 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 51:
//#line 123 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
case 52:
//#line 124 "/home/stein/Documentos/Semestres/Semestre2019-1/Compiladores/Compiladores2019-1/Proyectos/Proyecto02/src/main/byaccj/parser.y"
{dump_stacks(stateptr);}
break;
//#line 701 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
